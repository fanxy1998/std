package com.fanxy.interceptor;

import com.fanxy.redis.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author fanxy
 */
@Component
public class RedisSessionInterceptor implements HandlerInterceptor {

    @Autowired
    RedisUtils redisUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        HttpSession session = request.getSession();
        String loginUserId = "loginUserId";
        if(session.getAttribute(loginUserId)!= null){
            try {
                String loginSessionId = redisUtils.get("loginUser:"+session.getAttribute("loginUserId"));
                if(loginSessionId != null && loginSessionId.equals(session.getId())){
                    return true;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try {
            response.getWriter().print("用户未登录");
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView){
      //不需要
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e){
      //不需要
    }

}
