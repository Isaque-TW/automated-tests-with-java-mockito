package CourseBusinessTest.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.LessThan;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class HamcrestMatchersTest {

    @Test
    void testHamcrestMatchers() {
        // Given
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);

        // When / Then
        assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(99, 100, 101));
        assertThat(scores, everyItem(greaterThan(98)));
        assertThat(scores, everyItem(lessThan(106)));

        // Check Strings
        assertThat("", is(emptyString()));
        assertThat(null, is(emptyOrNullString()));

        // Arrays
        Integer[] myArray = {1, 2, 3};
        assertThat(myArray, arrayWithSize(3));
        assertThat(myArray, arrayContaining(1, 2, 3)); // Verifica se tem um dos numeros
        assertThat(myArray, arrayContainingInAnyOrder(3, 2, 1)); // Verifica fora de ordem
    }
}
