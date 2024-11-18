import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        try {

            BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
            BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ));

            StringTokenizer st = new StringTokenizer( br.readLine() );

            int resultMoney = 0;
            List<Integer> dices = new ArrayList<>();

            while ( st.hasMoreTokens() ) {
                dices.add( Integer.parseInt( st.nextToken() ) );
            }

            Map<Integer, Long> kindOfDice = dices.stream().collect( Collectors.groupingBy(e -> e, Collectors.counting() ) );

            int sizeOfDices = kindOfDice.size();

            // 3�� ���� �Է¹޴´� �������� ��, �ߺ��� �߻��ϴ� ����� �� 3����
            if ( 1 == sizeOfDices ) {
                for ( Integer key : kindOfDice.keySet() ) {
                    resultMoney = 10000 + ( key * 1000 );
                }
            } else if ( 2 == sizeOfDices ) {
                for ( Integer key : kindOfDice.keySet() ) {
                    if ( kindOfDice.get( key ) == 2 ) {
                        resultMoney = 1000 + ( key * 100 );
                    }
                }
            } else {
                // �ִ밪 ã��
                int maxKey = 0;

                for ( Integer key : kindOfDice.keySet() ) {
                    if ( maxKey < key ) {
                        maxKey = key;
                        resultMoney = key * 100;
                    }
                }
            }

            bw.write( Integer.toString( resultMoney ) );
            bw.flush();
            bw.close();

        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }
}
