package com.rivmt.kbd.hangulkeyboard.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import com.rivmt.kbd.hangulkeyboard.R;

import java.util.List;

import static android.provider.Settings.ACTION_HARD_KEYBOARD_SETTINGS;
import static android.provider.Settings.ACTION_INPUT_METHOD_SETTINGS;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "Splash";

    private boolean mActKeyboard, mSetKeyboard;
    private Button mButton;
    private InputMethodManager mInputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Set Keyboard
        mActKeyboard=false;
        mSetKeyboard=false;

        //InputMethodManager
        mInputMethodManager = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        //UI
        mButton = (Button) findViewById(R.id.btn_keyboard_set);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setKeyboardReady(true);
            }
        });

        //Check Keyboard Activation
        checkKeyboardActivation();

        //Fast-load
        setKeyboardReady(false);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //Check Keyboard Activation
        checkKeyboardActivation();
    }

    private void setKeyboardReady(boolean force) {
        //Load Settings
        if (mActKeyboard) {
            if (mSetKeyboard) {
                startActivity(new Intent(SplashActivity.this,MainSettingActivity.class));
            } else {
                openKeyboardSelector();
            }
        } else if (force) {
            Toast.makeText(this, getString(R.string.splash_toast_enable_keyboard), Toast.LENGTH_SHORT).show();
            openKeyboardSettings();
        }
    }

    private void checkKeyboardActivation() {
        //Check Keyboard Enabled
        String packageLocal = getPackageName();
        String lists = mInputMethodManager.getEnabledInputMethodList().toString();
        mActKeyboard=lists.contains(packageLocal);

        if (mActKeyboard) {
            mButton.setText(getString(R.string.splash_button_select_keyboard));
        }

        //Check Keyboard Selected
        String t = mInputMethodManager.getEnabledInputMethodList().toString();
        mSetKeyboard = (t.contains(packageLocal));
        Log.i(TAG,"IME Current: "+t);
    }

    private void openKeyboardSettings() {
        startActivityForResult(new Intent(ACTION_INPUT_METHOD_SETTINGS),0);
    }

    private void openKeyboardSelector() {
        mInputMethodManager.showInputMethodPicker();
    }
}
