package com.example.shopping.screenMain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.shopping.R;

import java.util.Random;

public class RecoveryPassword extends AppCompatActivity {

    Button back, recovery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery_password);

        back = findViewById(R.id.btn_backRecovery);
        recovery = findViewById(R.id.btn_recovery);


        recovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String good = idOrdenGenerated();
                Toast.makeText(RecoveryPassword.this,good,Toast.LENGTH_SHORT).show();

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(RecoveryPassword.this, Login.class);
                overridePendingTransition(R.anim.in_top,R.anim.out_top);
                start.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(start);
            }
        });


    }


    private String idOrdenGenerated(){

        char [] chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVXWZ".toCharArray();
        Random random = new Random();

        String clave = "";

        for (int i=0;i<9;i++){
         clave += chars[random.nextInt(chars.length)];
        }

        return clave;
    }


}