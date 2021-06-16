package ru.geekbrains.calculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static java.lang.Integer.parseInt;
import static java.lang.String.format;

public class MainActivity extends AppCompatActivity implements Constants {

    private static final int REQUEST_CODE_SETTING_ACTIVITY = 99;
    private final static String CALC = "Calc";
    private Calc calc;
    private TextView textCalc;
    private TextView textCalc2;
    private TextView textCalc3;
    private static int idCodeStyle;



    // Имя настроек
    private static final String NameSharedPreference = "LOGIN";
    // Имя параметра в настройках
    private static final String AppTheme = "APP_THEME";
    private static final int MyNightThemeCodeStyle = 0;
    private static final int MyDayThemeCodeStyle = 1;
    private static final int MyCoolStyleCodeStyle = 2;

    // Сохранение данных
    @Override
    protected void onSaveInstanceState(Bundle instanceState) {
        super.onSaveInstanceState(instanceState);
        instanceState.putParcelable(CALC, calc);


    }

    //Восстановление данных
    @Override
    protected void onRestoreInstanceState(Bundle instanceState) {
        super.onRestoreInstanceState(instanceState);
        calc = (Calc) instanceState.getParcelable(CALC);
        outputText();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getAppTheme(R.style.MyNightTheme));

        setContentView(R.layout.activity_main);


        calc = new Calc();
        initView();
        initBotton();
        initButtonTheme();
        initButtonTheme2();

        textCalc3.setText(String.valueOf( getCodeStyle(R.style.MyDayTheme)));//вывод кода темы
        idCodeStyle = getCodeStyle(R.style.MyDayTheme);
    }

    /**
     * инициализируем поле вывода
     */
    private void initView() {
        textCalc = findViewById(R.id.textView);
        textCalc2 = findViewById(R.id.textView2);
        textCalc3 = findViewById(R.id.textView3);
    }

    //выводим результат на табло
    private void outputText() {
        textCalc.setText(calc.getNumber());//1-е табло с текущим числом и результатом вычислений
        textCalc2.setText(calc.getStrCalc());//2-е табло с отображением всех действий

    }

    private static int initThemeChooser() {

        switch (idCodeStyle) {
            case 0:
                return idCodeStyle = 1;
            case 1:
                return idCodeStyle = 2;
            case 2:
                return idCodeStyle = 0;
            default:
                return idCodeStyle = 0;
        }

    }
//установка темеы по нажатию кнопке

    private void initButtonTheme() {
        Button buttonTheme = findViewById(R.id.buttonTheme);
        buttonTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // сохраним настройки

                setAppTheme(initThemeChooser());
                // пересоздадим активити, чтобы тема применилась
                recreate();
            }
        });
    }

    //установка темы по нажатию кнопке через отдельное активити

    private void initButtonTheme2() {
        Button buttonTheme2 = findViewById(R.id.buttonTheme2);
        buttonTheme2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Чтобы стартовать активити, надо подготовить интент
                // В данном случае это будет явный интент, поскольку здесь передаётся класс активити
                Intent runSettings = new Intent(MainActivity.this, SettingsActivity.class);

                // Передача данных через интент
                runSettings.putExtra(YOUR_THEME, String.valueOf(getCodeStyle(R.style.MyDayTheme)));

                // Метод стартует активити, указанную в интенте
               //startActivity(runSettings);
                // Усложнение. Метод стартует активити, указанную в интенте для возврата результата из нее по коду
                startActivityForResult(runSettings, REQUEST_CODE_SETTING_ACTIVITY);


            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != REQUEST_CODE_SETTING_ACTIVITY) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }

        if (resultCode == RESULT_OK){
            //получаем инфо от интента
            String text = data.getStringExtra(YOUR_THEME);
            setAppTheme(parseInt(text));

            // пересоздадим активити, чтобы тема применилась
            recreate();

        }
    }


    private void setAppTheme(int codeStyle) {
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        // Настройки сохраняются посредством специального класса editor.
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(AppTheme, codeStyle);
        editor.apply();
    }

    private int getAppTheme(int codeStyle) {
        return codeStyleToStyleId(getCodeStyle(codeStyle));
    }

    private int getCodeStyle(int codeStyle) {
        // Работаем через специальный класс сохранения и чтения настроек
        SharedPreferences sharedPref = getSharedPreferences(NameSharedPreference, MODE_PRIVATE);
        //Прочитать тему, если настройка не найдена - взять по умолчанию
        return sharedPref.getInt(AppTheme, codeStyle);
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case MyNightThemeCodeStyle:
                return R.style.MyNightTheme;
            case MyDayThemeCodeStyle:
                return R.style.MyDayTheme;
            case MyCoolStyleCodeStyle:
                return R.style.MyCoolStyle;
            default:
                return R.style.MyDayTheme;
        }
    }


    /**
     * О программе:
     * 1. Есть 2-а табло.
     * На верхнем высвечивается вся информация по введенным действиям по текущему расчету.
     * На нижнем высвечивается вводимое число и конечный результат.
     * <p>
     * 2. Все вычисления и информация для табло идут в классе "Calc".
     */
    public void initBotton() {

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) button1.getText());
                outputText();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) button2.getText());
                outputText();
            }
        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) button3.getText());
                outputText();
            }
        });
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) button4.getText());
                outputText();
            }
        });
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) button5.getText());
                outputText();
            }
        });
        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) button6.getText());
                outputText();
            }
        });
        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) button7.getText());
                outputText();
            }
        });
        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) button8.getText());
                outputText();
            }
        });
        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) button9.getText());
                outputText();
            }
        });
        Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) button0.getText());
                outputText();
            }
        });
        Button buttonDot = findViewById(R.id.buttonDot);
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) buttonDot.getText());
                outputText();
            }
        });

        Button buttonSum = findViewById(R.id.buttonSum);
        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) buttonSum.getText());
                outputText();
            }
        });
        Button buttonSubstract = findViewById(R.id.buttonSubstract);
        buttonSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) buttonSubstract.getText());
                outputText();
            }

        });
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) buttonMultiply.getText());
                outputText();
            }

        });
        Button buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) buttonDivide.getText());
                outputText();
            }

        });
        Button buttonEquals = findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) buttonEquals.getText());
                outputText();
            }

        });
        Button buttonRezet = findViewById(R.id.buttonRezet);
        buttonRezet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) buttonRezet.getText());
                outputText();
            }
        });
        Button buttonDel = findViewById(R.id.buttonDel);
        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.clickCalc((String) buttonDel.getText());
                outputText();
            }
        });

    }


}
