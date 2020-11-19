package com.example.shopping.screenSuplier.Facade.EntityFactory;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.shopping.GlobalUsuario;
import com.example.shopping.screenMain.screenSignup1;
import com.example.shopping.screenSuplier.Facade.IFactory;
import com.example.shopping.screenSuplier.UtilidadesListView.EntityCategoryModelo;
import com.example.shopping.screenSuplier.UtilidadesListView.EntityCompanyModelo;
import com.example.shopping.screenSuplier.UtilidadesListView.EntityProductModelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FactoryCategory implements IFactory {

    Context context;
    ArrayList<EntityCategoryModelo> categoryModeloArrayList;
    String url;

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
                }
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
                parametros.put("id_company", datos[2]);
                return parametros;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(con);
    }


    @Override
    public void Delete(final String id) {
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
                parametros.put("id", id);
                return parametros;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(con);
    }

    @Override
    public void Edit(final String[] datos) {
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
                parametros.put("id", datos[0]);
                parametros.put("name", datos[1]);
                parametros.put("description", datos[2]);
                return parametros;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(con);
    }

    @Override
    public void All() {

    }

    @Override
    public void AllSpecific(final String idCompany) {
        StringRequest con = new StringRequest(StringRequest.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null) {

                    try {
                        JSONArray array = new JSONArray(response);
                        categoryModeloArrayList = new ArrayList<>();

                        for(int i=0; i < array.length(); i++){

                            JSONObject row = array.getJSONObject(i);

                            String id = String.valueOf(row.getInt("id"));
                            String name = row.getString("name_category");
                            String description= row.getString("description_category");
                            String cantidad = row.getString("totalProduct");

                           categoryModeloArrayList.add(new EntityCategoryModelo(
                                    name,cantidad,id,description
                            ));

                        }

                    } catch (JSONException ex) {
                       Log.i("Error data",ex.getMessage().toString());
                        //ex.printStackTrace();
                    }
                }
                //Toast.makeText(context, "La consulta no retorna nada.", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Error data",error.getMessage().toString());
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("id_company", idCompany);
                return parametros;

            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(con);
    }


    public ArrayList<EntityCategoryModelo> categorysArrayList(){
        return categoryModeloArrayList;
    }

    @Override
    public ArrayList<EntityCompanyModelo> companyArrayList() {
        return null;
    }

    @Override
    public ArrayList<EntityProductModelo> productArrayList() {
        return null;
    }


}
