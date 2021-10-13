package com.example.Spring_JPA_Hibernate_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    employeeRepo emprepo;

    @GetMapping(path="Employee/findAll")
    public List<Employee> getEmployee(){
        Iterable<Employee> list= emprepo.findAll();
        return (List<Employee>) list;
    }

    @GetMapping(path="Employee/findById/{id}")
    public Optional<Employee> getEmployee(@PathVariable int id){
        Optional<Employee> emp= emprepo.findById(id);
        return emp;
    }

    @PostMapping(path="Employee/addEmployee")
    public void createEmployee(@RequestBody Employee emp){
        emprepo.save(emp);
    }

    @PostMapping(path ="Employee/updateEmployeeById/{id}")
    public void updateEmployee(@PathVariable int id,@RequestBody Employee uEmp ){
       Employee emp= emprepo.findById(id).get();
       emp.setName(uEmp.getName());
        emp.setAge(uEmp.getAge());
        emp.setLocation(uEmp.getLocation());
        emprepo.save(emp);
    }

    @DeleteMapping(path="Employee/deleteEmployeeById/{id}")
    public void deleteEmployee(@PathVariable int id){
        emprepo.deleteById(id);
    }

    @GetMapping(path = "Employee/count")
    public String countEmployee(){
        String str="*******************************";
        return str+"\n"+"Count of Employee: "+emprepo.count()+"\n"+str;
    }

     @GetMapping(path = "Employee/findByName/{Name}")
       public List<Employee> findByName(@PathVariable String Name){
         List<Employee> l= (List<Employee>) emprepo.findByName(Name);
       return  l;
   }

    @GetMapping(path = "Employee/findByNameStartsWith/{Char}")
    public List<Employee> findByNameStartsWith(@PathVariable String Char){
        List<Employee> l= (List<Employee>) emprepo.findByNameStartsWith(Char);
        return  l;
    }

    @GetMapping(path="Employee/findByAge")
    public List<Employee> findByAgebetween(@RequestHeader int min, int max){
        List<Employee> l= (List<Employee>) emprepo.findByAgeBetween(min,max);
        return  l;
    }




}
