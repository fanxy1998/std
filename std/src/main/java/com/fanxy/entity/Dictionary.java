package com.fanxy.entity;

import lombok.Data;

/**
 * @author fanxy
 */
@Data
public class Dictionary {
    /**
     * ID
     */
    private Integer id;

    /**
     * 字典ID
     */
    private Integer dictionaryId;

    /**
     * 状态ID
     */
    private String statsId;

    /**
     * 状态名称
     */
    private String statsName;

}
