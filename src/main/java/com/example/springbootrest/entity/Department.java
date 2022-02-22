package com.example.springbootrest.entity;

import javax.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "id",
            nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "departmentName")
    private String departmentName;

    @Column(name = "departmentAddress")
    private String departmentAddress;

    @Column(name = "departmentCode")
    private String departmentCode;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                ", departmentAddress='" + departmentAddress + '\'' +
                ", departmentCode='" + departmentCode + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
        if (getDepartmentName() != null ? !getDepartmentName().equals(that.getDepartmentName()) : that.getDepartmentName() != null)
            return false;
        if (getDepartmentAddress() != null ? !getDepartmentAddress().equals(that.getDepartmentAddress()) : that.getDepartmentAddress() != null)
            return false;
        return getDepartmentCode() != null ? getDepartmentCode().equals(that.getDepartmentCode()) : that.getDepartmentCode() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getDepartmentName() != null ? getDepartmentName().hashCode() : 0);
        result = 31 * result + (getDepartmentAddress() != null ? getDepartmentAddress().hashCode() : 0);
        result = 31 * result + (getDepartmentCode() != null ? getDepartmentCode().hashCode() : 0);
        return result;
    }

    public Department() {
    }

    public Department(Integer id, String departmentName, String departmentAddress, String departmentCode) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentAddress() {
        return departmentAddress;
    }

    public void setDepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
}
