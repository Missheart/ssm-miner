package home.utils;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 自定义全局异常处理器
 */
public class CustomExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/error");

        String method = httpServletRequest.getMethod();
        httpServletRequest.setAttribute("exception", e);
        httpServletRequest.setAttribute("message", e.getMessage());
        try {
            if( method.equals("GET") ){
                httpServletRequest.getRequestDispatcher("/exception/getHandle").forward(httpServletRequest, httpServletResponse);
            }else if( method.equals("POST") ){
                httpServletRequest.getRequestDispatcher(httpServletRequest.getContextPath()+"/exception/postHandle").forward(httpServletRequest, httpServletResponse);
            }
        } catch (ServletException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return modelAndView;
    }
}
