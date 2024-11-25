import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    final static int STUDENT_NUMBER = 30;

    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
            BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

            int[] receiptYn = new int[STUDENT_NUMBER];

            for ( int i = 0; i < STUDENT_NUMBER; i++ ) {
                String inputValue = br.readLine();

                // readLine 에 대한 null 처리 확실하게 처리
                if (inputValue == null || inputValue.isBlank()) {
                    break;
                }

                int studentKey = Integer.parseInt( inputValue );
                receiptYn[studentKey - 1] = 1;

            }

            for ( int j = 0; j < STUDENT_NUMBER; j++ ) {
                if ( 0 == receiptYn[j] ) {
                    bw.write( ( j + 1 ) + "\n" );
                }
            }

            bw.flush();
            bw.close();

        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }
}
