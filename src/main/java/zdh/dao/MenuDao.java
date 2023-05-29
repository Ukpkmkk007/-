package zdh.dao;

import org.springframework.stereotype.Repository;
import zdh.Bean.MainMenu;

import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMenus();
}
