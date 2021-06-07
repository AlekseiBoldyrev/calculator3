package ru.geekbrains.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private String numbersCalc = "";
    private TextView textCalc;
    double rez = 0;
    String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();

    }

    /**
     * О программе:
     * 1. На табло высвечивается полная инфрмация о всех чмслах и действиях, до тех пор пока не нажмем на "=".
     * 2. Все вычисления и информация для табло идет в классе "Calc".
     * 3. В методе InitView идет обработка кнопок и взаимодействие с классом Calc. Формирование числа идет в переменной numbersCalc.
     * После того как нажмем на действие или равно переменная рьнуляется, а информация из нее передается в Calc для расчета.
     * Информация для табло формируется в переменной strCalc в классе Calc.
     * @param str
     * @return
     */

    public static boolean checkDot(String str) {
        String check[] = str.split("[.]");
        if (check.length < 2) {
            return true;
        } else {
            return false;
        }
    }


    private void initView() {
        Calc calc = new Calc();

        textCalc = findViewById(R.id.textView);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbersCalc += button1.getText();
                textCalc.setText(calc.getStrCalc((String) button1.getText()));
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbersCalc += button2.getText();
                textCalc.setText(calc.getStrCalc((String) button2.getText()));
            }
        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbersCalc += button3.getText();
                textCalc.setText(calc.getStrCalc((String) button3.getText()));
            }
        });
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbersCalc += button4.getText();
                textCalc.setText(calc.getStrCalc((String) button4.getText()));
            }
        });
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbersCalc += button5.getText();
                textCalc.setText(calc.getStrCalc((String) button5.getText()));
            }
        });
        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbersCalc += button6.getText();
                textCalc.setText(calc.getStrCalc((String) button6.getText()));
            }
        });
        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbersCalc += button7.getText();
                textCalc.setText(calc.getStrCalc((String) button7.getText()));
            }
        });
        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbersCalc += button8.getText();
                textCalc.setText(calc.getStrCalc((String) button8.getText()));
            }
        });
        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numbersCalc += button9.getText();
                textCalc.setText(calc.getStrCalc((String) button9.getText()));
            }
        });
        Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numbersCalc.length() > 0) {
                    numbersCalc += button0.getText();
                    textCalc.setText(calc.getStrCalc((String) button0.getText()));
                }
            }
        });
        Button buttonDot = findViewById(R.id.buttonDot);
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!numbersCalc.toString().contains(".")) {
                    if (numbersCalc.length() > 0) {
                        numbersCalc += buttonDot.getText();
                        textCalc.setText(calc.getStrCalc((String) buttonDot.getText()));
                    } else {
                        numbersCalc = "0.";
                        textCalc.setText(calc.getStrCalc((String) buttonDot.getText()));
                    }
                }
            }
        });

        Button buttonSum = findViewById(R.id.buttonSum);
        buttonSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numbersCalc.length() > 0) {
                    calc.setCalcIn(numbersCalc);
                    calc.getCalcOut();
                    numbersCalc = "";
                    calc.setAction((String) buttonSum.getText());
                    textCalc.setText(calc.getStrCalc((String) buttonSum.getText()));
                }
            }
        });
        Button buttonSubstract = findViewById(R.id.buttonSubstract);
        buttonSubstract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numbersCalc.length() > 0) {
                    calc.setCalcIn(numbersCalc);
                    calc.getCalcOut();
                    numbersCalc = "";
                    calc.setAction((String) buttonSubstract.getText());
                    textCalc.setText(calc.getStrCalc((String) buttonSubstract.getText()));
                }
            }
        });
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numbersCalc.length() > 0) {
                    calc.setCalcIn(numbersCalc);
                    calc.getCalcOut();
                    numbersCalc = "";
                    calc.setAction((String) buttonMultiply.getText());
                    textCalc.setText(calc.getStrCalc((String) buttonMultiply.getText()));
                }
            }
        });
        Button buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numbersCalc.length() > 0) {
                    calc.setCalcIn(numbersCalc);
                    calc.getCalcOut();
                    numbersCalc = "";
                    calc.setAction((String) buttonDivide.getText());
                    textCalc.setText(calc.getStrCalc((String) buttonDivide.getText()));
                }
            }
        });
        Button buttonEquals = findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.setCalcIn(numbersCalc);
                numbersCalc = "";

                textCalc.setText(String.format("%.3f", calc.getCalcOut()));
                calc.rezetAll();

            }
        });
        Button buttonRezet = findViewById(R.id.buttonRezet);
        buttonRezet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calc.rezetAll();
                numbersCalc = "";
                textCalc.setText(String.format("%.3f", calc.getCalcOut()));
            }
        });


    }

}
