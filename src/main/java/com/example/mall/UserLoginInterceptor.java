package com.example.mall;

import com.example.mall.consts.MallConst;
import com.example.mall.exception.UserLoginException;
import com.example.mall.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 定义一个拦截器：检查是否登录，是handle（controller）处理之前检查
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {

    /**
     * true 表示继续，false 表示中断
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle...{}", handler);
        User user = (User) request.getSession().getAttribute(MallConst.CURRENT_USER);
        if (user == null) {
            log.info("user == null，session中无user，未登录");
            throw new UserLoginException();
//            response.getWriter().print("error");
//            return false;
//            return ResponseVo.error(ResponseEnum.NEED_LOGIN);
        }

        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
}
