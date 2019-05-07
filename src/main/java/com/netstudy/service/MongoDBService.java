package com.netstudy.service;

import java.util.Map;

public interface MongoDBService {

    <T> String save(String collectionName, String value);

    Map<String, Object> getContent(String collectionName, String contentId);
}
