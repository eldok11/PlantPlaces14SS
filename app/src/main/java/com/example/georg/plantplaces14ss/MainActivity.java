package com.example.georg.plantplaces14ss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       description= findViewById(R.id.editText);
    }

    public void searchClick(View v){
        String strDescription= description.getText().toString();
        int value=sum(1,2);
        Toast.makeText(this,strDescription + value,Toast.LENGTH_LONG).show();

    }

    public int sum(int operand1, int operand2){
        int total=operand1+operand2;
      return total;
    }
}
