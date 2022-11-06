package com.example.lab4iot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Button btn_alineacion=(Button) findViewById(R.id.btnAlineacion);
        btn_alineacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this, User_alineacion.class));
                finish();
            }
        });

        Button btn_hitos=(Button) findViewById(R.id.btnHitos);
        btn_hitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserActivity.this, User_hitos.class));
                finish();
            }
        });
    }
}