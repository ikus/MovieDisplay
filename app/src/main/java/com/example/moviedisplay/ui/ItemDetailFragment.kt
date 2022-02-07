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
import android.widget.TextView
import com.example.moviedisplay.ui.placeholder.PlaceholderContent
import com.example.moviedisplay.databinding.FragmentItemDetailBinding
import com.example.moviedisplay.domain.model.MovieDetail
import com.example.moviedisplay.model.GetDetailUseCase
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

    /**
     * The placeholder content this fragment is presenting.
     */
    private var item: PlaceholderContent.PlaceholderItem? = null
    private var movieId : Int = 0
    private var movieDetail : MovieDetail? = null //TODO: cambiar esat clase


    lateinit var itemDetailTextView: TextView
    private var toolbarLayout: CollapsingToolbarLayout? = null

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
        itemDetailTextView = binding.itemDetail

        updateContent()
        rootView.setOnDragListener(dragListener)

        //TODO: Aqu e pmezamos a llenar el view



        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDetail = getDetailUseCase.invoke(movieId)
            Log.d("ORIGINAL LANGUAGE::", movieDetail?.originalLanguage.toString())
            updateContent()
        }
    }

    private fun updateContent() {
        toolbarLayout?.title = movieDetail?.title
        // Show the placeholder content as text in a TextView.
        movieDetail?.let {
            itemDetailTextView.text = it.overview
        }
        //Obtner imagen


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