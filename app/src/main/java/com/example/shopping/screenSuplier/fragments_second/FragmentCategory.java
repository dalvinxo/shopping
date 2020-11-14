package com.example.shopping.screenSuplier.fragments_second;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.shopping.R;
import com.example.shopping.screenMain.Login;
import com.example.shopping.screenSuplier.AddCategoryActivity;
import com.example.shopping.screenSuplier.AddCompanyActivity;
import com.example.shopping.screenSuplier.MainSuplierActivity;
import com.example.shopping.screenSuplier.UtilidadesListView.EntityCategoryModelo;
import com.example.shopping.screenSuplier.UtilidadesListView.EntityCompanyModelo;
import com.example.shopping.screenSuplier.UtilidadesListView.RecyclerViewAdapterCategory;
import com.example.shopping.screenSuplier.UtilidadesListView.RecyclerViewAdapterCompany;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;


public class FragmentCategory extends Fragment {

    View v;
    Context context;
    public FragmentCategory(Context context) {
        this.context = context;
        // Required empty public constructor
    }

    Button addCategory;

    RecyclerView recyclerView;
    RecyclerViewAdapterCategory recyclerViewAdapterCategory;
    ArrayList<EntityCategoryModelo> categoryModeloArrayList;
    LinearLayoutManager linearLayoutManager;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_category, container, false);

        addCategory = v.findViewById(R.id.btn_addCompany_category);
        recyclerView = v.findViewById(R.id.recyclerCompany_category);

        categoryModeloArrayList = new ArrayList<>();
        categoryModeloArrayList.add(new EntityCategoryModelo("Carne","1","23"));
        categoryModeloArrayList.add(new EntityCategoryModelo("Bebida","2","21"));

        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapterCategory = new RecyclerViewAdapterCategory(categoryModeloArrayList,getActivity());
        recyclerView.setAdapter(recyclerViewAdapterCategory);

        addCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(v.getContext(),"Ok",Toast.LENGTH_SHORT).show();
                Intent start = new Intent(getActivity(), AddCategoryActivity.class);
                startActivity(start);

                //BottomDialogAddCategory();
            }
        });

        return v;
    }






}