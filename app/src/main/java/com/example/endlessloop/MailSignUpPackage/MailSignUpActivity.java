package com.example.endlessloop.MailSignUpPackage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.endlessloop.R;

public class MailSignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_sign_up);


        MailSignUpPresenter mailSignUpPresenter= new MailSignUpPresenter(this);

        mailSignUpPresenter.SignUp("ahmed","124asd");

    }
}
