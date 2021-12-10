package io.github.itamarc;

public class Strings {
    private static String str = "abcde5fghij";
    public static void main(String[] args) {
        manipStrings();
        manipStrBuf();
        manipChars();
        substrings();
    }

    public static void manipStrings() {
        System.out.println("String: " + str);
        System.out.println("charAt(0): " + str.charAt(0));
        System.out.println("charAt(str.length()-1): " + str.charAt(str.length()-1));
    }

    public static void manipStrBuf() {
        StringBuffer buff = new StringBuffer("Init... ");
        buff.append("middle... ");
        buff.append(123).append("...end.");
        System.out.println(buff.toString());
    }

    private static void manipChars() {
        char ch = str.charAt(4);
        System.out.println("Is char '"+ch+"' a digit? "+Character.isDigit(ch));
        ch = str.charAt(5);
        System.out.println("Is char '"+ch+"' a digit? "+Character.isDigit(ch));
        try {
            ch = str.charAt(-1);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException: "+e.getMessage());
        }

        String str2 = "abcde";
        char[] arr = str2.toCharArray();
        arr[2] = 'x';
        System.out.println("String from char array: "+String.valueOf(arr));
    }

    private static void substrings() {
        String str = "abcde5fghij";
        int b = str.indexOf('b');
        int e = str.indexOf('e');
        System.out.println("String: "+str);
        System.out.println("Substring from "+b+" to "+e+": "+str.substring(b, e)); // beginIndex is INCLUSVE, endIndex is EXCLUSIVE
        System.out.println("Substring from "+e+" to end: "+str.substring(e));
        System.out.println("Substring from start to "+e+": "+str.substring(0, e));
    }
}
