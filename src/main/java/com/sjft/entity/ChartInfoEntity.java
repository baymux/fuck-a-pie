package com.sjft.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author Mr.Baiyy
 * @email 
 * @date 2022-01-19 15:31:51
 */
@Data
@TableName("chart_info")
public class ChartInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private String cid;
	/**
	 * 
	 */
	private Integer alwaysLatest;
	/**
	 * 
	 */
	private Integer auth;
	/**
	 * 
	 */
	private String authorUid;
	/**
	 * 
	 */
	private String authorUserName;
	/**
	 * 内置标签
	 */
	private String builtinTags;
	/**
	 * 代码
	 */
	private String code;
	/**
	 * 
	 */
	private String customTags;
	/**
	 * 
	 */
	private String description;
	/**
	 * 
	 */
	private String echartsVersion;
	/**
	 * 
	 */
	private String externalScripts;
	/**
	 * 
	 */
	private String forkFrom;
	/**
	 * 
	 */
	private String html;
	/**
	 * 
	 */
	private Integer commentCount;
	/**
	 * 
	 */
	private Date createTime;
	/**
	 * 
	 */
	private Integer isCustomThumbnail;
	/**
	 * 
	 */
	private Integer isSpam;
	/**
	 * 
	 */
	private Integer isStared;
	/**
	 * 
	 */
	private Date lastUpdateTime;
	/**
	 * 
	 */
	private Integer latestVersion;
	/**
	 * 
	 */
	private String layout;
	/**
	 * 
	 */
	private Integer parentVersion;
	/**
	 * 
	 */
	private Integer publishedVersion;
	/**
	 * 
	 */
	private Integer starCount;
	/**
	 * 
	 */
	private String theme;
	/**
	 * 
	 */
	private String thumbnailUrl;
	/**
	 * 
	 */
	private String title;
	/**
	 * 
	 */
	private String uid;
	/**
	 * 
	 */
	private String updaterUid;
	/**
	 * 
	 */
	private String updaterUserName;
	/**
	 * 
	 */
	private String userName;
	/**
	 * 
	 */
	private Integer version;
	/**
	 * 
	 */
	private Date versionCreateTime;
	/**
	 * 
	 */
	private Integer viewCount;

}
