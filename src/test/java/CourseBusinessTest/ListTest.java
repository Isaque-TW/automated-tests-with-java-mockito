package CourseBusinessTest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static javax.swing.UIManager.get;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
    void testMockingList_When_SizeIsCalledWithArgumentMatcher_ShouldReturnErudio() {

        // Given Arrange
        var list = mock(List.class);
        when(list.get(anyInt())).thenReturn("Erudio");

        assertEquals("Erudio", list.get(0));
        assertEquals("Erudio", list.get(anyInt()));

    }

}
