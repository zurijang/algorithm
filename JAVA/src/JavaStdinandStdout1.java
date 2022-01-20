/*
 * 값을 읽을 때 stdin, 값을 쓸 때 stdout
 * Scanner 사용
 * BufferedReader 사용
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class JavaStdinandStdout1 {

    public static void main(String[] args) {

        // Usage Scanner Class
        /*Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        sc.close();*/

        // Usage BufferedReader Class
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            int c = Integer.parseInt(br.readLine());
            br.close();

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
