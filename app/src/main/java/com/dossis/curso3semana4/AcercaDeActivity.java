package com.dossis.curso3semana4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AcercaDeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
        setActionBar(this,true);
    }
}