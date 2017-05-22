package com.slashmobility.albumuserexample.service;

import com.slashmobility.albumuserexample.model.AlbumsUserModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Administrador on 21/05/2017.
 */

public interface ServiceInterface {
    @GET("albums")
    Call<ArrayList<AlbumsUserModel>> getPostList();
}
