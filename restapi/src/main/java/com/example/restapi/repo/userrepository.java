package com.example.restapi.repo;
import com.example.restapi.collections.student;
import com.example.restapi.collections.users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface userrepository extends MongoRepository<users, ObjectId> {
 users findByusername(String username);
}
