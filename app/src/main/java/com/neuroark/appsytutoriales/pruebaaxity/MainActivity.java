package com.neuroark.appsytutoriales.pruebaaxity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.neuroark.appsytutoriales.pruebaaxity.Internet.ConectorVolley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HurlStack stack = new HurlStack();

        ConectorVolley connector=ConectorVolley.getInstance(getApplicationContext(),ConectorVolley.STRING,stack);


        HashMap<String,String> headers = new HashMap<>();
        headers.put("accept","application/json");
        headers.put("connection","keep-alive");
        headers.put("content-type","application/json");
       // HashMap<String,String> params = new HashMap<>();
        headers.put("JSESSIONID_GR","ewnljk%2BfgPUYt2Uks5PY-vG9.restapp-298183240-6-359372925");
        headers.put("TS01f4281b","0130aff232b466ffcc4072d1bbce44ecbbd89f5d479ff3da4fb92ddaa94160888e2ca908d1fa72efd98d848e3e8531b6c0d47a99fe");
        headers.put("akavpau_vp_super","1544643414~id%3D0b950c261050bdafe78b05c390a1fd75;dtCookie=%7CbWV4aWNvX19ncm9jZXJpZXN8MA");
        headers.put("TS01c7b722","0130aff232b466ffcc4072d1bbce44ecbbd89f5d479ff3da4fb92ddaa94160888e2ca908d1fa72efd98d848e3e8531b6c0d47a99fe");
       // headers.put("cookie","JSESSIONID_GR=ewnljk%2BfgPUYt2Uks5PY-vG9.restapp-298183240-6-359372925;TS01f4281b=0130aff232b466ffcc4072d1bbce44ecbbd89f5d479ff3da4fb92ddaa94160888e2ca908d1fa72efd98d848e3e8531b6c0d47a99fe;akavpau_vp_super=1544643414~id%3D0b950c261050bdafe78b05c390a1fd75;dtCookie=%7CbWV4aWNvX19ncm9jZXJpZXN8MA;TS01c7b722=0130aff232b466ffcc4072d1bbce44ecbbd89f5d479ff3da4fb92ddaa94160888e2ca908d1fa72efd98d848e3e8531b6c0d47a99fe");
       StringRequest request= ConectorVolley.crearStringRequest(getString(R.string.walmart_url), headers, null, new Response.Listener<String>() {
           @Override
           public void onResponse(String response) {
               Log.d("VolleyRespuesta",response);
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {
               Log.e("VolleyError",error.getMessage(),error);
           }
       });
       connector.addToRequestQueue(request,stack );
    }
}


/*'JSESSIONID_GR=ewnljk%2BfgPUYt2Uks5PY-vG9.restapp-298183240-6-359372925;TS01f4281b=0130aff232b466ffcc4072d1bbce44ecbbd89f5d479ff3da4fb92ddaa94160888e2ca908d1fa72efd98d848e3e8531b6c0d47a99fe;akavpau_vp_super=1544643414~id%3D0b950c261050bdafe78b05c390a1fd75;dtCookie=%7CbWV4aWNvX19ncm9jZXJpZXN8MA;TS01c7b722=0130aff232b466ffcc4072d1bbce44ecbbd89f5d479ff3da4fb92ddaa94160888e2ca908d1fa72efd98d848e3e8531b6c0d47a99fe*/



