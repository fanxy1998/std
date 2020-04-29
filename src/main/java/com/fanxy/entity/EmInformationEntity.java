package com.fanxy.entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;


/**
 * 员工信息表
 * @author fanxy
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class EmInformationEntity extends BaseEntity {
    /**
     *员工ID
     */
    private Integer id;

    /**
     * 姓名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 所在部门
     */
    private String department;

    /**
     * 职位
     */
    private String position;

    /**
     * 进公司日期
     */
    private Date dateIntoCompany;

    /**
     * 联系方式
     */
    private String telephone;

}
