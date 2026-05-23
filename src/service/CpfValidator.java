package service;
import java.util.regex.Pattern;

public class CpfValidator {

    public static boolean isValid(String cpf) {

        // Regular expression to match valid cpf formats
        String cpfRegex = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";

        Pattern p = Pattern.compile(cpfRegex);

        return cpf != null && p.matcher(cpf).matches();
    }
}