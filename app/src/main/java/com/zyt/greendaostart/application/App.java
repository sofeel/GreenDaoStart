package com.zyt.greendaostart.application;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.zyt.greendaostart.entity.DaoMaster;
import com.zyt.greendaostart.entity.DaoSession;

/**
 * Created by Administrator on 2017/2/26.
 */

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        initGreenDao();
    }


    //数据库是否加密
    public static final boolean ENCRYPTED = true;
    //数据库session操作对象
    private DaoSession daoSession;

    //初始化数据库
    private void initGreenDao() {
//        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
//        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
//        daoSession = new DaoMaster(db).newSession();

        DaoMaster.DevOpenHelper openHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
        SQLiteDatabase db = openHelper.getWritableDatabase();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
