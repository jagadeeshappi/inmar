package com.inmat.test;

import org.inmar.demo.model.Category;
import org.inmar.demo.service.LocationService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)

public class SpringBootDemoApplicationTests {
	
	 @Autowired
	   private Category category;
	 @Test
	   public void whenUserIdIsProvided_thenRetrievedNameIsCorrect() {
		 Mockito.when(category.getCategory()).thenReturn("bb");
		 String testName = category.getCategory();
	      Assert.assertEquals("Mock Product Name", testName);
	
	 }
}
