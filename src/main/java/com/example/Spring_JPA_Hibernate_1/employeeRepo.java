package com.example.Spring_JPA_Hibernate_1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface employeeRepo extends JpaRepository<Employee,Integer> {
   // @Query("select e from Employee e where e.name = ?1")
    Iterable<Employee> findByName(String name);

    Iterable<Employee> findByNameStartsWith(String Char);

    Iterable<Employee> findByAgeBetween(int min,int max);


}
