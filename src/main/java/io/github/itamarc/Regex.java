package io.github.itamarc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void findGroup() {
        String text = "abcde32[a3[t]b]cd10[xyz]3[k]";
        System.out.println("Text: " + text);
        String expr = "(\\d+)\\[";
        System.out.println("Expression: " + expr);
        Pattern p = Pattern.compile(expr);
        Matcher m = p.matcher(text);
        while(m.find()) {
            System.out.println("Found '" + m.group(1) + "' on position " + m.start());
        }
    }
}
