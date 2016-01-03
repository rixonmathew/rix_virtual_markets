package com.rixon.virtualmarket.bootstrap;


public class Director {
  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.err.println("Usage java -jar rvm_director.jar --file <properties.file>");
      return;
    }
    RVMLoader loader = new RVMLoader();
    loader.start(args[1]);
  }
}
