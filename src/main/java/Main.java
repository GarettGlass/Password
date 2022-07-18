import java.io.ByteArrayOutputStream;

public class Main {
    public static void main(String[] args) {
        Password passwordGen = new Password();
        ByteArrayOutputStream password = Password.getPassword();
        System.out.println(password.toString());
    }
}
