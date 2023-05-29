package zdh.dao;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import zdh.Bean.Word;

import java.util.List;

@Repository
public interface WordListDao {
    public List<Word> getAllWord(
            @Param("en") String en,
            @Param("pageStart") int PageStart,
            @Param("pageSize") int pageSize);


    public int getWordCounts(@Param("en") String en);

    public int addWord(Word word);

    public int deleteWord(int id);

    public Word getUpdateWord(int id);

    public int editWord(Word word);
}
