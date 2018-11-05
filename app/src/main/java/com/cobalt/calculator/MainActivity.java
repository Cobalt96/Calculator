package com.cobalt.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class  MainActivity extends AppCompatActivity {

    EditText x1;
    EditText x2;
    TextView result;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x1 = (EditText) findViewById(R.id.x1);
        x2 = (EditText) findViewById(R.id.x2);
        result = (TextView) findViewById(R.id.result);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
    }

    public void onClickParce(View view) {

        Calculator calc = new Calculator("","","");
        calc.setFirstNum(x1.getText().toString());
        calc.setSecondNum(x2.getText().toString());

        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton myRadioButton = (RadioButton) findViewById(checkedRadioButtonId);
        calc.setOperator(myRadioButton.getText().toString());



        Intent intent = new Intent(this,CalculateActivity.class);
        intent.putExtra(Calculator.class.getSimpleName(), calc);
        startActivityForResult(intent, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK){
            String answer = data.getStringExtra("result");
            result.setText("Результат " + answer);
        }
        else{
            result.setText("Ошибка доступа");
        }
    }

    public void onClickClear(View view) {
        radioGroup.clearCheck();
        x1.setText("");
        x2.setText("");
        result.setText("");
    }

}
