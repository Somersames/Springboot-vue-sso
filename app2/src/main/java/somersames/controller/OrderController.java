package somersames.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import somersames.constant.ApiConstant;
import somersames.constant.ResponseEnum;
import somersames.entity.OrderInfo;
import somersames.service.OrderInfoService;
import somersames.util.CookiesUtil;
import somersames.util.ResponseUtils;

import java.util.List;

/**
 * @author szh
 * @create 2019-01-13 14:52
 **/
@RestController
@RequestMapping(ApiConstant.BASE_API)
@Slf4j
public class OrderController {

    @Autowired
    OrderInfoService orderInfoService;

    @CrossOrigin(origins = "*")
    @PostMapping(ApiConstant.APP)
    public ResponseUtils<List<OrderInfo>> queryOrderInfoList(HttpServletRequest request){
        String token = CookiesUtil.getToken(request);
        ResponseUtils<List<OrderInfo>> resp = new ResponseUtils<List<OrderInfo>>();
        ResponseEnum.SUCCESS.setResponse(resp);
        resp.setData(orderInfoService.queryUserOrderInfo(token));
        return resp;
    }
}
