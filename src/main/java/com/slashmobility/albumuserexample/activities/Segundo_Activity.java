package com.slashmobility.albumuserexample.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.slashmobility.albumuserexample.R;

import static android.R.attr.duration;

public class Segundo_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo_);

        Intent intent = getIntent();



        if(intent.hasExtra("parametro")){

            String message = intent.getStringExtra("parametro");
            Toast.makeText(this, "Diste Clieck en la posicion:" + message, Toast.LENGTH_SHORT).show();

        }



    }
}
