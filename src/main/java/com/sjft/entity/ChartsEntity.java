package com.sjft.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Mr.Baiyy
 * @email
 * @date 2022-01-19 15:31:51
 */
@Data
@TableName("charts")
public class ChartsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId
    private String cid;
    /**
     * 版本
     */
    private Integer version;
    /**
     * 标题
     */
    private String title;
    /**
     *
     */
    private Integer auth;
    /**
     * 描述
     */
    private String description;
    /**
     * uid
     */
    private String uid;
    /**
     * 赞赏数
     */
    private Integer starCount;
    /**
     * 评论数
     */
    private Integer commentCount;
    /**
     * 浏览量
     */
    private Integer viewCount;
    /**
     *
     */
    private Integer rankScore;
    /**
     *
     */
    private String forkFrom;
    /**
     *
     */
    private Integer isSpam;
    /**
     * 封面图地址
     */
    @TableField(value = "thumbnail_url")
    private String thumbnailUrl;
    /**
     *
     */
    private Integer isCustomThumbnail;
    /**
     * 提交用户
     */
    private String userName;
    /**
     * 头像
     */
    private String avatar;
    /**
     *
     */
    private String isStared;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 最后更新时间
     */
    private String lastUpdateTime;

}
