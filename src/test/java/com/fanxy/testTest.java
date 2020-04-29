package com.fanxy;
import com.fanxy.redis.RedisUtils;
import com.fanxy.service.DictionaryService;
import com.fanxy.service.EmInfomationService;
import com.fanxy.service.SignRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


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
        System.out.println(signRecordService.getMask(1));

    }


}