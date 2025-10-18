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

    /**
     * The total cost of the line item price of the product times the quantity bought
     * @return returns a double representing the total price
     */
    public double getCalculatedTotal(){
        return quantity * price;
    }
}
