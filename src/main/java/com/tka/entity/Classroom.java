package com.tka.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Classroom {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int clsId;
	String clsName;
	String clsCapacity;
	String clsLocation;

	public Classroom(String clsName, String clsCapacity, String clsLocation) {
		super();
		this.clsName = clsName;
		this.clsCapacity = clsCapacity;
		this.clsLocation = clsLocation;
	}

	public Classroom() {
		super();
	}

	public Classroom(String clsName) {
		super();
		this.clsName = clsName;
	}

	public Classroom(int clsId, String clsName) {
		super();
		this.clsId = clsId;
		this.clsName = clsName;
	}

	public int getClsId() {
		return clsId;
	}

	public void setClsId(int clsId) {
		this.clsId = clsId;
	}

	public String getClsName() {
		return clsName;
	}

	public void setClsName(String clsName) {
		this.clsName = clsName;
	}

	public String getClsCapacity() {
		return clsCapacity;
	}

	public void setClsCapacity(String clsCapacity) {
		this.clsCapacity = clsCapacity;
	}

	public String getClsLocation() {
		return clsLocation;
	}

	public void setClsLocation(String clsLocation) {
		this.clsLocation = clsLocation;
	}

	@Override
	public String toString() {
		return "Classroom [clsId=" + clsId + ", clsName=" + clsName + ", clsCapacity=" + clsCapacity + ", clsLocation="
				+ clsLocation + "]";
	}
}
