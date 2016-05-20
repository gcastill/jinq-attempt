package com.nelis.jinqexample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "location")
public class Address {

  @Id
  private int number = 0;
  @Column(name = "addr")
  private String street = "";

  public Address() {

  }

  public Address(int number, String street) {
    this.number = number;
    this.street = street;
  }

  @Override
  public String toString() {
    return "" + number + " " + street;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public int getNumber() {
    return number;
  }
}
