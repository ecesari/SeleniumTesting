package com.ecesari.selenium;

import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;

import java.io.IOException;

public class Runner {
  public static void main(String[] args) throws IOException {
    TestExecutor executor = new TestExecutor(
      HomePageTest.class, LoginTest.class, UserPageTests.class, DictionaryTest.class
    );

    Result result = executor.execute(true);
    System.out.println("Done: [" + result.getResults().toString(2) + "]");
  }
}
