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

public class Homepage extends AppCompatActivity {

    private static Button button_sgup;
    private static Button button_log;
    private EditText login_email;
    private EditText login_pass;
   private FirebaseAuth firebaseAuth;
    String email;
    String password;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        login_email = (EditText) findViewById(R.id.emaillogin);


        login_pass = (EditText) findViewById(R.id.passlogin);
        button_sgup = (Button) findViewById(R.id.signup);
        button_log = (Button) findViewById(R.id.login);
        firebaseAuth = FirebaseAuth.getInstance();

        NormalFunction();
    }
    public void NormalFunction() {

        button_sgup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Homepage.this, SignUp.class);
                        startActivity(intent);
                    }
                });

    }

    public void button_Click(View v) {


        email = login_email.getText().toString().trim();
        password = login_pass.getText().toString().trim();

        //  this.getLogin_name();



        if (TextUtils.isEmpty(email)) {
            Toast.makeText(Homepage.this, "Please enter username", Toast.LENGTH_SHORT).show();
            return;

        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(Homepage.this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        final ProgressDialog progressDialog = ProgressDialog.show(Homepage.this, "Please wait...", "Processing...", true);




        (firebaseAuth.signInWithEmailAndPassword(login_email.getText().toString(), login_pass.getText().toString())).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            // public EditText getLogin_name() {
            //   return login_name;
            //}

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    Toast.makeText(Homepage.this, "Login successfull", Toast.LENGTH_LONG).show();


                    Intent i = new Intent(Homepage.this, Track.class);
                    i.putExtra("Email", email);
                    i.putExtra("Email", firebaseAuth.getCurrentUser().getEmail());


                    startActivity(i);




                } else {
                    Log.e("ERROR", task.getException().toString());
                    Toast.makeText(Homepage.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });


    }









}
