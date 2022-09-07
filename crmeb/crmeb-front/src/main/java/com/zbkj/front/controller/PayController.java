package com.zbkj.front.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zbkj.common.constants.Constants;
import com.zbkj.common.model.finance.UserRecharge;
import com.zbkj.common.model.user.User;
import com.zbkj.common.model.user.UserBill;
import com.zbkj.common.request.OrderPayRequest;
import com.zbkj.common.response.CommonResult;
import com.zbkj.common.response.OrderPayResultResponse;
import com.zbkj.common.utils.CrmebUtil;
import com.zbkj.common.vo.OrderInfoVo;
import com.zbkj.service.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

/**
 * 微信缓存表 前端控制器
 * +----------------------------------------------------------------------
 * | CRMEB [ CRMEB赋能开发者，助力企业发展 ]
 * +----------------------------------------------------------------------
 * | Copyright (c) 2016~2022 https://www.crmeb.com All rights reserved.
 * +----------------------------------------------------------------------
 * | Licensed CRMEB并不是自由软件，未经许可不能去掉CRMEB相关版权
 * +----------------------------------------------------------------------
 * | Author: CRMEB Team <admin@crmeb.com>
 * +----------------------------------------------------------------------
 */

@RestController
@RequestMapping("api/front/pay")
@Api(tags = "支付管理")
public class PayController {

    @Autowired
    private WeChatPayService weChatPayService;

    @Autowired
    private OrderPayService orderPayService;

    @Autowired
    private AliPayService aliPayService;

    /**
     * 订单支付
     */
    @ApiOperation(value = "订单支付")
    @RequestMapping(value = "/payment", method = RequestMethod.POST)
    public CommonResult<OrderPayResultResponse> payment(@RequestBody @Validated OrderPayRequest orderPayRequest, HttpServletRequest request) {
        String ip = CrmebUtil.getClientIp(request);
        return CommonResult.success(orderPayService.payment(orderPayRequest, ip));
    }

    /**
     * 查询支付结果
     *
     * @param orderNo |订单编号|String|必填
     */
    @ApiOperation(value = "查询支付结果")
    @RequestMapping(value = "/queryPayResult", method = RequestMethod.GET)
    public CommonResult<Boolean> queryPayResult(@RequestParam String orderNo) {
        return CommonResult.success(weChatPayService.queryPayResult(orderNo));
    }

    @ApiOperation("支付回调")
    @PostMapping("/trade/notify")
    public void tradeNotify(@RequestParam Map<String, String> params) {
        aliPayService.tradeNotify(params);
    }

    @ApiOperation("退款")
    @PostMapping("/trade/refund")
    public void tradeRefund(@RequestParam String orderNo) {
        aliPayService.tradeRefund(orderNo);
    }
}
