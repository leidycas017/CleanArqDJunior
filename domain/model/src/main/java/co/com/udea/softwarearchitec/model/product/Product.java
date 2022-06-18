package co.com.udea.softwarearchitec.model.product;

public class Product {
    private String name;
    private String price;
    private String qty;

    public Product(String name, String price, String qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
