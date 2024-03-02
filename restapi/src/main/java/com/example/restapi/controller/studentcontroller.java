package com.example.restapi.controller;

import com.example.restapi.collections.student;
import com.example.restapi.collections.users;
import com.example.restapi.service.studentservice;
import com.example.restapi.service.userservice;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/student")
public class studentcontroller {

    @Autowired
    private studentservice stservice;
    @Autowired
    private userservice userservice;

@GetMapping("/{username}")
    public ResponseEntity<?> getall(@PathVariable  String username){
    users user=userservice.findByusername((username));
    List<student> all=user.getStudents();
    if(all!=null && !all.isEmpty()){
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

@PostMapping("/{username}")
    public ResponseEntity<student> createentry(@RequestBody student mystudent,@PathVariable String username){
    try{

        stservice.savestudent(mystudent,username);
        return  new ResponseEntity<>(mystudent, HttpStatus.CREATED);
    }
    catch (Exception e){
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    }

    @GetMapping("/id/{myid}")
    public ResponseEntity<student> getbyid(@PathVariable ObjectId myid){
    Optional<student> entry=stservice.findbyid(myid);
    if(entry.isPresent()){
        return new ResponseEntity<>(entry.get(), HttpStatus.OK);
    }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @DeleteMapping( "/id/{username}/{myid}")
    public ResponseEntity<?> deletebyid(@PathVariable ObjectId myid,@PathVariable String username){
         stservice.deletebyid(myid,username);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


   @PutMapping("/id/{username}/{myid}")
    public ResponseEntity<?>  update(@RequestBody student newStudent,@PathVariable String username,
                                     @PathVariable ObjectId myid){
   student old=stservice.findbyid(myid).orElse(null);
       if(old!=null) {
          old.setName(newStudent.getName()!=null &&!newStudent.getName().equals("")? newStudent.getName() : old.getName());
           old.setAge(newStudent.getAge()!=null &&!newStudent.getAge().equals("")? newStudent.getAge() : old.getAge());
           old.setAddress(newStudent.getAddress()!=null &&!newStudent.getAddress().equals("")? newStudent.getAddress() : old.getAddress());
          old.setName(newStudent.getName());
          old.setAge(newStudent.getAge());
          old.setAddress(newStudent.getAddress());
          stservice.savestudent(old);
           return new ResponseEntity<>(old,HttpStatus.OK) ;
       }

         return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
    }
}
