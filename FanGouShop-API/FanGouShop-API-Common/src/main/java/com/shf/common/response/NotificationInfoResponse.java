package com.shf.common.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统通知详情相应对象
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="NotificationInfoResponse对象", description="系统通知详情相应对象")
public class NotificationInfoResponse implements Serializable {

    private static final long serialVersionUID = -3214167698001861141L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "模板id(公用)")
    private String tempId;

    @ApiModelProperty(value = "模板说明(短信)")
    private String title;

    @ApiModelProperty(value = "模板编号(公用)")
    private String tempKey;

    @ApiModelProperty(value = "内容(公用)")
    private String content;

    @ApiModelProperty(value = "模板名")
    private String name;

    @ApiModelProperty(value = "状态,1-开启，2-关闭")
    private Integer status;
}
