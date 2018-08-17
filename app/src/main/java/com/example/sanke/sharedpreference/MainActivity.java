package com.example.sanke.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
EditText et1,et2;
Button bt1,bt2;
Switch sw1;
TextView tv1,tv2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        bt1=(Button)findViewById(R.id.save);
        bt2=(Button)findViewById(R.id.load);
        sw1=(Switch)findViewById(R.id.sw1);
        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        SharedPreferences sharedPreferences=getSharedPreferences("myfile",Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username",null);
        String password=sharedPreferences.getString("password",null);
        if(username!=null&&password!=null)
        {
            et1.setText(username);
            et2.setText(password);
        }
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee=new Employee(1,"Sanket","Kambli");
                Gson g=new Gson();
                String emp=g.toJson(employee,Employee.class);

               String username=et1.getText().toString();
              String  password=et2.getText().toString();
                SharedPreferences sharedPreferences=getSharedPreferences("myfile",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                if(sharedPreferences.getBoolean("isChecked",false))
                {
                   editor.putString("username",username);
                   editor.putString("password",password);
                   editor.putString("details",emp);
                   editor.apply();
                }
                else
                    {
                       if(!sharedPreferences.getString("username",null).equals(username) || !sharedPreferences.getString("password",null).equals(password))
                       {
                           editor.remove("username");
                           editor.remove("password");
                           editor.apply();
                       }
                    }

            }
        });
        sw1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {



                SharedPreferences sharedPreferences=getSharedPreferences("myfile", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putBoolean("isChecked",b);
                editor.apply();



            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
SharedPreferences sharedPreferences=getSharedPreferences("myfile",Context.MODE_PRIVATE);
String s1=sharedPreferences.getString("username","N/A");
String s2=sharedPreferences.getString("password","N/A");
Gson g=new Gson();
Employee e=g.fromJson(sharedPreferences.getString("details",null),Employee.class);

tv1.setText(s1);
tv2.setText(s2+e.toString());
            }
        });


    }


}
