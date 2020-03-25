package org.inmar.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//https://www.youtube.com/watch?v=hF-iMHpl970
@SpringBootApplication
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
public class SpringBootHibernateApplication extends SpringBootServletInitializer{

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBootHibernateApplication.class, args);   
	}
	
	  @Override protected SpringApplicationBuilder
	  configure(SpringApplicationBuilder application) { return
	  application.sources(SpringBootHibernateApplication.class); }
	 
}
//https://stackoverflow.com/questions/26658031/how-to-fetch-child-table-specific-data-when-we-are-selected-parent-table/26659196
//https://java2blog.com/spring-boot-hibernate-example/
//https://www.javaguides.net/2018/09/spring-boot-2-hibernate-5-mysql-crud-rest-api-tutorial.html
//  http://localhost:8080/api/v1/location
// http://localhost:8080/api/v1/location/{location_id}/department
// http://localhost:8080/api/v1/location/{location_id}/department/{department_id}/category
// http://localhost:8080/insertdept
// http://localhost:8080/savelocation
// http://localhost:8080/savecategory
//http://localhost:8080/deletelocation/1