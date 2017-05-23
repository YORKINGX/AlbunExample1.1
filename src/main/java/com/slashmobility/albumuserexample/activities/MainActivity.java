package com.slashmobility.albumuserexample.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.slashmobility.albumuserexample.R;
import com.slashmobility.albumuserexample.adapters.AlbumsAdapter;
import com.slashmobility.albumuserexample.model.AlbumsUserModel;
import com.slashmobility.albumuserexample.service.ServiceManager;
import com.slashmobility.albumuserexample.service.callback.CallBackAlbumsUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mrv_lista;
    final ArrayList<AlbumsUserModel> albumsModel = new ArrayList<AlbumsUserModel>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mrv_lista = (RecyclerView) findViewById(R.id.recycler_albums);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mrv_lista.setLayoutManager(linearLayoutManager);



        ServiceManager.getPost(new CallBackAlbumsUser() {
            @Override
            public void onSuccess(ArrayList<AlbumsUserModel> arrayAlbums) {
               // Toast.makeText(MainActivity.this,"Esto trajo "+ String.valueOf(albumsModel.size()),Toast.LENGTH_LONG).show();
                AlbumsAdapter mAdapter = new AlbumsAdapter(getApplicationContext(),arrayAlbums);
                mrv_lista.setAdapter(mAdapter);
            }

            @Override
            public void onError(String msgError, int indError) {
                Toast.makeText(MainActivity.this,msgError,Toast.LENGTH_LONG).show();

            }
        });



    }
}
