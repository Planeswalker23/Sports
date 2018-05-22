# Sports是一个运动型APP的功能原型项目
## 版本1.0
新增地图功能，包括：音乐播放器、实时定位、回到我的位置、绘制运动轨迹、显示/隐藏周围人数、保存运动轨迹、简易语音反馈、显示距离。

- MainActivity：主页面，包含各个功能页面的入口。

- MusicWebActivity：基于WebView控件嵌入百度音乐盒网页版，实现音乐播放器功能。

- MapActivity：基于百度地图SDK，实现显示地图、实时定位、开启城市热力图、回到我的位置功能。

- DynamicDemo：基于百度地图SDK，实现显示地图、实时定位、绘制运动轨迹、显示/隐藏周围人数、保存运动轨迹、显示距离的功能。

- MusicDemo：基于MediaPlayer实现播放音效的功能。


## 版本1.1
新增功能：绘制静态轨迹、状态通知栏通知、启动欢迎页面。

- StaticDemo：基于百度地图SDK，实现绘制静态轨迹的功能。

- NotificationDemo：基于Notification控件，实现状态通知栏的通知功能。

- WelCome：基于Handler运行机制，实现启动APP首先进入欢迎界面的功能。

## 版本1.2

新增功能：分享运动轨迹，查看保存的运动轨迹。

- MainActivity中的分享按钮：基于Android原生分享实现分享图片至第三方APP的功能。

- GalleryActivity：基于Gallery控件实现图片(运动轨迹)的轮播效果

- 修复了点击通知栏通知不消失的BUG，通过为Notification.Builder()对象添加setAutoCancel(true)属性。


## 版本1.3

新增功能：显示运动时间与运动距离，选择日期。

- MapActivity：基于百度地图工具类DistanceUtil.getDistance()获取运动距离，并使用System.currentTimeMillis()获取时间计算时间差得到运动时间。

- CalenderActivity：基于DatePicker控件实现选择日期功能，并使用startActivityForResult()方法实现参数回传。
