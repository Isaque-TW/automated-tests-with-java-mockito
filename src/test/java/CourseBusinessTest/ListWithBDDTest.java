package CourseBusinessTest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

public class ListWithBDDTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10() {

        // Given Arrange
        List <?> list = mock(List.class);
        given(list.size()).willReturn(10);

        assertThat(list.size(), is(10));
        assertThat(list.size(), is(10));
        assertThat(list.size(), is(10));
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValue() {

        // Given Arrange
        List <?> list = mock(List.class);
        given(list.size()).willReturn(10).willReturn(20);

        assertThat(list.size(), is(10));
        assertThat(list.size(), is(20));
        assertThat(list.size(), is(20));
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnErudio() {

        // Given Arrange
        var list = mock(List.class);
        given(list.get(0)).willReturn("Erudio");

        // When / Act & Then / Assert
        assertThat(list.get(0), is("Erudio"));
        assertNull(list.get(1));
    }

    @Test
    void testMockingList_When_ThrowsException() {

        // Given Arrange
        var list = mock(List.class);

        // If you are using argument, all arguments
        // have yo be provided by matchers.
        given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar!!"));

        // When / Act
        assertThrows(RuntimeException.class,
                () -> {
            // When / Act
            list.get(anyInt());},
                () -> "Should have throw an RuntimeException");
        }
    }

