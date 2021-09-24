package baekjoon;

import java.io.*;

public class 문자열반복2675 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] input_str;

        int input_count = Integer.parseInt(br.readLine());
        int repeat_cnt;

        for(int i = 0; i < input_count; i++) {
            input_str = br.readLine().split(" ");
            repeat_cnt = Integer.parseInt(input_str[0]);
            sb.append(input_str[1]);

            for (int j = 0; j < sb.length(); j++) {

                for (int z = 0; z < repeat_cnt; z++) {

                    bw.write(sb.substring(j, j+1));

                }

            }

            bw.write("\n");
            bw.flush();
            sb.setLength(0);

        }

        bw.close();

    }

}
