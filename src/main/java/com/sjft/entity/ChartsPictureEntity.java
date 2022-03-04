package com.sjft.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author Mr.Baiyy
 * @email 
 * @date 2022-01-20 08:56:16
 */
@Data
@TableName("charts_picture")
public class ChartsPictureEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * cid
	 */
	private String cid;
	/**
	 * 图片
	 */
	private String picture;
	/**
	 * 图片地址
	 */
	private String picturePath;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
