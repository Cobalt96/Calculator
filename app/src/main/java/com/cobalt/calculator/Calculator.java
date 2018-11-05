package com.cobalt.calculator;

import android.os.Parcel;
import android.os.Parcelable;

public class Calculator implements Parcelable{



    private String firstNum,secondNum,operator;

    public String getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(String firstNum) {
        this.firstNum = firstNum;
    }

    public String getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(String secondNum) {
        this.secondNum = secondNum;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
    //==============================

    public Calculator(String _firstNum,String _secondNum,String _operator) {
        firstNum = _firstNum;
        secondNum = _secondNum;
        operator = _operator;
    }

    public int describeContents() {
        return 0;
    }

    // упаковываем объект в Parcel
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(firstNum);
        parcel.writeString(secondNum);
        parcel.writeString(operator);
    }

    public static final Parcelable.Creator<Calculator> CREATOR = new Parcelable.Creator<Calculator>() {
        // распаковываем объект из Parcel
        public Calculator createFromParcel(Parcel in) {

            return new Calculator(in);
        }

        public Calculator[] newArray(int size) {
            return new Calculator[size];
        }
    };

    // конструктор, считывающий данные из Parcel
    public Calculator(Parcel parcel) {

        firstNum = parcel.readString();
        secondNum = parcel.readString();
        operator = parcel.readString();
    }
}
