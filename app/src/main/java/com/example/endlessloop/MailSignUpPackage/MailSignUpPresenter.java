package com.example.endlessloop.MailSignUpPackage;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MailSignUpPresenter {

    final static String USERS = "Users";

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference usersRef = db.collection(USERS);

    void uploadUserDataToCloud(String firstName, String lastName, String email, String password, String gender,String userId) {

        Map<String, Object> userMap = new HashMap<>();
        userMap.put("firstName", firstName);
        userMap.put("lastName", lastName);
        userMap.put("email", email);
        userMap.put("password", password);
        userMap.put("gender", gender);
        userMap.put("userId", userId);

        usersRef.document(userId).set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    //TODO: send user to the next page
                }
                else {
                    //TODO : handle exceptions and show message to the user

                }
            }
        });
    }






}
