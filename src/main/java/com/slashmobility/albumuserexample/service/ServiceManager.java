package com.slashmobility.albumuserexample.service;

import com.slashmobility.albumuserexample.model.AlbumsUserModel;
import com.slashmobility.albumuserexample.service.callback.CallBackAlbumsUser;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrador on 21/05/2017.
 */

public class ServiceManager {

    public static void getPost(final CallBackAlbumsUser callBackAlbumsUser)
    {
        ServiceInterface serviceInterface = ServiceHelper.getInstance();
        final ArrayList<AlbumsUserModel> ArrayAlbums =  new ArrayList<AlbumsUserModel>();
        serviceInterface.getPostList().enqueue(new Callback<ArrayList<AlbumsUserModel>>() {
            @Override
            public void onResponse(Call<ArrayList<AlbumsUserModel>> call, Response<ArrayList<AlbumsUserModel>> listResponse) {
                if(listResponse.body()!=null && listResponse.body().size()>0){
                    callBackAlbumsUser.onSuccess(listResponse.body());
                }
                else
                    callBackAlbumsUser.onError("Error al leer los registros del servicio",1);
            }

            @Override
            public void onFailure(Call<ArrayList<AlbumsUserModel>> call, Throwable t) {
                    callBackAlbumsUser.onError("falla la conexion",2);

            }

        });



        //final CallBackUserModelDataList callBackUserModel
    }
}
