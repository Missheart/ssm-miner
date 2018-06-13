package home.dao;

import home.entity.Notice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper {

    public List<Notice> getNoticeList();

    public Integer addNotice(Notice notice);
}
