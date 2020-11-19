package ru.geekbrains;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for Functions.
 */
public class FunctionsTest
{
    private static final Logger logger = LoggerFactory.getLogger(FunctionsTest.class);

    @BeforeEach
    void setUp() {
        logger.info("Start test");
    }

    @DisplayName("Проверка на нулевое значение стороны")
    @ParameterizedTest
    @MethodSource("localParameters_Zero")
    void isValidSide_Zero_Test(int a, int b, int c)
    {
        assertFalse(Functions.isValidSide(a, b, c));
    }

    static Stream<Arguments> localParameters_Zero() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(0, 2, 3),
                Arguments.of(5, 0, 8),
                Arguments.of(5, 3, 0)
        );
    }

    @DisplayName("Положительная проверка на сумму сторон")
    @ParameterizedTest
    @MethodSource("localParameters_Sum_Side_Positive")
    public void isValidSide_Sum_Side_Positive_Test(int a, int b, int c)
    {
        assertTrue(Functions.isValidSide(a, b, c));
    }

    static Stream<Arguments> localParameters_Sum_Side_Positive() {
        return Stream.of(
                Arguments.of(3, 3, 3),
                Arguments.of(5, 4, 8)
        );
    }

    @DisplayName("Отрицательная проверка на сумму сторон")
    @ParameterizedTest
    @MethodSource("localParameters_Sum_Side_Negative")
    public void isValidSide_Sum_Side_Negative_Test(int a, int b, int c)
    {
        assertFalse(Functions.isValidSide(a, b, c));
    }

    static Stream<Arguments> localParameters_Sum_Side_Negative() {
        return Stream.of(
                Arguments.of(4, 8, 4),
                Arguments.of(4, 4, 8),
                Arguments.of(8, 4, 4)
        );
    }

    @DisplayName("Проверка метода вычисления площади треугольника")
    @ParameterizedTest
    @MethodSource("localParameters_Side")
    void areaTriangleTest(int a, int b, int c, double p)
    {
        assertEquals(Functions.areaTriangle(a, b, c), p);
    }

    static Stream<Arguments> localParameters_Side() {
        return Stream.of(
                Arguments.of(3, 3, 3, 3.897114317029974),
                Arguments.of(4, 7, 8, 13.997767679169419),
                Arguments.of(5, 4, 8, 8.181534085976786)
        );
    }
}
