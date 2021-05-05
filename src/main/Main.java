package main;

import domain.Client;
import domain.Product;
import domain.Selling;
import domain.Store;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Store store1 = new Store(new ArrayList<Client>(), new ArrayList< Product >( ),  new ArrayList< Selling > ());

        store1.newProduct("oreo", 80, 8); //1
        store1.newProduct("fideos", 30, 6);//2
        store1.newProduct("duraznos en almibar", 50, 3);//3
        store1.newProduct("Crema", 100, 2);//4
        store1.newProduct("Cerveza", 150, 4);//5
        store1.newProduct("Vinagre", 80, 5);//6

        store1.newClient("Carlos", "Siempre viva 335", 465465, false);//1
        store1.newClient("Sacoa", "Sanmartin 1750", 456465, true);//2
        store1.newClient("Pancho", "quintana 1777", 456465, false);//3

        createSell(store1, store1.getClient(0), store1.getProduct(4), 3);
        createSell(store1, store1.getClient(0), store1.getProduct(1), 3);
        createSell(store1, store1.getClient(2), store1.getProduct(2), 3);
        createSell(store1, store1.getClient(0), store1.getProduct(4), 3);
        createSell(store1, store1.getClient(1), store1.getProduct(3), 3);

        double sells= avgSells(store1);
        System.out.println("sells = " + sells);

        Client aux = frequentClient(store1);
        System.out.println("aux = " + aux);


    }

    public static void createSell(Store localStore, Client localClientm, Product localProducte, int localDistance){
        if (localStore.newSelling(localClientm, localProducte, localDistance)){
            System.out.println("compra exitosa");
        }
        else {
            System.out.println("compra fallida");
        }
    }

    private static double avgSells(Store localStore){
        return localStore.averageSellEarning();
    }

    private static Client frequentClient(Store localStore){
        return localStore.mostFrequentClient();
    }
}
