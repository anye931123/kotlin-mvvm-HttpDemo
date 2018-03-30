package com.example.anye.photogallery.activity.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.anye.photogallery.R

/**
 * Created by anye on 2018/3/29.
 */
abstract class SingleFragmentActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResId())

        var fragment=supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment==null){
            fragment=createFragment()
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragment_container,fragment)
                    .commit()
        }
    }


    @LayoutRes
    open fun getLayoutResId():Int= R.layout.activity_fragment

    abstract fun createFragment():Fragment
}