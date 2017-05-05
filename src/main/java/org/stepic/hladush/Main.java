package org.stepic.hladush;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
public class Main {

    public static String minimaize(String expression) {
        if (expression.length() == 0) {
            return "You input empty string";
        }

        expression = simplifyAllSpaces(expression);

        if (expression.length() == 1 && expression.charAt(0) == ' ') {
            return "You input string which contains only spaces";
        }

        if (!isCorrectBraceSequence(expression)) {
            return "You input string contains incorrect brace sequence";
        }
        expression = removeAllEmptyBrace(expression);

        if (expression.length() == 0) {
            return "You input empty string";
        }
        expression = removeBracesWhichContainsSingleOperand(expression);
        return expression;
    }

    public static String removeBracesWhichContainsSingleOperand(String expression) {
        Pattern patter = Pattern.compile("(\\(((NOT )*(([a-z]+)|(TRUE)+|(FALSE)+)\\)))");
        Matcher matcher = patter.matcher(expression);
        while (matcher.find()) {
            String groupWithBrace = matcher.group(0);
            String groupWithoutBrace = matcher.group(2);
            expression=expression.replace(groupWithBrace, groupWithoutBrace);
        }

        return expression;
    }

    public static String removeAllEmptyBrace(String expression) {
        return expression.replaceAll("\\(((\\()*(\\))*)*\\)", "");
    }

    public static String simplifyAllSpaces(String expression) {
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

    public static void main(String[] args) {

    }

}
