package com.slashmobility.albumuserexample.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.slashmobility.albumuserexample.R;
import com.slashmobility.albumuserexample.adapters.AlbumsAdapter;
import com.slashmobility.albumuserexample.model.AlbumsUserModel;
import com.slashmobility.albumuserexample.service.ServiceManager;
import com.slashmobility.albumuserexample.service.callback.CallBackAlbumsUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView mrv_lista;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.idtool_bar);
        //COMENTARIO IMPORTANTE

      //  setSupportActionBar(toolbar);
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

    @Override
    public boolean  onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.example_menu,menu);
        return  true;


    }

    public void ejecutar_class_inf(View v){

        Intent intenInf = new Intent(this,Inflate_Menu.class);
        startActivity(intenInf);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem option_item) {

        int opcionMenu = option_item.getItemId();

        if (opcionMenu == R.id.item_config)
        {
            return  true;

        }

        if(opcionMenu == R.id.item_inf){

            ejecutar_class_inf(null);
            return true;
        }

        return super.onOptionsItemSelected(option_item);
    }


}
