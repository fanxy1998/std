package com.fanxy.controller;
import com.fanxy.entity.EmInformationEntity;
import com.fanxy.redis.RedisUtils;
import com.fanxy.result.Result;
import com.fanxy.service.EmInfomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author fanxy
 */
@RestController
@RequestMapping("/em")
public class EmInfomationController {
    private EmInfomationService emInfomationService;
    private RedisUtils redisUtils;
    private String sucess = "success";

    @Autowired
    public EmInfomationController(EmInfomationService emInfomationService) {
        this.emInfomationService = emInfomationService;
    }

    @Autowired
    public void setRedisUtils(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    /**
     * 登录
     * @param request 用户请求
     * @param username 员工名
     * @param password 密码
     * @return 员工信息
     */
    @PostMapping("/login/{username}/{password}")
    public Result login(HttpServletRequest request, @PathVariable("username") String username,
                        @PathVariable("password") String password){
        EmInformationEntity emInformationEntity = emInfomationService.login(username,password);
        if(emInformationEntity != null){
            //设置一个session保存用户ID
            HttpSession session = request.getSession();
            session.setAttribute("loginUserId", emInformationEntity.getId());
            session.setAttribute("loginUserName", emInformationEntity.getUsername());
            //把用户ID和 sessionID保存到redis中
            redisUtils.set("loginUser:"+ emInformationEntity.getId(),session.getId());
            return new Result<>(sucess,"登录成功", emInformationEntity);
        }else {
            return new Result("error","账号或密码错误");
        }
    }

    /**
     * 修改密码
     * @param username  员工名
     * @param oldpassword 旧密码
     * @param newPassword 新密码
     * @return 提示
     */
    @PostMapping("/resetPassword/{username}/{oldpassword}/{newPassword}")
    public String updatePassword(@PathVariable("username") String username,
                                 @PathVariable("oldpassword") String oldpassword,
                                 @PathVariable("newPassword") String newPassword){
        if(emInfomationService.login(username,oldpassword)!=null){
            emInfomationService.updatePassword(username,newPassword);
            return "修改成功";
        }
        return "输入密码错误请重试";
    }

    /**
     * 查询员工
     * @return 员工列表
     */
    @GetMapping("/queryEm/{userId}")
    public Result queryEm(@PathVariable("userId") int userId){
        String position = "普通员工";
        if(userId!=1){
            EmInformationEntity emInformationEntity = emInfomationService.queryByUserId(userId);
            if(emInformationEntity!=null){
                if(position.equals(emInformationEntity.getPosition())){
                    return new Result<>(sucess,"查询成功",emInformationEntity);
                }else {
                    return new Result<>(sucess,"查询成功",emInfomationService.findEmByDepartment(emInformationEntity.getDepartment()));
                }
            }
        }
        return new Result<>(sucess,"查询成功",emInfomationService.queryEm());
    }

    /**
     * 添加员工
     * @param emInformationEntity 员工数据
     * @return 提示信息
     */
    @PostMapping("/insertEm")
    public String insertEm(@RequestBody EmInformationEntity emInformationEntity){
        return emInfomationService.insertEm(emInformationEntity);
    }

    /**
     * 删除员工
     * @param username 员工姓名
     * @return 提升信息
     */
    @GetMapping("/deleteUser/{username}")
    public String deleteUser(@PathVariable("username") String username){
        emInfomationService.deleteUser(username);
        return "删除成功";
    }

    /**
     * 更新员工信息
     * @param emInformationEntity 员工信息
     * @return 提示信息
     */
    @PostMapping("/updateEm")
    public String updateEm(@RequestBody EmInformationEntity emInformationEntity){
        emInfomationService.updateEm(emInformationEntity);
        return "更新成功";
    }



}
