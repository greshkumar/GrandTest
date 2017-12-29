 package com.example.greshkumartharwani.grandtest;

 import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

 public class MainActivity extends AppCompatActivity {
     List<Offer> offersList;
     Example example;
     RecyclerView recyclerView;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         recyclerView = (RecyclerView)findViewById(R.id.recycler_View);
         recyclerView.setLayoutManager(new LinearLayoutManager(this));
         StringRequest request = new StringRequest("http://api.savrrr.com/public/offers/list", new Response.Listener<String>() {
             @Override
             public void onResponse(String response) {
                 GsonBuilder gsonBuilder = new GsonBuilder();
                 Gson data = gsonBuilder.create();
                 example = data.fromJson(response,Example.class);
                 offersList = example.getData().getOffers();
                 recyclerView.setAdapter(new RecylerAdapter(MainActivity.this,offersList));
             }
         }, new Response.ErrorListener() {
             @Override
             public void onErrorResponse(VolleyError error) {

             }
         });

         RequestQueue queue = Volley.newRequestQueue(this);
         queue.add(request);
     }

 }
