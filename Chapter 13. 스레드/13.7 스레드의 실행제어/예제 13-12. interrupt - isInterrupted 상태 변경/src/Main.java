import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하셈.");
        System.out.printf("입력하신 값은 %s입니다.%n", input);
        thread.interrupt();
    }
}
