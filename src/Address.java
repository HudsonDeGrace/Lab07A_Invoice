import java.util.Objects;

public class Address {
    private String street;
    private String apt;
    private String city;
    private String state;
    private String zip;

    public Address(String street, String apt, String city, String state, String zip) {
        this.street = street;
        this.apt = apt;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getApt() {
        return apt;
    }

    public void setApt(String apt) {
        this.apt = apt;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Makes a string formatted for a JLabel
     * @return returns a string on the inputted address values
     */
    public String getFormattedAddress() {
        if(Objects.equals(apt, "")){
            return  street + "<br />" + city + ", " + state + " " + zip;
        }
        else{
            return street + " " + apt + "<br />" + city + ", " + state + " " + zip;
        }
    }
}
