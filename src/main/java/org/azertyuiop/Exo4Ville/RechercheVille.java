package org.azertyuiop.Exo4Ville;

import jdk.jshell.spi.ExecutionControl;
import org.azertyuiop.exception.ArgumentTooShortException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RechercheVille {
   List<String> villes;

  public RechercheVille(List<String> villes) {
    this.villes = villes;
  }

  public List<String> rechercher(String mot) throws ArgumentTooShortException {

     if (mot.length() < 2) {
       if (Objects.equals(mot, "*"))
         return villes;
       throw new ArgumentTooShortException("Le texte de la recherche doit contenir plus de deux caractères");
     }
     else {
       List<String> result = new ArrayList<>();
       villes.forEach(v -> {
         if (v.toLowerCase().contains(mot.toLowerCase()))
           result.add(v);
       });
       return result;
     }
   }
}