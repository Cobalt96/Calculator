package com.cobalt.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateActivity extends AppCompatActivity {

    TextView tvParce;
    float x1 = 0;
    float x2 = 0;
    float res = 0;
    String otvet;
    String op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        tvParce = (TextView) findViewById(R.id.tvParce);

        Calculator calc= (Calculator) getIntent().getParcelableExtra("Calculator");

        x1 = Float.parseFloat(calc.getFirstNum().toString());
        x2 = Float.parseFloat(calc.getSecondNum().toString());
        op = calc.getOperator();

        tvParce.setText("x1 = " + calc.getFirstNum()+" | x2 = " + calc.getSecondNum()+" | оператор = " + calc.getOperator());
    }

    public void onClickCalc(View view) {
        try{
            switch (op) {
                case "+":
                    res = x1+x2;
                    break;
                case "-":
                    res = x1-x2;
                    break;
                case "*":
                    res = x1*x2;
                    break;
                case "/":
                    res = x1/x2;
                    break;
            }
        } catch (ArithmeticException e) {
            Toast.makeText(this, "Нельзя делить на ноль!", Toast.LENGTH_LONG).show();
        }
        otvet = Float.toString(res);
        Intent intent = new Intent();
        intent.putExtra("result", otvet);
        setResult(RESULT_OK, intent);
        finish();
    }

}
