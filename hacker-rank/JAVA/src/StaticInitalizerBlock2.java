import java.util.Scanner;

public class StaticInitalizerBlock2 {
    public static Scanner sc = new Scanner(System.in);

    public static int B = sc.nextInt();
    public static int H = sc.nextInt();

    public static boolean flag = checkParameter(B, H);

    private static boolean checkParameter(int B, int H) {
        boolean flag = true;

        if(B <= 0 || H <= 0) {
            System.out.print("java.lang.Exception: Breadth and height must be positive");
            flag = false;
        }

        return flag;
    }

    public static void main(String[] args) {
        if(flag) {
            int area = B * H;
            System.out.print(area);
        }
    }
}
