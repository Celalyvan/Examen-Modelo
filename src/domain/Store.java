package domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private ArrayList<Client> clients;
    private ArrayList<Product> products;
    private ArrayList<Selling> sellings;

    public Store(ArrayList<Client> clients, ArrayList<Product> products, ArrayList<Selling> sellings) {
        this.clients = clients;
        this.products = products;
        this.sellings = sellings;
    }

//    public Store() {
//        this.
//    }

    public Client getClient(int index) {
        return this.clients.get(index);
    }

    public Product getProduct(int index) {
        return this.products.get(index);
    }

    public void newClient(String clientName, String clientAdress, int clientPhone, boolean isClientBusiness){

        Client localClient = new Client(clientName,  clientAdress,  clientPhone, isClientBusiness);

        this.clients.add(localClient);
    }

    public void newProduct(String productName, int productPrice, int productStock){ System.out.println("creando nuevo producto");


        this.products.add(new Product(productName, productPrice, productStock));
    }

    public boolean newSelling(Client localClient, Product localProduct, int localDistance){

        int index=0;

        if(products.contains(localProduct)){
            index = products.indexOf(localProduct);
            Product aux = products.get(index);
            int localStock =aux.getStock();
            if ( localStock>0){
                this.sellings.add(new Selling( localClient, localProduct, localDistance));

                aux.setStock(--localStock);

                return true;
            }

        }

        return false;
    }

    public double averageSellEarning(){
        int counter=0;
        double acumulator=0;

        for (Object local :
                this.sellings) {
            acumulator += ((Selling)(local)).finalPrice();
            counter++;
        }

        return acumulator / (double) counter;

    }

    public Client mostFrequentClient(){
        int counter1=0;
        int counter2=0;
        Client localClient=null;

        for (Object local1 :
                this.clients) {
            counter2=0;
            for (Object local2 :
                    this.sellings) {
                if (((Selling) local2).getClient().equals(local1)){
                    counter2++;
                }
            }
            if (counter2>counter1){
                counter1=counter2;
                localClient = (Client) local1;
            }

        }

        return localClient;
    }


    public String toStringSellings() {
        final StringBuilder sb = new StringBuilder("Store{");
        sb.append("sellings=").append(sellings);
        sb.append('}');
        return sb.toString();
    }
}
