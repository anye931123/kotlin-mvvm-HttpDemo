package com.example.anye.photogallery.fragment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anye.photogallery.R
import com.example.anye.photogallery.adapter.PhotoAdapter
import com.example.anye.photogallery.data.GalleryItem
import com.example.anye.photogallery.databinding.FragmentPhotoGalleryBinding
import com.example.anye.photogallery.task.FetchItemsTask
import kotlinx.android.synthetic.main.fragment_photo_gallery.*

/**
 * Created by anye on 2018/3/29.
 */
class PhotoGalleryFragment : Fragment() {
    private var photoAdapter: PhotoAdapter? = null
    private var itemsTask:FetchItemsTask?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       itemsTask= FetchItemsTask(this)
        itemsTask!!.execute()
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentPhotoGalleryBinding>(inflater, R.layout.fragment_photo_gallery, container, false)
        binding.photoRecyclerView.layoutManager = GridLayoutManager(activity, 3)
        return binding.root

    }

    fun updateUI( items: MutableList<GalleryItem>) {

        if (photoAdapter == null) {
            photoAdapter = PhotoAdapter(activity, items)
            photo_recycler_view.adapter = photoAdapter
        } else {
            photoAdapter!!.run {
                setGalleryItems(items)
                notifyDataSetChanged()

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        itemsTask!!.cancel(false)
    }
    companion object {
        fun newInstance(): PhotoGalleryFragment = PhotoGalleryFragment()


    }

}