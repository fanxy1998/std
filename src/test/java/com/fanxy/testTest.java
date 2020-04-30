package com.fanxy;
import com.fanxy.entity.EmLeaveEntity;
import com.fanxy.redis.RedisUtils;
import com.fanxy.service.DictionaryService;
import com.fanxy.service.EmInfomationService;
import com.fanxy.service.EmLeaveService;
import com.fanxy.service.SignRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;


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

    @Autowired
    EmLeaveService emLeaveService;

    @Test
    public void test1() {
        EmLeaveEntity emLeaveEntity = new EmLeaveEntity();
        emLeaveEntity.setUserId(3);
        emLeaveEntity.setLeaveDate(new Date());
        emLeaveEntity.setLeaveDays(3);
        emLeaveEntity.setLeaveReason("11");
        emLeaveEntity.setUserLeader("fanxy");
        emLeaveEntity.setState(0);
        System.out.println(emLeaveEntity);
    }


}