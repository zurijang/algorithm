import java.util.Scanner;

public class JavaStdinandStdout2 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        // nextLine() 은 \n 을 포함하여 입력받음
        int i = sc.nextInt(); // 입력값 ex) 5(엔터) -> 5\n : \n을 제외한 5만 가져옴
        Double d = sc.nextDouble();
        sc.nextLine(); // 버퍼 정리 (버퍼에 \n 개행문자가 남아있음)
        String s = sc.nextLine();

        sc.close();

        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);

    }

}
