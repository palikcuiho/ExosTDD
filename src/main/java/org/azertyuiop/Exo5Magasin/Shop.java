package org.azertyuiop.Exo5Magasin;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class Shop {
    private List<Product> products;

    public void update(Product product) {
        product.setSellIn(product.getSellIn()-1);
        int depreciation = -1;

        if(product.getType().equals("produit laitier")){
            if(product.getName().equals("brie vieilli"))
                depreciation*=-1;
            else
                 depreciation*=2;
        }
        if(product.getSellIn() <= 0 && !product.getName().equals("brie vieilli")){
                 depreciation*=2;
        }

        product.setQuality(product.getQuality()+depreciation);
    }
}
