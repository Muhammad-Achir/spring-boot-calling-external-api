/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lastdeveloper.springbootcallingexternalapi.response;

/**
 *
 * @author Last
 */
public class PhotosFlickrAPIResponse {
    
    private int page;
    private int pages;
    private int perpage;
    private int total;
    private PhotoFlickrAPIResponse[] photo;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public PhotoFlickrAPIResponse[] getPhoto() {
        return photo;
    }

    public void setPhoto(PhotoFlickrAPIResponse[] photo) {
        this.photo = photo;
    }
    
    
}
