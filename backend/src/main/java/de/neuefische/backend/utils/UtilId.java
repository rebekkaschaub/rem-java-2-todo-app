package de.neuefische.backend.utils;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UtilId {

    public String generateId(){
        return UUID.randomUUID().toString();
    }



}
