package org.azertyuiop.Exo3De;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class DiceScoreTest {
  // réaliser des tests unitaires de la classe suivante en mockant l'interface Ide

  private Ide de = Mockito.mock(Ide.class);
  private DiceScore ds;

  // - lorsque les 2 dés sont identiques, on récupère bien valeur du dé * 2 + 10
  @Test
  public void whenBothDiceRollsEqual5_ThenResultEquals30(){
    // Arrange
    ds = new DiceScore(de);
    Mockito.when(de.getRoll()).thenReturn(5);

    // Act
    int result = ds.getScore();

    // Assert
    Assert.assertEquals(20, result);
  }

  // dans le cas où les 2 dés sont identiques et font 6, on récupère 30
  @Test
  public void whenBothDiceRollsEqual6_ThenResultEquals30(){
    // Arrange
    ds = new DiceScore(de);
    Mockito.when(de.getRoll()).thenReturn(6);

    // Act
    int result = ds.getScore();

    // Assert
    Assert.assertEquals(30, result);
  }
  //- dans le cas où les dés sont quelconques, on récupère la valeur du plus haut des 2
  @Test
  public void whenDiceRollsAre1And2_ThenReturn2(){
    // Arrange
    ds = new DiceScore(de);
    Mockito.when(de.getRoll()).thenReturn(1).thenReturn(2);

    // Act
    int result = ds.getScore();

    // Assert
    Assert.assertEquals(2, result);

  }
}
