package com.example.vasuki.firstandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class ListViewExample extends AppCompatActivity {
    EditText userName,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_example);
         userName =(EditText)findViewById(R.id.Username);
         password =(EditText)findViewById(R.id.Password);

        Button submit;
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name1 = userName.getText().toString();
                String password1 = password.getText().toString();
                if(Name1.equals("CodeShaala")&&password1.equals("android"))
                {
                    Intent intent = new Intent(ListViewExample.this,ViewDisplay.class);
                    startActivity(intent);

                }
                else
                    Toast.makeText(ListViewExample.this,"Invalid Credential",Toast.LENGTH_SHORT).show();

            }
        });
        }
}

