package com.example.restapi.collections;
import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Document(collection = "users")
@Data
public class users {
   @Id
   private ObjectId studentid;
   @Indexed(unique = true)
   @NonNull
    private String username;
   @NonNull
    private String password;
   @DBRef
      private List<student> students=new ArrayList<>();

}
