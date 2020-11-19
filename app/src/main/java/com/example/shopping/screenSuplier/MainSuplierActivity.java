package com.example.shopping.screenSuplier;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.shopping.GlobalUsuario;
import com.example.shopping.MainActivity;
import com.example.shopping.R;
import com.example.shopping.screenMain.Login;
import com.example.shopping.screenSuplier.fragments.FragmentAccount;
import com.example.shopping.screenSuplier.fragments.FragmentBusiness;
import com.example.shopping.screenSuplier.fragments.FragmentLogout;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainSuplierActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    //Fragments
    FragmentBusiness company = new FragmentBusiness();
    FragmentAccount profile = new FragmentAccount();
    FragmentLogout logout = new FragmentLogout();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_suplier);

        bottomNavigationView = findViewById(R.id.bottom_navegation_view_suplier_main);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_company);

    }
    private long backpressdtime;
    Toast alert;
    @Override
    public void onBackPressed() {
        if(backpressdtime + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                Intent sc = new Intent(MainSuplierActivity.this, Login.class);
                sc.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(sc);
            }
            alert.cancel();
            return;
        }else{
            alert = Toast.makeText(getApplicationContext(),"pressiona otra vez para cerrar sesión",Toast.LENGTH_SHORT);
            alert.show();
        }
        backpressdtime = System.currentTimeMillis();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.navigation_company:
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.in_fade, R.anim.out_fade)
                        .replace(R.id.container_supplier, company).commit();
                return true;

            case R.id.navigation_profile:
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.in_fade, R.anim.out_fade)
                        .replace(R.id.container_supplier, profile).commit();
                return true;

            case R.id.navigation_logout:
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.in_fade, R.anim.out_fade)
                        .replace(R.id.container_supplier, logout).commit();
                return true;

        }

        return false;
    }




}