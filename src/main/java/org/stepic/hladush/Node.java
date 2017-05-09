package org.stepic.hladush;


import java.util.Deque;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
public abstract class Node {
    private String value;
    private int priority = 0;

    public Node(String value) {
        this(value, 0);
    }

    public Node(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }


    public String getValue() {
        return value;
    }

    public int getPriority() {
        return priority;
    }

    public abstract void calculate(Deque<Node> operands, Deque<ProcessedNode> operations);


}
