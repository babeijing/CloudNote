import com.ycit.cloud_note.util.DBUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * @author OldHorse on 2022/9/29
 */
public class TestDB {
    //日志工厂类，记录日志
    private Logger logger= LoggerFactory.getLogger(TestDB.class);

    @Test
    public void testDB(){
        System.out.println(DBUtil.getConnection());
        logger.info("获取数据库连接:"+DBUtil.getConnection());
    }
}
