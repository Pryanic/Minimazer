package org.stepic.hladush;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
//todo check for incorrect symbol
//todo check two nearest operations AND OR...
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
       if(isContainsEmptyBrace(expression)){
            return "Incorrect sequence of brace";
       }


        if(isBraceOperation(expression)){
            return "Expression contains brace around operations is incorrect";
        }

        return expression;
    }

    public static boolean isContainsEmptyBrace(String expression) {
        Pattern compile = Pattern.compile("(\\(((\\()*(\\))*)*\\))|(\\)( )*\\()");
        return compile.matcher(expression).find();
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

    public static boolean isBraceOperation(String expression){
        Pattern compile = Pattern.compile("(\\(+( )*(NOT|OR|AND)+( )*\\)+)|(\\)( )*NOT( )*\\()");
        return compile.matcher(expression).find();
    }

    public static class Node{
        private Node parent;
        private boolean isOperation;
        private String value;
        private boolean addMore=true;
        private List<Node> children=new ArrayList<>();

        public Node(Node parent, boolean isOperation, String value) {
            this.parent = parent;
            this.isOperation = isOperation;
            this.value = value;
        }
        public void addChild(Node node) {
            if (addMore) {
                if (Boolean.TRUE.toString().equals(node.getValue()) && isOperation) {

                } else if (Boolean.FALSE.toString().equals(node.getValue()) && isOperation) {

                }else{
                    children.add(node);
                }
            }
        }

        public Node getParent() {
            return parent;
        }

        public boolean isOperation() {
            return isOperation;
        }

        public String getValue() {
            return value;
        }
    }
    public static void main(String[] args) {

    }

}
