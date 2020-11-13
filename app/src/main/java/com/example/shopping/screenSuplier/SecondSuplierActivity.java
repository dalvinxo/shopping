package com.example.shopping.screenSuplier;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import com.example.shopping.R;
import com.example.shopping.screenSuplier.fragments_second.FragmentCategory;
import com.example.shopping.screenSuplier.fragments_second.FragmentOrder;
import com.example.shopping.screenSuplier.fragments_second.FragmentProduct;
import com.example.shopping.screenSuplier.fragments_second.FragmentSetting;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondSuplierActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;

    FragmentCategory fragmentCategory = new FragmentCategory();
    FragmentProduct fragmentProduct = new FragmentProduct();
    FragmentOrder fragmentOrder = new FragmentOrder();
    FragmentSetting fragmentSetting = new FragmentSetting();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_suplier);

        toolbar = findViewById(R.id.toolbar_product_company);
        bottomNavigationView = findViewById(R.id.bottom_navegation_view_suplier_second);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_company_category);



        setSupportActionBar(toolbar);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top_search,menu);
        MenuItem item =  menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return  super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.navigation_company_category:
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.in_fade, R.anim.out_fade)
                        .replace(R.id.container_supplier_second, fragmentCategory).commit();
                return true;

            case R.id.navigation_company_product:
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.in_fade, R.anim.out_fade)
                        .replace(R.id.container_supplier_second, fragmentProduct).commit();
                return true;

            case R.id.navigation_company_order:
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.in_fade, R.anim.out_fade)
                        .replace(R.id.container_supplier_second, fragmentOrder).commit();
                return true;

            case R.id.navigation_company_setting:
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.in_fade, R.anim.out_fade)
                        .replace(R.id.container_supplier_second, fragmentSetting).commit();
                return true;

        }

        return false;
    }
}