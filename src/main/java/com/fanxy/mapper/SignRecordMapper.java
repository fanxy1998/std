package com.fanxy.mapper;

import com.fanxy.entity.SignRecordEntity;
import com.fanxy.vo.EmSignVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
    EmSignVo getMask(int userId);

    /**
     * 添加员工的同时向签到表加新员工信息
     * @param signRecordEntity 签到信息
     * @return 修改条数
     */
    int insertUser(SignRecordEntity signRecordEntity);

    /**
     * 查询员工签到信息
     * @return 员工签到信息列表
     */
    List<EmSignVo> queryEmSignInfo();

    /**
     * 按部门查询员工签到信息
     * @param department 部门名字
     * @return 员工签到信息列表
     */
    List<EmSignVo> queryEmSignInfoByDepartment(String department);

    /**
     * 根据ID查询员工签到信息
     * @param userId 员工ID
     * @return 员工签到信息列表
     */
    List<EmSignVo> queryEmSignInfoByUserId(int userId);

}
