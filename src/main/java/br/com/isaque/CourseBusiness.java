package br.com.isaque;

import br.com.isaque.service.CourseService;

import java.util.ArrayList;
import java.util.List;

// CourseBusiness = SUT - System (Method) Under Test
public class CourseBusiness {

    // CourseService is a Dependency
    private CourseService service;

    public CourseBusiness(CourseService service) {
        this.service = service;
    }

    public List<String> retriveCoursesRelatedToSpring(String student) {
        var filteredCourses = new ArrayList<String>();
        if ("Foo Bar".equals(student)) return filteredCourses;
        var allCourses = service.retrieveCourse(student);

        for (String course : allCourses) {
            if (course.contains("Spring")) {
                filteredCourses.add(course);
            }
        }

        return filteredCourses;
    }

    public void deleteCoursesNotRelatedToSpring(String student) {

        var allCourses = service.retrieveCourse(student);

        for (String course : allCourses) {
            if (!course.contains("Spring")) {
                service.deleteCourse(course);
            }
        }
    }
}
