package com.dossis.curso4semana4.activitys;

import android.os.Bundle;

import com.dossis.curso4semana4.R;

public class AcercaDeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        if (toolbar == null) {
            setActionBar(this, true);
        }
    }
}