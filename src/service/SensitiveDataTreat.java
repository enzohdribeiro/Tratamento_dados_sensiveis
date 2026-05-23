package service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SensitiveDataTreat {
    public static String sensitiveDataMasking(String serverLog) {

        //CPF com grupos: $1 pega os 3 primeiros digitos, $2 pega os 2 últimos
        Pattern cpfRegex = Pattern.compile("(\\d{3})\\.\\d{3}\\.\\d{3}-(\\d{2})");

        //$1 pega a primeira letra. $2 pega o restante a partir da última letra do nome.
        Pattern emailRegex = Pattern.compile("(\\w)[a-zA-Z0-9_+&*-]*(?:\\.[a-zA-Z0-9_+&*-]+)*(\\w@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7})", Pattern.CASE_INSENSITIVE);

        // CPF
        Matcher cpfMatcher = cpfRegex.matcher(serverLog);
        StringBuilder sbCpf = new StringBuilder();
        while (cpfMatcher.find()) {
            cpfMatcher.appendReplacement(sbCpf, "$1.***.***-$2");
        }
        cpfMatcher.appendTail(sbCpf);

        // Email
        Matcher emailMatcher = emailRegex.matcher(sbCpf.toString());
        StringBuilder resultadoFinal = new StringBuilder();

        while (emailMatcher.find()) {
            emailMatcher.appendReplacement(resultadoFinal, "$1*****$2");
        }
        emailMatcher.appendTail(resultadoFinal);

        return resultadoFinal.toString();
    }
}