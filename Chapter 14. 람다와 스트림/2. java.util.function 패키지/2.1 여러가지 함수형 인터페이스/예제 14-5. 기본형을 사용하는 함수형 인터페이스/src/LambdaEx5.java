import java.util.Arrays;
import java.util.function.*;

public class LambdaEx5 {

    public static void main(String[] args) {
        
        // 1~100 사이의 임의의 정수 10개 출력
        int[] ints = makeRandomInts(1,100, 10);
        System.out.println(Arrays.toString(ints));
        
        // 짝수만 출력
        printEvenNumber(ints);
        
        // 일의자리 숫자 제거하여 출력
        IntUnaryOperator deleteOnesPlace = i-> i/10*10;
        changeAll(ints, deleteOnesPlace);
        System.out.println(Arrays.toString(ints));
    }

    // start 이상 end 이하의 정수를 size개 가진 배열 반환
    private static int[] makeRandomInts(int start, int end, int size) {

        IntSupplier getRandomInt = () -> (int)(Math.random() * (Math.abs(end-start+1))) + start;

        int[] ints = new int[size];
        for (int i=0; i<ints.length; i++) {
            ints[i] = getRandomInt.getAsInt();
        }
        return ints;
    }

    // 지정 배열에서 짝수만 출력
    private static void printEvenNumber(int[] intArr) {
        IntPredicate isEvenNumber = i -> i%2==0;
        IntConsumer printInt = i -> System.out.print(i+", ");

        System.out.print('[');
        for(int i : intArr) {
            if(isEvenNumber.test(i)) printInt.accept(i);
        }
        System.out.println(']');
        return;
    }

    // 지정 배열의 모든 값을 IntUnaryOperator의 결과값으로 변경
    private static void changeAll(int[] intArr, IntUnaryOperator iop) {
        for (int i=0; i< intArr.length; i++) {
            int change = iop.applyAsInt(intArr[i]); // 함숫값
            intArr[i] = change; // 함숫값으로 덮어씀
        }
        return;
    }

}
