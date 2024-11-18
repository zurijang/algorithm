import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static class Item {


        private int price;
        private int count;

        public Item ( int price, int count ) {
            this.price = price;
            this.count = count;
        }

        private int getTotalPrice() {
            return price * count;
        }

    }

    public static void main(String[] args) {

        int totalPrice = 0;
        int totalItemCount = 0;
        int repeatCount = 0;

        try {

            BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
            BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );

            totalPrice = Integer.parseInt( br.readLine() );
            totalItemCount = Integer.parseInt( br.readLine() );
            int validatePrice = totalPrice;
            String correctYn = "No";

            while ( repeatCount < totalItemCount ) {

                StringTokenizer st = new StringTokenizer( br.readLine() );
                Item item = new Item( Integer.parseInt( st.nextToken() ), Integer.parseInt( st.nextToken() ) );

                validatePrice = validatePrice - item.getTotalPrice();

                repeatCount++;

            }

            if ( validatePrice == 0 ) {
                correctYn = "Yes";
            }

            bw.write( correctYn );
            bw.flush();
            bw.close();


        } catch ( Exception e ) {
            e.printStackTrace();
        }

    }
}
