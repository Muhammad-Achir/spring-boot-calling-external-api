/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lastdeveloper.springbootcallingexternalapi.controller;

import com.lastdeveloper.springbootcallingexternalapi.entity.PhotoItem;
import com.lastdeveloper.springbootcallingexternalapi.repository.PhotoFlickrRepository;
import com.lastdeveloper.springbootcallingexternalapi.response.RequestFlickrAPIResponse;
import com.lastdeveloper.springbootcallingexternalapi.response.TodoResponse;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
}
