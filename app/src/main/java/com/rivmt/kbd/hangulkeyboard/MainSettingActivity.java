package com.rivmt.kbd.hangulkeyboard;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class MainSettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_setting);

        //Set ListView for Activity
        ListView listView;
        ListAdapterMain adapter = new ListAdapterMain();

        listView = findViewById(R.id.list_main);
        listView.setAdapter(adapter);

        //Define Item Name and Icon
        final String[] product_name =
                {
                        getResources().getString(R.string.menu_main_language),
                        getResources().getString(R.string.menu_main_theme),
                        getResources().getString(R.string.menu_main_dictionary),
                        getResources().getString(R.string.menu_main_developer),
                };

        final Drawable[] product_icon =
                {
                        ContextCompat.getDrawable(this,R.drawable.ic_language_black_24dp),
                        ContextCompat.getDrawable(this, R.drawable.ic_color_lens_black_24dp),
                        ContextCompat.getDrawable(this, R.drawable.ic_chrome_reader_mode_black_24dp),
                        ContextCompat.getDrawable(this, R.drawable.ic_adb_black_24dp),
                };

        //Add item to listview
        for(int i=0; i < product_name.length; i++) {
            adapter.addItem(product_icon[i], product_name[i], getResources().getColor(R.color.colorAccent));
        }

        //OnClick
        final Activity reqPermAct = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListItemMain item = (ListItemMain) parent.getItemAtPosition(position);

                Intent intent = null;
                switch(position) {
                    case 0://Language
                        //intent = startSettingActivity(RearrangeSetting.class);
                        break;
                    case 1://Theme
                        //intent = startSettingActivity(BlankSetting.class);
                        break;
                    case 2://Dictionary
                        intent = startSettingActivity(DictMainActivity.class);
                        break;
                    case 3://Wordpad
                        intent = startSettingActivity(MainActivity.class);
                        break;
                    /*case 4:
                        if (Build.VERSION.SDK_INT >= 23) {
                            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                                AlertDialog.Builder msg = new AlertDialog.Builder(reqPermAct);
                                msg.setTitle("안내");
                                msg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        ActivityCompat.requestPermissions(reqPermAct, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                                    }
                                });
                                msg.setMessage("본문 파일을 불러오기 위해 기기 저장소에 접근할 수 있도록 권한을 설정해 주세요");
                                msg.show();
                            } else {
                                intent = new Intent(MainSettingActivity.this,FileLoadActivity.class);
                            }
                        }
                        break;*/
                }

                if (intent != null) {
                    startActivity(intent);
                    finish();
                }
            }
        });

        /*//Icon 색상 변경
        ImageView img = findViewById(R.id.img_icon_main);
        img.setColorFilter(getResources().getColor(R.color.colorPrimary), PorterDuff.Mode.SRC_IN);*/

    }

    private Intent startSettingActivity(Class cls) {
        return new Intent(MainSettingActivity.this, cls);
    }
}
