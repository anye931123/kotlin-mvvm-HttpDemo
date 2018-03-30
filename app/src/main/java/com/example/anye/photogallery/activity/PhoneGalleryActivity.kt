package com.example.anye.photogallery.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.example.anye.photogallery.activity.base.SingleFragmentActivity
import com.example.anye.photogallery.fragment.PhotoGalleryFragment

class PhoneGalleryActivity : SingleFragmentActivity(){


    override fun createFragment(): Fragment=PhotoGalleryFragment.newInstance()

}
