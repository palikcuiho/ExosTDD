package org.azertyuiop.Exo5Magasin;

import org.junit.Assert;
import org.junit.jupiter.api.*;

public class ShopTest {

  public Shop shop;
  public Product product;

  @BeforeEach
  public void beforeEachSetUp() {
    shop = new Shop();
  }

//-	Une fois la date de péremption est à zéro, la qualité se dégrade deux fois plus vite.
  @Test
  @DisplayName("Une fois la date de péremption à zéro, la qualité se dégrade 2x plus vite")
  public void ProductDepreciatesTwiceAsFastPastExpirationDate(){
    int qualityBeforeUpdate = 10;
    // Normal product
    product = new Product("type", "produit normal", 5, qualityBeforeUpdate);
    shop.update(product);
    int qualityAfterUpdate = product.getQuality();

    // Expired product
    Product expiredProduct = new Product("type", "produit périmé", 0, qualityBeforeUpdate);
    shop.update(expiredProduct);
    int qualityAfterUpdateExpiredProduct = expiredProduct.getQuality();

    if (qualityAfterUpdate > 0 && qualityAfterUpdateExpiredProduct > 0){
      int normalDailyDepreciation = qualityAfterUpdate - qualityBeforeUpdate;
      int expiredDailyDepreciation = qualityAfterUpdateExpiredProduct - qualityBeforeUpdate;
      if (normalDailyDepreciation != 0)
        Assert.assertEquals(2, expiredDailyDepreciation/normalDailyDepreciation);
    }
  }

//-	La qualité d'un article n'est jamais négative.
  @Test
  @DisplayName("La qualité d'un article n'est jamais négative")
  public void ProductQualityShouldNeverBeNegative(){
    product = new Product("type", "name", 0, 0);
    shop.update(product);
    Assert.assertTrue(product.getQuality() >= 0);
  }

//-	La qualité d'un article n'est jamais supérieure à 50.
  @Test
  @DisplayName("La qualité d'un article n'est jamais supérieure à 50")
  public void ProductQualityShouldNeverBeGreaterThan50(){
    product = new Product("type", "name", 0, 50);
    shop.update(product);
    Assert.assertTrue(product.getQuality() <=50);
  }

//-	La qualité du « brie vieilli » augmente à mesure qu'il vieillit.
  @Test
  @DisplayName("La qualité du « brie vieilli » augmente à mesure qu'il vieillit")
  public void ProductBrieVieilliQualityAppreciates(){
    int qualityBeforeUpdate = 10;
    product = new Product("produit laitier", "brie vieilli", 1, qualityBeforeUpdate);
    shop.update(product);
    int qualityAfterUpdate = product.getQuality();
    Assert.assertTrue(qualityAfterUpdate > qualityBeforeUpdate);
    }

  //-	Les produits laitiers se dégradent en qualité deux fois plus vite que les produits normaux
  @Test
  @DisplayName("Les produits laitiers se dégradent 2x plus vite que les produits normaux")
  public void DairyProductsDepreciateTwiceAsFast(){
    int qualityBeforeUpdate = 10;

    // Normal product
    product = new Product("produit normal", "nom", 5, qualityBeforeUpdate);
    shop.update(product);
    int qualityAfterUpdate = product.getQuality();

    // Dairy Product
    Product dairyProduct =  new Product("produit laitier", "pas du brie", 5, qualityBeforeUpdate);
    shop.update(dairyProduct);
    int qualityAfterUpdateDairyProduct = dairyProduct.getQuality();

    if (qualityAfterUpdate > 0 && qualityAfterUpdateDairyProduct > 0){
      int normalDailyDepreciation = qualityAfterUpdate - qualityBeforeUpdate;
      int dairyDailyDepreciation = qualityAfterUpdateDairyProduct - qualityBeforeUpdate;
      if (normalDailyDepreciation != 0)
        Assert.assertEquals(dairyDailyDepreciation/normalDailyDepreciation, 2);
    }

  }
}
