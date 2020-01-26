package com.example.admin.antitheft;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    private EditText name;
    private EditText pass;
    private Button register;
    private Button button_bck;
    private FirebaseAuth firebaseAuth;
    private  String email;
    private  String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        OnClickButtonListerner();
        name = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        firebaseAuth = FirebaseAuth.getInstance();
        register = (Button) findViewById(R.id.registers);
    }
    public void OnClickButtonListerner(){
        button_bck = (Button)findViewById(R.id.back);
        button_bck.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.admin.antitheft.Homepage");
                        startActivity(intent);
                    }
                }
        );
    }
    public void button_Click(View v){
        email = name.getText().toString().trim();
        password = pass.getText().toString().trim();

        //  this.getLogin_name();



        if (TextUtils.isEmpty(email)) {
            Toast.makeText(SignUp.this, "Please enter username", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(SignUp.this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }


        final ProgressDialog progressDialog = ProgressDialog.show(SignUp.this,"Please Wait...","Processing...",true);
        (firebaseAuth.createUserWithEmailAndPassword(name.getText().toString(),pass.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if (task.isSuccessful()) {
                    Toast.makeText(SignUp.this, "Registration Successfull", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(SignUp.this, Homepage.class);
                    startActivity(i);
                } else {
                    Log.e("ERROR", task.getException().toString());
                    Toast.makeText(SignUp.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }

        });
    }





}
