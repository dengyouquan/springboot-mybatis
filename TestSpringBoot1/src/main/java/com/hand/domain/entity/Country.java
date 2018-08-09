package com.hand.domain.entity;

import tk.mybatis.mapper.annotation.KeySql;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "country")
public class Country extends BaseEntity {
    @Id
    @KeySql(useGeneratedKeys = true)
    @Column(name = "country_id")
    private Short countryId;

    private String country;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    private List<City> cities;

    public Short getCountryId() {
        return countryId;
    }

    public void setCountryId(Short countryId) {
        this.countryId = countryId;
    }

    /**
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId=" + countryId +
                ", country='" + country + '\'' +
                ", lastUpdate=" + getLastUpdate() +
                ", cities=" + cities +
                '}';
    }
}