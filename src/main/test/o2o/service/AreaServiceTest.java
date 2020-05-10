package o2o.service;



import com.o2o.entity.Area;
import com.o2o.service.AreaService;
import o2o.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author shkstart
 * @create 2020-04-16 18:32
 */
public class AreaServiceTest extends BaseTest {

    @Autowired
    private AreaService areaService;

    @Test
    public void testGetAreaList(){
        List<Area> areaList=areaService.getAreaList();
        assertEquals("东苑",areaList.get(0).getAreaName());
        //System.out.println(areaList);
    }
}
