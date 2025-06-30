package com.qyg.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 订单实体类
 */
@Data
public class Order {
    
    private Long id;
    
    /**
     * 订单号
     */
    private String orderNo;
    
    /**
     * 用户ID
     */
    private Long userId;
    
    /**
     * 订单总金额
     */
    private BigDecimal totalAmount;
    
    /**
     * 订单状态：0-待支付，1-已支付，2-已发货，3-已完成，4-已取消，5-退款中，6-已退款
     */
    private Integer status;
    
    /**
     * 收货人姓名
     */
    private String receiverName;
    
    /**
     * 收货人电话
     */
    private String receiverPhone;
    
    /**
     * 收货地址
     */
    private String receiverAddress;
    
    /**
     * 物流单号
     */
    private String trackingNo;
    
    /**
     * 物流公司
     */
    private String logisticsCompany;
    
    /**
     * 支付方式：1-微信，2-支付宝，3-银行卡
     */
    private Integer payMethod;
    
    /**
     * 支付时间
     */
    private LocalDateTime payTime;
    
    /**
     * 发货时间
     */
    private LocalDateTime shipTime;
    
    /**
     * 完成时间
     */
    private LocalDateTime completeTime;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
} 