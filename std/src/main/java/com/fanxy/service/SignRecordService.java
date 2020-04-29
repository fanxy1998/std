package com.fanxy.service;
import com.fanxy.entity.SignRecord;
import com.fanxy.mapper.SignRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;

/***
 * @author fanxy
 */
@Service
public class SignRecordService {

    private SignRecordMapper signRecordMapper;

    @Autowired
    public SignRecordService(SignRecordMapper signRecordMapper) {
        this.signRecordMapper = signRecordMapper;
    }

    /**
     * 签到
     * @param userId 用户ID
     */
    public void signByUserId(int userId){
        //得到今天是第几天
        Calendar calendar = Calendar.getInstance();
        //根据用户ID得到他的签到数据
        int mask = getMask(userId);
        //把数据改变，签到
        mask = (1<<calendar.get(Calendar.DAY_OF_MONTH))|mask;
        signRecordMapper.signByUserId(userId,mask);
    }


    /**
     * 查询签到数据
     * @param userId 用户ID
     */
    public int getMask(int userId){
        return signRecordMapper.getMask(userId);
    }

    /**
     * 向签到表加入员工
     * @param signRecord 员工初始签到信息
     * @return 插入行数
     */
     int insertUser(SignRecord signRecord){
        return signRecordMapper.insertUser(signRecord);
    }


}
