package com.project_n.testlistretrofit.Service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {
    private Retrofit retrofit = null;

    public API getAPI() {
        String BASE_URL = "https://private-0e6b9-ganjarwidiatmansyah.apiary-mock.com/";

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(API.class);
    }

}
