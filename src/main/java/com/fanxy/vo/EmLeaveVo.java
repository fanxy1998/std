package com.fanxy.vo;


import lombok.Data;

import java.util.Date;

/**
 * @author fanxy
 */
@Data
public class EmLeaveVo {
    /**
     * 姓名
     */
    private String name;

    /**
     * 所在部门
     */
    private String deparment;

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
     * 审批人
     */
    private String userLeader;

    /**
     * 是否审批
     */
    private Integer state;
}
