# YFmod
A compact integrated Fmod sound processing library

## 简介
这是一个基于Fmod的二次封装库，可以用一句代码搞定语音变声的效果！

## 使用方法
1. 在自己的项目中集成yfmodlibrary
2. 使用YFmod
3. 使用YFmod中的方法就好啦

## 快速使用
```java
	YFmod.init(this);
	YFmod.fix("file:///android_asset/test.ogg",mode);
	YFmod.close();
```

你可以在Activity的onDestroy情况下调用YFmod.close();并非每次播放都需要调用

## TODO
计划增加几个fix方法的参数以达到动态调整音调、语速等状态...
