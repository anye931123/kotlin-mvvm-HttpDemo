package com.example.anye.photogallery.viewModel

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.example.anye.photogallery.data.GalleryItem

class PhotoViewModel: BaseObservable(){
    var mGalleryItem:GalleryItem?=null
    set(value) {
        field=value
        notifyChange()
    }
    @Bindable
    fun getTitle():String=mGalleryItem!!.mCaption
}