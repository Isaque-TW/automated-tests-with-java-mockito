package CourseBusinessTest;

import br.com.isaque.CourseBusiness;
import br.com.isaque.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CourseBusinessMockTest {

    CourseService mockService;
    CourseBusiness business;
    List<String> courses;

    @BeforeEach
    void setup() {
        // Given
        mockService = mock(CourseService.class);
        business = new CourseBusiness(mockService);

        courses = Arrays.asList("REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API'S RESTFul do O à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do O com ASP.NET, NET 6 e C#",
                "REST API's RESTFul do O à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );
    }
    @Test
    void testCoursesRelatedToSpring_When_UsingAMock() {

        when(mockService.retrieveCourse("Leandro"))
                .thenReturn(courses);

        // When / Act
        var filteredCourses =
                business.retriveCoursesRelatedToSpring("Leandro");

        // Then / Assert
        assertEquals(4, filteredCourses.size());

    }

}
