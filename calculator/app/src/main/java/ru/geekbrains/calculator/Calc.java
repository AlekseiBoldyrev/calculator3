package ru.geekbrains.calculator;

import android.os.Parcel;
import android.os.Parcelable;


import java.io.Serializable;

public class Calc implements Parcelable {

    private Double calculation;
    private String strCalc;
    private String number;
    private String action;

    public Calc() {
        calculation = (double) 0;
        strCalc = "";
        action = "";
        number = "";
    }

    protected Calc(Parcel in) {
        if (in.readByte() == 0) {
            calculation = null;
        } else {
            calculation = in.readDouble();
        }
        strCalc = in.readString();
        number = in.readString();
        action = in.readString();
    }

    public static final Creator<Calc> CREATOR = new Creator<Calc>() {
        @Override
        public Calc createFromParcel(Parcel in) {
            return new Calc(in);
        }

        @Override
        public Calc[] newArray(int size) {
            return new Calc[size];
        }
    };

    public String getNumber() {
        return number;
    }

    public String getAction() {
        return action;
    }

    public Double getCalculation() {
        return (double) Math.round(calculation * 100) / 100;
    }

    /**
     * метод на ввод числа
     *
     * @param str
     */
    private void setNumbers(String str) {
        //проверка если после нажатия равно и вывода результата будет введена цифра, то старый расчет сбрасываем и делаем новый расчет
        if (getCalculation() != 0 && action == "" && number.length() > 0) {
            rezetAll();
            number = str;
        } else {
            if (number.length() < 2 && number.equals("0")) {
                number = str;
            } else {
                number += str;
            }
        }
    }


    public String getStrCalc() {
        return strCalc;
    }

    public void setAction(String action) {
        this.action = action;
    }

    /**
     * метод принимает все что ввелось в калькуляторе и обрабатывает это
     *
     * @param str
     */
    public void clickCalc(String str) {

        switch (str) {
            case "+":
                action(str);
                break;
            case "-":
                action(str);
                break;
            case "*":
                action(str);
                break;
            case "÷":
                action(str);
                break;
            case "0":
                setNumbers(str);
                break;
            case "1":
                setNumbers(str);
                break;
            case "2":
                setNumbers(str);
                break;
            case "3":
                setNumbers(str);
                break;
            case "4":
                setNumbers(str);
                break;
            case "5":
                setNumbers(str);
                break;
            case "6":
                setNumbers(str);
                break;
            case "7":
                setNumbers(str);
                break;
            case "8":
                setNumbers(str);
                break;
            case "9":
                setNumbers(str);
                break;
            case ".":
                //если число уже содержит точку то 2-ю точку не ставим
                if (!number.contains(".")) {
                    if (number.length() < 1) {
                        number = "0.";
                    } else {
                        number += str;
                    }
                }
                break;
            case "C":
                rezetAll();
                break;
            case "del":
                if (number.length() > 0 && action != "") {//отсутствие action, говорит о том что на табло результат - его стиратть не будем
                    number = number.substring(0, number.length() - 1);
                }

                break;

            case "=":
                //проверка на нажатие клавиши "=", если есть число и число не равно 0 и в буфере есть действие, которое можно просчитать.
                if (number.length() > 0 && !number.equals("0") && action != "") {
                    Calculation(number);
                    strCalc += number;//формируем сводную строку для табло
                    strCalc += str; //формируем сводную строку для табло
                    setAction("");//обнуляем буфер с действием
                    number = String.valueOf(getCalculation());//присваиваем результат в текущее число, для возможности продолжения расчета
                }
                break;
        }

    }

    /**
     * метод при нажатии на кнопки действия
     *
     * @param str
     */
    private void action(String str) {
        if (number.length() > 0 && !number.equals("0")) {
            Calculation(number);//передаем число для обсчета
            setAction(str); // передаем действие в буфер
            strCalc += String.valueOf(Double.parseDouble(number));//если в числе есть последние нули, то убираем их - преобразуя текст в число и обратно.
            strCalc += str;//формируем сводную строку для табло
            number = ""; // обнуляем текущее число
        } else {
            // чтобы поменять действие до ввода 2-го числа
            setAction(str);//меняем действие
            strCalc = strCalc.substring(0, strCalc.length() - 1);//стираем предыдущее действие из строки
            strCalc += str;//устанавливаем новое действие

        }

    }

    private void rezetAll() {
        strCalc = "";
        calculation = (double) 0;
        number = "";
    }


    public void Calculation(String numbers) {

        if (action.length() > 0) {

            switch (action) {
                case "+":
                    calculation += Double.parseDouble(numbers);
                    break;
                case "-":
                    calculation -= Double.parseDouble(numbers);
                    break;
                case "*":
                    calculation *= Double.parseDouble(numbers);
                    break;
                case "÷":
                    calculation /= Double.parseDouble(numbers);
                    break;
            }
        } else {
            calculation = Double.parseDouble(numbers);

        }

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (calculation == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(calculation);
        }
        dest.writeString(strCalc);
        dest.writeString(number);
        dest.writeString(action);
    }

}
