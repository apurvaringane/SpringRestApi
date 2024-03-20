package org.jspiders.SpringRestApi.service;

import org.jspiders.SpringRestApi.model.Course;
import org.jspiders.SpringRestApi.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CourseService {
    private List<Course> courseList=new ArrayList<>();
    {
        courseList.add(new Course(1,"DEVELOPMENT",34500.500,"JAVA","CHETAN","JHACODA1",50,false));
        courseList.add(new Course(2,"TESTING",32000.50,"MANUL","ANVESH","JHAMADA3",40,true));
        courseList.add(new Course(3,"DEVELOPMENT",33000.00,"SQL","VIVEK","JHASQDA1",30,true));
        courseList.add(new Course(4,"DEVELOPMENT",34500.500,"SPRING","CHETAN","JSPA1",30,false));

    }
    //GET ALL COURSES
    public List<Course> getCourseList(){
        return courseList;
    }

    //GET COURSE BY ID
    public Course getCourseById(int id){
        for (Course c:courseList){
            if (c.getCourseId()==id){
                return c;
            }
        }
        return null;
    }
    //get course by name
    public Course getCourseByName(String courseName){
        for (Course c:courseList){
            if (c.getCourseName().equals(courseName)){
                return c;
            }
        }
        return null;
    }

    //add new course
    public void addNewCourse(Course c){
        courseList.add(c);
    }

    //delete course by batch code
    public String deleteCourse(String batchCode) {
        Iterator<Course> itr=courseList.iterator();
        while (itr.hasNext()){
            if (itr.next().getBatchCode()==batchCode){
                itr.remove();
            }
        }
        return null;
    }

    //get course by subject & batchcode
    public Course getCourseBySubjectAndBatchCode(String subjectName,String batchCode){
        for (Course c:courseList){
            if (c.getSubjectName().equals(subjectName) && c.getBatchCode().equals(batchCode)){
                return c;
            }
        }
        return null;
    }

    //GET ALL THE SUBJECTS ALLOCATED TO SPECIFIC FACULTY
    //GET BATCH CODE WISE TOTAL COUNT OF STUDENTS
    //GET COURSES WHICH ARE COMPLETED

    public boolean getCompletedCourses(){
        for (Course c:courseList){
            if (c.isCompleted()==true){
                return true;
            }
        }
        return false;
    }

    //GET ALL THE SUBJECTS ALLOCATED TO SPECIFIC FACULTY
    public List<String> getSubjectOfSpecificFaculty(String faculty){
        List<String> filterByFaculty=new ArrayList<>();
        for (Course c:courseList){
            if (c.getFacultyName().equalsIgnoreCase(faculty)){
                filterByFaculty.add(c.getSubjectName());
            }
        }
        return filterByFaculty;
    }

    //GET BATCH CODE WISE TOTAL NUMBER OF STUDENTS.
    public Map<String,Integer> getBatchCodeWiseTotalCount(String bacthCode,int toatlStudent){
        Map<String,Integer> filterByTotalCount=new HashMap<>();
        for (Course c:courseList){
            if (c.getBatchCode().equalsIgnoreCase(bacthCode))
            {
                filterByTotalCount.put(bacthCode,c.getTotalStudents());
            }
        }
        return filterByTotalCount;
    }

    //GET COURSES WHICH ARE COMPLETED


}
