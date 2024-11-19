import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int inputCount = Integer.parseInt( br.readLine() );

            StringTokenizer st = new StringTokenizer( br.readLine() );
            if( st.countTokens() == inputCount ) {

                int[] inputList = new int[inputCount];

                for( int i = 0; i < inputCount; i++ ) {
                    inputList[i] = Integer.parseInt( st.nextToken() );
                }

                int findKey = Integer.parseInt( br.readLine() );
                int findCount = 0;

                for ( int value : inputList ) {
                    if ( value == findKey ) {
                        findCount++;
                    }
                }

                bw.write( Integer.toString( findCount ) );

            }

            bw.flush();
            bw.close();

        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

}
