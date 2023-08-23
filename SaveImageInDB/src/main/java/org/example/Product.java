package org.example;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    private String id;
    @Column(columnDefinition = "NVARCHAR(30)")
    private String name;
    @Column(columnDefinition = "varbinary(MAX)")
    private byte[] image;
    @Column(columnDefinition = "NVARCHAR(30)")
    private String describe;

    public Product(String id, String name, byte[] image, String describe) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.describe = describe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Product() {
    }
}
