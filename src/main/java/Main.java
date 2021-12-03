import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Scanner;
import java.util.regex.Pattern;


public class Main {

    static final int MIN_LENGTH = 8;
    static final String[] badPasswords = {
            "passwort", "123456", "123456789", "12345", "qwerty", "password", "12345678", "111111",
            "123123", "1234567890", "1234567", "qwerty123", "000000", "1q2w3e", "aa12345678", "abc123", "password1",
            "1234", "qwertyuiop", "123321", "password123", "1q2w3e4r5t", "iloveyou", "654321", "666666", "987654321",
            "123456a", "qwe123", "1q2w3e4r", "7777777", "1qaz2wsx", "123qwe", "zxcvbnm", "121212", "asdasd", "a123456",
            "555555", "dragon", "112233", "123123123", "monkey", "11111111", "qazwsx", "159753", "asdfghjkl", "222222",
            "1234qwer", "qwerty1", "123654", "123abc", "asdfgh", "777777", "aaaaaa", "myspace1", "3 Hours", "88888888",
            "fuckyou", "123456789a", "999999", "888888", "football", "princess", "789456123", "147258369", "1111111",
            "sunshine", "michael", "computer", "qwer1234", "daniel", "789456", "11111", "abcd1234", "q1w2e3r4",
            "shadow", "159357", "123456q", "1111", "samsung", "killer", "asd123", "superman", "master", "12345a",
            "azerty", "zxcvbn", "qazwsxedc", "131313", "ashley", "2 Minutes", "target123", "987654", "baseball",
            "qwert", "asdasd123", "qwerty", "soccer", "charlie", "qweasdzxc", "tinkle", "2 Minutes", "jessica",
            "q1w2e3r4t5", "asdf", "test1", "1g2w3e4r", "3 Hours", "gwerty123", "3 Hours", "zag12wsx", "1 Hour",
            "gwerty", "147258", "12341234", "qweqwe", "jordan", "pokemon", "q1w2e3r4t5y6", "12345678910", "1111111111",
            "12344321", "thomas", "love", "12qwaszx", "102030", "welcome", "liverpool", "iloveyou1", "michelle",
            "3 Hours", "101010", "1234561", "hello", "andrew", "2 Minutes", "a123456789", "a12345", "Status",
            "fuckyou1", "1qaz2wsx3edc", "hunter", "princess1", "naruto", "justin", "2 Minutes", "jennifer",
            "2 Hours", "qwerty12", "qweasd", "anthony", "17 Minutes", "andrea", "2 Minutes", "joshua", "2 Minutes",
            "asdf1234", "12345qwert", "1qazxsw2", "marina", "love123", "111222", "robert", "10203", "nicole",
            "2 Minutes", "letmein", "football1", "secret", "1234554321", "freedom", "michael1", "11223344", "qqqqqq",
            "123654789", "chocolate", "12345q", "internet", "q1w2e3", "google", "starwars", "mynoob", "2 Minutes",
            "qwertyui", "55555", "qwertyu", "lol123", "lovely", "monkey1", "nikita", "pakistan", "7758521", "4 Minutes",
            "87654321", "147852", "jordan23", "212121", "123789", "147852369", "123456789q", "qwe", "forever",
            "741852963", "123qweasd", "123456abc", "1q2w3e4r5t6y", "qazxsw", "456789", "232323", "999999999",
            "qwerty12345", "qwaszx", "1234567891", "456123", "444444", "qq123456", "xxx"
    };


    public static String renameBoolean(boolean status) {
        return status ? "Yes" : "No";
    }

    public static boolean checkForBadPassword(String password) {
        for (String x : badPasswords) {
            if (x.equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static boolean validateLength(String password) {
        return password.length() >= MIN_LENGTH;
    }

    public static boolean hasNumbers(String password) {
        return password.matches(".*\\d.*");
    }

    public static boolean hasLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    public static boolean hasUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    public static boolean hasSpecialChar(String password) {
        Pattern specialChar = Pattern.compile("[^a-zA-Z0-9]");
//        pattern.matcher(password).find();
        return specialChar.matcher(password).find();
    }

    public static String encodePassword(String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String split = "\\$2a\\$10\\$";
        String encodedPassword;
        do {
            encodedPassword = encoder.encode(password);
        } while(!checkPassword(encodedPassword.split(split)[1]));
        return encodedPassword.split(split)[1];
    }

    public static boolean checkPassword(String password) {
        return validateLength(password) && hasNumbers(password) && hasLowerCase(password) && hasUpperCase(password)
                && hasSpecialChar(password);
    }

    public static void validatePassword(String password) {
        if (!checkForBadPassword(password)) {
            System.out.println("Password Long Enough: " + renameBoolean(validateLength(password)));
            System.out.println("Has numbers: " + renameBoolean(hasNumbers(password)));
            System.out.println("Has lower case: " + renameBoolean(hasLowerCase(password)));
            System.out.println("Has upper case: " + renameBoolean(hasUpperCase(password)));
            System.out.println("Has special character: " + renameBoolean(hasSpecialChar(password)));
        } else {
            System.out.println("Found given password in list of bad passwords\n" +
                    "Please use another password");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;
        boolean continueValidate = true;

        while (continueValidate) {
            String contInput;

            System.out.print("Enter Password: ");
            password = scanner.nextLine();
            validatePassword(password);

            System.out.println("Encrypted password: " + encodePassword(password));

            System.out.print("Continue (y|n)?: ");
            contInput = scanner.nextLine();
            continueValidate = contInput.equals("y");
            System.out.println();

        }

    }

}
