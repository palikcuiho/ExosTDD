package org.azertyuiop.Exo5Magasin;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class Shop {
    private List<Product> products;

    public void update(Product product) throws ExecutionControl.NotImplementedException {
        product.setSellIn(product.getSellIn()-1);


        if(product.getType().equals("produit laitier")){
            product.setQuality(product.getQuality()-20);
        }
        else
            product.setQuality(product.getQuality()-10);
    }
}
