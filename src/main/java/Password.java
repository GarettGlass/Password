import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Генератор паролей
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
*/
public class Password {
    static List<Character> list = new ArrayList<>();
    static List<Character> list1 = new ArrayList<>();
    static List<Character> list2 = new ArrayList<Character>();

    static {
        for (char i = 'a'; i <= 'z'; i++) {
            list.add(i);
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            list1.add(i);
        }
        for (char i = '0'; i <= '9'; i++) {
            list2.add(i);
        }
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Collections.shuffle(list);
        Collections.shuffle(list1);
        Collections.shuffle(list2);
        List<Character> forOut = new ArrayList<>();
        forOut.add(list.get(1));
        forOut.add(list2.get(2));
        forOut.add(list1.get(3));
        int lengthPassword = 5;
        while (lengthPassword > 0) {
            int i = 1 + (int) (Math.random() * 3);
            switch (i) {
                case 1:
                    forOut.add(list.get((int) (Math.random() * 25)));
                    break;
                case 2:
                    forOut.add(list1.get((int) (Math.random() * 25)));
                    break;
                case 3:
                    forOut.add(list2.get((int) (Math.random() * 9)));
                    break;
            }
            lengthPassword--;
        }
        Collections.shuffle(forOut);
        forOut.forEach(byteArrayOutputStream::write);
        return byteArrayOutputStream;
    }
}
