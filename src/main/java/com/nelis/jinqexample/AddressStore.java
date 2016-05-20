package com.nelis.jinqexample;

import java.util.List;

public interface AddressStore {

  long getCount();

  List<Address> allAddresses();

  List<Address> allAddressesHigherThan(int number);
}
