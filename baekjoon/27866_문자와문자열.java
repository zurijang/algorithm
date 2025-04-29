import java.io.*;

public class Main {
    public static void main(String[] args) {

        char[] S;
        int i;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            S = br.readLine().toCharArray();
            i = Integer.parseInt(br.readLine());

            bw.write(S[i-1]);
            bw.flush();
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
