package domain;

import java.util.Objects;

public class Client {
    private String name;
    private String adress;
    private int phone;
    private boolean isBusines;

    public Client(String name, String adress, int phone, boolean isBusines) {
        this.name = name;
        this.adress = adress;
        this.phone = phone;
        this.isBusines = isBusines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean isBusines() {
        return isBusines;
    }

    public void setBusines(boolean busines) {
        isBusines = busines;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Client{");
        sb.append("name='").append(name).append('\'');
        sb.append(", adress='").append(adress).append('\'');
        sb.append(", phone=").append(phone);
        sb.append(", isBusines=").append(isBusines);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getPhone() == client.getPhone() && isBusines() == client.isBusines() && getName().equals(client.getName()) && getAdress().equals(client.getAdress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAdress(), getPhone(), isBusines());
    }
}
