package com.restapi.postgresql.entity;

import javax.persistence.*;

@Entity
@Table(name="students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;



    @Column(name="name")
    private String name;

    @Column(name="subjects")
    private String subjects;

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSubjects() {

        return subjects;
    }

    public void setSubjects(String subjects) {

        this.subjects = subjects;
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public StudentEntity(String name, String subjects) {

        this.name = name;
        this.subjects = subjects;
    }

    public StudentEntity( ) {


    }
}
