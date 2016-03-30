# ConsoleUtil: Simple console input/output utility for Java

```java
import static jp.co._3sss.console_util.ConsoleUtil.*;

public class Sample {
  public static void main(String[] args) {
    // 文字列を読み取る
    String name = readString("氏名を入力してください: ");
    // 整数を読み取る
    int age = readInt("年齢を入力してください: ");
    
    // 読み取ったデータを表示する
    println("氏名: ", name); 
    println("年齢: ", age); 
  }
}

```
