import java.util.Scanner;

// 사용자 정의 예외
class NegativeException extends Exception {
    public NegativeException() {}
    public NegativeException(String message) {super(message);}
}

public class StaticInitializerBlock {

    // parallelogram
    // B : breadth
    // H : height
    public static int B = 0;
    public static int H = 0;

    public static boolean flag = false;

    public static void checkParameter(int B, int H) throws NegativeException {
        if(B < 0 || H < 0) {
            flag = false;
            throw new NegativeException("java.lang.Exception: Breadth and height must be postivie");
        } else {
            flag = true;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        try {
            B = sc.nextInt();
            H = sc.nextInt();
            checkParameter(B, H);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(flag) {
            int area = B * H;
            System.out.print(area);
        }
    }
}
