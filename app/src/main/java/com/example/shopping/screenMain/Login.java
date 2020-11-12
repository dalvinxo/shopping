package com.example.shopping.screenMain;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;

import com.example.shopping.MainActivity;
import com.example.shopping.R;
import com.example.shopping.screenSuplier.MainSuplierActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class Login extends AppCompatActivity {

    Button back, signup, recovery, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        back = findViewById(R.id.btn_backlogin);
        signup = findViewById(R.id.btn_signupLogin);
        recovery = findViewById(R.id.btn_recoveryLogin);
        login = findViewById(R.id.btn_accessLogin);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(Login.this, ScreenSignup.class);
                startActivity(start);
                overridePendingTransition(R.anim.in_bottom,R.anim.out_bottom);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(Login.this, MainSuplierActivity.class);
                startActivity(start);
                overridePendingTransition(R.anim.in_fade,R.anim.out_fade);
            }
        });

        recovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(Login.this, RecoveryPassword.class);
                startActivity(start);
                overridePendingTransition(R.anim.in_bottom,R.anim.out_bottom);
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.in_top,R.anim.out_top);
    }

    /* private void alertSignup(){

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder (Login.this,android.R.style.Theme_Material_Dialog_NoActionBar);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_signup,null);
        builder.setView(view);
        final AlertDialog dialog = builder.create();
        dialog.show();


        final CheckBox check = view.findViewById(R.id.politeCheckbox);
        MaterialButton aceptar = view.findViewById(R.id.politeAceptada);
        MaterialButton cancelar = view.findViewById(R.id.politeRechazada);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check.isChecked()){
                    Toast.makeText(getApplicationContext(),"politicas aceptadas",Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                    dialogcorreo();

                }else{
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),"Debes aceptar nuestras politica",Toast.LENGTH_SHORT).show();

                        }
                    },1000);
                }

            }
        });



        cancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }
*/

}