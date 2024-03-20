package org.jspiders.SpringRestApi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Course {
    private int courseId;
    private String courseName;
    private double courseFees;
    private String subjectName;
    private String facultyName;
    private String batchCode;
    private int totalStudents;
    private boolean isCompleted;
}
