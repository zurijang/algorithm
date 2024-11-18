import java.util.Scanner;

public class IfElse {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int N = sc.nextInt();
        // 정규표현식
        // ? : 문자 0 or 1개 매치
        // | : OR
        // \r : 새 줄 (carriage return)
        // \n : 줄 바꿈
        // \r\n : Windows 라인 끝
        // [] : 단일 문자
        // () : 문자 덩어리
        // \u2028 : LINE SEPARATOR
        // \u2029 : PARAGRAPH SEPARATOR
        // \u0085 : NEXT LINE
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        sc.close();

        if(N % 2 == 1) { // 홀수
            System.out.println("Weird");
        } else if (N >= 2 & N <= 5) { // 짝수이면서 2<=N<= 5
            System.out.println("Not Weird");
        } else if (N >= 6 & N <= 20) { // 짝수이면서 6<=N<=20
            System.out.println("Weird");
        } else if (N > 20) { // 짝수이면서 N>20
            System.out.println("Not Weird");
        } else { // 조건 외 경우
            System.out.println("Not Expected");
        }
    }

}
