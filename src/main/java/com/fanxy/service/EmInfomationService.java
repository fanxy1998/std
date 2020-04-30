package com.fanxy.service;

import com.fanxy.entity.EmInformationEntity;
import com.fanxy.entity.SignRecordEntity;
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

    public EmInformationEntity login(String username, String password){
        return emInfomationMapper.login(username,password);
    }

    public List<EmInformationEntity> queryEm(){
        return emInfomationMapper.queryEm();
    }

    public void updatePassword(String username,String password){
         emInfomationMapper.updatePassword(username,password);
    }

    public String insertEm(EmInformationEntity emInformationEntity){
        if(emInfomationMapper.insertEm(emInformationEntity)>0) {
            //添加成功，则向签到表初始化添加员工信息
            SignRecordEntity signRecordEntity = new SignRecordEntity();
            signRecordEntity.setUserId(emInfomationMapper.getMaxId());
            signRecordEntity.setDateMath(new Date());
            signRecordEntity.setMask(0);
            signRecordEntity.setSignDays(0);
            if (signRecordService.insertUser(signRecordEntity) > 0) {
                return "添加成功";
            }
        }
        return "系统异常，条件失败";
    }

    public void deleteUser(String username){
        emInfomationMapper.deleteEm(username);
    }

    public void updateEm(EmInformationEntity emInformationEntity){
        emInfomationMapper.updateEm(emInformationEntity);
    }

    public List<EmInformationEntity> findEmByDepartment(String department){
        return emInfomationMapper.findEmByDepartment(department);
    }

    public EmInformationEntity queryByUserId(int userId){
        return emInfomationMapper.findEminfoById(userId);
    }
}
