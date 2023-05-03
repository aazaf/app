package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Mohamed Aazaf <aazafmax2@gmail.com> (www.aazafbiz.web.app)
 * @since 2023-04-29
 */

@Embeddable
public class Address {
    @Column(length = 45, nullable = false)
    private String country;

    @Column(length = 45, nullable = false)
    private String city;

    private int postalCode;

    public Address() {
    }

    public Address(String country, String city, int postalCode) {
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }
}
