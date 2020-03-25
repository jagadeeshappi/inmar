package org.inmar.demo.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name = "Category")
public class Category {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "catID", unique = true, nullable = false)
	private Integer catID;

	@Column(name = "category")
	private String category;
	@OneToMany(cascade = CascadeType.ALL) // , fetch=FetchType.EAGER)
	@JoinColumn(name = "CAT_ID")
	private List<Subcategory> subCategory;

	public List<Subcategory> getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(List<Subcategory> subCategory) {
		this.subCategory = subCategory;
	}

	public Integer getCatID() {
		return catID;
	}

	public void setCatID(Integer catID) {
		this.catID = catID;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
