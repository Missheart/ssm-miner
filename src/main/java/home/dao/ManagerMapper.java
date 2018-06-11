package home.dao;

import home.entity.Manager;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerMapper {
    public Manager getManagerByName(String username);
}
