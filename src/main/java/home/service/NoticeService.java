package home.service;

import home.entity.Notice;

import java.util.List;

public interface NoticeService {

    /***
     * 获取热门资讯列表
     * @return
     */
    public List<Notice> getNoticeList();

    /***
     * 添加热门资讯
     * @param notice
     * @return
     */
    public Integer addNotice(Notice notice);
}
