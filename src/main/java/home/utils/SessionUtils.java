/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: SessionUtis
 * Author:   Administrator
 * Date:     2018/6/12 10:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package home.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/6/12
 * @since 1.0.0
 */
@Component
public class SessionUtils {

    private HttpServletRequest request;

    private HttpSession session;

    public void setRequestSession(){
        request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        session = request.getSession();
    }

    /**
     * 获取session
     * @param key
     * @return
     */
    public Object getSession(String key){
        setRequestSession();

        if (key == null)
            return null;

        if( request == null )
            return null;

        if( session == null )
            return null;

        return session.getAttribute(key);
    }

    /**
     * 设置session
     * @param key
     * @param value
     * @return
     */
    public boolean setSession(String key, Object value){
        setRequestSession();
        if (key == null)
            return false;

        if( request == null )
            return false;

        if( session == null )
            return false;

        if( session.getId() == null )
            return false;

        session.setAttribute(key, value);
        return true;
    }

    /**
     * 设置session过期时间
     * @param time
     * @return
     */
    public boolean setSessionExpire(Integer time){
        setRequestSession();
        if( request == null )
            return false;

        if( session == null )
            return false;

        if( session.getId() == null )
            return false;

        session.setMaxInactiveInterval(time);
        return true;
    }

    /***
     * 注销session
     * @return
     */
    public boolean unsetSession(){
        setRequestSession();
        if( request == null )
            return false;

        if( session != null ){
            session.invalidate();
            return true;
        }

        return false;
    }
}