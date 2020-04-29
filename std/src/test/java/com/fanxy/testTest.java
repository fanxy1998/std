package com.fanxy;
import com.fanxy.entity.Dictionary;
import com.fanxy.redis.RedisUtils;
import com.fanxy.service.DictionaryService;
import com.fanxy.service.EmInfomationService;
import com.fanxy.service.SignRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class testTest {

    @Autowired
    SignRecordService signRecordService;

    @Autowired
    EmInfomationService emInfomationService;
    @Autowired
    DictionaryService dictionaryService;
    @Autowired
    RedisUtils redisUtils;

    @Test
    public void test1() {

//        System.out.println(signRecordService.getMask(1));
//        int mask = signRecordService.getMask(1);
        int signNum = 0;
        for(int i=0;i<Integer.SIZE;i++){
            int num =  signRecordService.getMask(1) & (1<<i);
            if(num>0){
                System.out.println("第"+i+"天签到了");
                signNum++;
            }
        }
//        Calendar calendar = Calendar.getInstance();
//        int day = signRecordService.getMask(21) & (1<<calendar.get(Calendar.DAY_OF_MONTH));
//        if(day==0){
//            System.out.println("今天未签到");
//        }
//        signRecordService.signByUserId(21);
//        day = signRecordService.getMask(21) & (1<<calendar.get(Calendar.DAY_OF_MONTH));
//        if(day==0){
//            System.out.println("今天未签到");
//        }



//        List<Dictionary> list = dictionaryService.getDictionValue();
//        for(Dictionary dictionary:list){
//            System.out.println(dictionary);
//        }
    }


}