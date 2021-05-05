package domain;

public class Selling {
    private Client client;
    private Product product;
    private int discance; // deberia ser double, pero tengo que cprregir todo el codigo
    private final static double pricePerKm= 125;

    public Selling(Client client, Product product, int discance) {
        this.client = client;
        this.product = product;
        this.discance = discance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getDiscance() {
        return discance;
    }

    public void setDiscance(int discance) {
        this.discance = discance;
    }

    public static double getPricePerKm() {
        return pricePerKm;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Selling{");
        sb.append("client=").append(client);
        sb.append(", product=").append(product);
        sb.append(", discance=").append(discance);
        sb.append(", precio total=").append(this.finalPrice());
        sb.append('}');
        return sb.toString();
    }

    public double finalPrice(){
        if (this.client.isBusines()){

            return (this.product.getPrice() + pricePerKm * (double) this.discance) * 0.85;
        }
        else {
            return (this.product.getPrice() + pricePerKm * (double) this.discance);
        }
    }
}
