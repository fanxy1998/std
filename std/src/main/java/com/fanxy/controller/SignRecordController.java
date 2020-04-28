package com.fanxy.controller;


import com.fanxy.result.Result;
import com.fanxy.service.SignRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Calendar;


/**
 * @author fanxy
 */
@RestController
@RequestMapping("/sign")
public class SignRecordController {


    private SignRecordService signRecordService;

    @Autowired
    public SignRecordController(SignRecordService signRecordService) {
        this.signRecordService = signRecordService;
    }

    /**
     * 得到签到信息
     * @param userId 用户ID
     * @return 签到结果
     */
    @GetMapping("/getSignMask/{userId}")
    public Result getSignMask(@PathVariable("userId") int userId){
        //得到今天是第几天
        Calendar calendar = Calendar.getInstance();
        //根据用户ID得到他的签到数据
        int day = signRecordService.getMask(userId) & (1<<calendar.get(Calendar.DAY_OF_MONTH));
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
     * 查询签到天数
     * @param userId 用户ID
     * @return 天数
     */
    private int getSignNum(int userId){
        int signNum = 0;
        for(int i=0;i<Integer.SIZE;i++){
            int num =  signRecordService.getMask(userId) & (1<<i);
            if(num>0){
                signNum++;
            }
        }
        return signNum;
    }
}
