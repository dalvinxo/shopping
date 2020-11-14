package com.example.shopping.screenSuplier.UtilidadesListView;

public class EntityCategoryModelo {

    String name,quantityCategory,id;


    public EntityCategoryModelo(String name, String quantityCategory,String id) {
        this.id = id;
        this.name = name;
        this.quantityCategory = quantityCategory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuantityCategory() {
        return quantityCategory;
    }

    public void setQuantityCategory(String quantityCategory) {
        this.quantityCategory = quantityCategory;
    }
}
