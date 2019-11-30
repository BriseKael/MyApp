package com.example.myapp;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.apache.commons.lang3.RandomUtils;

import com.example.myapp.model.UserDO;
import com.google.common.collect.Lists;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    private static int index;

    private static List<UserDO> userDOList = Lists.newArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnTestAlpha).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnTestAlpha: {
                doAlphaTest();
                break;
            }
            default: {
                break;
            }
        }
    }

    private void doAlphaTest() {
        Log.i(TAG, "start to do alpha test");
        index += 1;
        Log.i(TAG, "index: " + index);

        UserDO userDO = new UserDO();
        userDO.setUsername("testUser_" + index);
        long randomPassword = RandomUtils.nextLong((long)Math.pow(10, 15), (long)Math.pow(10, 16) - 1);
        userDO.setPassword(Objects.toString(randomPassword));

        Log.i(TAG, "generate new user: " + userDO + ", password length: "
            + Optional.ofNullable(userDO).map(UserDO::getPassword).map(String::length).orElse(-1));

        userDOList.add(userDO);
    }
}
