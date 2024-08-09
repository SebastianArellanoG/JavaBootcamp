package cl.praxis;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("TDD Clase Calculadora")
public class CalculadoraTest {
    private Calculadora calculadora;

    @BeforeEach
    void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    @DisplayName("TDD - suma de dos números")
    void testSuma() {
        int resultado = calculadora.sumar(4, 6);
        assertEquals(10, resultado, "4 + 6 = 10");
    }

    @Test
    @DisplayName("TDD - resta de dos números")
    void testResta() {
        int resultado = calculadora.restar(10, 4);
        assertEquals(6, resultado, "10 - 4 = 6");
    }

    @Test
    @DisplayName("TDD - multiplicación de dos números")
    void testMultiplicacion() {
        int resultado = calculadora.multiplicar(7, 3);
        assertEquals(21, resultado, "7 * 3 = 21");
    }

    @Test
    @DisplayName("TDD - división de dos números")
    void testDivision() {
        double resultado = calculadora.dividir(9, 3);
        assertEquals(3.0, resultado, "9 / 3 = 3.0");
    }
}
