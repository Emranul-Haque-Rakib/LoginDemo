package com.example.rakib.logindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Enter;
    private TextView attempt;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Name=findViewById(R.id.edittext);
        attempt=findViewById(R.id.textView2);
        Password=findViewById(R.id.edittext2);
        Enter=findViewById(R.id.button);
        attempt.setText("No of attemts remaining: 5");
        Enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

    }

    private void validate(String Username,String UserPassword){
        if((Username=="Admin") && (UserPassword=="1234")){
            Intent intent=new Intent(this,Main2Activity.class);
            startActivity(intent);
        }else{

            counter--;
            attempt.setText("NO of attempts remaining"+String.valueOf(counter));
                if(counter==0){
                    Enter.setEnabled(false);
                }
        }
    }
}
