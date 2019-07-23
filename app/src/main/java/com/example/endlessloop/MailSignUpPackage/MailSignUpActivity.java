package com.example.endlessloop.MailSignUpPackage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.endlessloop.R;

public class MailSignUpActivity extends AppCompatActivity {


    private EditText mailEt, passwordEt, confirmPasswordEt, firstnameEt, lastnameEt;
    //private TextView gender;
    private RadioButton radioMale, radioFemale;
    private RadioGroup radioGroup;
    private String firstName , lastName , password, email , gender;
    private Button confirmButton;
    private MailSignUpPresenter mailSignUpPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_sign_up);


        final MailSignUpPresenter mailSignUpPresenter = new MailSignUpPresenter(this);



        InitializeFields();


        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = mailEt.getText().toString();
                password = passwordEt.getText().toString();

                if (email.isEmpty()) {
                    mailEt.setError("you cant leave this empty");
                } else if (password.isEmpty()) {
                    passwordEt.setError("you have to create a password");
                } else {
                    getUserData();
                    mailSignUpPresenter.SignUp(firstName,lastName,email,password,gender);

                }
            }
        });

    }

    private void getUserData() {
        firstName = firstnameEt.getText().toString();
        lastName = lastnameEt.getText().toString();
        email=mailEt.getText().toString();
        password=passwordEt.getText().toString();
        if (radioMale.isChecked()) gender = "male"; else gender = "female";
    }

    private void InitializeFields() {

        mailEt = findViewById(R.id.newEmail);
        passwordEt = findViewById(R.id.newPassword);
        confirmPasswordEt = findViewById(R.id.tvConfirmPassword);
        firstnameEt = findViewById(R.id.tvFirstName);
        lastnameEt = findViewById(R.id.tvLastName);
        //gender = findViewById(R.id.tvGender);
        radioGroup = findViewById(R.id.radioGroup);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        confirmButton = findViewById(R.id.confirm_button);
    }
}
