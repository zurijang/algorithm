package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    final static int MAX_HOUR = 24;
    final static Integer MAX_MINUTE = 60;

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st = new StringTokenizer(br.readLine());

            /* �Է�, ��� �� ���� �ʱ�ȭ */
            int inputHour = Integer.parseInt(st.nextToken());
            int inputMinute = Integer.parseInt(st.nextToken());

            int addMinute = Integer.parseInt(br.readLine());
            int sumMinute = inputMinute + addMinute;

            int outputHour = inputHour;
            int outputMinute = inputMinute;

            /* ��, �� ó�� */
            if ( ( sumMinute ) >= MAX_MINUTE ) {

                outputHour += sumMinute / MAX_MINUTE;
                outputMinute = sumMinute % MAX_MINUTE;

                if ( MAX_HOUR <= outputHour ) {
                    outputHour = outputHour % MAX_HOUR;
                }

            } else {
                outputMinute += addMinute;
            }

            bw.write(outputHour + " " + outputMinute);
            bw.flush();
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
