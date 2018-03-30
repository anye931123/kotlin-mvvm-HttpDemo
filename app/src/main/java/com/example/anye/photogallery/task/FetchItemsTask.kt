package com.example.anye.photogallery.task

import android.os.AsyncTask
import android.util.Log
import com.example.anye.photogallery.data.GalleryItem
import com.example.anye.photogallery.fragment.PhotoGalleryFragment
import com.example.anye.photogallery.utils.HttpUtils

/**
 * Created by anye on 2018/3/29.
 */
class FetchItemsTask(private val photoGalleryFragment: PhotoGalleryFragment):AsyncTask<Unit,Unit,MutableList<GalleryItem>>() {

    override fun doInBackground(vararg params: Unit?):MutableList<GalleryItem> {
       return   HttpUtils().fetchItems()
    }

    override fun onPostExecute(result: MutableList<GalleryItem>?) {
       photoGalleryFragment.updateUI(result!!)

        Log.e("结果》》》》》》",result.toString())
    }
}