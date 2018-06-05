package com.ying.background.controller;

import com.ying.background.dto.BookDTO;
import com.ying.background.services.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yingsy on 2018/5/20.
 */
@Controller
@RequestMapping("/book")
public class BookTestController {

    @Autowired
    private IBookService bookServiceImpl;

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        Map<String, List<BookDTO>> map = new HashMap<>();
        map.put("books",bookServiceImpl.getAllBook());
        mv.addAllObjects(map);
        return mv;
    }
}
