import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class Result {

    public static String getDay(Calendar calendar) {

        String day_of_week;

        switch(calendar.get(Calendar.DAY_OF_WEEK)) {
            case 1:
                day_of_week = "SUNDAY";
                break;
            case 2:
                day_of_week = "MONDAY";
                break;
            case 3:
                day_of_week = "TUESDAY";
                break;
            case 4:
                day_of_week = "WEDNESDAY";
                break;
            case 5:
                day_of_week = "THURSDAY";
                break;
            case 6:
                day_of_week = "FRIDAY";
                break;
            case 7:
                day_of_week = "SATURDAY";
                break;
            default:
                day_of_week = "ERROR";
                break;
        }

        return day_of_week;
    }

    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();

        try {
            // 날짜 형식지정을 위해 입력받은 int 값들을 toString() 메서드를 활용해 문자열로 만들어줌
            // yyyy-MM-dd 형식으로 지정하여 setTime 메서드로 calendar 인스턴스에 날짜 적용
            String date = year + "-" + month + "-" + day;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date nDate = dateFormat.parse(date);

            calendar.setTime(nDate);

//            System.out.println(calendar.get(Calendar.YEAR));
//            System.out.println(calendar.get(calendar.MONTH));
//            System.out.println(calendar.get(calendar.DATE));
//            System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return getDay(calendar);
    }
}

public class DateandTime {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);
        int day = Integer.parseInt(firstMultipleInput[1]);
        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        //bufferedWriter.write(res);
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}
