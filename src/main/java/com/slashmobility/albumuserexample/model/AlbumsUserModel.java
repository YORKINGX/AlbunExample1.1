package com.slashmobility.albumuserexample.model;

/**
 * Created by Administrador on 21/05/2017.
 */

public class AlbumsUserModel {

        private int userId;
        private int id;
        private String title;

    public AlbumsUserModel(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public AlbumsUserModel() {
    }

    public int getUserId() {
            return this.userId;
        }
        public void setUserId(int userId) {
            this.userId = userId;
        }
        public int getId() {
            return this.id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getTitle() {
            return this.title;
        }
        public void setTitle(String title) {
            this.title = title;
        }

}
