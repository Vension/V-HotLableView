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
  <a href="https://shang.qq.com/wpa/qunwpa?idkey=1a5dc5e9b2e40a780522f46877ba243eeb64405d42398643d544d3eec6624917">
    <img src="https://img.shields.io/badge/QQ-2506856664-orange.svg?style=flat-square" alt="QQ Group" />
  </a>
</p>

## Preview
<p>
   <img src="/images/GIF.gif" style="width: 50%;">
</p>

## Download [ ![Download](https://api.bintray.com/packages/vension/vensionCenter/MultiStateLayout/images/download.svg) ](https://bintray.com/vension/vensionCenter/MultiStateLayout/_latestVersion)
``` gradle
 implementation 'me.vension:MultiStateLayout:_latestVersion'
```

## Usage

* **具体使用查看demo示例**
```java
 MultiStateLayout.Builder(this)
            .initPage(this)
            .setEmpty(layoutId = ,ivEmptyId = ,tvEmptyId = )
            .setEmptyText(text = )
            .setEmptyTextColor(color = )
            .setCustomLayout(layoutId = )
            .setOnRetryListener(this).build()
            .setOnRetryListener(object : MultiStateLayout.OnRetryClickListener{
                override fun onRetry() {
                    //TODO 点击重试
                }
            })
            .build()
            .showLoading()
```

## update
* **V1.0.1**: <新增根据状态返回对应Layout方法>
* **V1.0.0**: <初始化版本>


## About Me
* **Email**: <2506856664@qq.com>
* **Github**: <https://github.com/Vension>
* **简书**: <https://www.jianshu.com/u/38adb0e04e65>

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


### 使用说明

导入 lclablelibrary 到项目中

在 build.gradle 的 dependencies 添加:
```
	dependencies {
    compile fileTree(include: ['*.jar'], dir: 'libs')
    ....
    compile project(':lclablelibrary')
    }
```

#### 属性

| Attribute 属性          | Description 描述 |
|:---				     |:---|
| lv_text                | 设置文字内容           |
| lv_text_color         | 设置文字颜色,默认#ffffff       |
| lv_text_size         | 设置文字大小,默认11sp           |
| lv_text_bold         | 设置文字是否支持加粗,默认true    |
| lv_text_all_caps      | 设置文字是否支持全部大写,默认true |
| lv_background_color      | 设置背景颜色,默认"#FF4081" |
| lv_min_size      | 设置LabelView所在矩形最小宽高,默认35dp或50dp |
| lv_padding      | 设置文字上下padding,默认3.5dp |
| lv_gravity      | 设置LabelView方向  |
| lv_fill_triangle      | 设置是否填充三角区域,默认false  |
| lv_fill_size      | 设置是否浮嵌显示大小  |


### 实际使用代码

######使用空边标签时

```
 <FrameLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <View
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="@drawable/bag"
        android:orientation="vertical"
        android:gravity="center">
    </View>
    <com.xiaochao.lclablelibrary.LabelView
        android:layout_width="60dp"
        android:layout_height="60dp"
        android:layout_gravity="bottom"
        lv:lv_background_color="#FF6666"
        lv:lv_gravity="BOTTOM_LEFT"
        lv:lv_text="十年经验"
        lv:lv_text_size="8dp"
        />
 </FrameLayout>
```

#####使用浮嵌标签时

要注意容器的android:layout_margin="3dp"必须和lv:lv_fill_size="3"值一样
```
<FrameLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <View
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="3dp"
        android:background="@drawable/bag"
        android:orientation="vertical"
        android:gravity="center">
    </View>
    <com.xiaochao.lclablelibrary.LabelView
        android:layout_width="60dp"
        android:layout_height="60dp"
        lv:lv_background_color="#FF6666"
        lv:lv_gravity="TOP_LEFT"
        lv:lv_text="十年经验"
        lv:lv_text_size="8dp"
        lv:lv_fill_size="3"
        />
</FrameLayout>
```
