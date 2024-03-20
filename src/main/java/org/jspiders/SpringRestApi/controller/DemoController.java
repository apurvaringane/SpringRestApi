package org.jspiders.SpringRestApi.controller;

import org.jspiders.SpringRestApi.model.Employee;
import org.jspiders.SpringRestApi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employeecontroller")
public class DemoController {
    List<String> subjects=new ArrayList<>();
    {
        subjects.add("J2EE");
        subjects.add("Spring");
        subjects.add("JAVA");
    }
    @GetMapping("/")
    public String getWelcome(){
        return "welcome";
    }
    @GetMapping("/subjects")
    public String getSubjects(){
        return "/subjects";
    }

    @Autowired
    private EmployeeService service;
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return service.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable(value = "id") int empID){
        return service.getEmployeeById(empID);
    }

    @PostMapping("employees")
    public void addEmployee(@RequestBody Employee e){
        service.addEmployee(e);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") int id,Employee e){
        //return updateEmployee(e,id);
        return service.updateEmployee(id, e);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id){
         return service.deleteEmployee(id);
    }

    @GetMapping("/employees/{desg}")
    public Employee getEmployeeByDesg(@PathVariable(value = "desg") String desg){
        return service.displayEmployee(desg);
    }

    @PatchMapping("/employees/{id}")
    public String updateEmployeeFields(@PathVariable int id,@RequestBody Map<String,Object> patchData){
        return service.updateEmployeeFields(patchData,id);
    }
}
