package com.vension.v_hotlableview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_main.*


/**
 * ========================================================
 * 作 者：Vension
 * 日 期：2019/1/15 10:26
 * 更 新：2019/1/15 10:26
 * 描 述：
 * ========================================================
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rg.setOnCheckedChangeListener { group, checkedId ->
            val lp = FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT)
            when(checkedId){
                R.id.rb_lt ->{
                    lp.gravity = Gravity.LEFT or Gravity.TOP  //这才是布局文件中的Android:layout_gravity属性
                    hlv_1.layoutParams = lp
                    hlv_2.layoutParams = lp
                    hlv_3.layoutParams = lp
                    hlv_1.setGravity(Gravity.LEFT or Gravity.TOP)//这是布局文件中的Android：gravity属性
                    hlv_2.setGravity(Gravity.LEFT or Gravity.TOP)//这是布局文件中的Android：gravity属性
                    hlv_3.setGravity(Gravity.LEFT or Gravity.TOP)//这是布局文件中的Android：gravity属性
                }
                R.id.rb_lb ->{
                    lp.gravity = Gravity.LEFT or Gravity.BOTTOM  //这才是布局文件中的Android:layout_gravity属性
                    hlv_1.layoutParams = lp
                    hlv_2.layoutParams = lp
                    hlv_3.layoutParams = lp
                    hlv_1.setGravity(Gravity.LEFT or Gravity.BOTTOM)//这是布局文件中的Android：gravity属性
                    hlv_2.setGravity(Gravity.LEFT or Gravity.BOTTOM)//这是布局文件中的Android：gravity属性
                    hlv_3.setGravity(Gravity.LEFT or Gravity.BOTTOM)//这是布局文件中的Android：gravity属性
                }
                R.id.rb_rt ->{
                    lp.gravity = Gravity.RIGHT or Gravity.TOP  //这才是布局文件中的Android:layout_gravity属性
                    hlv_1.layoutParams = lp
                    hlv_2.layoutParams = lp
                    hlv_3.layoutParams = lp
                    hlv_1.setGravity(Gravity.RIGHT or Gravity.TOP)//这是布局文件中的Android：gravity属性
                    hlv_2.setGravity(Gravity.RIGHT or Gravity.TOP)//这是布局文件中的Android：gravity属性
                    hlv_3.setGravity(Gravity.RIGHT or Gravity.TOP)//这是布局文件中的Android：gravity属性
                }
                R.id.rb_rb ->{
                    lp.gravity = Gravity.RIGHT or Gravity.BOTTOM  //这才是布局文件中的Android:layout_gravity属性
                    hlv_1.layoutParams = lp
                    hlv_2.layoutParams = lp
                    hlv_3.layoutParams = lp
                    hlv_1.setGravity(Gravity.RIGHT or Gravity.BOTTOM)//这是布局文件中的Android：gravity属性
                    hlv_2.setGravity(Gravity.RIGHT or Gravity.BOTTOM)//这是布局文件中的Android：gravity属性
                    hlv_3.setGravity(Gravity.RIGHT or Gravity.BOTTOM)//这是布局文件中的Android：gravity属性
                }
            }
            group.check(checkedId)
        }
    }
}
