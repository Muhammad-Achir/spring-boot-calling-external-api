/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lastdeveloper.springbootcallingexternalapi.controller;

import com.lastdeveloper.springbootcallingexternalapi.entity.PhotoItem;
import com.lastdeveloper.springbootcallingexternalapi.repository.PhotoFlickrRepository;
import com.lastdeveloper.springbootcallingexternalapi.response.PhotoFlickrAPIResponse;
import com.lastdeveloper.springbootcallingexternalapi.response.PhotoUrlResponse;
import com.lastdeveloper.springbootcallingexternalapi.response.RequestFlickrAPIResponse;
import com.lastdeveloper.springbootcallingexternalapi.response.TodoResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Last
 */
@RestController
public class RequestAPIController {
    
    @Autowired
    private PhotoFlickrRepository photoFlickrRepository;
    
    @GetMapping(value = "/collect-photos")
    private RequestFlickrAPIResponse getHello() {
//        String uri = "http://localhost:8080/hello";
//        String uri = "https://jsonplaceholder.typicode.com/todos";
        String uri = "https://api.flickr.com/services/rest/?method=flickr.galleries.getPhotos&api_key=8a31faa50d9023242e2521abf0bf3afa&gallery_id=66911286-72157647277042064&format=json&nojsoncallback=1";
        RestTemplate restTemplate = new RestTemplate();
        RequestFlickrAPIResponse result = restTemplate.getForObject(uri, RequestFlickrAPIResponse.class);        
        
        List<PhotoItem> photoItems = photoFlickrRepository.findAll();
        
        for (PhotoFlickrAPIResponse photo : result.getPhotos().getPhoto()) {
//            System.out.println(Long.parseLong(photo.getId()));
            
            boolean isInclude = false;
            for (PhotoItem photoItem : photoItems) {
                if (photo.getId().equals(photoItem.getPhotoItemId())) {
                    isInclude = true;
                    break;
                }
            }
            
            if (!isInclude) {
                PhotoItem photoItem = new PhotoItem();
                photoItem.setPhotoItemId(photo.getId());
                photoItem.setFarm(photo.getFarm());
                photoItem.setHas_comment(photo.getHas_comment());
                photoItem.setIs_primary(photo.getIs_primary());
                photoItem.setIsfamily(photo.getIsfamily());
                photoItem.setIsfriend(photo.getIsfriend());
                photoItem.setIspublic(photo.getIspublic());
                photoItem.setOwner(photo.getOwner());
                photoItem.setSecret(photo.getSecret());
                photoItem.setServer(photo.getServer());
                photoItem.setTitle(photo.getTitle());

                photoFlickrRepository.save(photoItem);
            }
        }
        
        return result;
    }
    
    @GetMapping("/photos")
    public ResponseEntity<List<PhotoItem>> getPhotos() {
        List<PhotoItem> photoItems = new ArrayList<>();
        Iterable<PhotoItem> photoItem = photoFlickrRepository.findAll();
        for (PhotoItem pI : photoItem) {
            photoItems.add(pI);
        }
        return ResponseEntity.ok(photoItems);
    }
    
//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/photos-url")
    public List<PhotoUrlResponse> getPhotosUrl() {
        List<PhotoUrlResponse> result = new ArrayList<>();
        for (PhotoItem photoItem : photoFlickrRepository.findAll()) {
            PhotoUrlResponse photoUrlResponse = new PhotoUrlResponse();
            photoUrlResponse.setId(photoItem.getId());
            photoUrlResponse.setUrl("https://farm" + photoItem.getFarm() + 
                    ".staticflickr.com/" + photoItem.getServer() +
                    "/" + photoItem.getPhotoItemId() + 
                    "_" + photoItem.getSecret() +
                    ".jpg");
            
            result.add(photoUrlResponse);
        }
        return result;
    }
}
