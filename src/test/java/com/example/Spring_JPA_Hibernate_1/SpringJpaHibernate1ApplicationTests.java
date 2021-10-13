package com.example.Spring_JPA_Hibernate_1;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringJpaHibernate1ApplicationTests {
	@Autowired
    employeeRepo emprepo;
	@Ignore
	@Test
	void contextLoads() {
	}
	@Ignore
	@Test
	void createRow(){
	Employee emp =new Employee();
	emp.setId(125);
	emp.setName("akash");
	emp.setAge(21);
	emp.setLocation("greater noida");
	emprepo.save(emp);
	}
	@Ignore
    @Test
	void readRowbyId(){
	Employee emp=emprepo.findById(123).get();
		assertNotNull(emp);
		assertEquals("akash",emp.getName());
		System.out.println("************************");
		System.out.println(emp.getName()+" "+emp.getLocation());
		System.out.println("************************");
	}
	@Ignore
	@Test
	void updateRowbyID(){
		Employee emp = emprepo.findById(123).get();
		emp.setName("Bhavya");
		emprepo.save(emp);
	}
	@Ignore
	@Test
	void deletebyID(){
		emprepo.deleteById(123);
	}
	@Ignore
	@Test
	void countRows(){
		System.out.println("************************");
		System.out.println("Total count of rows: "+emprepo.count());
		System.out.println("************************");
	}
    @Ignore
	@Test
	void findbyname(){
		List<Employee> l= (List<Employee>) emprepo.findByName("akash");
		for (Employee i:l
			 ) {
			System.out.println(l);

		}
	}
	@Ignore
	@Test
	void findbyAge(){
		List<Employee> l= (List<Employee>) emprepo.findByAgeBetween(20,21);
		for (Employee i:l
		) {
			System.out.println(l);

		}
	}


}
