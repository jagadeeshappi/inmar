package org.inmar.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Filter;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.inmar.demo.model.Department;
import org.inmar.demo.model.Subcategory;
import org.inmar.vo.Category;
import org.inmar.vo.Location;
import org.inmar.vo.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LocationDaoImpl implements LocationDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Location> getAllLocations() {
		Session session = this.sessionFactory.getCurrentSession();
		List list=new ArrayList<Location>();
		List<org.inmar.demo.model.Location>  customerList = session.createQuery("from Location").list();
		for(org.inmar.demo.model.Location loc:customerList)
		{org.inmar.vo.Location l=new org.inmar.vo.Location();
		l.setLocid(loc.getLocid());
		l.setLocation(loc.getLocation());
			list.add(l);
		}
	
		return list;
	}

	
	  @Override 
	  public List<org.inmar.vo.Department> getDepsLocationid(int location_id)
	  { Session	  session = this.sessionFactory.getCurrentSession(); 
	  String hql = "from Department where loc_id = :depid";
	  Query query =session.createQuery(hql); 
	  query.setInteger("depid",location_id);
	  List<Department> results = query.list();	  
	  List list=new ArrayList<org.inmar.vo.Department>();
	  for(Department dep:results)
	  {org.inmar.vo.Department d=new org.inmar.vo.Department();
	  d.setDepID(dep.getDepID());
	  d.setDepartment(dep.getDepartment());
		  list.add(d);
	  }
	  return list; 
	
	  }
	  @Override
		public List<Category> getCategory(int location_id, int depid) {
			// TODO Auto-generated method stub
		  Session	  session = this.sessionFactory.getCurrentSession();
		  Criteria   c=session.createCriteria(org.inmar.demo.model.Location.class).add(Restrictions.eq("locid", new Integer(location_id)));; 
		  List<org.inmar.demo.model.Location> li=c.list();
		  List<Category> catlist=new ArrayList<Category>();
		  for(org.inmar.demo.model.Location d:li)
			  {
			  List<Department> depp=new ArrayList<Department>();
			  List<Department>dep =d.getDepartments();
			  for(Department d1:dep) 
			  { if(d1.getDepID()==depid)
			    {for(org.inmar.demo.model.Category c1:d1.getCategory())
			    {Category cv=new Category();
			    cv.setCategory(c1.getCategory());
			    cv.setCatID(c1.getCatID());
				  catlist.add(cv);
			    }}
			  
			  } }
			return catlist;
		}
	  @Override
		public List<SubCategory> getSubCategory(int location_id, int depid, int catgeoryid) {
			// TODO Auto-generated method stub
		  Session	  session = this.sessionFactory.getCurrentSession();
		  Criteria   c=session.createCriteria(org.inmar.demo.model.Location.class).add(Restrictions.eq("locid", new Integer(location_id)));
		  List<org.inmar.demo.model.Location> li=c.list();
		  List<SubCategory> catlist=new ArrayList<SubCategory>();
		  for(org.inmar.demo.model.Location d:li)
		  {
			  List<Department>dep =d.getDepartments();
			  for(Department d1:dep) 
			  {
				  if(d1.getDepID()==depid)
				    {
					  for(org.inmar.demo.model.Category c1:d1.getCategory())
					  { if(c1.getCatID()==catgeoryid)
					  {
						  List<Subcategory> listsub=c1.getSubCategory();
						  for(Subcategory sub:listsub) 
						  {
							  SubCategory s=new SubCategory();
							  s.setSubcategory(sub.getSubcategory()); 
							  s.setSubCatID(sub.getSubCatID());
							  catlist.add(s);
						  }
						  }
					  }
							
					  }
				    }
				    }
			  
		  
		  return catlist;
		}
	 
	  @Override 
	  public Integer saveLocation(org.inmar.demo.model.Location loc) 
	  { // TODO Auto-generated
	   Session session = this.sessionFactory.getCurrentSession();
	   Integer x=(Integer)session.save(loc);
	   return x;
	  }
	  
	  @Override 
	  public Integer saveDepartment(org.inmar.demo.model.Location dep) { // TODO Auto-generated
	  Session session = this.sessionFactory.getCurrentSession();
	  Integer x=(Integer)session.save(dep);
	  return x;
	  
	  }
	  @Override 
	  public Integer saveCategory(org.inmar.demo.model.Location cat) { // TODO Auto-generated
		  Session session = this.sessionFactory.getCurrentSession();
		  Integer x=(Integer)session.save(cat);
		  return x;
		  
		  }

	@Override
	public Integer saveSubCategory(org.inmar.demo.model.Location subcat) {
		// TODO Auto-generated method stub
		 Session session = this.sessionFactory.getCurrentSession();
		  Integer x=(Integer)session.save(subcat);
		  return x;
	}

	@Override
	public void updateLocation(org.inmar.demo.model.Location loc) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(loc);
	}

	@Override
	public void updateDepartment(org.inmar.demo.model.Location dep) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		org.inmar.demo.model.Location ldb= session.get(org.inmar.demo.model.Location.class, new Integer(dep.getLocid()));
		ldb.setLocation(dep.getLocation());
	List<Department>	depldb=ldb.getDepartments();
	List<Department>	depz=new ArrayList<Department>();
	for(Department d:dep.getDepartments())
	{ 
		for(Department  d1:depldb)
		{ if(d.getDepID()==d1.getDepID())
		{
			d1.setDepartment(d.getDepartment());
			depz.add(d1);
		}
			
		}
		
	}
	ldb.setDepartments(depz);
		session.update(ldb);
		
	}

	@Override
	public void updateCategory(org.inmar.demo.model.Location locv) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		
		List<Department> listvo=locv.getDepartments();
		 for(org.inmar.demo.model.Department d:listvo)
		 {   session.beginTransaction();
			 Query q1= session.createQuery("update Department d set d.department=:cat where d.depID= :id");
			q1.setString("cat", d.getDepartment());
			q1.setInteger("id", d.getDepID());
			int x1=q1.executeUpdate();
			session.getTransaction().commit();
			 for(org.inmar.demo.model.Category c:d.getCategory())
			 {   session.beginTransaction();
			 System.out.println(c.getCategory());
				Query q= session.createQuery("update Category c set c.category=:cat where c.catID= :id");
				q.setString("cat", c.getCategory());
				q.setInteger("id", c.getCatID());
				int x=q.executeUpdate();
				session.getTransaction().commit();
			 }
		 }
		
	}

	@Override
	public void deleteLocation(int locid) {
		// TODO Auto-generated method stub
		 Session session = this.sessionFactory.getCurrentSession();
		 org.inmar.demo.model.Location l=new org.inmar.demo.model.Location();
		 l.setLocid(locid);
		 session.delete(l);
	}

	@Override
	public void deleteDepartment(int depid) {
		// TODO Auto-generated method stub
		 Session session = this.sessionFactory.getCurrentSession();
		 org.inmar.demo.model.Department dep=new org.inmar.demo.model.Department();
		 dep.setDepID(depid);
		 session.delete(dep);
	}

	@Override
	public void deleteCategory(int cat_id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		org.inmar.demo.model.Category cat=new org.inmar.demo.model.Category();
		cat.setCatID(cat_id);
		session.delete(cat);
		
	}

	@Override
	public void deletesubCategory(int subcat_id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Subcategory subcat=new Subcategory();
		subcat.setSubCatID(subcat_id);
		session.delete(subcat);
		
	}
	  
	 
}
