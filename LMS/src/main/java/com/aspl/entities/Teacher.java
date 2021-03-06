package com.aspl.entities;


import com.aspl.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {
    private int id;
    private int version;
    private String name;
    private Gender gender;
    private int age;
    private Date created;
    private Date modified;
    private List<Klass> klasses;

    public Teacher() {
    }


    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Teacher(String name, Gender gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;

    }

    @Version

    public int getVersion() {
        return version;
    }
    public void setVersion(int version) {
        this.version = version;
    }

    @NotNull
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Column(columnDefinition = "ENUM('MALE', 'FEMALE')")
    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @NotNull
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }
    public void setCreated(Date created) {
        this.created = created;
    }

    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }
    public void setModified(Date modified) {
        this.modified = modified;
    }

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    public List<Klass> getKlasses() {
        return klasses;
    }
    public void setKlasses(List<Klass> klasses) {
        this.klasses = klasses;
    }

}