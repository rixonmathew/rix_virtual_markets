package com.rixon.virtualmarket.dataprovider.provider;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class IdentifierTypeProvider {

  private List<String> identifierTypes = Arrays.asList("CUSIP", "ISIN", "SEDOL", "RIC", "CUSTOM");

  public List<String> getAllIdentifierTypes() {
    return identifierTypes;
  }

  public String getRandomIdentifierType() {
    Random random = new Random();
    return identifierTypes.get(random.nextInt(identifierTypes.size()));
  }
}
