package com.sjft.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import org.omg.CORBA.IDLType;

/**
 * 
 * 
 * @author Mr.Baiyy
 * @email 
 * @date 2022-01-26 15:03:59
 */
@Data
@TableName("area_code")
public class AreaCodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId(type = IdType.AUTO)
	private Integer id;
	/**
	 * 
	 */
	private Integer adcode;
	/**
	 * 
	 */
	private String level;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private Double lat;
	/**
	 * 
	 */
	private Double lng;
	/**
	 * 
	 */
	private Integer parent;

}
