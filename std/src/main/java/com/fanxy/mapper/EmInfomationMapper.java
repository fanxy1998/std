package com.fanxy.mapper;

import com.fanxy.entity.EmInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;


/**
 * @author fanxy
 */
@Mapper
public interface EmInfomationMapper {
    /**
     * 根据ID得员工信息
     * @param id 员工ID
     * @return 员工信息
     */
    EmInformation findEminfoById(int id);

    /**
     * 查询全部员工
     * @return  员工列表
     */
    List<EmInformation> queryEm();


    /**
     * 根据部门得到员工列表
     * @param department 部门ID
     * @return  员工列表
     */
    List<EmInformation> findEmByDepartment(int department);



    /**
     * 登录
     * @param username  员工名
     * @param password   密码
     * @return 员工信息
     */
    EmInformation login(@Param("username") String username, @Param("password") String password);


    /**
     * 修改密码
     * @param username 员工们
     * @param password 密码
     * @return 修改条数
     */
    int updatePassword(@Param("username") String username, @Param("password") String password);

    /**
     * 添加员工
     * @param emInformation 员工信息
     * @return 修改条数
     */
    int insertEm(EmInformation emInformation);


    /**
     * 得到自增后的主键值
     * @return 最大ID
     */
    int getMaxId();


}
