package com.example.shopping.screenSuplier.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.shopping.R;
import com.example.shopping.screenMain.ScreenLogin;
import com.example.shopping.screenSuplier.AddCompanyActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FragmentBusiness extends Fragment {

    View v;
    public FragmentBusiness(){

    }

    FloatingActionButton addCompany;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_business, container, false);

        addCompany = v.findViewById(R.id.floating_add_company);

        addCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent start = new Intent(getContext(),AddCompanyActivity.class);
                startActivity(start);
               // Toast.makeText(getContext(),"Hola mundo",Toast.LENGTH_LONG).show();

            }
        });

        return v;
    }
}