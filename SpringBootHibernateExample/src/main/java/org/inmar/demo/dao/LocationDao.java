package org.inmar.demo.dao;

import java.util.List;

import org.inmar.demo.model.Department;
import org.inmar.vo.Category;
import org.inmar.vo.Location;
import org.inmar.vo.SubCategory;

public interface LocationDao {
	public List<Location> getAllLocations() ;	
	public List<org.inmar.vo.Department> getDepsLocationid(int location_id); 
	public List<Category> getCategory(int location_id,int depid);
	public List<SubCategory> getSubCategory(int location_id,int depid,int catgeoryid);
	public Integer  saveLocation(org.inmar.demo.model.Location loc);
	public Integer saveDepartment(org.inmar.demo.model.Location dep);
	public Integer saveCategory(org.inmar.demo.model.Location dep);
	public Integer saveSubCategory(org.inmar.demo.model.Location dep);
	public void updateLocation(org.inmar.demo.model.Location dep);
	public void updateDepartment(org.inmar.demo.model.Location dep); 
	public void updateCategory(org.inmar.demo.model.Location dep);
	public void deleteLocation(int locid);
	public void deleteDepartment(int depid);
	public void deleteCategory(int cat_id);
	public void deletesubCategory(int subcat_id);
	
	
}
