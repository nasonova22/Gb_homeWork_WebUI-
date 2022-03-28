package lesson4;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static lesson4.Triangle.AreaTriangle;

public class TriangleTest {
   private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

 @Test
  void ifExistTriangle() {
  // double result=AreaTriangle(3.0,4.0,5.0);
     Assertions.assertEquals(6.0, AreaTriangle(3.0, 4.0, 5.0));
     logger.debug("info debug");
     logger.trace("info trace");
 }

 @Test
  void ifnotExistTriangle() {
  Assertions.assertEquals(-1, AreaTriangle(1, 2, 9));
 }

 @ParameterizedTest
 @CsvSource({"6,3,4,5", "-1,1,2,9"})
  void commonAreaTriangle(double s, double a, double b, double c) {
  Assertions.assertEquals(s, AreaTriangle(a, b, c));
 }
}
