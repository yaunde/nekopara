package io.blotus.model.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 
 * </p>
 *
 * @author zzq123
 * @since 2018-03-06
 */
@TableName("lt_users")
public class LtUsers extends Model<LtUsers> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    /**
     * 用户的注册名称
     */
    @TableField("user_login")
    private String userLogin;
    /**
     * 用户密码
     */
    @TableField("user_pass")
    private String userPass;
    /**
     * 用户昵称
     */
    @TableField("user_nicename")
    private String userNicename;
    /**
     * 电邮地址
     */
    @TableField("user_email")
    private String userEmail;
    /**
     * 用户网址
     */
    @TableField("user_url")
    private String userUrl;
    /**
     * 用户注册时间，datetime值。
     */
    @TableField("user_registered")
    private Date userRegistered;
    /**
     * 用户激活码，不详。
     */
    @TableField("user_activation_key")
    private String userActivationKey;
    /**
     * 用户状态，int(11)值，默认为0
     */
    @TableField("user_status")
    private Integer userStatus;
    /**
     * 来前台显示出来的用户名字
     */
    @TableField("display_name")
    private String displayName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserNicename() {
        return userNicename;
    }

    public void setUserNicename(String userNicename) {
        this.userNicename = userNicename;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserUrl() {
        return userUrl;
    }

    public void setUserUrl(String userUrl) {
        this.userUrl = userUrl;
    }

    public Date getUserRegistered() {
        return userRegistered;
    }

    public void setUserRegistered(Date userRegistered) {
        this.userRegistered = userRegistered;
    }

    public String getUserActivationKey() {
        return userActivationKey;
    }

    public void setUserActivationKey(String userActivationKey) {
        this.userActivationKey = userActivationKey;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "LtUsers{" +
        "id=" + id +
        ", userLogin=" + userLogin +
        ", userPass=" + userPass +
        ", userNicename=" + userNicename +
        ", userEmail=" + userEmail +
        ", userUrl=" + userUrl +
        ", userRegistered=" + userRegistered +
        ", userActivationKey=" + userActivationKey +
        ", userStatus=" + userStatus +
        ", displayName=" + displayName +
        "}";
    }
}
