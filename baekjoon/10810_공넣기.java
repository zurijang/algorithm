import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static String getBufferedToken(StringTokenizer st) {
        return st.hasMoreTokens() ? st.nextToken()  : "0";
    }

    public static void main(String[] args) {

        int bucketCount = 0;
        int actionCount = 0;
        String[] buckets;

        try {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st;

            st = new StringTokenizer(br.readLine());

            bucketCount = Integer.parseInt(getBufferedToken( st ));
            actionCount = Integer.parseInt(getBufferedToken( st ));
            buckets = new String[bucketCount];

            for ( int i = 0; i < actionCount; i++ ) {
                st = new StringTokenizer( br.readLine() );

                int startBucket = Integer.parseInt(getBufferedToken( st ));
                int endBucket = Integer.parseInt(getBufferedToken( st ));
                String ballNumber = getBufferedToken( st );

                for ( int j = startBucket - 1; j <= endBucket - 1; j++ ) {
                    buckets[j] = ballNumber;
                }

            }

            int index = 0;
            for ( String value : buckets ) {
                if( value == null ) {
                    buckets[index] = "0";
                }
                index++;
            }

            bw.write( String.join(" ",  buckets ) );
            bw.flush();
            bw.close();

        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

}
