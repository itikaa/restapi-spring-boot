package com.example.restapi.collections;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Document(collection = "student_data")
@Data
@NoArgsConstructor
public class student {
   @Id
   private ObjectId id;
    private String address;
    @NonNull
    private String name;
    private String age;
   private LocalDateTime date;

}
