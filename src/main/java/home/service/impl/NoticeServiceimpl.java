/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: NoticeServiceimpl
 * Author:   Administrator
 * Date:     2018/6/13 14:32
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package home.service.impl;

import home.dao.NoticeMapper;
import home.entity.Notice;
import home.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Administrator
 * @create 2018/6/13
 * @since 1.0.0
 */
@Service("noticeService")
public class NoticeServiceimpl implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getNoticeList() {
        return null;
    }

    @Override
    public Integer addNotice(Notice notice) {
        if (notice != null) {
            return noticeMapper.addNotice(notice);
        }
        return 0;
    }
}