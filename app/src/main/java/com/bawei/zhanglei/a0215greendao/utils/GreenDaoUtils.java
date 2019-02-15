package com.bawei.zhanglei.a0215greendao.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.system.OsConstants;

import com.bawei.zhanglei.a0215greendao.greendao.DaoMaster;
import com.bawei.zhanglei.a0215greendao.greendao.DaoSession;

public class GreenDaoUtils {
    private static GreenDaoUtils gInstance;

    private GreenDaoUtils(){

    }
    /**
     * 双重检索锁
     * @return
     */
    public static GreenDaoUtils getInstance(){
        if(gInstance==null){
            synchronized (GreenDaoUtils.class){
                if(gInstance==null){
                    gInstance = new GreenDaoUtils();
                }
            }
        }
        return gInstance;
    }
    /**
     *
     * 初始化GreenDao,直接在Application中进行初始化操作
     */
    public void initGreenDao(Context context){
        //创建表
       DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context,"lll.db");
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();//database 读写数据库
        DaoMaster daoMaster = new DaoMaster(sqLiteDatabase);//创建对象
        //创建daosession
        daoSession = daoMaster.newSession();

    }
    private DaoSession daoSession;
    public DaoSession getDaoSession(){
        return daoSession;
    }

}
