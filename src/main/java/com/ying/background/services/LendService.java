package com.ying.background.services;

import com.ying.background.dao.LendDao;
import com.ying.background.dao.model.Lend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LendService {
    private LendDao lendDao;

    @Autowired
    public void setLendDao(LendDao lendDao) {
        this.lendDao = lendDao;
    }

    public boolean bookReturn(long bookId){
        return lendDao.bookReturnOne(bookId)>0 && lendDao.bookReturnTwo(bookId)>0;
    }

    public boolean bookLend(long bookId,int readerId){
        return lendDao.bookLendOne(bookId,readerId)>0 && lendDao.bookLendTwo(bookId)>0;
    }

    public List<Lend> lendList(){
        return lendDao.lendList();
    }

    public List<Lend> getPageLendList(int offset, int length){
        return lendDao.getPageLendList(offset, length);
    }

    public int getAllLendCount(){
        return lendDao.queryAllLendCount();
    }
    
    public List<Lend> myLendList(int readerId){
        return lendDao.myLendList(readerId);
    }

}
