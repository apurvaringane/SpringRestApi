package org.jspiders.SpringRestApi.service;

import org.jspiders.SpringRestApi.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
  private List<Employee>  employees=new ArrayList<>();
    {
        employees.add(new Employee(101,"AYUSH","TESTER",30000.50));
        employees.add(new Employee(102,"AMEY","DEVELOPER",35000.50));
        employees.add(new Employee(103,"ARUN","TESTER",32000.50));
    }

    public List<Employee> getEmployees(){
        return employees;
    }
    public Employee getEmployeeById(int id){
        for (Employee e:employees){
            if (e.getEmpId()==id){
                return e;
            }
        }
        return null;
    }
    //service to add new emp
    public void addEmployee(Employee e){
        employees.add(e);
    }
    public Employee updateEmployee(int id, Employee e){

       for (int a=0;a<employees.size();a++){
           Employee emp=employees.get(a);

            if (e.getEmpId()==id) {
                employees.set(a, e);
            }
        }
        return e;
    }
    public String deleteEmployee(int id){
        Iterator<Employee> itr=employees.iterator();
        while (itr.hasNext()){
            if (itr.next().getEmpId()==id){
                itr.remove();
            }
        }
        return null;
    }

    public Employee displayEmployee(String desg){
        for (Employee e:employees){
            if (e.getEmpDesg().equals(desg)){
                return e;
            }
        }
        return null;
    }
    public String updateEmployeeFields(Map<String, Object> patchData, int id) {
        Employee e=employees.stream().filter(employee -> id==employee.getEmpId()).findAny().orElse(null);
            if (patchData.containsKey("empSal") && patchData.containsKey("empDesg")){
                assert employees!=null;
                e.setEmpDesg((String) patchData.get("empDesg"));
                e.setEmpSal((Double) patchData.get("empSal"));
            }
        return null;
    }
}
