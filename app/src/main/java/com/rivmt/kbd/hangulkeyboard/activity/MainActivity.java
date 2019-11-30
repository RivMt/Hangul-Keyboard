package com.rivmt.kbd.hangulkeyboard.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rivmt.kbd.hangulkeyboard.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        Intent mainAct = new Intent(this, MainSettingActivity.class);
        startActivity(mainAct);
        finish();
        super.onBackPressed();
    }
}
