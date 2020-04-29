package com.fanxy.service;

import com.fanxy.entity.EmInformation;
import com.fanxy.entity.SignRecord;
import com.fanxy.mapper.EmInfomationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author fanxy
 */
@Service
public class EmInfomationService {

    private EmInfomationMapper emInfomationMapper;

    private SignRecordService signRecordService;

    @Autowired
    public EmInfomationService(EmInfomationMapper emInfomationMapper) {
        this.emInfomationMapper = emInfomationMapper;
    }


    @Autowired
    public void setSignRecordService(SignRecordService signRecordService) {
        this.signRecordService = signRecordService;
    }

    public EmInformation login(String username, String password){
        return emInfomationMapper.login(username,password);
    }

    public List<EmInformation> queryEm(){
        return emInfomationMapper.queryEm();
    }

    public void updatePassword(String username,String password){
         emInfomationMapper.updatePassword(username,password);
    }

    public String insertEm(EmInformation emInformation){
        if(emInfomationMapper.insertEm(emInformation)>0) {
            //添加成功，则向签到表初始化添加员工信息
            SignRecord signRecord = new SignRecord();
            signRecord.setUserId(emInfomationMapper.getMaxId());
            signRecord.setDateMath(new Date());
            signRecord.setMask(0);
            signRecord.setContinueSign(0);
            if (signRecordService.insertUser(signRecord) > 0) {
                return "添加成功";
            }
        }
        return "系统异常，条件失败";
    }

}
