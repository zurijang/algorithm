import java.util.Scanner;

public class EndofFile {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = 0;

        // hasNext() : 입력된 데이터가 있으면 true
        //             새로운 입력이 들어올 때까지 무한정 대기
        //             새로운 입력이 들어오면 true
        do {
            System.out.println(++i + " " + sc.nextLine());
        } while(sc.hasNext());

    }
}