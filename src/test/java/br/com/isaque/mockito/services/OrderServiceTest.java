package br.com.isaque.mockito.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class OrderServiceTest {

    private final OrderService service = new OrderService();
    private final UUID defaultUuid = UUID.fromString("8d8b30e3-de52-4f1c-a71c-9905a8043dac");
    private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2025, 1, 15, 14, 10);

    @DisplayName("Should Include Random OrderId When no OrderId Exists")
    @Test
    void shouldIncludeRandomOrderIdWhenNoParentOrderExists() {

        try (MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

            // When / Act
            Order result = service.createOrder("MacBook Pro", 2L, null);

            assertEquals("8d8b30e3-de52-4f1c-a71c-9905a8043dac", result.getId());
        }
    }

    @DisplayName("Should Include Current Time When Creating a New Order")
    @Test
    void shouldIncludeCurrentTime_When_CreatingANewOrder() {
        try (MockedStatic<LocalDateTime> mockedUuid = mockStatic(LocalDateTime.class)) {
            mockedUuid.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

            Order result = service.createOrder("MacBook Pro", 2L, "42");

            // Then Assert
            assertEquals(defaultLocalDateTime, result.getCreationDate());
        }
    }
}
