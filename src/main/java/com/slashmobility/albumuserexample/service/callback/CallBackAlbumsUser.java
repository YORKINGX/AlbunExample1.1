package com.slashmobility.albumuserexample.service.callback;

import com.slashmobility.albumuserexample.model.AlbumsUserModel;

import java.util.ArrayList;

/**
 * Created by Administrador on 21/05/2017.
 */

public interface CallBackAlbumsUser {
    void onSuccess(ArrayList<AlbumsUserModel> arrayAlbums);
    void onError(String msgError, int indError);

}
