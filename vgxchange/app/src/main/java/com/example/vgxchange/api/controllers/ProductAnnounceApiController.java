package com.example.vgxchange.api.controllers;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.vgxchange.api.dto.ProductAnnounce;
import com.example.vgxchange.fragments.browsing_products.ProductAnnounceAdapter;
import com.example.vgxchange.network.ApiRetrofit;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProductAnnounceApiController {

    public List<ProductAnnounce> getAllSynchronous() {
        List<ProductAnnounce> productAnnounces = new ArrayList<>();
        Retrofit retrofit = ApiRetrofit.getClient();

        BrowsingProductAnnouncesApi browsingProductAnnouncesApi = retrofit.create(BrowsingProductAnnouncesApi.class);
        Call<List<ProductAnnounce>> call = browsingProductAnnouncesApi.getAllProducts();
        try {
            Response<List<ProductAnnounce>> response = call.execute();
            productAnnounces = response.body();
        }
        catch (Exception x)
        {
            Log.d("Api Product Error : ", x.getMessage());
        }
        return productAnnounces;
    }


}
