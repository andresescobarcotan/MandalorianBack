package com.charla.mandalorian.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name ="images")
public class Image {

  @Id
  @Column(name="name")
  private String name;

  @Column(name="image")
  @Lob
  private byte[] image;

  public Image() {
  }

  public Image(String name, byte[] image) {
    this.name = name;
    this.image = image;
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
}
