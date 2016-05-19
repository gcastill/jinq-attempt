package com.nelis.jinqexample;


public class Address
{
  private int number = 0;
  private String street = "";

  public Address(int number, String street)
  {
     this.number = number;
     this.street = street;
  }

  public String getAddress()
  {
    return "" + number + " " + street;
  }

  public void setNumber(int number)
  {
    this.number = number;
  }

  public void setStreet(String street)
  {
    this.street = street;
  }
}
