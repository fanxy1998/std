package com.fanxy.controller;
import com.fanxy.entity.EmInformation;
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
        EmInformation emInformation = emInfomationService.login(username,password);
        if(emInformation != null){
            //设置一个session保存用户ID
            HttpSession session = request.getSession();
            session.setAttribute("loginUserId",emInformation.getId());
            session.setAttribute("loginUserName",emInformation.getUsername());
            //把用户ID和 sessionID保存到redis中
            redisUtils.set("loginUser:"+emInformation.getId(),session.getId());
            return new Result<>("success","登录成功",emInformation);
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
     * 查询全部员工
     * @return 员工列表
     */
    @GetMapping("/queryEm")
    public Result queryEm(){
        return new Result<>("success","查询成功",emInfomationService.queryEm());
    }

    /**
     * 添加员工
     * @param emInformation 员工数据
     * @return 提示信息
     */
    @PostMapping("/insertEm")
    public String insertEm(@RequestBody EmInformation emInformation){
        return emInfomationService.insertEm(emInformation);
    }


}
