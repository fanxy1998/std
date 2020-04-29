package com.fanxy.service;
import com.fanxy.entity.SignRecordEntity;
import com.fanxy.mapper.SignRecordMapper;
import com.fanxy.vo.EmSignVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Calendar;
import java.util.List;

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
        int mask = getMask(userId).getMask();
        //把数据改变，签到
        mask = (1<<calendar.get(Calendar.DAY_OF_MONTH))|mask;
        signRecordMapper.signByUserId(userId,mask);
    }

    /**
     * 查询签到数据
     * @param userId 用户ID
     */
    public EmSignVo getMask(int userId){
        return signRecordMapper.getMask(userId);
    }

    /**
     * 向签到表加入员工
     * @param signRecordEntity 员工初始签到信息
     * @return 插入行数
     */
     int insertUser(SignRecordEntity signRecordEntity){
        return signRecordMapper.insertUser(signRecordEntity);
    }

    /**
     * 分页查询员工考勤信息
     * @param begin 开始
     * @param nums  个数
     * @return 员工考勤信息
     */
    public List<EmSignVo> queryEmSignInfo(int begin,int nums){
         return signRecordMapper.queryEmSignInfo(begin,nums);
    }


}
