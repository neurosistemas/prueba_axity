package com.neuroark.appsytutoriales.pruebaaxity.Herramientas;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class ManejadorJSON {

    public static HashMap<String, String> obtenerDatosWalmart(JSONObject obj){
        HashMap<String,String> map = new HashMap<>();

        return  map;
    }
    public static JSONObject convertirStringAjson(String jsonString){
        JSONObject object = null;
        try {
            object = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("ErrorJSON",e.getMessage(),e);
        }
        return object;
    }


}
