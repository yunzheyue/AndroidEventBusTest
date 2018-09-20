package com.example.app1.test

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.app1.R
import com.example.app1.Subscriber
import kotlinx.android.synthetic.main.activity_main.*

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    //这里必须有一个参数，因为用反射的方法时候invoke()调用的时候，
    //是调用一个参数的方法
    @Subscriber(tag = "testTag")
    public fun changeBase(test: String) {
        tv_base_text.text = test
    }

}
