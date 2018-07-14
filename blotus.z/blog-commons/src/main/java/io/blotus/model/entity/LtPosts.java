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
@TableName("lt_posts")
public class LtPosts extends Model<LtPosts> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;
    @TableField("post_author")
    private Long postAuthor;
    @TableField("post_date")
    private Date postDate;
    @TableField("post_date_gmt")
    private Date postDateGmt;
    @TableField("post_content")
    private String postContent;
    @TableField("post_title")
    private String postTitle;
    @TableField("post_excerpt")
    private String postExcerpt;
    @TableField("post_status")
    private String postStatus;
    @TableField("comment_status")
    private String commentStatus;
    @TableField("ping_status")
    private String pingStatus;
    @TableField("post_password")
    private String postPassword;
    @TableField("post_name")
    private String postName;
    @TableField("to_ping")
    private String toPing;
    private String pinged;
    @TableField("post_modified")
    private Date postModified;
    @TableField("post_modified_gmt")
    private Date postModifiedGmt;
    @TableField("post_content_filtered")
    private String postContentFiltered;
    @TableField("post_parent")
    private Long postParent;
    private String guid;
    @TableField("menu_order")
    private Integer menuOrder;
    @TableField("post_type")
    private String postType;
    @TableField("post_mime_type")
    private String postMimeType;
    @TableField("comment_count")
    private Long commentCount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPostAuthor() {
        return postAuthor;
    }

    public void setPostAuthor(Long postAuthor) {
        this.postAuthor = postAuthor;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getPostDateGmt() {
        return postDateGmt;
    }

    public void setPostDateGmt(Date postDateGmt) {
        this.postDateGmt = postDateGmt;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostExcerpt() {
        return postExcerpt;
    }

    public void setPostExcerpt(String postExcerpt) {
        this.postExcerpt = postExcerpt;
    }

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getPingStatus() {
        return pingStatus;
    }

    public void setPingStatus(String pingStatus) {
        this.pingStatus = pingStatus;
    }

    public String getPostPassword() {
        return postPassword;
    }

    public void setPostPassword(String postPassword) {
        this.postPassword = postPassword;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getToPing() {
        return toPing;
    }

    public void setToPing(String toPing) {
        this.toPing = toPing;
    }

    public String getPinged() {
        return pinged;
    }

    public void setPinged(String pinged) {
        this.pinged = pinged;
    }

    public Date getPostModified() {
        return postModified;
    }

    public void setPostModified(Date postModified) {
        this.postModified = postModified;
    }

    public Date getPostModifiedGmt() {
        return postModifiedGmt;
    }

    public void setPostModifiedGmt(Date postModifiedGmt) {
        this.postModifiedGmt = postModifiedGmt;
    }

    public String getPostContentFiltered() {
        return postContentFiltered;
    }

    public void setPostContentFiltered(String postContentFiltered) {
        this.postContentFiltered = postContentFiltered;
    }

    public Long getPostParent() {
        return postParent;
    }

    public void setPostParent(Long postParent) {
        this.postParent = postParent;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public Integer getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(Integer menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getPostType() {
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public String getPostMimeType() {
        return postMimeType;
    }

    public void setPostMimeType(String postMimeType) {
        this.postMimeType = postMimeType;
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "LtPosts{" +
        "id=" + id +
        ", postAuthor=" + postAuthor +
        ", postDate=" + postDate +
        ", postDateGmt=" + postDateGmt +
        ", postContent=" + postContent +
        ", postTitle=" + postTitle +
        ", postExcerpt=" + postExcerpt +
        ", postStatus=" + postStatus +
        ", commentStatus=" + commentStatus +
        ", pingStatus=" + pingStatus +
        ", postPassword=" + postPassword +
        ", postName=" + postName +
        ", toPing=" + toPing +
        ", pinged=" + pinged +
        ", postModified=" + postModified +
        ", postModifiedGmt=" + postModifiedGmt +
        ", postContentFiltered=" + postContentFiltered +
        ", postParent=" + postParent +
        ", guid=" + guid +
        ", menuOrder=" + menuOrder +
        ", postType=" + postType +
        ", postMimeType=" + postMimeType +
        ", commentCount=" + commentCount +
        "}";
    }
}
