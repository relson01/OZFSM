package com.example.shaikhfamily.myapplication.performLogin;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/Projects/login_app/login.php")
    Call<modeling> getInfo(@Query("username") String username,@Query("password") String password);

    @GET("Projects/login_app/register.php")
    Call<modeling> setInfo(@Query("username") String username,@Query("email") String email,@Query("password") String password);

    @GET("/Projects/menu/getItemList.php")
    Call<List<menu>> getItem();


}
