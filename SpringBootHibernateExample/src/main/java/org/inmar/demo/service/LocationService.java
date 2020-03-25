package org.inmar.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.inmar.demo.dao.LocationDao;
import org.inmar.demo.model.Department;
import org.inmar.vo.Category;
import org.inmar.vo.Location;
import org.inmar.vo.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class LocationService {

	@Autowired
	LocationDao customerDao;

	@Transactional
	public List<Location> getAllCustomers() {
		return customerDao.getAllLocations();
	}

	@Transactional
	public List<org.inmar.vo.Department> getDepsLocationid(int location_id) {
		return customerDao.getDepsLocationid(location_id);
	}

	@Transactional
	public List<Category> getCategory(int location_id, int depid) {
		return customerDao.getCategory(location_id, depid);
	}

	@Transactional
	public List<SubCategory> getSubCategory(int location_id, int depid, int category_id) {
		return customerDao.getSubCategory(location_id, depid, category_id);
	}

	@Transactional
	public Integer saveLocation(org.inmar.demo.model.Location loc) {
		return customerDao.saveLocation(loc);
	}

	@Transactional
	public Integer saveDepartment(org.inmar.demo.model.Location loc) {
		return customerDao.saveDepartment(loc);
	}

	@Transactional
	public Integer saveCategory(org.inmar.demo.model.Location loc) {
		return customerDao.saveCategory(loc);
	}

	@Transactional
	public Integer saveSubCategory(org.inmar.demo.model.Location loc) {
		return customerDao.saveSubCategory(loc);
	}

	@Transactional
	public void updateLocation(org.inmar.demo.model.Location loc) {
		customerDao.updateLocation(loc);
	}

	@Transactional
	public void updateDepartment(org.inmar.demo.model.Location loc) {
		customerDao.updateDepartment(loc);
	}

	@Transactional
	public void updateCategory(org.inmar.demo.model.Location loc) {
		customerDao.updateCategory(loc);
	}

	@Transactional
	public void deleteLocation(int location_id) {
		customerDao.deleteLocation(location_id);
	}

	@Transactional
	public void deleteDepartment(int depid) {
		customerDao.deleteDepartment(depid);
	}

	@Transactional
	public void deleteCategory(int depid) {
		customerDao.deleteCategory(depid);
	}

	@Transactional
	public void deletesubCategory(int depid) {
		customerDao.deletesubCategory(depid);
	}

}
