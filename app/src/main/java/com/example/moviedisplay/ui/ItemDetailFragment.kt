package com.example.moviedisplay.ui

import android.content.ClipData
import android.os.Bundle
import android.util.Log
import android.view.DragEvent
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.CollapsingToolbarLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.moviedisplay.R
import com.example.moviedisplay.data.MovieRepository
import com.example.moviedisplay.ui.placeholder.PlaceholderContent
import com.example.moviedisplay.databinding.FragmentItemDetailBinding
import com.example.moviedisplay.domain.model.MovieDetail
import com.example.moviedisplay.model.GetDetailUseCase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListFragment]
 * in two-pane mode (on larger screen devices) or self-contained
 * on handsets.
 */
@AndroidEntryPoint
class ItemDetailFragment : Fragment() {

    @Inject
    internal lateinit var getDetailUseCase: GetDetailUseCase

    @Inject
    internal lateinit var repository: MovieRepository
    /**
     * The placeholder content this fragment is presenting.
     */
    private var item: PlaceholderContent.PlaceholderItem? = null
    private var movieId : Int = 0
    private var movieDetail : MovieDetail? = null //TODO: cambiar esat clase

    lateinit var item0DetailTextView: TextView
    lateinit var item1DetailTextView: TextView
    lateinit var item2DetailTextView: TextView
    lateinit var item3DetailTextView: TextView
    lateinit var item4DetailTextView: TextView

    lateinit var fabFavorite: FloatingActionButton



    private var toolbarLayout: CollapsingToolbarLayout? = null

    lateinit var imageViewDetailMovie:ImageView




    private var _binding: FragmentItemDetailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val dragListener = View.OnDragListener { v, event ->
        if (event.action == DragEvent.ACTION_DROP) {
            val clipDataItem: ClipData.Item = event.clipData.getItemAt(0)
            val dragData = clipDataItem.text
            item = PlaceholderContent.ITEM_MAP[dragData]
            updateContent()
        }
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the placeholder content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.

                    //TODO: Obtenr el detalle de la pelicula

                item = PlaceholderContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                item = PlaceholderContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                movieId = it.getString(ARG_ITEM_ID)?.toInt() ?: 0
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentItemDetailBinding.inflate(inflater, container, false)
        val rootView = binding.root

        toolbarLayout = binding.toolbarLayout
        item0DetailTextView = binding.itemDetail
        item1DetailTextView = binding.item1Detail!!
        item2DetailTextView = binding.item2Detail!!
        item3DetailTextView = binding.item3Detail!!
        //item4DetailTextView = binding.itemDetail
        fabFavorite = binding.fab!!


        imageViewDetailMovie = binding.imageViewDetailMovie!!

        updateContent()
        rootView.setOnDragListener(dragListener)

        //TODO: Aqu e pmezamos a llenar el view



        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDetail = getDetailUseCase.invoke(movieId)
            Log.d("ORIGINAL LANGUAGE::", movieDetail?.originalLanguage.toString())
            activity?.runOnUiThread{
                updateContent()
            }


            var isFavorite : Boolean =repository.getMovieFromDatabase(movieId).favorite
            if(isFavorite == true) {
                fabFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_favorite_24,activity?.theme))
            } else {
                fabFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_favorite_border_24,activity?.theme))
            }

            fabFavorite.setOnClickListener {
                isFavorite = !isFavorite
                if(isFavorite == true) {
                    fabFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_favorite_24,activity?.theme))
                } else {
                    fabFavorite.setImageDrawable(resources.getDrawable(R.drawable.ic_baseline_favorite_border_24,activity?.theme))
                }
                CoroutineScope(Dispatchers.IO).launch {
                    repository.setFavoriteInDatabase(movieId,isFavorite)
                }
            }
        }


    }

    private fun updateContent() {
        toolbarLayout?.title = movieDetail?.title
        // Show the placeholder content as text in a TextView.
        movieDetail?.let {
            item0DetailTextView.text = it.overview
            item1DetailTextView.text = it.releaseDate
            item2DetailTextView.text = it.homepage
            item3DetailTextView.text = it.status
        }
        //Obtner imagen
        Glide.with(requireActivity()).load(
            "http://image.tmdb.org/t/p/w185/"+movieDetail?.backdropPath +"?api_key=28b80b41ebf312e0ba2909f4472d67b6").into(imageViewDetailMovie)

    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}