package org.inmar.demo.controller;


import java.util.List;

import org.inmar.demo.model.Department;
import org.inmar.demo.service.LocationService;
import org.inmar.vo.Category;
import org.inmar.vo.Location;
import org.inmar.vo.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inmar.exceptions.RecordNotFoundException;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	LocationService locationService;
	@RequestMapping(value = "/api/v1/location", method = RequestMethod.GET,headers = "Accept=application/json") 
	public List<Location> getLocations() {
		return locationService.getAllCustomers();
	}
	
	  @RequestMapping(value = "/api/v1/location/{location_id}/department", method =  RequestMethod.GET,headers = "Accept=application/json")
	  public List<org.inmar.vo.Department> getDepsLocationid(@PathVariable("location_id") int location_id) {
	  System.out.println(location_id);
	  return locationService.getDepsLocationid(location_id); }
	  //{"depID":3,"department":"Bakery"}
	  
	  @RequestMapping(value ="/api/v1/location/{location_id}/department/{department_id}/category", method= RequestMethod.GET,headers = "Accept=application/json") 
	  public  List<Category> getCategory(@PathVariable("location_id") int location_id,@PathVariable("department_id") int department_id) 
	  {
	  System.out.println(location_id); 
	  return locationService.getCategory(location_id,department_id);
	  }
	 
	  @RequestMapping(value = "/api/v1/location/{location_id}/department/{department_id}/category/{category_id}/subcategory", method = RequestMethod.GET,headers = "Accept=application/json")
	  public List<SubCategory> getSubCategory(@PathVariable("location_id") int location_id,@PathVariable("department_id") int  department_id,@PathVariable("category_id") int category_id) 
	  {
	  System.out.println(location_id); 
	  return locationService.getSubCategory(location_id,department_id,category_id );
	  }
	  
	
	  @PostMapping(path = "/saveLocation", consumes = "application/json", produces = "application/json")
	  public Integer saveLocation(@RequestBody org.inmar.demo.model.Location  location)
	  { 
	  System.out.println(location); 
	   return  locationService.saveLocation(location);
	  }
	  
	  @PostMapping(path = "/saveDepartment", consumes = "application/json", produces = "application/json")
	  public Integer saveDepartment(@RequestBody  org.inmar.demo.model.Location location)
	  { 
		  if(location.getLocation()==null||location.getLocation()=="")
		  {
			  throw new RecordNotFoundException("Location not found to insert department");
		  }
	  System.out.println("jag"+location); 
	  return locationService.saveDepartment(location);
	  }
	  @PostMapping(path = "/saveCategory", consumes = "application/json", produces = "application/json")
	  public Integer saveCategory(@RequestBody  org.inmar.demo.model.Location location)
	  {
	  System.out.println("jag"+location); 
	  if(location.getLocation()==null||location.getLocation()=="")
	  {
		  throw new RecordNotFoundException("Location not found to insert category");
	  }
	  else if(location.getDepartments().get(0).getDepartment()==null||location.getDepartments().get(0).getDepartment()=="")
	  {
		  throw new RecordNotFoundException("Department not found to insert category");
	  }
	  return locationService.saveCategory(location);
	  }
	  @PostMapping(path = "/saveSubCategory", consumes = "application/json", produces = "application/json")
	  public Integer saveSubCategory(@RequestBody  org.inmar.demo.model.Location location)
	  { 
	  System.out.println("jag"+location); 
	  if(location.getLocation()==null||location.getLocation()=="")
	  {
		  throw new RecordNotFoundException("Location not found to insert category");
	  }
	  else if(location.getDepartments().get(0).getDepartment()==null||location.getDepartments().get(0).getDepartment()=="")
	  {
		  throw new RecordNotFoundException("Department not found to insert category");
	  }
	  else if(location.getDepartments().get(0).getCategory().get(0).getCategory() ==null||location.getDepartments().get(0).getCategory().get(0).getCategory()=="")
	  {
		  throw new RecordNotFoundException("Category not found to insert subcategory");
	  }
	  return locationService.saveCategory(location);
	  }
	  @PutMapping( path = "/updateLocation",produces = MediaType.APPLICATION_JSON_VALUE)
	  public void updateLocation(@RequestBody  org.inmar.demo.model.Location location)
	  {   if(location.getLocid()==0 ||location.getLocid()==null)
	    {
		  throw new RecordNotFoundException("Location id mandatory to update ");
	    }
	  locationService.updateLocation(location);
		  System.out.println(location);
	  }
	  @PutMapping( path = "/updateDepartment",produces = MediaType.APPLICATION_JSON_VALUE)
	  public void updateDepartment(@RequestBody  org.inmar.demo.model.Location location)
	  {   if(location.getLocid()==0 ||location.getLocid()==null)
	    {
		  throw new RecordNotFoundException("Location id mandatory to update ");
	    }
	  else 
	  { List<Department> dl=location.getDepartments();
	    for(Department d:dl)
	    {
	    	if(d.getDepID()==null)
	    	{
	    		throw new RecordNotFoundException("Department id mandatory to update ");
	    	}
	    }
		  
	  }
	  locationService.updateDepartment(location);
		  System.out.println(location);
	  }
	  @PutMapping( path = "/updateCategory",produces = MediaType.APPLICATION_JSON_VALUE)
	  public void updateCategory(@RequestBody  org.inmar.demo.model.Location location)
	  {   if(location.getLocid()==0 ||location.getLocid()==null)
	    {
		  throw new RecordNotFoundException("Location id mandatory to update ");
	    }
	  else 
	  { List<Department> dl=location.getDepartments();
	    for(Department d:dl)
	    {
	    	if(d.getDepID()==null)
	    	{
	    		throw new RecordNotFoundException("Department id mandatory to update ");
	    	}
	    	else 
	    	{
	    		for(org.inmar.demo.model.Category cat:d.getCategory())
	    		{
	    			if(cat.getCatID()==null)
	    			{
	    				throw new RecordNotFoundException("Category id mandatory to update ");
	    	    	}
	    			}
	    		}
	    	}
	    }
	  
	  locationService.updateCategory(location);
		  System.out.println(location);
	  }
	  
		@DeleteMapping(value = "/deletelocation/{location_id}")
		public void deleteLocation(@PathVariable("location_id") int location_id) {
			locationService.deleteLocation(location_id);
		}

		@DeleteMapping(value = "/deletedepartment/{dep_id}")
		public void deleteDepartment(@PathVariable("dep_id") int dep_id) {
			locationService.deleteDepartment(dep_id);
		}

		@DeleteMapping(value = "/deletecategory/{cat_id}")
		public void deleteCategory(@PathVariable("cat_id") int cat_id) {
			locationService.deleteCategory(cat_id);
		}

		@DeleteMapping(value = "/deletesubcategory/{subcat_id}")
		public void deletesubCategory(@PathVariable("subcat_id") int subcat_id) {
			locationService.deletesubCategory(subcat_id);
		}
}
