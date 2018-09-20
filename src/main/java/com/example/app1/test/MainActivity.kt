package com.example.administrator.project_three

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.app1.EventBus
import com.example.app1.Subscriber
import com.example.app1.test.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //注册
        EventBus.getDefault().register(this)
    }

    //这里必须有一个参数，因为用反射的方法时候invoke()调用的时候，
    //是调用一个参数的方法
    @Subscriber(tag = "testTag")
    public fun change(test: String) {
        tv_text.text =test
    }


    public fun startA(view: View) {
        var intent = Intent(this, Main2Activity::class.java)
        startActivity(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
}
