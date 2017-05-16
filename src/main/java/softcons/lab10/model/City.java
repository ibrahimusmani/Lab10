/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softcons.lab10.model;

/**
 *
 * @author ibrah
 */
public class City {
    private int locId;
    private String country;
    private String region;
    private String city;
    private String postalCode;
    private float latitude;
    private float longitude;
    private int metroCode;
    private int areaCode;

    public int getLocId() {
        return locId;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public int getMetroCode() {
        return metroCode;
    }

    public int getAreaCode() {
        return areaCode;
    }

    public void setLocId(int locId) {
        this.locId = locId;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setMetroCode(int metroCode) {
        this.metroCode = metroCode;
    }

    public void setAreaCode(int areaCode) {
        this.areaCode = areaCode;
    }
}
