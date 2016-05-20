package com.nelis.jinqexample;

public class AddressQueryRunner {
  public void runQueries(AddressStore addressStore) {

    System.out.println(addressStore.getCount());

    // all addresses
    System.out.println(addressStore.allAddresses());

    // addresses where number is higher than 1911
    System.out.println(addressStore.allAddressesHigherThan(1911));

  }
}
