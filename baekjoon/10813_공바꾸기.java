import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static void switchBallInBuckets(String[] buckets, int sourceIndex, int targetIndex) {

        int bucketsSize = buckets.length;

        if ( sourceIndex < bucketsSize && targetIndex < bucketsSize ) {
            String tmp = buckets[sourceIndex];
            buckets[sourceIndex] = buckets[targetIndex];
            buckets[targetIndex] = tmp;
        }

    }

    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
            BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ));

            StringTokenizer st = new StringTokenizer( br.readLine() );

            int bucketSize = Integer.parseInt( st.nextToken() );
            int changeCount = Integer.parseInt( st.nextToken() );

            // init buckets
            String[] buckets = new String[bucketSize];
            for ( int i = 1; i <= bucketSize; i++ ) {
                buckets[i - 1] = Integer.toString(i);
            }

            // switch ball
            for ( int j = 0; j < changeCount; j++ ) {
                StringTokenizer st2 = new StringTokenizer( br.readLine() );
                int sourceIndex = Integer.parseInt( st2.nextToken() );
                int targetIndex = Integer.parseInt( st2.nextToken() );

                switchBallInBuckets( buckets, sourceIndex - 1, targetIndex - 1 );

            }

            bw.write( String.join( " ", buckets ) );
            bw.flush();
            bw.close();

        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }

}
