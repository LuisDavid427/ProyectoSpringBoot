package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity(name = "visitor_type")
public class VisitorType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type")
    private int idType;

    @Column(name = "type_name", length = 20)
    private String typeName;

    @OneToMany(mappedBy = "visitorType")
    private List<Visitor> visitors;
}