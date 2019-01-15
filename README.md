# V-HotLableView
A simple and practical label control, easy to add the latest and hottest labels, etc.

<p align="center">
   <a href="https://bintray.com/vension/vensionCenter/MultiStateLayout/_latestVersion">
    <img src="https://img.shields.io/badge/Jcenter-V1.0.1-brightgreen.svg?style=flat-square" alt="Latest Stable Version" />
  </a>
  <a href="https://travis-ci.org/Vension/V-MultiStateLayout">
    <img src="https://travis-ci.org/Vension/V-MultiStateLayout.svg?branch=master" alt="Build Status" />
  </a>
  <a href="https://developer.android.com/about/versions/android-4.0.html">
    <img src="https://img.shields.io/badge/API-15%2B-blue.svg?style=flat-square" alt="Min Sdk Version" />
  </a>
  <a href="http://www.apache.org/licenses/LICENSE-2.0">
    <img src="http://img.shields.io/badge/License-Apache%202.0-blue.svg?style=flat-square" alt="License" />
  </a>
  <a href="https://www.jianshu.com/u/38adb0e04e65">
    <img src="https://img.shields.io/badge/Author-Vension-orange.svg?style=flat-square" alt="Author" />
  </a>
</p>

## Preview
<p>
   <img src="/images/GIF.gif" style="width: 50%;">
</p>

## Download[ ![Download](https://api.bintray.com/packages/vension/vensionCenter/HotLableView/images/download.svg) ](https://bintray.com/vension/vensionCenter/HotLableView/_latestVersion)
``` gradle
 implementation 'me.vension:hotlableview:_latestVersion'
```

## update
* **V1.0.0**: <初始化版本>

## Usage

* **具体使用查看demo示例**

######使用空边标签时
```
<FrameLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="@android:color/white"
            android:layout_margin="10dp">

        <LinearLayout android:layout_width="match_parent"
                      android:layout_height="wrap_content">

            <android.support.v7.widget.AppCompatImageView
                    android:layout_width="140dp"
                    android:layout_height="100dp"
                    android:scaleType="centerCrop"
                    android:src="@drawable/img_item"/>

            <LinearLayout android:layout_width="0dp"
                          android:layout_height="wrap_content"
                          android:orientation="vertical"
                          android:layout_weight="1"
                          android:layout_marginTop="5dp"
                          android:layout_marginLeft="12dp">

                <android.support.v7.widget.AppCompatTextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:textSize="16sp"
                        android:textColor="@color/colorPrimary"
                        android:text="@string/app_name"/>

                <android.support.v7.widget.AppCompatTextView
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:lineSpacingExtra="3dp"
                        android:layout_marginTop="10dp"
                        android:textSize="14sp"
                        android:textColor="#999999"
                        android:text="一个简单实用的标签控件,轻松添加最新最热等标签"/>

            </LinearLayout>
        </LinearLayout>
        <com.vension.hotlableview.HotLableView
                android:id="@+id/hlv_2"
                android:layout_width="50dp"
                android:layout_height="50dp"
                android:layout_gravity="left|top"
                app:hlv_gravity="TOP_LEFT"
                app:hlv_bgColor="#d51d50"
                app:hlv_fillTriangle="true"
                app:hlv_text="推荐"
                app:hlv_textSize="8sp"/>
    </FrameLayout>
```
#####使用浮嵌标签时

要注意容器的android:layout_margin="3dp"必须和app:hlv_fillSize="3"值一样
```
<FrameLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <View
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="3dp"
        android:background="#ffffff"
        android:orientation="vertical"
        android:gravity="center">
    </View>
    <com.vension.hotlableview.HotLableView
                    android:id="@+id/hlv_2"
                    android:layout_width="50dp"
                    android:layout_height="50dp"
                    android:layout_gravity="left|top"
                    app:hlv_gravity="TOP_LEFT"
                    app:hlv_bgColor="#d51d50"
                    app:hlv_fillSize="3"
                    app:hlv_text="推荐"
                    app:hlv_textSize="8sp"/>
</FrameLayout>
```


#### attrs

| Attribute 属性         | Description 描述 |
|:---				    |:---|
| hlv_text              | 设置文字内容           |
| hlv_textColor         | 设置文字颜色,默认#ffffff       |
| hlv_textSize          | 设置文字大小,默认11sp           |
| hlv_textBold          | 设置文字是否支持加粗,默认true    |
| hlv_textAllCaps       | 设置文字是否支持全部大写,默认true |
| hlv_bgColor           | 设置背景颜色,默认"#FF4081" |
| hlv_minSize           | 设置LabelView所在矩形最小宽高,默认35dp或50dp |
| hlv_padding           | 设置文字上下padding,默认3.5dp |
| hlv_gravity           | 设置LabelView方向  |
| hlv_fillTriangle      | 设置是否填充三角区域,默认false  |
| hlv_fillSize          | 设置是否浮嵌显示大小  |


## License
```
 Copyright 2018, Vension

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
