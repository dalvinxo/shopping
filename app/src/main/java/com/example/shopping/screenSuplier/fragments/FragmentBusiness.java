package com.example.shopping.screenSuplier.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shopping.R;
import com.example.shopping.screenMain.ScreenLogin;
import com.example.shopping.screenSuplier.AddCompanyActivity;
import com.example.shopping.screenSuplier.UtilidadesListView.EntityCompanyModelo;
import com.example.shopping.screenSuplier.UtilidadesListView.RecyclerViewAdapterCompany;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FragmentBusiness extends Fragment {

    View v;
    public FragmentBusiness(){

    }

    FloatingActionButton addCompany;

    RecyclerView recyclerViewcompany;
    RecyclerViewAdapterCompany adapterCompany;
    ArrayList<EntityCompanyModelo> arrayListCompany;
    LinearLayoutManager layoutManager;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_business, container, false);

        addCompany = v.findViewById(R.id.floating_add_company);
        recyclerViewcompany = (RecyclerView) v.findViewById(R.id.recyclerCompany);

        arrayListCompany = new ArrayList<>();
        arrayListCompany.add(new EntityCompanyModelo("La Sirena","(809) 895-2514",
                "Republica Dominicana","Arroyo HN","www.company.com",R.drawable.logocompany,
                "true","2","1"));

        arrayListCompany.add(new EntityCompanyModelo("La Sirena","(809) 895-2514",
                "Republica Dominicana","Arroyo HN","www.company.com",R.drawable.emojilove,
                "true","2","1"));


        layoutManager = new LinearLayoutManager(getActivity());
        recyclerViewcompany.setLayoutManager(layoutManager);
        adapterCompany = new RecyclerViewAdapterCompany(getActivity(),arrayListCompany);
        recyclerViewcompany.setAdapter(adapterCompany);


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

    public ArrayList<EntityCompanyModelo> obtenerCompany(){
        ArrayList<EntityCompanyModelo> company = new ArrayList<>();
        company.add(new EntityCompanyModelo("La Sirena","(809) 895-2514",
                "Republica Dominicana","Arroyo HN","www.company.com",R.drawable.logocompany,
                "true","2","1"));

        return company;
    }


}