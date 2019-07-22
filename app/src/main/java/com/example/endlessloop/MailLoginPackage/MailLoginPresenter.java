package com.example.endlessloop.MailLoginPackage;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.endlessloop.MailSignUpPackage.MailSignUpActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MailLoginPresenter {

    private Context context;
    private FirebaseAuth mAuth;

    MailLoginPresenter(Context context) {

        this.context = context;
        mAuth = FirebaseAuth.getInstance();
    }

    void SignIn(final String mail,final String password){

        mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){


                }
            }
        });

    }

    void SendUserToRegisterActivity(){

        Intent registerIntent = new Intent(context, MailSignUpActivity.class);
        context.startActivity(registerIntent);


    }
}
