public class MyNumber {

    private int value;

    public MyNumber() {
        this((int)(Math.random()*10)+1); // 1~10 중 임의의 값
    }

    public MyNumber(int value) {
        this.value = value;
        return;
    }

    // 지정 값을 객체의 value에 합산하여 반환
    public int getAddition(int addNumber) {
        return value+addNumber;
    }

    public String toString() {
        return String.valueOf(value);
    }

}
