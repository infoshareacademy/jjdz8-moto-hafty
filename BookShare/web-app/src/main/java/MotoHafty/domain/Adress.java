package MotoHafty.domain;

public class Adress {

    private String streetAddress;
    private String city;
    private String province;
    private String zipCode;

    public Adress(String streetAddress, String city, String province, String zipCode) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.province = province;
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
