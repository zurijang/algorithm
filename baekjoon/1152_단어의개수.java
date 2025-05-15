import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String inputStr = br.readLine();

            StringTokenizer st = new StringTokenizer(inputStr, " ");
            int size = st.countTokens();

            bw.write(Integer.toString(size));
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
