
package com.junittestes.tdd;

import org.slf4j.Logger;

public class App {
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    int result = calculator.multiply(2, 3);
    // declare a logger to print the result
    Logger logger = org.slf4j.LoggerFactory.getLogger(App.class);
    logger.debug("Result: {}", result);
  }
}
