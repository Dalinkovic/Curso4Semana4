package com.dossis.curso4semana3.activitys;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dossis.curso4semana3.R;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;

public class LoginActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (toolbar == null) {
            setActionBar(this, true);
        }

        Button btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //finish();
               // String token= FirebaseInstanceId
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

}


