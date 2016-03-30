package jp.co._3sss.console_util;

import static jp.co._3sss.console_util.ConsoleUtil.*;
import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

public class ConsoleUtilTest {

  @Rule
  public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();

  @Rule
  public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

  @Test
  public void testReadIntWithoutPrompt() {
    systemInMock.provideLines("1");
    int i = readInt();
    assertEquals(1, i);
    assertEquals("", systemOutRule.getLog());
  }

  @Test
  public void testReadIntWithPrompt() {
    systemInMock.provideLines("1");
    int i = readInt("整数を入力してください:");
    assertEquals(1, i);
    assertEquals("整数を入力してください:", systemOutRule.getLog());
  }

  @Test
  public void testReadIntWithRetry() {
    systemInMock.provideLines("a", "1.2", "1");
    int i = readInt("整数を入力してください:");
    assertEquals(1, i);
    assertEquals(
        "整数を入力してください:" //
            + "(入力エラー)整数を入力してください。\n" //
            + "整数を入力してください:" //
            + "(入力エラー)整数を入力してください。\n" //
            + "整数を入力してください:", //
        systemOutRule.getLog());
  }

  @Test
  public void testReadDoubleWithoutPrompt() {
    systemInMock.provideLines("1.23");
    double d = readDouble();
    assertEquals(1.23, d, 0.001);
    assertEquals("", systemOutRule.getLog());
  }

  @Test
  public void testReadDoubleWithPrompt() {
    systemInMock.provideLines("1.23");
    double d = readDouble("実数を入力してください:");
    assertEquals(1.23, d, 0.001);
    assertEquals("実数を入力してください:", systemOutRule.getLog());
  }

  @Test
  public void testReadDoubleWithRetry() {
    systemInMock.provideLines("a", "1.2");
    double d = readDouble("実数を入力してください:");
    assertEquals(1.2, d, 0.001);
    assertEquals(
        "実数を入力してください:" //
            + "(入力エラー)実数を入力してください。\n" //
            + "実数を入力してください:", //
        systemOutRule.getLog());
  }

  @Test
  public void testReadStringWithoutPrompt() {
    systemInMock.provideLines("hello");
    String s = readString();
    assertEquals("hello", s);
    assertEquals("", systemOutRule.getLog());
  }

  @Test
  public void testReadStringWithPrompt() {
    systemInMock.provideLines("hello");
    String s = readString("文字列を入力してください");
    assertEquals("hello", s);
    assertEquals("文字列を入力してください", systemOutRule.getLog());
  }

  @Test
  public void testPrintWithNoArg() {
    print();
    assertEquals("", systemOutRule.getLog());
  }

  @Test
  public void testPrintWithOneArg() {
    print("hello");
    assertEquals("hello", systemOutRule.getLog());
  }

  @Test
  public void testPrintWithTwoArg() {
    print("hello", "world");
    assertEquals("helloworld", systemOutRule.getLog());
  }

  @Test
  public void testPrintlnWithNoArg() {
    println();
    assertEquals("\n", systemOutRule.getLog());
  }

  @Test
  public void testPrintlnWithOneArg() {
    println("hello");
    assertEquals("hello\n", systemOutRule.getLog());
  }

  @Test
  public void testPrintlnWithTwoArg() {
    println("hello", "world");
    assertEquals("helloworld\n", systemOutRule.getLog());
  }

  @Test
  public void testPrintf() {
    printf("%s%d%3.1f\n", "hello", 1, 2.3);
    assertEquals("hello12.3\n", systemOutRule.getLog());
  }
  
  @Test
  public void testPersonalDataInputScenario() {
    systemInMock.provideLines("Taro Yamada", "30", "171.2", "090-9999-9999", "1");
    String name = readString("氏名を入力してください:");
    int age = readInt("年齢を入力してください:");
    double height = readDouble("身長を入力してください:");
    String tel = readString("電話番号を入力してください:");
    int gender = readInt("性別を入力してください(1:男性, 2:女性):");
    assertEquals("Taro Yamada", name);
    assertEquals(30, age);
    assertEquals(171.2, height, 0.001);
    assertEquals("090-9999-9999", tel);
    assertEquals(1, gender);
    assertEquals("氏名を入力してください:" //
        + "年齢を入力してください:" //
        + "身長を入力してください:" //
        + "電話番号を入力してください:" //
        + "性別を入力してください(1:男性, 2:女性):", //
        systemOutRule.getLog());

  }

}
