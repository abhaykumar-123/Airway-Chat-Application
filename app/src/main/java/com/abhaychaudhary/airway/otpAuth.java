package com.abhaychaudhary.airway;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class otpAuth extends AppCompatActivity {

    TextView mchangenumber;
    EditText mgetotp;
    android.widget.Button mverifyotp;
    String enteredotp;

    FirebaseAuth firebaseAuth;
    ProgressBar mprogressbarofotpauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_auth);

        mchangenumber = findViewById(R.id.changenumber);
        mverifyotp = findViewById(R.id.verifyotp);
        mgetotp = findViewById(R.id.getotp);

        mprogressbarofotpauth=findViewById(R.id.progressbarofotpauth);

        firebaseAuth=FirebaseAuth.getInstance();


        mchangenumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(otpAuth.this,MainActivity.class);
                startActivity(intent);
            }
        });


        mverifyotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                enteredotp=mgetotp.getText().toString();

                if(enteredotp.isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Please enter the OTP", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    mprogressbarofotpauth.setVisibility(View.VISIBLE);
                    String codereceived=getIntent().getStringExtra("otp");
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codereceived,enteredotp);
                    signInwithPhoneAuthCredential(credential);
                }
            }


        });


    }


    private void signInwithPhoneAuthCredential(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
              if(task.isSuccessful())
              {
                  mprogressbarofotpauth.setVisibility(View.INVISIBLE);
                  Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();

                  Intent intent=new Intent(otpAuth.this,setProfile.class);
                  startActivity(intent);
                  finish();
              }
              else
              {
                  if(task.getException() instanceof FirebaseAuthInvalidCredentialsException)
                  {
                      mprogressbarofotpauth.setVisibility(View.INVISIBLE);
                      Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                  }
              }
            }
        });
    }


}