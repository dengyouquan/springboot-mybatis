package com.hand.domain.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "language")
public class Language extends BaseEntity {
    @Id
    @Column(name = "language_id")
    private Byte languageId;

    private String name;

    /**
     * @return language_id
     */
    public Byte getLanguageId() {
        return languageId;
    }

    /**
     * @param languageId
     */
    public void setLanguageId(Byte languageId) {
        this.languageId = languageId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Language{" +
                "languageId=" + languageId +
                ", name='" + name + '\'' +
                ", lastUpdate=" + getLastUpdate() +
                '}';
    }
}