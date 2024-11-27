package CourseBusinessTest;

import br.com.isaque.CourseBusiness;
import br.com.isaque.service.CourseService;
import br.com.isaque.service.stubs.CourseServiceStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CourseBusinessStubTest {

    @Test
    void testCoursesRelatedToSpring_When_UsingAStub() {

        // Given Arrange
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        // When / Act
        var filteredCourses =
                business.retriveCoursesRelatedToSpring("Leandro");

        // Then / Assert
        assertEquals(4, filteredCourses.size());

    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAFooBarStudent() {

        // Given Arrange
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        // When / Act
        var filteredCourses =
                business.retriveCoursesRelatedToSpring("Foo Bar");

        // Then / Assert
        assertEquals(0, filteredCourses.size());

    }
}
