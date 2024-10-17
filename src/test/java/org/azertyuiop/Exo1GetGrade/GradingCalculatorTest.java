package org.azertyuiop.Exo1GetGrade;
import org.junit.Assert;
import org.junit.Test;

public class GradingCalculatorTest {

  // Score : 95%, Présence : 90 → Note : A
  @Test
  public void shouldGetA_whenScoreIs95AndAttendancePercentageIs90() {
    // Arrange
    int score = 95;
    int attendancePercentage = 90;
    GradingCalculator calculator = new GradingCalculator(score, attendancePercentage);

    // Act
    char grade = calculator.getGrade();

    // Assert
    Assert.assertEquals('A', grade);
  }

  // Score : 85%, Présence : 90 → Note : B
  @Test
  public void shouldGetB_whenScoreIs85AndAttendancePercentageIs90() {
    int score = 85;
    int attendancePercentage = 90;
    GradingCalculator calculator = new GradingCalculator(score, attendancePercentage);
    char grade = calculator.getGrade();
    Assert.assertEquals('B', grade);
  }

  // Score : 65%, Présence : 90 → Note : C
  @Test
  public void shouldGetC_whenScoreIs65AndAttendancePercentageIs90() {
    int score = 65;
    int attendancePercentage = 90;
    GradingCalculator calculator = new GradingCalculator(score, attendancePercentage);
    char grade = calculator.getGrade();
    Assert.assertEquals('C', grade);
  }

  // Score : 95%, Présence : 65 → Note : B
  @Test
  public void shouldGetB_whenScoreIs95AndAttendancePercentageIs65() {
    int score = 95;
    int attendancePercentage = 65;
    GradingCalculator calculator = new GradingCalculator(score, attendancePercentage);
    char grade = calculator.getGrade();
    Assert.assertEquals('B', grade);
  }

  // Score : 95%, Présence : 55 → Note : F
  @Test
  public void shouldGetF_whenScoreIs95AndAttendancePercentageIs55() {
    int score = 95;
    int attendancePercentage = 55;
    GradingCalculator calculator = new GradingCalculator(score, attendancePercentage);
    char grade = calculator.getGrade();
    Assert.assertEquals('F', grade);
  }

  // Score : 65%, Présence : 55 → Note : F
  @Test
  public void shouldGetF_whenScoreIs65AndAttendancePercentageIs55() {
    int score = 65;
    int attendancePercentage = 55;
    GradingCalculator calculator = new GradingCalculator(score, attendancePercentage);
    char grade = calculator.getGrade();
    Assert.assertEquals('F', grade);
  }

  // Score : 50%, Présence : 90 → Note : F
  @Test
  public void shouldGetF_whenScoreIs50AndAttendancePercentageIs90() {
    int score = 50;
    int attendancePercentage = 90;
    GradingCalculator calculator = new GradingCalculator(score, attendancePercentage);
    char grade = calculator.getGrade();
    Assert.assertEquals('F', grade);
  }
}

