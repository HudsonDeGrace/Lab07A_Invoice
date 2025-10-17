public class LineItem extends Product{
    private int quantity;

    public LineItem(String name, double price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }

    public LineItem(Product product, int quantity){
        super(product.getName(), product.getPrice());
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCalculatedTotal(){
        return quantity * price;
    }
}
