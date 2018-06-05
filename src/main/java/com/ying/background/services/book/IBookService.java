package com.ying.background.services.book;

import com.ying.background.dto.BookDTO;

import java.util.List;

/**
 * Created by yingsy on 2018/5/20.
 */
public interface IBookService {

    List<BookDTO> getAllBook();

    boolean addBook(BookDTO bookDTO);
}
