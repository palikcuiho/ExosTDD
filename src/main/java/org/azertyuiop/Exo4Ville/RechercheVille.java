package org.azertyuiop.Exo4Ville;

import jdk.jshell.spi.ExecutionControl;
import org.azertyuiop.exception.ArgumentTooShortException;

import java.util.List;

public class RechercheVille {
   private List<String> villes;

   public List<String> rechercher(String mot) throws ArgumentTooShortException {
     if (mot.length() < 2)
      throw new ArgumentTooShortException("Le texte de la recherche doit contenir plus de deux caractères");
     return List.of();
   }
}