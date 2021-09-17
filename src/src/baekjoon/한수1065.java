package baekjoon;

import java.io.*;

public class 한수1065 {

    static final int MAX = 1000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(solution(num)));
        bw.close();
    }

    public static int solution(int num) {

        int count=0;
        int one;
        int two;
        int three;

        for (int i = num; i > 0; i--) {

            if(i > 99) {
                three = i / 100;
                two = (i / 10) % 10;
                one = i % 10;

                if ((three - two) == (two - one)) {
                    count++;
                }
            } else {
                count++;
            }

        }

        return count;
    }

}
