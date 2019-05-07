package com.netstudy.service.impl;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.netstudy.common.bean.Remarks;
import com.netstudy.common.utils.normal.BeanUtils;
import com.netstudy.common.utils.normal.StringUtil;
import com.netstudy.service.MongoDBService;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
public class MongoDBServiceImpl implements MongoDBService {

    @Autowired
    private DB db;
    @Autowired
    private MongoDatabase mongoDatabase;

    @Remarks("将大存量的内容保存到MongoDB当中")
    @Override
    public <T> String save(String collectionName, String value) {

        String contentId = StringUtil.getUUID();
        Map<String, Object> map = new HashMap<>();
        map.put("content", value);
        map.put("contentId", contentId);
        DBObject dbObject = BeanUtils.beanToDBObject(map);
        db.getCollection(collectionName).insert(dbObject);
        return contentId;
    }

    @Override
    public Map<String, Object> getContent(String collectionName, String contentId) {

        Bson bson = new Document("contentId", contentId);
        return (Map<String, Object>)mongoDatabase.getCollection(collectionName).find(bson);
    }
}
