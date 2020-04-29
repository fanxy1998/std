package com.fanxy.vo;

import lombok.Data;

/**
 * @author fanxy
 */
@Data
public class EmSignVo {

    /**
     * 姓名
     */
    private String username;

    /**
     * 所在部门
     */
    private String department;

    /**
     * 职位
     */
    private String position;

    /**
     * 联系方式
     */
    private String telephone;

    /**
     * 本月签到数据
     */
    private Integer mask;

    /**
     * 本月签到天数
     */
    private Integer signDays;

}
