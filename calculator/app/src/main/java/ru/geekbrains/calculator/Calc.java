package ru.geekbrains.calculator;

public class Calc {

    private Double CalcOut = (double) 0;
    private String strCalc = "";
    private String CalcIn;
    private String action;

    Calc() {
    }

    public Double getCalcOut() {

        if (CalcOut != 0) {

            switch (action) {
                case "+":
                    CalcOut += +Double.parseDouble(CalcIn);
                    break;
                case "-":
                    CalcOut -= Double.parseDouble(CalcIn);
                    break;
                case "*":
                    CalcOut *= Double.parseDouble(CalcIn);
                    break;
                case "÷":
                    CalcOut /= Double.parseDouble(CalcIn);
                    break;
            }
        } else {
            CalcOut = Double.parseDouble(CalcIn);
        }

        return CalcOut;
    }

    public void setCalcIn(String CalcIn) {
        this.CalcIn = CalcIn;
    }

    public void rezetAll() {
        strCalc = "";
        CalcOut = (double) 0;
        CalcIn = "0";
    }

    public String getStrCalc(String str) {
        if (str.equals(".")&& strCalc.length()<1)  {
            strCalc = "0.";
        }else {
            strCalc += str;
        }
        return strCalc;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
