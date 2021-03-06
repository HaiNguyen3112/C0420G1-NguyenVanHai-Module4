package com.codegym.case_study_md4.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_type")
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_type_id")
    private Long id;

    private String name;

    @OneToMany
    private List<Servicee> serviceList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Servicee> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Servicee> serviceList) {
        this.serviceList = serviceList;
    }
}


