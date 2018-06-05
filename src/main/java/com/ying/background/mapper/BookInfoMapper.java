package com.ying.background.mapper;

import com.ying.background.model.BookInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface BookInfoMapper {
    int insert(BookInfo record);

    BookInfo selectByPrimaryKey(Long bookId);

    List<BookInfo> selectAllBooks();

    int updateByPrimaryKey(BookInfo record);

    int deleteBookByBookId(BookInfo record);
}