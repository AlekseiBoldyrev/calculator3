package ru.geekbrains.calculator;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import static java.lang.String.format;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "[LifeCycleActivity]";
    private final static String CALC = "Calc";
    private Calc calc;
    private TextView textCalc;
    private TextView textCalc2;
    //private TextView textCalc3;
    //private TextView textCalc4;

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
        setContentView(R.layout.activity_main);
        String instanceState;
        if (savedInstanceState == null) {
            instanceState = "Первый запуск!";
        } else {
            instanceState = "Повторный запуск!";
        }
        Toast.makeText(getApplicationContext(), instanceState + " - onCreate()", Toast.LENGTH_SHORT).show();
        makeToast(instanceState + " - onCreate()");


        calc = new Calc();
        initView();
        initBotton();

    }

    private void makeToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        Log.d(TAG, message);
    }



    /**
     * инициализируем поле вывода
     */
    private void initView() {
        textCalc = findViewById(R.id.textView);
        textCalc2 = findViewById(R.id.textView2);

        //запасные поля для вывода переменных  для проверки
//        textCalc3 = findViewById(R.id.textView3);
//        textCalc4 = findViewById(R.id.textView4);
    }

    private void outputText() {
        textCalc.setText(calc.getNumber());
        textCalc2.setText(calc.getStrCalc());

//        textCalc3.setText(String.format("%.4f", calc.getCalculation()));
//        textCalc4.setText(calc.getAction());
    }

    /**
     * О программе:
     * 1. Есть 2-а табло.
     * На верхнем высвечивается вся информация по введенным действиям, по текущему расчету.
     * На нижнем высвечивается вводимое число и результат.

     * 2. Все вычисления и информация для табло идет в классе "Calc".

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

    }


}
