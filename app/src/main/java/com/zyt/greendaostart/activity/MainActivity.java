package com.zyt.greendaostart.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.zyt.greendaostart.R;
import com.zyt.greendaostart.application.App;
import com.zyt.greendaostart.entity.User;
import com.zyt.greendaostart.entity.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserDao userDao = ((App) getApplication()).getDaoSession().getUserDao();

        //inser
        User user = new User(1l, "zyt");
        userDao.insert(user);
        userDao.insertOrReplaceInTx(user);

        //query
        List<User> userList = userDao.queryBuilder()
                .where(UserDao.Properties.Name.eq("zyt"))
                .build().list();

        TextView userName = (TextView) findViewById(R.id.tv_userName);
        userName.setText(userList.get(0).getName());

    }
}
