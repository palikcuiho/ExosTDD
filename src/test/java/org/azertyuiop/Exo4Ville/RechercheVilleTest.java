package org.azertyuiop.Exo4Ville;

import org.azertyuiop.exception.ArgumentTooShortException;
import org.junit.Assert;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

class RechercheVilleTest {

  RechercheVille rechercheVille;
  static List<String> villes;

  @BeforeAll
  public static void beforeAllSetUp() {
    villes = Arrays.asList(new String[]{"Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam",
            "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul"});
  }

  @BeforeEach
  public void beforeEachSetUp() {
    rechercheVille = new RechercheVille(villes);
  }

  //  1. Si le texte de la recherche contient moins de 2 caractères, ***Une exception est levée de type NotFoundException***.
  @Test
  @DisplayName("Lève une exception quand le texte est trop court")
  public void whenArgumentLessThan2CharactersLong_NotFoundExceptionThrown() {
    String argument = "a";
    Assert.assertThrows(ArgumentTooShortException.class, () -> {
      rechercheVille.rechercher(argument);
    });
  }

  //  2. Si le texte de recherche est égal ou supérieur à 2 caractères, il doit renvoyer tous les noms de ville commençant par le texte de recherche exact.
  //   Par exemple, pour le texte de recherche "Va", la fonction doit renvoyer Valence et Vancouver
  @Test
  @DisplayName("La recherche \"Va\" renvoie Valence et Vancouver")
  public void whenArgumentIsVa_ReturnValenceAndVancouver() {
    String argument = "Va";
    String[] expected = {"Valence", "Vancouver"};
    List<String> result = rechercheVille.rechercher(argument);
    Assert.assertArrayEquals(expected, result.toArray());
  }

  //  3. La fonctionnalité de recherche doit être insensible à la casse
  @Test
  @DisplayName("La recherche \"rome\" renvoie Rome")
  public void whenArgumentIsLowercaseRome_ReturnRome() {
    String argument = "rome";
    String[] expected = {"Rome"};
    List<String> result = rechercheVille.rechercher(argument);
    Assert.assertArrayEquals(expected, result.toArray());
  }

  //  4. La fonctionnalité de recherche devrait également fonctionner lorsque le texte de recherche n'est qu'une partie d'un nom de ville
//   Par exemple "ape" devrait renvoyer la ville "Budapest"
  @Test
  @DisplayName("La recherche \"ape\" renvoie Budapest")
  public void whenArgumentIsApe_ReturnBudapest() {
    String argument = "ape";
    String[] expected = {"Budapest"};
    List<String> result = rechercheVille.rechercher(argument);
    Assert.assertArrayEquals(expected, result.toArray());
  }

  //  5. Si le texte de recherche est un « * » (astérisque), il doit renvoyer tous les noms de ville.
  @Test
  @DisplayName("La recherche \"*\" renvoie tous les noms de ville")
  public void whenArgumentIsWildcard_ReturnAllCities() {
    String argument = "*";
    List<String> result = rechercheVille.rechercher(argument);
    Assert.assertArrayEquals(villes.toArray(), result.toArray());
  }
}
