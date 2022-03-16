package com.sjft.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

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
     * 标题
     */
    private String title;

    private String echartsVersion;

    /**
     * 浏览量
     */
    private Integer viewCount;

    /**
     * 创建时间
     */
    private String createTime;


}
