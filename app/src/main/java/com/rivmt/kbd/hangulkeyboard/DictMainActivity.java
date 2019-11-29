package com.rivmt.kbd.hangulkeyboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DictMainActivity extends AppCompatActivity {

    private final DictionaryDBHelper DBHelper = new DictionaryDBHelper(this, Constants.DICT_DB_ALL, null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dict_main);

        //Add Word Button
        final EditText boxWord = (EditText) findViewById(R.id.box_word_name);
        final EditText boxInput = (EditText) findViewById(R.id.box_word_input);
        Button btnAdd = (Button) findViewById(R.id.btn_add_word);
        btnAdd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.insertWord(boxWord.getText().toString(), boxInput.getText().toString(), "a");
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent mainAct = new Intent(this, MainSettingActivity.class);
        startActivity(mainAct);
        finish();
        super.onBackPressed();
    }
}
