package com.example.mongodb.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Staff {
    @Id
    private ObjectId _id;
    private Person member;

    public String get_id() {
        return _id.toHexString();
    }
}