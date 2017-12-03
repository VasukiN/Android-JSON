package com.example.vasuki.firstandroidapp;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    EditText username,Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        username =(EditText) findViewById(R.id.Username);
        Password =(EditText) findViewById(R.id.Password);
        Button submit;
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new  View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String Name = username.getText().toString();
                String password = Password.getText().toString();
                if(Name.equals("CodeShaala")&&password.equals("android"))
                {
                    Intent intent = new Intent(Main4Activity.this,MainActivity.class);
                    startActivity(intent);

                }
                else
                    Toast.makeText(Main4Activity.this,"Invalid Credential",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(Main4Activity.this,"OnStart Method for Main2Activity  called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(Main4Activity.this,"OnResume Methodfor Main2Activity  called",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(Main4Activity.this,"OnRestart Method for Main2Activity  called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(Main4Activity.this,"OnPause Method for Main2Activity  called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(Main4Activity.this,"OnStop Method for Main2Activity called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(Main4Activity.this,"OnDestroy Method for Main2Activity  Called",Toast.LENGTH_SHORT).show();
    }



}
