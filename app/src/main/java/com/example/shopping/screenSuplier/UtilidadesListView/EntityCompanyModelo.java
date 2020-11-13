package com.example.shopping.screenSuplier.UtilidadesListView;

public class EntityCompanyModelo {

    String name,phone,country,address,link;
    int Imagen;
    String estado;
    String order,id;

    public EntityCompanyModelo(String name, String phone, String country, String address, String link, int imagen, String estado, String order, String id) {
        this.name = name;
        this.phone = phone;
        this.country = country;
        this.address = address;
        this.link = link;
        Imagen = imagen;
        this.estado = estado;
        this.order = order;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
