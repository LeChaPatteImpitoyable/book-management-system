package com.ying.background.convert;

import com.ying.background.dto.BookDTO;
import com.ying.background.model.Book;
import com.ying.background.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by yingsy on 2018/5/20.
 */
@Component
public class BookConvert {

    public BookDTO convertToBookDTO(Book book){
        if (book == null){
            return null;
        }
        BookDTO bookDTO = new BookDTO();
        BeanUtils.copyProperties(book, bookDTO);
        return bookDTO;
    }

    public Book convertBook(BookDTO bookDTO){
        if (bookDTO == null){
            return null;
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookDTO, book);
        Date date = new Date();
        book.setCreateTime(DateUtil.getStrByDate(date, DateUtil.DEFAULT_DATETIME_FORMAT));
        book.setModifyTime(DateUtil.getStrByDate(date, DateUtil.DEFAULT_DATETIME_FORMAT));
        return book;
    }
}
