package com.fanxy;

import com.fanxy.entity.EmInformation;
import com.fanxy.service.EmInfomationService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = {"com.fanxy"})
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class,args);
    }
}


