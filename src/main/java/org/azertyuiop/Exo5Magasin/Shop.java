package org.azertyuiop.Exo5Magasin;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class Shop {
    private List<Product> products;

    public void update(Product product) {
        product.setSellIn(product.getSellIn()-1);
        int depreciation = -1;

        if (!product.getName().equals("brie vieilli")){
             if(product.getType().equals("produit laitier")){
                 depreciation*=2;
             }
            if(product.getSellIn() <= 0){
                depreciation*=2;
            }
        }
        else depreciation*=-1;

        product.setQuality(product.getQuality()+depreciation);
    }
}
