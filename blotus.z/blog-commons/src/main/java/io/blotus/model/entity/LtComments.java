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
 * 文章评论信息表
 * </p>
 *
 * @author zzq123
 * @since 2018-03-06
 */
@TableName("lt_comments")
public class LtComments extends Model<LtComments> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "comment_ID", type = IdType.AUTO)
    private Long commentId;
    /**
     * 每个评论对应的文章的ID号
     */
    @TableField("comment_post_ID")
    private Long commentPostId;
    /**
     * 每个评论的评论者名称
     */
    @TableField("comment_author")
    private String commentAuthor;
    @TableField("comment_author_email")
    private String commentAuthorEmail;
    /**
     * 每个评论的评论者网址
     */
    @TableField("comment_author_url")
    private String commentAuthorUrl;
    /**
     * 每个评论的评论者的IP地址
     */
    @TableField("comment_author_IP")
    private String commentAuthorIp;
    @TableField("comment_date")
    private Date commentDate;
    /**
     * 每个评论发表的时间，datetime值(是标准的格林尼治时间)
     */
    @TableField("comment_date_gmt")
    private Date commentDateGmt;
    /**
     * 每个评论的具体内容，text值
     */
    @TableField("comment_content")
    private String commentContent;
    @TableField("comment_karma")
    private Integer commentKarma;
    /**
     * 每个评论的当前状态，为一个枚举值enum(’0′,’1′,’spam’)，0为等待审核，1为允许发布，spam为垃圾评论。默认值为1
     */
    @TableField("comment_approved")
    private String commentApproved;
    /**
     * 每个评论的评论者的客户端信息，varchar(255)值，主要包括其浏览器和操作系统的类型、版本等资料。
     */
    @TableField("comment_agent")
    private String commentAgent;
    /**
     * 评论的类型，varchar(20)值
     */
    @TableField("comment_type")
    private String commentType;
    /**
     * 某一评论的上级评论，int(11)值，对应wp_comment.ID，默认为0，即无上级评论。
     */
    @TableField("comment_parent")
    private Long commentParent;
    /**
     * 某一评论对应的用户ID，只有当用户注册后才会生成，int(11)值，对应wp_users.ID。未注册的用户，即外部评论者，这个ID的值为0
     */
    @TableField("user_id")
    private Long userId;


    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentPostId() {
        return commentPostId;
    }

    public void setCommentPostId(Long commentPostId) {
        this.commentPostId = commentPostId;
    }

    public String getCommentAuthor() {
        return commentAuthor;
    }

    public void setCommentAuthor(String commentAuthor) {
        this.commentAuthor = commentAuthor;
    }

    public String getCommentAuthorEmail() {
        return commentAuthorEmail;
    }

    public void setCommentAuthorEmail(String commentAuthorEmail) {
        this.commentAuthorEmail = commentAuthorEmail;
    }

    public String getCommentAuthorUrl() {
        return commentAuthorUrl;
    }

    public void setCommentAuthorUrl(String commentAuthorUrl) {
        this.commentAuthorUrl = commentAuthorUrl;
    }

    public String getCommentAuthorIp() {
        return commentAuthorIp;
    }

    public void setCommentAuthorIp(String commentAuthorIp) {
        this.commentAuthorIp = commentAuthorIp;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Date getCommentDateGmt() {
        return commentDateGmt;
    }

    public void setCommentDateGmt(Date commentDateGmt) {
        this.commentDateGmt = commentDateGmt;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getCommentKarma() {
        return commentKarma;
    }

    public void setCommentKarma(Integer commentKarma) {
        this.commentKarma = commentKarma;
    }

    public String getCommentApproved() {
        return commentApproved;
    }

    public void setCommentApproved(String commentApproved) {
        this.commentApproved = commentApproved;
    }

    public String getCommentAgent() {
        return commentAgent;
    }

    public void setCommentAgent(String commentAgent) {
        this.commentAgent = commentAgent;
    }

    public String getCommentType() {
        return commentType;
    }

    public void setCommentType(String commentType) {
        this.commentType = commentType;
    }

    public Long getCommentParent() {
        return commentParent;
    }

    public void setCommentParent(Long commentParent) {
        this.commentParent = commentParent;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    protected Serializable pkVal() {
        return this.commentId;
    }

    @Override
    public String toString() {
        return "LtComments{" +
        "commentId=" + commentId +
        ", commentPostId=" + commentPostId +
        ", commentAuthor=" + commentAuthor +
        ", commentAuthorEmail=" + commentAuthorEmail +
        ", commentAuthorUrl=" + commentAuthorUrl +
        ", commentAuthorIp=" + commentAuthorIp +
        ", commentDate=" + commentDate +
        ", commentDateGmt=" + commentDateGmt +
        ", commentContent=" + commentContent +
        ", commentKarma=" + commentKarma +
        ", commentApproved=" + commentApproved +
        ", commentAgent=" + commentAgent +
        ", commentType=" + commentType +
        ", commentParent=" + commentParent +
        ", userId=" + userId +
        "}";
    }
}
