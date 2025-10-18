public class Customer extends Address{
    private String name;

    public Customer(String name, String street, String apt, String city, String state, String zip) {
        super(street, apt, city, state, zip);
        this.name = name;
    }

    public Customer(Address address, String name) {
        super(address.getStreet(),  address.getApt(), address.getCity(), address.getState(), address.getZip());
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Makes the full customer block to be set for the JLabel
     * @return returns the full formatted string customer block
     */
    public String getCustomerBlock(){
        return "<html>" + name + "<br />" + getFormattedAddress() + "</html>";
    }
}
