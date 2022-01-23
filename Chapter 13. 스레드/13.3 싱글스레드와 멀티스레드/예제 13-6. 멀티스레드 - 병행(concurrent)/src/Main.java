import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // 작업 A : 출력
        Thread th = new Thread(new MyRunnable());
        th.start();

        // 작업 B : 입력
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세용");
        System.out.printf("입력하신 값은 %s입니다.%n", input);

    }
}
