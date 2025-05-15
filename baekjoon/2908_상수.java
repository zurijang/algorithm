import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            int[] arrS = new int[st.countTokens()];
            int index = 0;

            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                String reverseToken = new StringBuilder(token).reverse().toString();
                arrS[index++] = Integer.parseInt(reverseToken);
            }

            int max = Arrays.stream(arrS).max().getAsInt();
            bw.write(Integer.toString(max));
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
