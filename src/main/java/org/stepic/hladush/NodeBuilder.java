package org.stepic.hladush;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by ihladush on 06.05.17.
 */
public class NodeBuilder {
    private String expression;
    private int currentPosition;
    private Deque<ProcessedNode> operations = new LinkedList<>();
    private Deque<Node> operands = new LinkedList<>();

    public NodeBuilder(String expression) {
        this.currentPosition = 0;
        this.expression = expression;
    }

    public Node build() {
        while (currentPosition < expression.length()) {
            String lecsem = getNextLecsem();
            Node node = NodeFactory.createNode(lecsem);
            node.calculate(operands, operations);
        }
        while (!operations.isEmpty()) {
            operations.pollLast().process(operands, operations);
        }
        if (operands.size() > 1) {
            throw new IllegalArgumentException("Incorrect state");
        }
        return operands.poll();
    }

    private String getNextLecsem() {

        while (expression.charAt(currentPosition) == ' ') {
            currentPosition++;
        }
        int startPosition = currentPosition;
        while (currentPosition < expression.length() &&
                expression.charAt(currentPosition) != ' ' &&
                expression.charAt(currentPosition) != '(' &&
                expression.charAt(currentPosition) != ')') {
            currentPosition++;
        }
        if (currentPosition == startPosition) {
            currentPosition++;
        }
        return expression.substring(startPosition, currentPosition);
    }
}
