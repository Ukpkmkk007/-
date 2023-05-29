package zdh.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zdh.Bean.MainMenu;
import zdh.dao.MenuDao;

import java.util.HashMap;
import java.util.List;

@RestController
public class MenuController {
    @Autowired
    MenuDao menuDao;

    @RequestMapping("/menus")
    public String getAllMenus(){
        System.out.println("access successful");
        HashMap<String, Object> data = new HashMap<>();
        int status=404;
        List<MainMenu> menus=menuDao.getMenus();
        if(menus!=null){
            data.put("menus",menus);
            data.put("flag",200);
        }else{
            data.put("flag",404);
        }

        String s = JSON.toJSONString(data);

        return s;


    }
}
