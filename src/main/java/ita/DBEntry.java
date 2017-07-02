package ita;

public class DBEntry
{
    private String title;
    private int quantity;
    private double price;

    public DBEntry(String title, int quantity, double price) {
        this.title = title;
        this.quantity = quantity;
        this.price = price;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void decreaseQuantity() {
        this.quantity--;
    }
}
