package com.example.firstlaunch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private PrefManager prefManager;
private Button acceptButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefManager = new PrefManager(this);
        if(!prefManager.isFirstTimeLaunch()){
            launch();
            finish();
        }

        setContentView(R.layout.activity_main);
        acceptButton = findViewById(R.id.button);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launch();
            }
        });
    }

    private void launch() {
        prefManager.setFirstTimeLaunch(false);
        Intent intent = new Intent(MainActivity.this,Launched.class);
        startActivity(intent);
    }
}
