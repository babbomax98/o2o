package com.o2o.service.impl;

import com.o2o.dao.HeadLineDao;
import com.o2o.entity.HeadLine;
import com.o2o.service.HeadLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-30 10:29
 */
@Service
public class HeadLineServiceImpl implements HeadLineService {

    @Autowired
    private HeadLineDao headLineDao;

    @Override
    public List<HeadLine> getHeadLineList(HeadLine headlineCondition) throws IOException {
        return headLineDao.queryHeadLine(headlineCondition);
    }
}
