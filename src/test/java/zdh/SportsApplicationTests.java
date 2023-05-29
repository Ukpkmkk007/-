package zdh;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zdh.dao.UserDao;

import java.util.Scanner;

//@RunWith(SpringRunner.class)
@SpringBootTest
class SportsApplicationTests {

    @Autowired
    UserDao userDao;

    @Test
    public void TestGetCount(){
        System.out.println(userDao.getUserCounts("a"));
    }

}
