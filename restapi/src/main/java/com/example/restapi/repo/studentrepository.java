package com.example.restapi.repo;
import com.example.restapi.collections.student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface studentrepository extends MongoRepository<student, ObjectId> {

}
