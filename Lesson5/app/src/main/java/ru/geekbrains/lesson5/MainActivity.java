package ru.geekbrains.lesson5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Constants {
    private EditText txtName;
    private Account account;
    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;
    private final static String TAG = "[LifeCycleActivity]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //для сообщений о состоянии
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        makeToast(instanceState + " - onCreate()");

        account = new Account();
        initView();
    }

    //сообщения о состоянии
    private void makeToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Log.d(TAG, message);
    }

    private void initView() {
        Button btnGreetings = findViewById(R.id.btnGreetings);
        txtName = findViewById(R.id.textName);


        final TextView txtGreetings = findViewById(R.id.textHello);
        btnGreetings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = txtName.getText().toString();
                String sayHello = getString(R.string.say_hello) + name;
                txtGreetings.setText(sayHello);
            }
        });
        Button btnSettings = findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Чтобы стартовать активити, надо подготовить интент
                // В данном случае это будет явный интент, поскольку здесь передаётся класс активити
                Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);
                populateAccount();

                // Передача данных через интент
                runSettings.putExtra(YOUR_ACCOUNT, account);


                // Метод стартует активити, указанную в интенте
                startActivityForResult(runSettings, REQUEST_CODE_SETTING_ACTIVITY);

            }
        });
    }

    private void populateAccount() {
        account.setName(txtName.getText().toString());
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != REQUEST_CODE_SETTING_ACTIVITY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        if (resultCode == RESULT_OK){
            account = data.getParcelableExtra(YOUR_ACCOUNT);
            populateView();
        }
    }

    private void populateView(){
        txtName.setText(account.getName());
    }

}
