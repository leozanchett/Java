package com.junittestes.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
   Calculator calculator;

   @BeforeEach
   void setUp() {
      calculator = new Calculator();
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
}
