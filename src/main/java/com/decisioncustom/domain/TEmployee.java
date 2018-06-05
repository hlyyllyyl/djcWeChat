package com.decisioncustom.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 描述:t_employee表的实体类
 * @version
 * @author:  Administrator
 * @创建时间: 2018-05-11
 */
public class TEmployee {
    public List<TEmployeeRole> getEmployeeRoles() {
        List<TEmployeeRole> list_rp = new ArrayList<>();
        Long id = this.getId();
        List<Role> p = this.getRoles();
        for (Role p2 : p) {
            list_rp.add(new TEmployeeRole(id, p2.getId()));
        }
        return list_rp;
    }
    //部门
    private Department department;
    //角色
    private List<Role> roles = new ArrayList<>();

    //栏目
    private List<TColumn> columns = new ArrayList<>();

    //部门
    private List<TDepartment> departments = new ArrayList<>();

    private  String newPassword;

    private  String[] roleStrs;

    private  String[] columnStrs;

    public List<TDepartment> getDepartments() {
        return departments;
    }

    public void setDepartments(List<TDepartment> departments) {
        this.departments = departments;
    }

    public String[] getColumnStrs() {
        return columnStrs;
    }

    public void setColumnStrs(String[] columnStrs) {
        this.columnStrs = columnStrs;
    }

    public List<TColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<TColumn> columns) {
        this.columns = columns;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String[] getRoleStrs() {
        return roleStrs;
    }

    public void setRoleStrs(String[] roleStrs) {
        this.roleStrs = roleStrs;
    }

    @Override
    public String toString() {
        return "TEmployee{" +
                ", id=" + id +
                ", userName='" + userName + '\'' +
                ", headImg='" + headImg + '\'' +
                ", realName='" + realName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", inputTime=" + inputTime +
                ", readingQuantity=" + readingQuantity +
                ", thumbUpQuantity=" + thumbUpQuantity +
                ", practiceNum='" + practiceNum + '\'' +
                ", state=" + state +
                '}';
    }

    /**
     * 
     */
    private Long id;

    /**
     * 老师姓名
     */
    private String userName;

    /**
     * 老师头像
     */
    private String headImg;

    /**
     * 二维码
     */
    private String quickMark;

    /**
     * 老师电话
     */
    private String phoneNum;

    /**
     * 老师真实姓名
     */
    private String realName;

    /**
     * 密码
     */
    private String passWord;

    /**
     * 录入时间
     */
    private Date inputTime;

    /**
     * 浏览量
     */
    private Long readingQuantity;

    /**
     * 点赞量
     */
    private Long thumbUpQuantity;

    /**
     * 执业编号
     */
    private String practiceNum;

    /**
     * 风险揭示
     */
    private String riskDisclosure;

    /**
     * 免责声明
     */
    private String disclaimer;

    /**
     * 状态 1：在职 -1：离职  
     */
    private Integer state;

    /**
     * 老师简介
     */
    private String employeeDetails;

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
     * 老师姓名
     * @return user_name 老师姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 老师姓名
     * @param userName 老师姓名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 老师头像
     * @return head_img 老师头像
     */
    public String getHeadImg() {
        return headImg;
    }

    /**
     * 老师头像
     * @param headImg 老师头像
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg == null ? null : headImg.trim();
    }

    /**
     * 二维码
     * @return quick_mark 二维码
     */
    public String getQuickMark() {
        return quickMark;
    }

    /**
     * 二维码
     * @param quickMark 二维码
     */
    public void setQuickMark(String quickMark) {
        this.quickMark = quickMark == null ? null : quickMark.trim();
    }

    /**
     * 老师电话
     * @return phone_num 老师电话
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * 老师电话
     * @param phoneNum 老师电话
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    /**
     * 老师真实姓名
     * @return real_name 老师真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 老师真实姓名
     * @param realName 老师真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 密码
     * @return pass_word 密码
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * 密码
     * @param passWord 密码
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    /**
     * 录入时间
     * @return input_time 录入时间
     */
    public Date getInputTime() {
        return inputTime;
    }

    /**
     * 录入时间
     * @param inputTime 录入时间
     */
    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    /**
     * 浏览量
     * @return reading_quantity 浏览量
     */
    public Long getReadingQuantity() {
        return readingQuantity;
    }

    /**
     * 浏览量
     * @param readingQuantity 浏览量
     */
    public void setReadingQuantity(Long readingQuantity) {
        this.readingQuantity = readingQuantity;
    }

    /**
     * 点赞量
     * @return thumb_up_quantity 点赞量
     */
    public Long getThumbUpQuantity() {
        return thumbUpQuantity;
    }

    /**
     * 点赞量
     * @param thumbUpQuantity 点赞量
     */
    public void setThumbUpQuantity(Long thumbUpQuantity) {
        this.thumbUpQuantity = thumbUpQuantity;
    }

    /**
     * 执业编号
     * @return practice_num 执业编号
     */
    public String getPracticeNum() {
        return practiceNum;
    }

    /**
     * 执业编号
     * @param practiceNum 执业编号
     */
    public void setPracticeNum(String practiceNum) {
        this.practiceNum = practiceNum == null ? null : practiceNum.trim();
    }

    /**
     * 风险揭示
     * @return risk_disclosure 风险揭示
     */
    public String getRiskDisclosure() {
        return riskDisclosure;
    }

    /**
     * 风险揭示
     * @param riskDisclosure 风险揭示
     */
    public void setRiskDisclosure(String riskDisclosure) {
        this.riskDisclosure = riskDisclosure == null ? null : riskDisclosure.trim();
    }

    /**
     * 免责声明
     * @return disclaimer 免责声明
     */
    public String getDisclaimer() {
        return disclaimer;
    }

    /**
     * 免责声明
     * @param disclaimer 免责声明
     */
    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer == null ? null : disclaimer.trim();
    }

    /**
     * 状态 1：在职 -1：离职  
     * @return state 状态 1：在职 -1：离职  
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态 1：在职 -1：离职  
     * @param state 状态 1：在职 -1：离职  
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 老师简介
     * @return employee_details 老师简介
     */
    public String getEmployeeDetails() {
        return employeeDetails;
    }

    /**
     * 老师简介
     * @param employeeDetails 老师简介
     */
    public void setEmployeeDetails(String employeeDetails) {
        this.employeeDetails = employeeDetails == null ? null : employeeDetails.trim();
    }
}