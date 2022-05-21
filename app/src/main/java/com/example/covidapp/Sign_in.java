package com.example.covidapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Sign_in extends AppCompatActivity {
EditText email1;
EditText password1;
Button signin;
TextView register;
private FirebaseAuth mAuth;
    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
         email1= (EditText) findViewById(R.id.emailfield1);
         password1= (EditText) findViewById(R.id.passfield1);
         register=(TextView) findViewById(R.id.register);
         mAuth = FirebaseAuth.getInstance();

         register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toRegister();
            }
        });
         signin=(Button)findViewById(R.id.signinbutton);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=email1.getText().toString();
                String password=password1.getText().toString();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Sign_in.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                 //   Log.d(TAG, "signInWithEmail:success");
                                   // FirebaseUser user = mAuth.getCurrentUser();
                                   // updateUI(user);
                                    Intent intent=new Intent(Sign_in.this , Tabs.class);
                                    startActivity(intent);
                                }
                                else {
                                    // If sign in fails, display a message to the user.
                                   // Log.w(TAG, "signInWithEmail:failure", task.getException());
                                   Toast.makeText(Sign_in.this, "Authentication failed.",
                                           Toast.LENGTH_SHORT).show();
                                   // updateUI(null);
                                }
                            }
                        });
                //toHello();
            }
        });

    }
    public void toRegister(){
        type=getIntent().getStringExtra("type");
        Intent intent = new Intent(this , Register.class);
        intent.putExtra("type",type);
        startActivity(intent);
    }

}