package com.example.endlessloop.MailSignUpPackage;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.example.endlessloop.MainPackage.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MailSignUpPresenter {

    final static String USERS = "Users";
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference usersRef = db.collection(USERS);
    private Context context;
    private FirebaseAuth mAuth;

    public MailSignUpPresenter(Context context) {
        this.context = context;
        mAuth = FirebaseAuth.getInstance();
    }

    void SignUp(String mail, String password) {


        mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    //TODO upload user date to cloud ;
                }

            }
        });
    }

    void uploadUserDataToCloud(String firstName, String lastName, String email, String password, String gender, String userId,String deviceToken) {

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("firstName", firstName);
        userMap.put("lastName", lastName);
        userMap.put("email", email);
        userMap.put("password", password);
        userMap.put("gender", gender);
        userMap.put("userId", userId);
        userMap.put("devideToken",deviceToken);
        usersRef.document(userId).set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {
                    //TODO: send user to the next page
                } else {
                    //TODO : handle exceptions and show message to the user

                }
            }
        });
    }

    private void sendUserToMainActivity() {

        Intent mainIntent = new Intent(context, MainActivity.class);
        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(mainIntent);
    }
}
