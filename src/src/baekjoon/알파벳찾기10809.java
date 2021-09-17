package baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;

public class 알파벳찾기10809 {

    static int[] abc = new int[26];

    public static void main(String[] args) throws IOException {

        Arrays.fill(abc, -1);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String str = br.readLine().toLowerCase(Locale.ROOT);

        solution(str);
    }

    public static void solution(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (abc[ch - 'a'] == -1) {
                abc[ch - 'a'] = i;
            }
        }

        for (int j : abc) {
            System.out.print(j + " ");
        }
    }

}
