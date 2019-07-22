package com.example.endlessloop.MainPackage;

import android.content.Context;
import android.content.Intent;

import com.example.endlessloop.MailLoginPackage.MailLoginActivity;

class MainActivityPresenter {
    private Context context;

    MainActivityPresenter(Context context) {

        this.context = context;
    }

    void sendUserToLoginActivity() {
        Intent i = new Intent(context, MailLoginActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }
}
