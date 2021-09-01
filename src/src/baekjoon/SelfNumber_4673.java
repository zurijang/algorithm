package baekjoon;

public class SelfNumber_4673 {

    public static int SelfNum(int num) {

        int sum = num;

        while (num != 0) {
            sum = sum + (num % 10);
            num = num / 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        boolean check[] = new boolean[10001];
        int n;

        for (int i = 1; i < 10001; i++) {
            n = SelfNum(i);
            if (n < 10001) {
                check[n] = true;
            }
        }

        for (int i = 1; i < 10001; i++) {
            if (!check[i]) {
                System.out.println(i);
            }
        }

    }
}
