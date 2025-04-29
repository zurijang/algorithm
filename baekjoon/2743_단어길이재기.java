import java.io.*;

public class Main {
    public static void main(String[] args) {

        char[] S;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            S = br.readLine().toCharArray();
            int charSize = S.length;
            bw.write(Integer.toString(charSize));
            bw.flush();
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
