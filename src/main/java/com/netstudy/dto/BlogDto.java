package com.netstudy.dto;

import com.mongodb.BasicDBObject;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BlogDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String title;
    private String contentId;
    private String content;

    public BlogDto(){}

    public BlogDto(String title, String content) {

        this.title = title;
        this.content = content;
    }

    public BlogDto(String title, String contentId, String content) {

        this.title = title;
        this.contentId = contentId;
        this.content = content;
    }
}
