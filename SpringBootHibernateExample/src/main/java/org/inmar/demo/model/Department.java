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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "depID", unique = true, nullable = false)
	private Integer depID;
	@Column(name = "department")
	private String department;

	@OneToMany(cascade = CascadeType.ALL) // , fetch=FetchType.EAGER)
	@JoinColumn(name = "DEP_ID")
	private List<Category> Category;

	public List<Category> getCategory() {
		return Category;
	}

	public void setCategory(List<Category> category) {
		Category = category;
	}

	public Integer getDepID() {
		return depID;
	}

	public void setDepID(Integer depID) {
		this.depID = depID;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
}
