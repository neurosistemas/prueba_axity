package com.neuroark.appsytutoriales.pruebaaxity.Internet;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.BaseHttpStack;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

//Nota, continuar con el uso de volley me hubiese llevado más tiempo para descargar el zip, por eso mejor regresé al uso de asynctask e inputstreams
public class ConectorVolley {
    public static final int STRING = 344;
    public static final int IMAGEN = 345;
    public static final int JSON = 346;
    private static ConectorVolley instancia = new ConectorVolley();
    static ConectorVolley getInstance() {
        return instancia;
    }
    private ConectorVolley() { }
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private static Context mCtx;

    private ConectorVolley(Context context, int tipo, BaseHttpStack stack) {
        inicializar(context,tipo, stack);
    }
    public static synchronized ConectorVolley getInstance(Context context, int tipo, BaseHttpStack stack) {
        if (instancia == null) {
            instancia = new ConectorVolley(context, tipo, stack);
        }
        instancia.inicializar(context,tipo, stack);
        return instancia;
    }
    private void inicializar(Context context, int tipo, BaseHttpStack stack){
        mCtx = context;
        switch (tipo){
            case IMAGEN:
                prepararCacheImagen();
                break;
            case STRING:
                break;
            case JSON:
                break;
            default:
                break;
        }
        mRequestQueue = crearRequestQueue(stack);
    }

    private RequestQueue crearRequestQueue(BaseHttpStack stack) {
        if (mRequestQueue == null) {
            if(stack!=null){
                mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext(),stack);
            }else{
                mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
            }
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, BaseHttpStack stack) {
        crearRequestQueue(stack).add(req);
    }


    private void prepararCacheImagen(){
        mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);
                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }
                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                }
        );
    }
    public ImageLoader getImageLoader() {
        return mImageLoader;
    }

    public static StringRequest crearStringRequest(String url, final Map<String, String> headers, final Map<String, String> params,
                                                   Response.Listener<String> respuestaListener, Response.ErrorListener errorListener){
        int metodo = params==null? Request.Method.POST: Request.Method.GET;
        return new StringRequest(metodo, url,respuestaListener,errorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if(headers!=null){return headers;}
                else{return super.getHeaders();}
            }

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if(params!=null){return params;}
                else {return  super.getParams();}
            }
        };
    }

}

  /*  @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Map<String,String> params=new HashMap<String,String>();
        params.put("grant_type","authorization_code");
        return params;
    }
    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String,String> headers=new HashMap<String,String>();
        headers.put("Accept","application/json");
        headers.put("Content-Type","application/x-www-form-urlencoded");
        return headers;
    }*/