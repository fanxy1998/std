package com.fanxy.mapper;

import com.fanxy.entity.EmLeaveEntity;
import com.fanxy.vo.EmLeaveVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author fanxy
 */
@Mapper
public interface EmLeaveMapper {

    /**
     * 员工请假
     * @param emLeaveEntity 请假信息
     */
    void userLeave(EmLeaveEntity emLeaveEntity);


    /**
     * 查询部门领导
     * @param userId 员工ID
     * @return 领导姓名
     */
    List<String> queryLeaderByuserId(int userId);

    /**
     * 查询请假记录
     * @param userId 员工ID
     * @return 请假记录
     */
    List<EmLeaveVo> queryLeaveRecordByuserId(@Param("userId") int userId);

    /**
     * 查询部门员工请假记录
     * @param deparment 部门
     * @return 请假记录
     */
    List<EmLeaveVo> queryLeaveRecordByDeparment(String deparment);


    /**
     * 审批请假
     * @param state 是否同意
     * @param emName 申请人姓名
     * @param leaderName 领导人姓名
     */
    void approvalEmLeave(@Param("state") int state, @Param("emName") String emName, @Param("leaderName") String leaderName);
}
