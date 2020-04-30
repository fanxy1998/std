package com.fanxy.entity;

import lombok.Data;
import java.util.Date;

/**
 * @author fanxy
 */
@Data
public class EmLeaveEntity {

    /**
     * id
     */
    private Integer id;

    /**
     * 申请人ID
     */
    private Integer userId;

    /**
     * 请假日期
     */
    private Date leaveDate;

    /**
     * 请假天数
     */
    private Integer leaveDays;

    /**
     * 请假原因
     */
    private String leaveReason;

    /**
     * 审批人姓名
     */
    private String userLeader;

    /**
     * 申请状态
     */
    private Integer state;
}
