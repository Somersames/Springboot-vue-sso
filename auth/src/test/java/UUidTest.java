import org.junit.Test;

import java.util.UUID;

/**
 * @author szh
 * @create 2019-01-13 13:04
 **/
public class UUidTest {
    @Test
    public void uuid(){
        System.out.println(UUID.randomUUID().toString().replace("-","").length());
    }
}
