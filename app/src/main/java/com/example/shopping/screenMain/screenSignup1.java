package com.example.shopping.screenMain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shopping.R;

public class screenSignup1 extends AppCompatActivity {

    Button cancel, save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_signup1);

        cancel = findViewById(R.id.btn_cancelAccount);
        save = findViewById(R.id.btn_saveAccount);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(screenSignup1.this, Login.class);
                overridePendingTransition(R.anim.in_top,R.anim.out_top);
                start.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(start);

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(screenSignup1.this, Login.class);
                overridePendingTransition(R.anim.in_top,R.anim.out_top);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

    }
}