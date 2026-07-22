package com.example.junit.service;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CalculatorServiceTest{
 CalculatorService s=new CalculatorService();
 @Test void testAdd(){
   assertEquals(5,s.add(2,3));
   assertEquals(0,s.add(-2,2));
   assertEquals(-5,s.add(-2,-3));
 }
}
