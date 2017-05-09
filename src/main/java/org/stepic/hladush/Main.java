package org.stepic.hladush;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
//todo check two nearest operations AND OR...
//todo make pattern static or other class
//todo make all paterns return string and place
//todo think about chain of responsebility pattern
public class Main {

    public static String minimaize(String expression) {
        if (expression == null || expression.length() == 0) {
            return "You input empty string";
        }

        expression = simplifyAllSpaces(expression);

        if (expression.isEmpty()) {
            return "You input string which contains only spaces";
        }

        if (!isCorrectBraceSequence(expression)) {
            return "You input string contains incorrect brace sequence";
        }
        if (isContainsEmptyBrace(expression)) {
            return "Incorrect sequence of brace";
        }


        if (isBraceOperation(expression)) {
            return "Expression contains brace around operations is incorrect";
        }


        Node root = buildTree(expression);
        return root.toString();
    }


    //todo make this validator
    public static boolean isContainsEmptyBrace(String expression) {
        Pattern compile = Pattern.compile("(\\(((\\()*(\\))*)*\\))|(\\)( )*\\()");
        return compile.matcher(expression).find();
    }

    public static String simplifyAllSpaces(String expression) {
        expression = expression.trim();
        expression = expression.replaceAll("\\(( )*", "(");
        expression = expression.replaceAll("( )*\\)", ")");
        return expression.replaceAll("( )( )+", " ");
    }

    public static boolean isCorrectBraceSequence(String expression) {
        int count = 0;

        for (int i = 0; i < expression.length(); ++i) {
            if (expression.charAt(i) == '(') {
                count++;
            } else if (expression.charAt(i) == ')') {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }

    public static boolean isBraceOperation(String expression) {
        Pattern compile = Pattern.compile("(\\(+( )*(NOT|OR|AND)+( )*\\)+)|(\\)( )*NOT( )*\\()");
        return compile.matcher(expression).find();
    }

    public static Node buildTree(String expression) {
        return new NodeBuilder(expression).build();
    }

    public static void main(String[] args) {
        String a = "ab(cd";
        System.out.println(a.substring(0, 3));
    }

}
