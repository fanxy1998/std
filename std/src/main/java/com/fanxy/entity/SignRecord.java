package com.fanxy.entity;
import lombok.Data;

import java.util.Date;


/**
 * @author fanxy
 */
@Data
public class SignRecord{
    /**
     * id
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 签到月份
     */
    private Date dateMath;

    /**
     * 签到数据
     */
    private Integer mask;


    /**
     * 连续签到天数
     */
    private Integer continueSign;

}
