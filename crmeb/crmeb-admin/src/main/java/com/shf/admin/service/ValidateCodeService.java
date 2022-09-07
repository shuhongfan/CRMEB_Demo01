package com.shf.admin.service;


import com.shf.admin.vo.ValidateCode;

/**
 * ValidateCodeService 接口
 */
public interface ValidateCodeService {

    /**
     * 获取图片验证码
     * @return CommonResult
     */
    ValidateCode get();

    /**
     * 验证验证码
     */
    Boolean check(String key, String code);
}
