
package com.example.ergasiaproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        if (getIntent().hasExtra("com.example.ergasiaproject.SOMETHING")){
            TextView tv=(TextView) findViewById(R.id.textView);
            String text= getIntent().getExtras().getString("com.example.ergasiaproject.SOMETHING");
            tv.setText(text);

        }

        Button addBtn=(Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstText= (EditText) findViewById(R.id.firstText);
                EditText secondText= (EditText) findViewById(R.id.secondText);
                TextView resultTextView= (TextView) findViewById(R.id.resultTextView);

                int num1=Integer.parseInt(firstText.getText().toString());
                int num2= Integer.parseInt(secondText.getText().toString());
                int result= num1+num2;
                resultTextView.setText(result +"");
            }
        });
    }
}
