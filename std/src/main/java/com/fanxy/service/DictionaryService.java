package com.fanxy.service;

import com.fanxy.entity.Dictionary;
import com.fanxy.mapper.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fanxy
 */
@Service
public class DictionaryService {

    private DictionaryMapper dictionaryMapper;

    @Autowired
    public DictionaryService(DictionaryMapper dictionaryMapper) {
        this.dictionaryMapper = dictionaryMapper;
    }

    public List<Dictionary> getDictionValue(){
        return dictionaryMapper.getDictionValue();
    }
}
