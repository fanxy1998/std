package com.fanxy.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
    public Date CREATE_TIME;
    public Integer CREATE_USER;
    public Integer USE_STATE;
    public String TAG_1;
    public String TAG_2;
    public String TAG_3;
}
