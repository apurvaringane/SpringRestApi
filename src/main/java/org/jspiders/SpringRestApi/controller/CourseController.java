package org.jspiders.SpringRestApi.controller;

import org.jspiders.SpringRestApi.model.Course;
import org.jspiders.SpringRestApi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/coursecontroller")
public class CourseController {
    @Autowired
    private CourseService service;
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return service.getCourseList();
    }

    @GetMapping("/course{id}")
    public Course getCourse(@PathVariable(value = "id") int id){
        return service.getCourseById(id);
    }

    @GetMapping("/course/{courseName}")
    public Course getCourseByName(@PathVariable(value = "courseName") String courseName){
        return service.getCourseByName(courseName);
    }

    @PostMapping("/courses")
    public void addNewCourse(@RequestBody Course c){
        service.addNewCourse(c);
    }

    @DeleteMapping("/course/{batchCode}")
    public String deleteCourse(@PathVariable(value = "batchCode") String batchCode){
        return service.deleteCourse(batchCode);
    }

    @GetMapping("/course/{subjetName}/{batchCode}")
    public Course getCourseBySubjecNameAndBatchCode(@PathVariable(value = "subjectName") String subjectName,@PathVariable(value = "batchCode") String bacthCode){
        return service.getCourseBySubjectAndBatchCode(subjectName,bacthCode);
    }

    @GetMapping("/faculty/{faculty}")
    public List<String> getSubjectsOfSpecificFaculty(@PathVariable String faculty) {
        return service.getSubjectOfSpecificFaculty(faculty);
    }

//    @GetMapping("/count/{titalcount}")
//    public Map<String, Integer> getBatchCodeWiseTotalCount(@PathVariable String batchCode, @PathVariable int totalStudent)
//    {
//        return services.getBatchCodeWiseTotalCount(batchCode,totalStudent);
//    }

    @GetMapping("/count/{totalCount}")
    public Map<String,Integer> getBatchCodeWiseTotalCount(@PathVariable String batchCode,@PathVariable int totalStudent)
    {
        return service.getBatchCodeWiseTotalCount(batchCode,totalStudent);
    }

}
