/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lastdeveloper.springbootcallingexternalapi.response;

/**
 *
 * @author Last
 */
public class RequestFlickrAPIResponse {
    
    private String stat;
    private PhotosFlickrAPIResponse photos;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public PhotosFlickrAPIResponse getPhotos() {
        return photos;
    }

    public void setPhotos(PhotosFlickrAPIResponse photos) {
        this.photos = photos;
    }

    
}
