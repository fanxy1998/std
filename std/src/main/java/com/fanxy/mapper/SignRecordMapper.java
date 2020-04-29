package com.fanxy.mapper;

import com.fanxy.entity.SignRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author fanxy
 */
@Mapper
public interface SignRecordMapper {

    /**
     * 签到
     * @param userId 用户id
     * @param mask 签到数据
     */
    void signByUserId(@Param("userId") int userId, @Param("mask")int mask);


    /**
     * 得到签到数据
     * @param userId 用户id
     * @return 签到数据
     */
    int getMask(int userId);

    /**
     * 加员工
     * @param signRecord
     * @return
     */
    int insertUser(SignRecord signRecord);

}
