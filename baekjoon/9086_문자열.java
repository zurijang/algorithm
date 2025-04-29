import java.io.*;

public class Main {
    public static void main(String[] args) {

        int count = 0;
        String input;
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {

            count = Integer.parseInt(br.readLine());

            for (int i = 0; i < count; i++) {
                // 반복문 안에서 객체생성 안하기
                input = br.readLine();
                // StringBuilder 를 사용해서 출력용 반복 안쓰기
                sb.append(input.charAt(0)).append(input.charAt(input.length() - 1)).append("\n");
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
