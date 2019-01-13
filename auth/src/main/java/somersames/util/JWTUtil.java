package somersames.util;


import com.sun.corba.se.impl.orbutil.closure.Constant;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author szh
 * @create 2019-01-13 17:34
 **/
@Service
public class JWTUtil {


    @Value("jwt.securityKey")
    private String securityKey;

    public  String createJWT(String userId)  {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Map<String,Object> claims = new HashMap<String,Object>();
        claims.put("userId", userId);
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setId(userId)
                .setIssuedAt(now)
                .setSubject(userId)
                .signWith(signatureAlgorithm, key);
        return builder.compact();
    }
    public SecretKey generalKey(){
        byte[] encodedKey = Base64.decodeBase64("somersames");
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
}
