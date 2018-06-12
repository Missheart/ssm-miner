/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: LoginHandle
 * Author:   Administrator
 * Date:     2018/6/12 15:28
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package home.Aspectj;

import home.entity.Manager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/6/12
 * @since 1.0.0
 */
@Aspect
@Component
public class LoginHandle {
    private static final String NEED_LOGIN = "请先登录";

//    @Pointcut(value = "execution(public * home.controller.*.*(..))")
    public void start(){
    }

//    @Before("start()")
    public boolean access(ProceedingJoinPoint joinPoint){
        /*Manager manager = getManager();
        MethodSignature joinPointObject = (MethodSignature) joinPoint.getSignature();
        //获得请求的方法
        Method method = joinPointObject.getMethod();
        //判断是否需要登陆（含有Login注解）
        if (hasAnnotationOnMethod(method,Login.class)){
            if (manager == null){
                //用户未登录
                System.out.println("用户未登陆");
                return false;
            }
        }*/
        return true;
    }

    /**
     * 从session中获取当前用户
     * @return
     */
    private Manager getManager(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpSession session = request.getSession();
        Manager manager = (Manager) session.getAttribute("ManagerData");
        return manager;
    }

    /**
     * 判断某方法上是否含有某注解
     * @param method
     * @param annotationClazz
     * @return
     */
    private boolean hasAnnotationOnMethod(Method method,Class annotationClazz){
        //使用反射获取注解信息
        Annotation a = method.getAnnotation(annotationClazz);
        if (a == null){
            return false;
        }
        return true;
    }

}