package com.decisioncustom.domain;

import java.util.Date;

/**
 * 描述:t_user表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-06-04
 */
public class TUserVO {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 用户头像
     */
    private String headimg;

    /**
     * 账号(身份证)
     */
    private String idCard;

    /**
     * 手机号
     */
    private Long mobile;

    /**
     * 密码
     */
    private String password;

    /**
     * 微信
     */
    private String wechat;

    /**
     * 开通时间
     */
    private Date turnOnTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 剩余时间
     */
    private Long remainingTime;

    /**
     * 用户角色 0:用户 1：老师 2：管理员
     */
    private Integer userRole;

    /**
     * 用户ID
     * @return user_id 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 用户姓名
     * @return user_name 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户姓名
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 用户头像
     * @return headimg 用户头像
     */
    public String getHeadimg() {
        return headimg;
    }

    /**
     * 用户头像
     * @param headimg 用户头像
     */
    public void setHeadimg(String headimg) {
        this.headimg = headimg == null ? null : headimg.trim();
    }

    /**
     * 账号(身份证)
     * @return id_card 账号(身份证)
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 账号(身份证)
     * @param idCard 账号(身份证)
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 手机号
     * @return mobile 手机号
     */
    public Long getMobile() {
        return mobile;
    }

    /**
     * 手机号
     * @param mobile 手机号
     */
    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 微信
     * @return wechat 微信
     */
    public String getWechat() {
        return wechat;
    }

    /**
     * 微信
     * @param wechat 微信
     */
    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    /**
     * 开通时间
     * @return turn_on_time 开通时间
     */
    public Date getTurnOnTime() {
        return turnOnTime;
    }

    /**
     * 开通时间
     * @param turnOnTime 开通时间
     */
    public void setTurnOnTime(Date turnOnTime) {
        this.turnOnTime = turnOnTime;
    }

    /**
     * 结束时间
     * @return end_time 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 剩余时间
     * @return remaining_time 剩余时间
     */
    public Long getRemainingTime() {
        return remainingTime;
    }

    /**
     * 剩余时间
     * @param remainingTime 剩余时间
     */
    public void setRemainingTime(Long remainingTime) {
        this.remainingTime = remainingTime;
    }

    /**
     * 用户角色 0:用户 1：老师 2：管理员
     * @return user_role 用户角色 0:用户 1：老师 2：管理员
     */
    public Integer getUserRole() {
        return userRole;
    }

    /**
     * 用户角色 0:用户 1：老师 2：管理员
     * @param userRole 用户角色 0:用户 1：老师 2：管理员
     */
    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }
}