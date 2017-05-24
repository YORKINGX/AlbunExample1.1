package com.slashmobility.albumuserexample.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.slashmobility.albumuserexample.R;
import com.slashmobility.albumuserexample.model.AlbumsUserModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrador on 22/05/2017.
 */

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.AlbumsAvilableViewHolder> {

    Context mContext;
    ArrayList<AlbumsUserModel> arrayAlbums;

    public AlbumsAdapter(Context mContext, ArrayList<AlbumsUserModel> arrayAlbums) {
        this.mContext = mContext;
        this.arrayAlbums = arrayAlbums;
    }

    public AlbumsAdapter() {
    }

    @Override
    public AlbumsAvilableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view_albums = LayoutInflater.from(parent.getContext()).inflate(R.layout.albums_user_adapter, parent, false);
        AlbumsAdapter.AlbumsAvilableViewHolder albums_vh = new AlbumsAdapter.AlbumsAvilableViewHolder(view_albums);
        return albums_vh;

    }

    @Override
    public void onBindViewHolder(AlbumsAvilableViewHolder holder, int position) {
        holder.midAlbums.setText(String.valueOf(arrayAlbums.get(position).getId()));
        holder.midUser.setText(String.valueOf(arrayAlbums.get(position).getUserId()));
        holder.midTitle.setText(arrayAlbums.get(position).getTitle());
        Picasso.with(mContext).load("https://goo.gl/LwAau1").into(holder.midImage);
    }

    @Override
    public int getItemCount() {
        return arrayAlbums.size();
    }

    public class AlbumsAvilableViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.idUser) TextView midUser;
        @BindView(R.id.idAlbums) TextView midAlbums;
        @BindView(R.id.idTitle) TextView midTitle;
        @BindView(R.id.idimage) ImageView midImage;

        View itemView;
        public AlbumsAvilableViewHolder(View itemView) {

            super(itemView);
            ButterKnife.bind(this, itemView);
            this.itemView = itemView;
        }
    }



}



