/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lastdeveloper.springbootcallingexternalapi.repository;

import com.lastdeveloper.springbootcallingexternalapi.entity.PhotoItem;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Last
 */
public interface PhotoFlickrRepository extends CrudRepository<PhotoItem, Integer>{
    
    public List<PhotoItem> findById (PhotoItem photoItem);
    
}
