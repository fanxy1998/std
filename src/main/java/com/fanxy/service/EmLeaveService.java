package com.fanxy.service;

import com.fanxy.entity.EmLeaveEntity;
import com.fanxy.mapper.EmLeaveMapper;
import com.fanxy.vo.EmLeaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fanxy
 */
@Service
public class EmLeaveService {

    private EmLeaveMapper emLeaveMapper;

    @Autowired
    public EmLeaveService(EmLeaveMapper emLeaveMapper) {
        this.emLeaveMapper = emLeaveMapper;
    }

    /**
     * 员工请假
     * @param emLeaveEntity 请假信息
     */
    public void userLeave(EmLeaveEntity emLeaveEntity){
        emLeaveMapper.userLeave(emLeaveEntity);
    }


    /**
     * 查询部门领导
     * @param userId 员工ID
     * @return 领导姓名
     */
    public List<String> queryLeaderByuserId(int userId){
        return emLeaveMapper.queryLeaderByuserId(userId);
    }

    /**
     * 查询请假记录
     * @param userId 员工ID
     * @return 请假记录
     */
    public List<EmLeaveVo> queryLeaveRecordByuserId(int userId){
        return emLeaveMapper.queryLeaveRecordByuserId(userId);
    }

    /**
     * 查询部门员工请假记录
     * @param deparment 部门
     * @return 请假记录
     */
    public List<EmLeaveVo> queryLeaveRecordByDeparment(String deparment){
        return emLeaveMapper.queryLeaveRecordByDeparment(deparment);
    }

    /**
     * 审批请假
     * @param state 是否同意
     * @param emName 申请人姓名
     * @param leaderName 领导人姓名
     */
    public void approvalEmLeave(int state,String emName,String leaderName){
        emLeaveMapper.approvalEmLeave(state,emName,leaderName);
    }

}
