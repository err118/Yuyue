package com.yuyue.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Staff implements Serializable {
    /**
     * 员工id
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 员工编码
     */
    private String staffNo;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 图片介绍一
     */
    private String coverone;

    /**
     * 图片介绍二
     */
    private String covertwo;

    /**
     * 图片介绍三
     */
    private String coverthree;

    /**
     * 属于的店铺id
     */
    private Long shopId;

    /**
     * 余额
     */
    private Float money;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCoverone() {
        return coverone;
    }

    public void setCoverone(String coverone) {
        this.coverone = coverone;
    }

    public String getCovertwo() {
        return covertwo;
    }

    public void setCovertwo(String covertwo) {
        this.covertwo = covertwo;
    }

    public String getCoverthree() {
        return coverthree;
    }

    public void setCoverthree(String coverthree) {
        this.coverthree = coverthree;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Staff other = (Staff) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getStaffNo() == null ? other.getStaffNo() == null : this.getStaffNo().equals(other.getStaffNo()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getCoverone() == null ? other.getCoverone() == null : this.getCoverone().equals(other.getCoverone()))
            && (this.getCovertwo() == null ? other.getCovertwo() == null : this.getCovertwo().equals(other.getCovertwo()))
            && (this.getCoverthree() == null ? other.getCoverthree() == null : this.getCoverthree().equals(other.getCoverthree()))
            && (this.getShopId() == null ? other.getShopId() == null : this.getShopId().equals(other.getShopId()))
            && (this.getMoney() == null ? other.getMoney() == null : this.getMoney().equals(other.getMoney()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getStaffNo() == null) ? 0 : getStaffNo().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getCoverone() == null) ? 0 : getCoverone().hashCode());
        result = prime * result + ((getCovertwo() == null) ? 0 : getCovertwo().hashCode());
        result = prime * result + ((getCoverthree() == null) ? 0 : getCoverthree().hashCode());
        result = prime * result + ((getShopId() == null) ? 0 : getShopId().hashCode());
        result = prime * result + ((getMoney() == null) ? 0 : getMoney().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nickname=").append(nickname);
        sb.append(", staffNo=").append(staffNo);
        sb.append(", age=").append(age);
        sb.append(", sex=").append(sex);
        sb.append(", coverone=").append(coverone);
        sb.append(", covertwo=").append(covertwo);
        sb.append(", coverthree=").append(coverthree);
        sb.append(", shopId=").append(shopId);
        sb.append(", money=").append(money);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}