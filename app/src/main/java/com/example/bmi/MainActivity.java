package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        EditText editWeight , editHeightFt , editHeightIn;
        Button calculateBtn;
        TextView txtResult;
        LinearLayout mainLL;

        editWeight = findViewById (R.id.editWeight);
        editHeightFt = findViewById (R.id.editHeightInFt);
        editHeightIn = findViewById (R.id.editHeightInIns);

        calculateBtn = findViewById (R.id.calculateBtn);

        txtResult = findViewById (R.id.txtResult);

        mainLL = findViewById (R.id.mainLinear);

        calculateBtn.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
             int wt =  Integer.parseInt (editWeight.getText ().toString ());
             int htFt = Integer.parseInt (editHeightFt.getText ().toString ());
             int htIn = Integer.parseInt (editHeightIn.getText ().toString ());

             int totalIn = htFt * 12 + htIn;
             double totalCm = totalIn * 2.53;
             double totalM = totalCm/100;
             double bmi = wt/(totalM * totalM);

             if(bmi > 25)
             {
                 txtResult.setText ("You're Overweight");
                 mainLL.setBackgroundColor (getResources ().getColor (R.color.overW));
             }
             else if(bmi < 18)
             {
                 txtResult.setText ("You're Underweight");
                 mainLL.setBackgroundColor (getResources ().getColor (R.color.underW));
             }
             else
             {
                 txtResult.setText ("You're Healthy");
                 mainLL.setBackgroundColor (getResources ().getColor (R.color.healthy));
             }
            }
        });
    }
}