package com.wt.pojo;

import lombok.*;

import java.util.Date;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Role {
	
	private Integer id;   //id
	private String roleCode; //角色编码
	private String roleName; //角色名称
	private Integer createdBy; //创建者
	private Date creationDate; //创建时间
	private Integer modifyBy; //更新者
	private Date modifyDate;//更新时间
	

}
