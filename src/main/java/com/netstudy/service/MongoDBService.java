package com.netstudy.service;

import com.netstudy.bean.Blog;
import com.netstudy.dto.BlogDto;

import java.util.Map;

public interface MongoDBService {

    <T> String saveBlog(String collectionName, BlogDto dto );

    Map<String, Object> getContent(String collectionName, String contentId);

    void test(Blog blog);
}
