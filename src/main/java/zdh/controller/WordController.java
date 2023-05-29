package zdh.controller;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zdh.Bean.QueryInfo;
import zdh.Bean.Word;
import zdh.dao.WordListDao;

import java.util.HashMap;
import java.util.List;

@RestController
public class WordController {


    @Autowired
    WordListDao wordListDao;
    @RequestMapping("/allWord")
    public String getWordList(QueryInfo queryInfo){
        int num = wordListDao.getWordCounts(queryInfo.getQuery());
        int pageStart = (queryInfo.getPageNum() - 1) * queryInfo.getPageSize();
        List<Word> words = wordListDao.getAllWord(queryInfo.getQuery(), pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",num);
        res.put("data",words);
        String res_String= JSON.toJSONString(res);
        return res_String;
    }


    @RequestMapping("/addWord")
    public String addUser(@RequestBody Word word){
        int i = wordListDao.addWord(word);
        return i>0?"success":"error";
    }

    @RequestMapping("/deleteWord")
    public String deleteWord(int id){
        int i = wordListDao.deleteWord(id);
        return i>0?"success":"error";
    }

    @RequestMapping("/getUpdateWord")
    public String getUpdateWord(int id){
        Word updateWord=wordListDao.getUpdateWord(id);
        String res_String= JSON.toJSONString(updateWord);
        return res_String;
    }

    @RequestMapping("/editWord")
    public String editUser(@RequestBody Word word){
        int i = wordListDao.editWord(word);
        String str = i >0?"success":"error";
        return str;
    }
}
