package CourseBusinessTest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static javax.swing.UIManager.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10() {

        // Given Arrange
        List <?> list = mock(List.class);
        when(list.size()).thenReturn(10);
        assertEquals(10, list.size());
        assertEquals(10, list.size());
        assertEquals(10, list.size());
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValue() {

        // Given Arrange
        List <?> list = mock(List.class);
        when(list.size()).thenReturn(10).thenReturn(20);
        assertEquals(10, list.size());
        assertEquals(20, list.size());
        assertEquals(20, list.size());
    }

    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnErudio() {

        // Given Arrange
        var list = mock(List.class);
        when(list.get(0)).thenReturn("Erudio");

        // When / Act & Then / Assert
        assertEquals("Erudio", list.get(0));
        assertNull(list.get(1));
    }

    @Test
    void testMockingList_When_ThrowsException() {

        // Given Arrange
        var list = mock(List.class);

        // If you are using argument, all arguments
        // have yo be provided by matchers.
        when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar!!"));

        // When / Act
        assertThrows(RuntimeException.class,
                () -> {
            // When / Act
            list.get(anyInt());},
                () -> "Should have throw an RuntimeException");
        }
    }

