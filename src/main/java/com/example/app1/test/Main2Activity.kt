package com.example.administrator.project_three

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.app1.EventBus
import com.example.app1.R

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    public fun startPost(view: View) {
        //第一个参数是要发布的对象  第二个参数是action
        EventBus.getDefault().post("test", "testTag")
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}
