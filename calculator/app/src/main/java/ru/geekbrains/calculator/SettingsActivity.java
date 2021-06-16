package ru.geekbrains.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.radiobutton.MaterialRadioButton;

import static java.lang.Integer.parseInt;

public class SettingsActivity extends AppCompatActivity implements Constants {

    private static final int MyNightCodeStyle = 0;
    private static final int MyDayCodeStyle = 1;
    private static final int MyCoolCodeStyle = 2;
    private static String theme;
    private TextView codeTheme;

    private void initView() {
        codeTheme = findViewById(R.id.textView);
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings2);

        initReturn();
        initView();//проверка установки кода темы


        // получить данные из Intent
        String codeThemeFromCalc = getIntent().getExtras().getString(YOUR_THEME);
        initThemeChooser(codeThemeFromCalc);
        // Вывести код  в поле на экране
        codeTheme.setText(codeThemeFromCalc);

    }

    private void initThemeChooser(String codeThemeFromCalc) {


        initRadioButton(findViewById(R.id.radioButtonMyNightStyle),
                MyNightCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMyDayStyle),
                MyDayCodeStyle);
        initRadioButton(findViewById(R.id.radioButtonMyCoolStyle),
                MyCoolCodeStyle);
        RadioGroup rg = findViewById(R.id.radioButtons);

        //  берем код из калькулятора и ставим кнопку по этому коду
        ((MaterialRadioButton)rg.getChildAt(parseInt(codeThemeFromCalc))).setChecked(true);

    }

    // Все инициализации кнопок очень похожи, поэтому создадим метод для переиспользования
    private void initRadioButton(View button, final int codeStyle) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                theme = String.valueOf(codeStyle);
                codeTheme.setText(theme + " fromRadio");//проверка установки кода темы
            }
        });
    }

    private void initReturn() {
        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentResult = new Intent();
                intentResult.putExtra(YOUR_THEME,theme);
                setResult(RESULT_OK, intentResult);

                // Метод finish() завершает активити
                finish();
            }
        });


    }
}