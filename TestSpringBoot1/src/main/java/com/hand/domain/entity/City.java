package com.hand.domain.entity;

import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import javax.persistence.*;

@Table(name = "city")
public class City extends BaseEntity {
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "city_id")
    private Short cityId;

    private String city;

    @Column(name = "country_id")
    private Short countryId;

    private Country country;

    public Short getCityId() {
        return cityId;
    }

    public void setCityId(Short cityId) {
        this.cityId = cityId;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return country_id
     */
    public Short getCountryId() {
        return countryId;
    }

    /**
     * @param countryId
     */
    public void setCountryId(Short countryId) {
        this.countryId = countryId;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", city='" + city + '\'' +
                ", countryId=" + countryId +
                ", lastUpdate=" + getLastUpdate() +
                ", country=" + country +
                '}';
    }
}