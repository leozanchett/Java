package com.junittestes.tdd;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
   Calculator calculator;
   Person person;

   @BeforeEach
   void setUp() {
      calculator = new Calculator();
      person = new Person("John", "Doe");
   }

   @Test
   @DisplayName("Multiplicação simples")
   void multiply() {
      int result = calculator.multiply(2, 3);
      assertEquals(6, result);
   }

   @RepeatedTest(5)
   @DisplayName("Multiplicação por zero")
   void testMultiplyWithZero() {
      int result = calculator.multiply(2, 0);
      assertEquals(0, result);
   }

   @Target(ElementType.METHOD)
   @Retention(RetentionPolicy.RUNTIME)
   @Tag("fast")
   @Test
   public @interface FastTest {

   }

   @Test
   void standardAssertions() {
      assertEquals(2, calculator.add(1, 1));
      assertEquals(4, calculator.multiply(2, 2), "The optional failure message is now the last parameter");
      assertTrue('a' < 'b',
            () -> "Assertion messages can be lazily evaluated --  to avoid constructing complex messages unnecessarily.");
   }

   @Test
   void groupedAssertions() {
      // In a grouped assertion all assertions are executed, and all
      // failures will be reported together.
      assertAll("O nome e sobrenome das pessoas devem ser iguais",
            () -> assertEquals("John", person.getName()),
            () -> assertEquals("Doe", person.getLastName()));
   }

   @Test
   void dependentAssertions() {
      // Within a code block, if an assertion fails the
      // subsequent code in the same block will be skipped.
      assertAll("valor das properties",
            () -> {
               String firstName = person.getName();
               assertNotNull(firstName);
               // Executed only if the previous assertion is valid.
               assertAll("first name",
                     () -> assertTrue(firstName.startsWith("J")),
                     () -> assertTrue(firstName.endsWith("n")));
            },
            () -> {
               // Grouped assertion, so processed independently
               // of results of first name assertions.
               String lastName = person.getLastName();
               assertNotNull(lastName);
               // Executed only if the previous assertion is valid.
               assertAll("last name",
                     () -> assertTrue(lastName.startsWith("D")),
                     () -> assertTrue(lastName.endsWith("e")));
            });
   }

   @Test
   void exceptionTesting() {
      Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
      assertEquals("/ by zero", exception.getMessage());
   }

   @Test
   void timeoutNotExceeded() {
      // The following assertion succeeds.
      assertTimeout(Duration.ofMinutes(2), () -> {
         // Perform task that takes less than 2 minutes.
      });
   }
}
