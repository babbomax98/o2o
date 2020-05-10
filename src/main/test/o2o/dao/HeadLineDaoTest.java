package o2o.dao;

import com.o2o.dao.HeadLineDao;
import com.o2o.entity.HeadLine;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-04-30 10:11
 */
public class HeadLineDaoTest extends BaseTest {

    @Autowired
    private HeadLineDao headLineDao;

    @Test
    public void testQueryArea(){
        List<HeadLine> headLineList=headLineDao.queryHeadLine(new HeadLine());

    }

}
