package com.jousp.model;

/**
 * 公司创始团队
 * 
 * @author apple
 * 
 */
public class MemberModel {
	private String name; // 创始人名字
	private String portrait; // 头像
	private String position; // 职位
	private String description; // 基本信息

	public MemberModel() {
		super();
	}

	public MemberModel(String name, String portrait, String position,
			String description) {
		super();
		this.name = name;
		this.portrait = portrait;
		this.position = position;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "MemberModel [name=" + name + ", portrait=" + portrait
				+ ", position=" + position + ", description=" + description
				+ "]";
	}

}
