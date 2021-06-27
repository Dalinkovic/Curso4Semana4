package com.dossis.curso4semana3.restApi;

import com.dossis.curso4semana3.pojo.IGMediaItem;

import java.util.ArrayList;

public class IGMediaResponse {
    ArrayList<IGMediaItem> IGMediaItems;

    public ArrayList<IGMediaItem> getMediaItems() {
        return IGMediaItems;
    }

    public void setMediaItems(ArrayList<IGMediaItem> IGMediaItems) {
        this.IGMediaItems = IGMediaItems;
    }
}