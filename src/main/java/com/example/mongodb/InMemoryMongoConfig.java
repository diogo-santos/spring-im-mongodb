package com.example.mongodb;

import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class InMemoryMongoConfig extends AbstractMongoConfiguration {
    @Override
    protected String getDatabaseName() {
        return "in-memory-db";
    }

    @Override
    public Mongo mongo() {
        return new Fongo(getDatabaseName()).getMongo();
    }
}