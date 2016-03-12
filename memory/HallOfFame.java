package ru.glebproject.itschool.samsung.memory;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HallOfFame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hall_of_fame);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
    }
}
