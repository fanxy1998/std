package com.fanxy.mapper;

import com.fanxy.entity.EmInformationEntity;
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
    EmInformationEntity findEminfoById(int id);

    /**
     * 分页查询员工
     * @param begin 开始
     * @param num 个数
     * @return 员工列表
     */
    List<EmInformationEntity> queryEm(@Param("begin") int begin, @Param("num") int num);


    /**
     * 根据部门得到员工列表
     * @param department 部门ID
     * @return  员工列表
     */
    List<EmInformationEntity> findEmByDepartment(int department);



    /**
     * 登录
     * @param username  员工名
     * @param password   密码
     * @return 员工信息
     */
    EmInformationEntity login(@Param("username") String username, @Param("password") String password);


    /**
     * 修改密码
     * @param username 员工们
     * @param password 密码
     * @return 修改条数
     */
    int updatePassword(@Param("username") String username, @Param("password") String password);

    /**
     * 添加员工
     * @param emInformationEntity 员工信息
     * @return 修改条数
     */
    int insertEm(EmInformationEntity emInformationEntity);

    /**
     * 删除员工
     * @param username 员工姓名
     * @return 删除条数
     */
    int deleteEm(String username);

    /**
     * 更新员工信息
     * @param emInformationEntity 员工信息
     * @return 更新条数
     */
    int updateEm(EmInformationEntity emInformationEntity);

    /**
     * 得到自增后的主键值
     * @return 最大ID
     */
    int getMaxId();


}
