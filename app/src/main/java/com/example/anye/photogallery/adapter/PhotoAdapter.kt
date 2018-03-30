package com.example.anye.photogallery.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.anye.photogallery.R
import com.example.anye.photogallery.data.GalleryItem
import com.example.anye.photogallery.databinding.PhotoItemBinding
import com.example.anye.photogallery.viewHolder.PhotoHolder

class PhotoAdapter(private val context: Context,
                   private var mGalleryItem:MutableList<GalleryItem>):RecyclerView.Adapter<PhotoHolder>() {

   fun setGalleryItems(galleryItems: MutableList<GalleryItem>)={mGalleryItem=galleryItems}

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PhotoHolder {

        val inflater=LayoutInflater.from(context)
        val binding=DataBindingUtil.inflate<PhotoItemBinding>(inflater, R.layout.photo_item,parent,false)

        return PhotoHolder(binding)

    }

    override fun getItemCount(): Int=mGalleryItem.size


    override fun onBindViewHolder(holder: PhotoHolder?, position: Int) {

        holder!!.bind(mGalleryItem[position])
    }
}