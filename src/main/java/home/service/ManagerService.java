package home.service;

import home.entity.Manager;

public interface ManagerService {
    /***
     * 获取管理员数据
     * @param username
     * @return
     */
    public Manager getManagerByName(String username);

    /***
     * 管理员登陆
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password);

    /***
     * 退出登陆
     * @return
     */
    public boolean logout();

}
