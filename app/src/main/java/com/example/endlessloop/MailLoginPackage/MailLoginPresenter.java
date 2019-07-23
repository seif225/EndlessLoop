package com.example.endlessloop.MailLoginPackage;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.endlessloop.MailSignUpPackage.MailSignUpActivity;
import com.example.endlessloop.MainPackage.MainActivity;
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

                    sendUserToMainActivity();

                }
            }
        });

    }

    private void sendUserToMainActivity() {

    Intent i = new Intent ( context , MainActivity.class);
    i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(i);

    }

    void SendUserToRegisterActivity(){

        Intent registerIntent = new Intent(context, MailSignUpActivity.class);
        context.startActivity(registerIntent);


    }
}
