public class Outer {
    public int val = 10; // Outer.this.val

    public class Inner {
        public int val= 20; // this.val

        public void method1(int i) { // final int i

            int val = 30; // final int val

            MyFunction_1 f = () -> {
                System.out.printf("%22s : %d%n","i",i); // 외부 지역변수 : 상수
                System.out.printf("%22s : %d%n","val",val); // 외부 지역변수 : 상수
                System.out.printf("%22s : %d%n","this.val",++this.val); // 람다식이 참조하는 내부 인스턴스 변수는 변경 가능
                System.out.printf("%22s : %d%n","Outer.this.val",++Outer.this.val); // 람다식이 참조하는 외부 인스턴스 변수는 변경 가능

            };

            System.out.println(f); //Outer$Inner$$Lambda$숫자 : 람다식으로 MyFunction 인터페이스를 구현한 익명객체

            f.myMethod();
            return;
        }

        public void method2 (int i) {
            int val = 40;

            //MyFunction_2 f = (i) -> { // 외부 지역변수와 같은 이름의 람다식 매개변수는 허용되지 않는다.
            MyFunction_2 f = (k) -> {
                System.out.printf("%16s(k=%d) : %d%n","k+i",k,k+i);
                System.out.printf("%16s(k=%d) : %d%n","k+val",k,k+val);
                System.out.printf("%16s(k=%d) : %d%n","k+this.val",k,k+(++this.val)); // 람다식 내에서 참조하는 외부 인스턴스 변수는 변경이 가능하다.
                System.out.printf("%16s(k=%d) : %d%n","k+Outer.this.val",k,k+(++Outer.this.val));
            };

            System.out.println(f);

            f.myMethod((int)(Math.random()*100)); // 랜덤값을 인자로 하여 함수를 실행한다.
            return;
        }

    }
}
