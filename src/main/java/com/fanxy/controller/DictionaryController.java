package com.fanxy.controller;

import com.fanxy.entity.DictionaryEntity;
import com.fanxy.result.Result;
import com.fanxy.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fanxy
 */
@RestController
@RequestMapping("/api")
public class DictionaryController {

    private DictionaryService dictionaryService;

    @Autowired
    public DictionaryController(DictionaryService dictionaryService) {
        this.dictionaryService = dictionaryService;
    }

    /**
     * 得到全部字典值
     * @return JSON
     */
    @GetMapping("/dic")
    public Result getDictionaryValue(){
        List<DictionaryEntity> list = dictionaryService.getDictionValue();
        return new Result<>("success","查询成功",list);
    }
}
