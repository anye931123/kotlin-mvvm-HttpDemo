package com.example.anye.photogallery.viewModel

import android.content.Context
import android.databinding.BaseObservable
import android.databinding.Bindable
import android.graphics.drawable.Drawable
import com.example.anye.photogallery.R
import com.example.anye.photogallery.data.GalleryItem

class PhotoViewModel(private val context: Context): BaseObservable(){
    var mGalleryItem:GalleryItem?=null
    set(value) {
        field=value
        notifyChange()
    }
    @Bindable
    fun getTitle():String=mGalleryItem!!.mCaption

    fun getDrawable(): Drawable {
        val placeholder=context.resources.getDrawable(R.drawable.placehoder_image)
        return placeholder
    }
}