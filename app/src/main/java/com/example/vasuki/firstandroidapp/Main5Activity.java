package com.example.vasuki.firstandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    EditText  username,Password,EmailId,PhoneNumber;
    Spinner spinner,spinner1,spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

           username =(EditText)findViewById(R.id.UserName);
           Password =(EditText)findViewById(R.id.Password);
          EmailId =(EditText)findViewById(R.id.EmailID);
         PhoneNumber=(EditText)findViewById(R.id.PhoneNumber);
          spinner = (Spinner) findViewById(R.id.spinner1);
          spinner1=(Spinner)findViewById(R.id.spinner2);
          spinner2=(Spinner)findViewById(R.id.spinner3);
        Button submit;
        submit=(Button)findViewById(R.id.submit);
        submit.setOnClickListener(new  View.OnClickListener()
        {

            @Override
            public void onClick(View view) {
                String Name = username.getText().toString();
                String password = Password.getText().toString();
                String EmailID = EmailId.getText().toString();
                String PhoneNumber = EmailId.getText().toString();
                String City = spinner.getSelectedItem().toString();
                String State = spinner1.getSelectedItem().toString();
                String Country = spinner2.getSelectedItem().toString();
                if(!Name.equals("CodeShaala")&& !password.equals("android") )

                {
                    Toast.makeText(Main5Activity.this,"Invalid Credential",Toast.LENGTH_SHORT).show();
                }
               else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(EmailID).matches()&& !android.util.Patterns.PHONE.matcher(PhoneNumber).matches())
                {
                    Toast.makeText(Main5Activity.this,"Invalid Emailid and phonenumber",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(Main5Activity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
