package com.example.shopping.screenSuplier.Facade;

import android.content.Context;

import com.example.shopping.screenSuplier.Facade.EntityFactory.FactoryCategory;

public class FactoryMaker {

    IFactory FactoryCategory;


    public FactoryMaker(Context context, String url) {
        FactoryCategory = new FactoryCategory(context,url);

    }

    public void FactoryCategoryMethodCreate(String[] date){
        FactoryCategory.Create(date);
    }


}
