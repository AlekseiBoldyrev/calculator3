package ru.geekbrains.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "[LifeCycleActivity]";
    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBotton();
    }

    //по кнопке переходим в интент для создания сообщения
    private void initBotton() {
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent runSettings = new Intent(MainActivity.this, NoteActivity.class);
                startActivityForResult(runSettings, REQUEST_CODE_SETTING_ACTIVITY);
            }
        });
    }

    //возврат из нтинта с автоматическим обновлением в МэйнАктивити списка сообщений
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != REQUEST_CODE_SETTING_ACTIVITY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        if (resultCode == RESULT_OK){
            recreate();
        }
    }

}