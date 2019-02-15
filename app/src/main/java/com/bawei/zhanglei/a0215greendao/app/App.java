package com.bawei.zhanglei.a0215greendao.app;

import android.app.Application;

import com.bawei.zhanglei.a0215greendao.utils.GreenDaoUtils;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GreenDaoUtils.getInstance().initGreenDao(this);
    }
}
