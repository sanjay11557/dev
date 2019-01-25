package com.developer.s.worklist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WorklistLogin extends Activity {
    EditText userEdit,passEdit;
    String username,password,userid,pass;
    Button login_but;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worklist_login);
        userEdit=(EditText) findViewById(R.id.input_username);
        passEdit=(EditText)findViewById(R.id.input_password);
        login_but=(Button) findViewById(R.id.login);
        userid="sanjay";
        pass="a";
        System.out.println("USERNAME : "+username+" PASSWORD: "+password);
        login_but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username=userEdit.getText().toString().trim();
                password=passEdit.getText().toString().trim();
                if(username.equals(userid) && password.equals(pass))
                {
                    System.out.println("USERID : "+userid+" PASSWORD : "+pass);
                    Intent i=new Intent(getApplicationContext(),Dashboard.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Toast t= Toast.makeText(getApplicationContext(),"Incorrect username/password",Toast.LENGTH_SHORT);
                    t.show();
                    userEdit.setText("");
                    passEdit.setText("");
                    userEdit.requestFocus();
                }
            }
        });


    }
}

