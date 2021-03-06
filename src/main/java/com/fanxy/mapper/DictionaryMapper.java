package com.fanxy.mapper;

import com.fanxy.entity.DictionaryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author fanxy
 */
@Mapper
public interface DictionaryMapper {

    /**
     * 得到全部字典值
     * @return 字典列表
     */
    List<DictionaryEntity> getDictionValue();


}
