package com.example.administrator.project_three

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.app1.EventBus
import com.example.app1.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //注册
        EventBus.getDefault().register(this)
    }

//    @Subscriber(tag = "testTag")   //这里必须有一个参数，因为用反射的方法时候invoke()调用的时候，是调用一个参数的方法
//    public fun change(test: String) {
//        tv_text.text = "test"
//    }



    public fun startA(view: View) {
        var intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}
