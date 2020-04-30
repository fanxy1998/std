package com.fanxy.controller;
import com.fanxy.entity.EmInformationEntity;
import com.fanxy.result.Result;
import com.fanxy.service.EmInfomationService;
import com.fanxy.service.SignRecordService;
import com.fanxy.vo.EmSignVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Calendar;
import java.util.List;


/**
 * @author fanxy
 */
@RestController
@RequestMapping("/sign")
public class SignRecordController {

    private SignRecordService signRecordService;

    private EmInfomationService emInfomationService;

    @Autowired
    public SignRecordController(SignRecordService signRecordService) {
        this.signRecordService = signRecordService;
    }

    @Autowired
    public void setEmInfomationService(EmInfomationService emInfomationService) {
        this.emInfomationService = emInfomationService;
    }

    /**
     * 判断今天是否签到
     * @param userId 用户ID
     * @return 签到结果
     */
    @GetMapping("/getSignMask/{userId}")
    public Result getSignMask(@PathVariable("userId") int userId){
        //得到今天是第几天
        Calendar calendar = Calendar.getInstance();
        //根据用户ID得到他的签到数据
        int day = signRecordService.getMask(userId).getMask() & (1<<calendar.get(Calendar.DAY_OF_MONTH));
        if(day==0){
            return new Result<>("success","您今天还未签到，请及时签到哦",getSignNum(userId));
        }
        return new Result<>("error","您今天已经完成签到",getSignNum(userId));
    }


    /**
     * 签到
     * @param userId 用户ID
     * @return 返回信息
     */
    @PostMapping("/signByUserId/{userId}")
    public Result sign(@PathVariable("userId") int userId){
        signRecordService.signByUserId(userId);
        return new Result<>("success","签到成功",getSignNum(userId));
    }


    /**
     * 查询本月签到天数
     * @param userId 用户ID
     * @return 天数
     */
    private int getSignNum(int userId){
       return signRecordService.getMask(userId).getSignDays();
    }

    /**
     * 查询员工考勤信息
     * @param userId 员工ID
     * @return 员工列表
     */
    @GetMapping("queryEmSignInfo/{userId}")
    public List<EmSignVo> queryEmSignInfo(@PathVariable("userId") int userId){
        String position = "普通员工";
        if(userId!=1){
            EmInformationEntity emInformationEntity = emInfomationService.queryByUserId(userId);
            if(emInformationEntity!=null){
                if(position.equals(emInformationEntity.getPosition())){
                    return signRecordService.queryEmSignInfoByUserId(userId);
                }else {
                    return signRecordService.queryEmSignInfoByDepartment(emInformationEntity.getDepartment());
                }
            }
        }
        return signRecordService.queryEmSignInfo();
    }

}
