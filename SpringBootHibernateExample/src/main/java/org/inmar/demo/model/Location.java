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
@Table(name = "Location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "locID", unique = true, nullable = false)
	private Integer locid;
	@Column(name = "location")
	private String location;
	@OneToMany(cascade = CascadeType.ALL) // , fetch=FetchType.EAGER)
	@JoinColumn(name = "LOC_ID")
	private List<Department> departments;

	public Integer getLocid() {
		return locid;
	}

	public void setLocid(Integer locid) {
		this.locid = locid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

}
