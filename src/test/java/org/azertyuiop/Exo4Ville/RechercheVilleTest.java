package org.azertyuiop.Exo4Ville;

import org.azertyuiop.exception.ArgumentTooShortException;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class RechercheVilleTest {

  RechercheVille rechercheVille;
  static List<String> villes;

  @BeforeAll
  public static void beforeAllSetUp() {
    villes = Arrays.asList(new String[]{"Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney",
            "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul"});
  }

    @BeforeEach
  public void beforeEachSetUp() {
    rechercheVille = new RechercheVille();
  }

//  1. Si le texte de la recherche contient moins de 2 caractères, ***Une exception est levée de type NotFoundException***.
  @Test
  public void whenArgument2CharactersLong_NotFoundExceptionThrown(){
    String argument = "a";
    Assert.assertThrows(ArgumentTooShortException.class,()->{rechercheVille.rechercher(argument);});


  }

//  2. Si le texte de recherche est égal ou supérieur à 2 caractères, il doit renvoyer tous les noms de ville commençant par le texte de recherche exact.
//   Par exemple, pour le texte de recherche "Va", la fonction doit renvoyer Valence et Vancouver
//  3. La fonctionnalité de recherche doit être insensible à la casse
//  4. La fonctionnalité de recherche devrait également fonctionner lorsque le texte de recherche n'est qu'une partie d'un nom de ville
//   Par exemple "ape" devrait renvoyer la ville "Budapest"
//  5. Si le texte de recherche est un « * » (astérisque), il doit renvoyer tous les noms de ville.

}
