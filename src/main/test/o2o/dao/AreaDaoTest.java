package o2o.dao;


import com.o2o.dao.AreaDao;
import com.o2o.entity.Area;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author shkstart
 * @create 2020-04-16 14:14
 */
public class AreaDaoTest extends BaseTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    public void testQueryArea(){
        List<Area> areaList=areaDao.queryArea();
        assertEquals(4,areaList.size());
    }
}
