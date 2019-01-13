package somersames.constant;

import somersames.util.ResponseUtils;

/**
 * @author szh
 * @create 2018-12-15 23:42
 **/
public enum ResponseEnum {
    SUCCESS("200","success"),

    FAIL("201","fail")
    ;
    private String code;

    private String desc;

    ResponseEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public void setResponse(ResponseUtils response){
        response.setCode(this.code);
        response.setMessage(this.desc);
    }
}
