package com.fec.yunmall.mall.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import butterknife.ButterKnife
import com.fec.yunmall.mall.R
import kotlinx.android.synthetic.main.mall_activity_kotlin_view.*

/**
 * @author  tome
 * @date 2019/2/13  17:06
 * @describe ${TODO}
 */

class TestKotlinAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mall_activity_kotlin_view)
        ButterKnife.bind(this)
        initView()

    }

    private fun initView() {
        mall_button.setOnClickListener(View.OnClickListener { finish() })
    }

    override fun onDestroy() {
        super.onDestroy()

    }

}

