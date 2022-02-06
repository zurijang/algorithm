import java.security.Permission;
import java.util.Scanner;

public class IntToString {

    public static void main(String[] args) {

        DoNotTerminate.forbidExit();

        try {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.close();

            String s = Integer.toString(n);

            if (n == Integer.parseInt(s)) {
                System.out.println("Good Job");
            } else {
                System.out.println("Wrong answer.");
            }
        } catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }

}

// exit(0) 코드 종료 방지
// exit(0) EXIT_SUCCESS : 정상종료
// exit(1) EXIT_FAILURE : 에러메시지 종료
class DoNotTerminate {

    public static class ExitTrappedException extends SecurityException {
        private static final long serialVersionUID = 1;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}

