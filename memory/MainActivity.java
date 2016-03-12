package ru.glebproject.itschool.samsung.memory;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import android.os.Handler;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    public String name;
    EditText editText;
    TextView textView;


    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        editText = (EditText) this.findViewById(R.id.editText);
        name = editText.getText().toString();
        Log.d("Test", "OnCreate success");

    }

    public void classical(View v){
        Log.d("Test", "in classical");
        final ImageButton button = (ImageButton) this.findViewById(R.id.imageButton);


                button.setClickable(false);
                button.setImageResource(R.drawable.ic_launcher_pressed);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                button.setImageResource(R.drawable.ic_launcher);
                button.setClickable(true);
            }
        }, 0);


        startActivity(new Intent(this, ClassicalActivity.class));


    }

    public void arcade(View v) {
        Log.d("Test", "in arcade");
        startActivity(new Intent(this, ArcadeActivity.class));
    }

    public void clickHoF(View v){
        Log.d("Test", "in HoF");
        startActivity(new Intent(this, HallOfFame.class));
    }


}


