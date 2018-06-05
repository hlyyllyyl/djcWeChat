package com.decisioncustom.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述:t_customer表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-04-20
 */
public class TCustomer {
    private List<TColumn> columns = new ArrayList<>();

    private TEmployee serviceMan;

    private TEmployee inputMan;

    private String turnOnTimeStr;

    private String endTimeStr;

    private String[] productStr;

    private String newPassword;

    private List<TCustomerColumn> customerColumns = new ArrayList<>();

    public List<TCustomerColumn> getCustomerColumns() {
        return customerColumns;
    }

    public void setCustomerColumns(List<TCustomerColumn> customerColumns) {
        this.customerColumns = customerColumns;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    /* public List<TCustomerColumn> getCustomerColumn() {
        List<TCustomerColumn> list_rp = new ArrayList<>();
        Long id = this.getId();
        List<TColumn> p = this.getColumns();
        for (TColumn p2 : p) {
            list_rp.add(new TCustomerColumn(id, p2.getId(),));
        }
        return list_rp;
    }*/


    public List<TColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<TColumn> columns) {
        this.columns = columns;
    }


    public TEmployee getServiceMan() {
        return serviceMan;
    }

    public void setServiceMan(TEmployee serviceMan) {
        this.serviceMan = serviceMan;
    }

    public TEmployee getInputMan() {
        return inputMan;
    }

    public void setInputMan(TEmployee inputMan) {
        this.inputMan = inputMan;
    }

    public String getTurnOnTimeStr() {
        return turnOnTimeStr;
    }

    public void setTurnOnTimeStr(String turnOnTimeStr) {
        this.turnOnTimeStr = turnOnTimeStr;
    }

    public String getEndTimeStr() {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr) {
        this.endTimeStr = endTimeStr;
    }

    public String[] getProductStr() {
        return productStr;
    }

    public void setProductStr(String[] productStr) {
        this.productStr = productStr;
    }
 /* public List<TCustomerColumn> getCustomerColumn() {
        List<TCustomerColumn> list_rp = new ArrayList<>();
        Long id = this.getId();
        List<TColumn> p = this.getColumns();
        for (TColumn p2 : p) {
            list_rp.add(new TCustomerColumn(id, p2.getId(),));
        }
        return list_rp;
    }*/

    @Override
    public String toString() {
        return "TCustomer{" +
                ", id=" + id +
                ", customerName='" + customerName + '\'' +
                ", idCard='" + idCard + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", mobile=" + mobile +
                ", wxHeadImg='" + wxHeadImg + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", fromUserName='" + fromUserName + '\'' +
                ", wechatName='" + wechatName + '\'' +
                ", wechat='" + wechat + '\'' +
                ", turnOnTime=" + turnOnTime +
                ", endTime=" + endTime +
                ", registerTime=" + registerTime +
                ", inputManId=" + inputManId +
                ", servicemanId=" + servicemanId +
                ", remark='" + remark + '\'' +
                ", state=" + state +
                '}';
    }

    /**
     *
     */
    private Long id;

    /**
     * 客户姓名
     */
    private String customerName;

    /**
     * 身份证号
     */
    private String idCard;

    /**
     * 密码
     */
    private String password;

    /**
     * 客户真实姓名
     */
    private String realName;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别 0：女 1：男 -1：未知
     */
    private Integer gender;

    /**
     * 手机号
     */
    private Long mobile;

    /**
     * 微信头像
     */
    private String wxHeadImg;

    /**
     * 城市
     */
    private String city;

    /**
     * 省份
     */
    private String province;

    /**
     * 微信编号
     */
    private String fromUserName;

    /**
     * 微信昵称
     */
    private String wechatName;

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
     * 注册日期
     */
    private Date registerTime;

    /**
     * 录入人ID
     */
    private Long inputManId;

    /**
     * 客服ID
     */
    private Long servicemanId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态 0：正常 ，1：暂停，-1：中止，2：回收站，3：初始录入
     */
    private Long state;

    /**
     *
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 客户姓名
     * @return customer_name 客户姓名
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 客户姓名
     * @param customerName 客户姓名
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * 身份证号
     * @return id_card 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 身份证号
     * @param idCard 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
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
     * 客户真实姓名
     * @return real_name 客户真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 客户真实姓名
     * @param realName 客户真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 年龄
     * @return age 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 性别 0：女 1：男 -1：未知
     * @return gender 性别 0：女 1：男 -1：未知
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 性别 0：女 1：男 -1：未知
     * @param gender 性别 0：女 1：男 -1：未知
     */
    public void setGender(Integer gender) {
        this.gender = gender;
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
     * 微信头像
     * @return wx_head_img 微信头像
     */
    public String getWxHeadImg() {
        return wxHeadImg;
    }

    /**
     * 微信头像
     * @param wxHeadImg 微信头像
     */
    public void setWxHeadImg(String wxHeadImg) {
        this.wxHeadImg = wxHeadImg == null ? null : wxHeadImg.trim();
    }

    /**
     * 城市
     * @return city 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 城市
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 省份
     * @return province 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省份
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 微信编号
     * @return from_user_name 微信编号
     */
    public String getFromUserName() {
        return fromUserName;
    }

    /**
     * 微信编号
     * @param fromUserName 微信编号
     */
    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName == null ? null : fromUserName.trim();
    }

    /**
     * 微信昵称
     * @return wechat_name 微信昵称
     */
    public String getWechatName() {
        return wechatName;
    }

    /**
     * 微信昵称
     * @param wechatName 微信昵称
     */
    public void setWechatName(String wechatName) {
        this.wechatName = wechatName == null ? null : wechatName.trim();
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
     * 注册日期
     * @return register_time 注册日期
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 注册日期
     * @param registerTime 注册日期
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 录入人ID
     * @return input_man_id 录入人ID
     */
    public Long getInputManId() {
        return inputManId;
    }

    /**
     * 录入人ID
     * @param inputManId 录入人ID
     */
    public void setInputManId(Long inputManId) {
        this.inputManId = inputManId;
    }

    /**
     * 客服ID
     * @return serviceman_id 客服ID
     */
    public Long getServicemanId() {
        return servicemanId;
    }

    /**
     * 客服ID
     * @param servicemanId 客服ID
     */
    public void setServicemanId(Long servicemanId) {
        this.servicemanId = servicemanId;
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 状态 0：正常 ，1：暂停，-1：中止，2：回收站，3：初始录入
     * @return state 状态 0：正常 ，1：暂停，-1：中止，2：回收站，3：初始录入
     */
    public Long getState() {
        return state;
    }

    /**
     * 状态 0：正常 ，1：暂停，-1：中止，2：回收站，3：初始录入
     * @param state 状态 0：正常 ，1：暂停，-1：中止，2：回收站，3：初始录入
     */
    public void setState(Long state) {
        this.state = state;
    }
}