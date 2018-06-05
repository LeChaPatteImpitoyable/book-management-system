package com.ying.background.dao;

import com.ying.background.dao.model.Lend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class LendDao {

    private JdbcTemplate jdbcTemplate;
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final static String BOOK_RETURN_SQL_ONE="UPDATE lend_list SET back_date = ? WHERE book_id = ? AND back_date is NULL";

    private final static String BOOK_RETURN_SQL_TWO="UPDATE book_info SET state = 1 WHERE book_id = ? ";

    private final static String BOOK_LEND_SQL_ONE="INSERT INTO lend_list (book_id,reader_id,lend_date) VALUES ( ? , ? , ? )";

    private final static String BOOK_LEND_SQL_TWO="UPDATE book_info SET state = 0 WHERE book_id = ? ";

    private final static String LEND_LIST_SQL="SELECT * FROM lend_list";

    private final static String PAGE_LEND_LIST_SQL="SELECT * FROM lend_list limit ?,?";

    private final static String LEND_LIST_COUNT_SQL="SELECT count(*) FROM lend_list";

    private final static String MY_LEND_LIST_SQL="SELECT * FROM lend_list WHERE reader_id = ? ";

    public int queryAllLendCount(){
        return jdbcTemplate.queryForObject(LEND_LIST_COUNT_SQL,Integer.class);
    }

    public List<Lend> getPageLendList(int offset, int length){
        final List<Lend> list=new ArrayList<Lend>();
        jdbcTemplate.query(PAGE_LEND_LIST_SQL, new Object[]{offset, length},new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()){
                    Lend lend=new Lend();
                    lend.setBackDate(resultSet.getDate("back_date"));
                    lend.setBookId(resultSet.getLong("book_id"));
                    lend.setLendDate(resultSet.getDate("lend_date"));
                    lend.setReaderId(resultSet.getInt("reader_id"));
                    lend.setSernum(resultSet.getLong("sernum"));
                    list.add(lend);
                }
            }
        });
        return list;
    }

    public int bookReturnOne(long bookId){
        return  jdbcTemplate.update(BOOK_RETURN_SQL_ONE,new Object[]{df.format(new Date()),bookId});
    }
    public int bookReturnTwo(long bookId){
        return jdbcTemplate.update(BOOK_RETURN_SQL_TWO,new Object[]{bookId});
    }
    public int bookLendOne(long bookId,int readerId){
        return  jdbcTemplate.update(BOOK_LEND_SQL_ONE,new Object[]{bookId,readerId,df.format(new Date())});
    }
    public int bookLendTwo(long bookId){
        return  jdbcTemplate.update(BOOK_LEND_SQL_TWO,new Object[]{bookId});
    }

    public List<Lend> lendList(){
        final List<Lend> list=new ArrayList<Lend>();

        jdbcTemplate.query(LEND_LIST_SQL, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()){
                    Lend lend=new Lend();
                    lend.setBackDate(resultSet.getDate("back_date"));
                    lend.setBookId(resultSet.getLong("book_id"));
                    lend.setLendDate(resultSet.getDate("lend_date"));
                    lend.setReaderId(resultSet.getInt("reader_id"));
                    lend.setSernum(resultSet.getLong("sernum"));
                    list.add(lend);
                }
            }
        });
        return list;
    }

    public List<Lend> myLendList(int readerId){
        final List<Lend> list=new ArrayList<Lend>();

        jdbcTemplate.query(MY_LEND_LIST_SQL, new Object[]{readerId},new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                resultSet.beforeFirst();
                while (resultSet.next()){
                    Lend lend=new Lend();
                    lend.setBackDate(resultSet.getDate("back_date"));
                    lend.setBookId(resultSet.getLong("book_id"));
                    lend.setLendDate(resultSet.getDate("lend_date"));
                    lend.setReaderId(resultSet.getInt("reader_id"));
                    lend.setSernum(resultSet.getLong("sernum"));
                    list.add(lend);
                }
            }
        });
        return list;

    }
}
