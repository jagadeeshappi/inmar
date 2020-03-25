package org.inmar.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "SubCategory")
public class Subcategory {
	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "subCatID", unique = true, nullable = false)
	private Integer subCatID;
	@Column(name = "subcategory")
	private String subcategory;

	public Integer getSubCatID() {
		return subCatID;
	}

	public void setSubCatID(Integer subCatID) {
		this.subCatID = subCatID;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
}
