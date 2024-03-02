package com.example.restapi.service;

import com.example.restapi.collections.student;
import com.example.restapi.collections.users;
import com.example.restapi.repo.studentrepository;
import com.example.restapi.repo.userrepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class userservice {
    @Autowired
    private userrepository userrepo;

    public void saveuser(users us){
        userrepo.save(us);
    }
    public List<users> getall(){
        return userrepo.findAll();
    }
    public Optional<users> findbyid(ObjectId id){
        return userrepo.findById(id);
    }
    public void deletebyid(ObjectId id){
        userrepo.deleteById(id);
    }
    public users findByusername(String username){ return userrepo.findByusername(username);}
}
