package org.azertyuiop.Exo5Magasin;

import jdk.jshell.spi.ExecutionControl;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;

public class ShopTest {

  public Shop shop;
  public Product product;

  @BeforeEach
  public void beforeEachSetUp() {
    shop = new Shop();
//    product = new Product();
  }

//-	Une fois la date de péremption est à zéro, la qualité se dégrade deux fois plus vite.
//-	La qualité d'un article n'est jamais négative.
  @Test
  @DisplayName("La qualité d'un article n'est jamais négative")
  public void ProductQualityShouldNeverBeNegative() throws ExecutionControl.NotImplementedException {
    product = new Product("type", "name", 0, 0);
    shop.update(product);
    Assert.assertTrue(product.getQuality() >= 0);
  }

//-	La qualité d'un article n'est jamais supérieure à 50.
  @Test
  @DisplayName("La qualité d'un article n'est jamais supérieure à 50")
  public void ProductQualityShouldNeverBeGreaterThan50() throws ExecutionControl.NotImplementedException {
    product = new Product("type", "name", 0, 50); // ??
    shop.update(product);
    Assert.assertTrue(product.getQuality() <=50);
  }


//-	La qualité du « brie vieilli » augmente à mesure qu'il vieillit.
  @Test
  @DisplayName("La qualité du « brie vieilli » augmente à mesure qu'il vieillit")
  public void ProductBrieVieilliQualityAppreciates() throws ExecutionControl.NotImplementedException {
    int qualityBeforeUpdate = 1;
    product = new Product("produit laitier", "brie vieilli", 1, qualityBeforeUpdate);
      shop.update(product);
      int qualityAfterUpdate = product.getQuality();
      Assert.assertTrue(qualityAfterUpdate > qualityBeforeUpdate);
    }


  //-	Les produits laitiers se dégradent en qualité deux fois plus vite que les produits normaux
  @Test
  @DisplayName("Les produits laitiers se dégradent 2x plus vite que les produits normaux")
  public void DairyProductsDepreciateTwiceAsFast() throws ExecutionControl.NotImplementedException {
    // Normal product
    int qualityBeforeUpdate = 1;
    product = new Product("produit normal", "nom", 5, qualityBeforeUpdate);
    shop.update(product); // ! peut se retrouver à 0
    int qualityAfterUpdate = product.getQuality();

    // Dairy Product
    int qualityBeforeUpdateDairyProduct = 1;
    Product dairyProduct =  new Product("produit laitier", "pas du brie", 5, qualityBeforeUpdateDairyProduct);
    shop.update(dairyProduct);
    int qualityAfterUpdateDairyProduct = dairyProduct.getQuality();

    if (qualityAfterUpdate > 0 && qualityAfterUpdateDairyProduct > 0){
      int normalDailyDepreciation = qualityAfterUpdate - qualityBeforeUpdate;
      int dairyDailyDepreciation = qualityAfterUpdateDairyProduct - qualityBeforeUpdateDairyProduct;
      if (normalDailyDepreciation != 0)
        Assert.assertEquals(dairyDailyDepreciation/normalDailyDepreciation, 2);
    }

  }
}
