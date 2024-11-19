import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
public class Main {

    final static int LONG_BYTE = 4;

    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int byteNum = Integer.parseInt(br.readLine());
            int count = byteNum / LONG_BYTE;
            String[] resultArray = new String[count + 1];
            String result = "";

            // 문자열 저장 부분
            int i = 0;
            for ( i = 0; i < count; i++ ) {
                resultArray[i] = "long";
            }
            resultArray[i] = "int";

            // 문자열 출력 처리, long, int 사이 띄어쓰기 깔끔하게 처리
            result = String.join(" ", resultArray);

            bw.write(result);
            bw.flush();
            bw.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
