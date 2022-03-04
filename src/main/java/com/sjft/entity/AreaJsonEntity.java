package com.sjft.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @date 2022-02-07 16:04:34
 */
@Data
@TableName("area_json")
public class AreaJsonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * 区域编号
	 */
	private String areaCode;
	/**
	 * 区域名称
	 */
	private String name;
	/**
	 * 父级编号
	 */
	private String parent;
	/**
	 * 区域json
	 */
	private String areaJson;

}
