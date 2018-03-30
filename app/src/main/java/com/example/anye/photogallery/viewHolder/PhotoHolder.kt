package com.example.anye.photogallery.viewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.anye.photogallery.data.GalleryItem
import com.example.anye.photogallery.databinding.PhotoItemBinding
import com.example.anye.photogallery.viewModel.PhotoViewModel

class PhotoHolder(private val mBinding:PhotoItemBinding,
                  itemView:View?=mBinding.root) : RecyclerView.ViewHolder(itemView) {
    init {
        mBinding.viewModel= PhotoViewModel()
    }

    fun bind(galleryItem: GalleryItem){
        mBinding.viewModel!!.mGalleryItem=galleryItem
        mBinding.executePendingBindings()

    }

}