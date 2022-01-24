package com.example.springbootrest.entity;

import javax.persistence.*;

@Entity
@Table(name = "Workplace")
public class Workplace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Capitalization")
    private Integer capitalization;

    public Workplace(String name, Integer capitalization) {
        this.name = name;
        this.capitalization = capitalization;
    }

    public Workplace() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Workplace workplace = (Workplace) o;

        if (getId() != null ? !getId().equals(workplace.getId()) : workplace.getId() != null) return false;
        if (getName() != null ? !getName().equals(workplace.getName()) : workplace.getName() != null) return false;
        return getCapitalization() != null ? getCapitalization().equals(workplace.getCapitalization()) : workplace.getCapitalization() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getCapitalization() != null ? getCapitalization().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Workplace{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capitalization=" + capitalization +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(Integer capitalization) {
        this.capitalization = capitalization;
    }
}
