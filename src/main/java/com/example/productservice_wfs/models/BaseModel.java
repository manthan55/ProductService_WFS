package com.example.productservice_wfs.models;

import lombok.Data;

import java.util.Date;

@Data
public class BaseModel {
    protected Long id;
    protected String createBy;
    protected Date createdAt;
    protected Boolean isDeleted; // This can be an Enum as well.
}
