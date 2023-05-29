package zdh.Bean;


import lombok.Data;

@Data
public class QueryInfo {
    private String query;
    private int pageNum;
    private int pageSize;
}
