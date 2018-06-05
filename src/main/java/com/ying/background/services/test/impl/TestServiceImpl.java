package com.ying.background.services.test.impl;

import com.ying.background.mapper.TestMapper;
import com.ying.background.model.Test;
import com.ying.background.services.test.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yingsy on 2018/5/8.
 */
@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> getAll() {
        return testMapper.selectAll();
    }
}
