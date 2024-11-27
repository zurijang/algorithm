import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int getIntOfStringTokenizerToken(StringTokenizer st) {
        return st.hasMoreTokens() ? Integer.parseInt( st.nextToken() ) : 0;
    }

    private static void reverseBuecktsValue(String[] arr, int source, int target) {

        if ( source != target ) {

            int repeatCount = ((target - source) / 2);

            // source와 대칭되는 target 의 값과 스위칭
            // source target 사이즈의 절반만큼 반복
            do {
                String temp = arr[source - 1];
                arr[source - 1] = arr[target - 1];
                arr[target - 1] = temp;

                source++;
                target--;
                repeatCount--;
            } while( repeatCount >= 0);

        }

    }

    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
             BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) ); ) {

            StringTokenizer st = new StringTokenizer( br.readLine() );
            int bucketCount = getIntOfStringTokenizerToken( st );
            int repeatNumber = getIntOfStringTokenizerToken( st );

            // bucket 초기화
            String[] buckets = new String[bucketCount];
            for ( int index = 0; index < bucketCount; index ++ ) {
                buckets[index] = Integer.toString( index + 1 );
            }

            // M번 바구니 뒤집기
            for ( int count = 0; count < repeatNumber; count++ ) {
                st = new StringTokenizer( br.readLine() );
                int sourceIndex = getIntOfStringTokenizerToken( st );
                int targetIndex = getIntOfStringTokenizerToken( st );
                reverseBuecktsValue( buckets, sourceIndex, targetIndex );

            }

            bw.write( String.join(" ", buckets) );
            bw.flush();
            bw.close();

        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }
}
