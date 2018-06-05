package com.ying.background.services.book.impl;

import com.ying.background.constant.Constants;
import com.ying.background.convert.BookConvert;
import com.ying.background.dto.BookDTO;
import com.ying.background.mapper.BookMapper;
import com.ying.background.model.Book;
import com.ying.background.services.book.IBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yingsy on 2018/5/20.
 */
@Service
@Slf4j
public class BookServiceImpl implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookConvert bookConvert;

    @Override
    public List<BookDTO> getAllBook() {
        List<Book> books = bookMapper.selectAllBooks();
        if(CollectionUtils.isEmpty(books)){
            return null;
        }
        List<BookDTO> bookDTOS = new ArrayList<>();
        for(Book book : books){
            bookDTOS.add(bookConvert.convertToBookDTO(book));
        }
        return bookDTOS;
    }

    @Override
    public boolean addBook(BookDTO bookDTO) {
        if(bookDTO == null){
            log.info("新加书本时，请求参数为空!");
            return Constants.FAIL;
        }
        bookMapper.insertBook(bookConvert.convertBook(bookDTO));
        return Constants.SUCCESS;
    }
}
