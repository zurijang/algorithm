import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int inputCount = Integer.parseInt( br.readLine() );
            List<Integer> inputList = new ArrayList<>();

            StringTokenizer st = new StringTokenizer( br.readLine() );
            if( st.countTokens() == inputCount ) {

                while( st.hasMoreTokens() ) {
                    inputList.add( Integer.parseInt( st.nextToken() ) );
                }

                Map<Integer, Long> resultMap = inputList.stream().collect( Collectors.groupingBy(Function.identity(), Collectors.counting() ) );

                int findKey = Integer.parseInt( br.readLine() );
                Long findCount = 0L;

                if ( resultMap.containsKey( findKey ) ) {
                    findCount = resultMap.get( findKey );
                }

                bw.write( findCount.toString() );

            }

            bw.flush();
            bw.close();

        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }

}
