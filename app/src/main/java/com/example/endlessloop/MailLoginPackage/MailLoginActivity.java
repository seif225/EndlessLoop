package com.example.endlessloop.MailLoginPackage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.endlessloop.R;

public class MailLoginActivity extends AppCompatActivity {


    TextView donthaveAnAccount;
    private String mail, password;
    private EditText mailEt, passwordEt;
    private Button loginButton;
    private MailLoginPresenter mailLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mail_login_activity);


        initializeFields();


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mail = mailEt.getText().toString();
                password = passwordEt.getText().toString();

                if (mail.isEmpty()) {
                    mailEt.setError("you have to enter your mail");
                } else if (password.isEmpty()) {
                    passwordEt.setError("you have to enter your password");
                } else {

                    mailLoginPresenter.SignIn(mail, password);
                }
            }
        });


        donthaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mailLoginPresenter.SendUserToRegisterActivity();
            }
        });

    }

    private void initializeFields() {

        mailEt = findViewById(R.id.enterEmail);
        passwordEt = findViewById(R.id.enterPassword);
        loginButton = findViewById(R.id.BtnLogin);
        donthaveAnAccount = findViewById(R.id.dont_have_account);
        mailLoginPresenter = new MailLoginPresenter(this);
    }
}
