package somersames.util;

import java.util.UUID;

/**
 * @author szh
 * @create 2019-01-13 13:05
 **/
public class UserUtil {
    public static String generateUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
