package jp.co._3sss.console_util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 画面の入出力をかんたんに行うためのライブラリです。
 * 
 * 例：
 * <pre>{@code
 * 
 * import static jp.co._3sss.console_util.ConsoleUtil.*;
 * 
 * public class Sample {
 *   public static void main(String[] args) {
 *     // 文字列を読み取る
 *     String name = readString("氏名を入力してください: ");
 *     // 整数を読み取る
 *     int age = readInt("年齢を入力してください: ");
 *     
 *     // 読み取ったデータを表示する
 *     println("氏名: ", name); 
 *     println("年齢: ", age); 
 *   }
 * }</pre>
 */
public class ConsoleUtil {

  /**
   * 標準入力から整数を1つ読み取ります。
   * @param prompt 入力前に表示する文字列
   * @return 読み取った整数
   */
  public static int readInt(String prompt) {
    while (true) {
      try {
        return Integer.parseInt(readString(prompt));
      } catch (NumberFormatException e) {
        println("(入力エラー)整数を入力してください。");
      }
    }
  }

  /**
   * 標準入力から整数を1つ読み取ります。
   * @return 読み取った整数
   */
  public static int readInt() {
    return readInt(null);
  }

  /**
   * 標準入力から実数を1つ読み取ります。
   * @param prompt 入力前に表示する文字列
   * @return 読み取った実数
   */
  public static double readDouble(String prompt) {
    while (true) {
      try {
        return Double.parseDouble(readString(prompt));
      } catch (NumberFormatException e) {
        println("(入力エラー)実数を入力してください。");
      }
    }
  }

  /**
   * 標準入力から実数を1つ読み取ります。
   * @return 読み取った実数
   */
  public static double readDouble() {
    return readDouble(null);
  }

  /**
   * 標準入力から1行の文字列を読み取ります。
   * @param prompt 入力前に表示する文字列
   * @return 読み取った文字列(改行文字は付きません)
   */
  public static String readString(String prompt) {
    try {
      if (prompt != null) {
        print(prompt);
      }
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      return br.readLine();
    } catch (IOException e) {
      throw new ConsoleException(e);
    }
  }

  /**
   * 標準入力から1行の文字列を読み取ります。
   * @return 読み取った文字列(改行文字は付きません)
   */
  public static String readString() {
    return readString(null);
  }

  /**
   * それぞれの引数を標準出力に出力します。
   * @param args 出力する文字列や整数などのオブジェクト
   */
  public static void print(Object... args) {
    for (Object obj : args) {
      System.out.print(obj);
    }
  }

  /**
   * それぞれの引数を標準出力に出力し、改行を出力します。
   * @param args 出力する文字列や整数などのオブジェクト
   */
  public static void println(Object... args) {
    for (Object obj : args) {
      System.out.print(obj);
    }
    System.out.println();
  }

  /**
   * System.out.println()を使用して、引数を標準出力へ出力します。
   * @param format 書式文字列
   * @param args 出力する文字列や整数などのオブジェクト
   */
  public static void printf(String format, Object... args) {
    System.out.printf(format, args);
  }

}
