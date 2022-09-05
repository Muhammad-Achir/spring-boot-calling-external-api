/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.lastdeveloper.springbootcallingexternalapi.controller;

import com.lastdeveloper.springbootcallingexternalapi.entity.PhotoItem;
import com.lastdeveloper.springbootcallingexternalapi.repository.PhotoFlickrRepository;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Last
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class RequestAPIControllerTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Autowired
    private PhotoFlickrRepository photoFlickrRepository;

    @Test
    public void testGetPhotoByPhotoItemId() {
//        given
        PhotoItem photoItem = new PhotoItem();
        photoItem.setPhotoItemId("23");
        photoItem.setFarm(23);
        photoItem.setHas_comment(34);
        photoItem.setIs_primary(5);
        photoItem.setIsfamily(7);
        photoItem.setIsfriend(8);
        photoItem.setIspublic(9);
        photoItem.setOwner("my owner");
        photoItem.setSecret("my secret");
        photoItem.setServer("my server");
        photoItem.setTitle("my title");
        
        entityManager.persist(photoItem);
        entityManager.flush();
        
//        when
        PhotoItem found = photoFlickrRepository.findByPhotoItemId(photoItem.getPhotoItemId());
        
//        then
        assertEquals(found.getPhotoItemId(), photoItem.getPhotoItemId()); 
    }
    
}
