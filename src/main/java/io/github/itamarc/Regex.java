package io.github.itamarc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static void main(String[] args) {
        findGroup();
        renameTestMethod();
    }

    private static void findGroup() {
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

    private static void renameTestMethod() {
        String name = """
        @Test
        public void testMethod(
            """;

        Pattern p = Pattern.compile("^\\s*@Test\\s*\n\\s*(.+)\\s+test(\\w)(\\w+)\\s*\\(.*");
        Matcher m = p.matcher(name);
        if (m.find()) {
            System.out.println("Found:\n@Test\n" + m.group(1) + " " + m.group(2).toLowerCase() + m.group(3) + "(");
        } else {
            System.out.println("Not found");
        }

    }
}
