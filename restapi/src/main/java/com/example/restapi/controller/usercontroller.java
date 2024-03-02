package com.example.restapi.controller;
import com.example.restapi.collections.users;
import com.example.restapi.service.userservice;
import com.example.restapi.collections.student;
import com.example.restapi.service.studentservice;
import com.example.restapi.service.userservice;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class usercontroller {

@Autowired
    private userservice userservice;

@GetMapping
public List<users> getall(){
return userservice.getall();
}
@PostMapping
    public boolean createuser(@RequestBody users us){
    userservice.saveuser(us);
    return true;
}
@PutMapping("/{username}")
    public ResponseEntity<?> update( @RequestBody users us,@PathVariable String username){
 users userdb=userservice.findByusername(username);
 if(userdb!=null){
     userdb.setUsername(us.getUsername());
     userdb.setPassword(us.getPassword());
     userservice.saveuser(userdb);
 }
 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}
    }

