package com.netstudy.service.impl;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.netstudy.bean.Blog;
import com.netstudy.common.bean.Remarks;
import com.netstudy.common.utils.normal.BeanUtils;
import com.netstudy.common.utils.normal.DateUtil;
import com.netstudy.common.utils.normal.StringUtil;
import com.netstudy.dto.BlogDto;
import com.netstudy.service.MongoDBService;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * 一天备份一次
 *
 */
@Service
@Transactional
public class MongoDBServiceImpl implements MongoDBService {

    @Autowired
    private DB db;
    @Autowired
    private MongoDatabase mongoDatabase;

    @Remarks("将大存量的内容保存到MongoDB当中")
    @Override
    public <T> String saveBlog(String collectionName, BlogDto dto) {

        String contentId = StringUtil.getUUID();
        dto.setContentId(contentId);
        db.getCollection(collectionName + "-" + DateUtil.getNowdateForMongoDB()).insert(BeanUtils.beanToDBObject(dto));
        return contentId;
    }

    public void test(Blog blog) {

        DBObject dbObject = BeanUtils.beanToDBObject(blog);
        db.getCollection("test").insert(dbObject);
    }

    @Override
    public Map<String, Object> getContent(String collectionName, String contentId) {

        Bson bson = new Document("contentId", contentId);
        return (Map<String, Object>)mongoDatabase.getCollection(collectionName + "-" + DateUtil.getNowdateForMongoDB()).find(bson);
    }
}
