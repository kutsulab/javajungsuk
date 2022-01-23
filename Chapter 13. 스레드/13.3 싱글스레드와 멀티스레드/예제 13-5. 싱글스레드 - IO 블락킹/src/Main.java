import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // 작업 1 : 입력
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세용");
        System.out.printf("입력하신 값은 %s입니다.%n", input);

        // 작업 2 : 출력 (입력 대기 시간만큼을 대기하고 있고, 입력이 끝나야 실행됨.)
        for (int i=10; i>0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
