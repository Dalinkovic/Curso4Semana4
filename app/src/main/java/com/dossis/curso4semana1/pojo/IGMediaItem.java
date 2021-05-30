package com.dossis.curso4semana1.pojo;

public class IGMediaItem {

    private String id;
    private String petName;
    private String urlPetPic;
    private int likes = 0;

    public IGMediaItem() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getUrlPetPic() {
        return urlPetPic;
    }

    public void setUrlPetPic(String urlPetPic) {
        this.urlPetPic = urlPetPic;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}


