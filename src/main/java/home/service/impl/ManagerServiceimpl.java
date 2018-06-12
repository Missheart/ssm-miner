/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: ManagerServiceimpl
 * Author:   Administrator
 * Date:     2018/6/11 15:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package home.service.impl;

import home.dao.ManagerMapper;
import home.entity.Manager;
import home.service.ManagerService;
import home.utils.CommonFunction;
import home.utils.SessionUtis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/6/11
 * @since 1.0.0
 */
@Service("managerService")
public class ManagerServiceimpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private SessionUtis SessionUtis;

    @Override
    public boolean login(String username, String password) {
        //查询管理员
        Manager manager = managerMapper.getManagerByName(username);
        if( manager == null )
            return false;
        System.out.println(manager);
        String rightPassword = manager.getPassword();
        String md5Password = CommonFunction.getManagerPassword(password, manager.getSalt());
        if( !rightPassword.equals(md5Password) )
            return false;

        //设置session
        boolean set = SessionUtis.setSession("managerData", manager);
        if( set == false )
            return false;

        return true;
    }

    @Override
    public Manager getManagerByName(String username) {
        return managerMapper.getManagerByName(username);
    }
}