package com.example.shopping.screenSuplier.Facade.EntityFactory;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shopping.screenMain.screenSignup1;
import com.example.shopping.screenSuplier.Facade.IFactory;
import com.example.shopping.screenSuplier.UtilidadesListView.EntityCategoryModelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FactoryCategory implements IFactory {

    Context context;
    ArrayList<EntityCategoryModelo> noteArrayList;
    String url;
    String[] entity;
    String Today = "";
    String prueba = "";

    public FactoryCategory(Context context, String url) {
        this.context = context;
        this.url = url;
    }

    @Override
    public void Create(final String[] datos) {
        StringRequest con = new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {
                    //Toast.makeText(context, "save", Toast.LENGTH_SHORT).show();
                }
                //Toast.makeText(context, "La consulta no retorna nada.", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
               // Toast.makeText(context, error.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("name_category", datos[0]);
                parametros.put("descripcion_category", datos[1]);
                parametros.put("id_user", datos[2]);
                return parametros;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(con);
    }


    @Override
    public void Delete() {

    }

    @Override
    public void Edit() {

    }

    @Override
    public void All() {

    }


}
