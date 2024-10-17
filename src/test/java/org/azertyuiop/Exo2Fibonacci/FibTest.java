package org.azertyuiop.Exo2Fibonacci;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;


public class FibTest {
  private Fib fib;

  //  Lors du déclenchement de la fonction GetFibSeries() avec un Range de 1
  //  - Le résultat n’est pas vide
    @Test
  public void whenRangeEquals1_ThenResultIsNotEmpty (){
    // Arrange
    fib = new Fib(1);
    // Act
    List<Integer> result = fib.getFibSeries();
    // Assert
    Assert.assertEquals(1, result.size());
  }

  //  - Le résultat correspond à une liste qui contient {0}
  @Test
  public void whenRangeEquals1_ThenResultIs0 (){
    // Arrange
    fib = new Fib(1);
    // Act
    List<Integer> result = fib.getFibSeries();

    // Assert
    Assert.assertArrayEquals(new Integer[]{0}, result.toArray());
  }

  //  Lors du déclenchement de la fonction GetFibSeries() avec un Range de 6

  //  - Le résultat contient le chiffre 3
  @Test
  public void whenRangeEquals6_ThenResultContains3(){
    // Arrange
    fib = new Fib(6);
    // Act
    List<Integer> result = fib.getFibSeries();
    // Assert
    Assert.assertNotEquals(-1, result.indexOf(3));
  }

  //  - Le résultat contient 6 éléments
    @Test
  public void whenRangeEquals6_ThenResultContains6Items(){
    // Arrange
    fib = new Fib(6);
    // Act
    List<Integer> result = fib.getFibSeries();
    // Assert
    Assert.assertEquals(6, result.size());
  }

  //  - Le résultat n’a pas le chiffre 4 en son sein
  @Test
  public void whenRangeEquals6_ThenResultDoesntContain4(){
    // Arrange
    fib = new Fib(6);
    // Act
    List<Integer> result = fib.getFibSeries();
    // Assert
    Assert.assertEquals(-1, result.indexOf(4));
  }

  //  - Le résultat correspond à une liste qui contient {0, 1, 1, 2, 3, 5}
  @Test
  public void whenRangeEquals6_ThenResultIs011235(){
    // Arrange
    fib = new Fib(6);
    // Act
    List<Integer> result = fib.getFibSeries();
    // Assert
    Assert.assertArrayEquals(new Integer[]{0, 1, 1, 2, 3, 5}, result.toArray());
  }

  //  - Le résultat est trié de façon ascendante
    @Test
  public void whenRangeEquals6_ThenResultIsInAscendingOrder(){
    // Arrange
    fib = new Fib(6);
    // Act
    List<Integer> result = fib.getFibSeries();
    int currentIndex = 0;
    while (currentIndex < result.size()-1){
      int current = result.get(currentIndex);
      int next = result.get(currentIndex + 1);
      Assert.assertTrue(next >= current);
      currentIndex++;
    }
  };
}
