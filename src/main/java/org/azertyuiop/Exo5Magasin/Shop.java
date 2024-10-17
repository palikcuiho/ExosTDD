package org.azertyuiop.Exo5Magasin;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class Shop {
    private List<Product> products;

    public void update(Product product) {
        product.setSellIn(product.getSellIn()-1);

        if(product.getType().equals("produit laitier") || product.getSellIn() <= 0){
            if(product.getName().equals("brie vieilli"))
                product.setQuality(product.getQuality()+1);
            else
                product.setQuality(product.getQuality()-2);
        }
        else
            product.setQuality(product.getQuality()-1);
    }
}
