package org.stepic.hladush;

import java.util.Deque;

/**
 * Created by ihladush on 06.05.17.
 */
public class CloseBraceNode extends BraceNode {
    public final static String VALUE = ")";
    private final static CloseBraceNode INSTANCE = new CloseBraceNode();

    private CloseBraceNode() {
        super(VALUE, Integer.MAX_VALUE);
    }

    public static CloseBraceNode getInstance() {
        return INSTANCE;
    }

    @Override
    public void calculate(Deque<Node> operands, Deque<ProcessedNode> operations) {
        ProcessedNode processedNode;
        while (!OpenBraceNode.VALUE.equals((processedNode = operations.pollLast()).getValue())) {
            processedNode.process(operands, operations);
        }
    }

    @Override
    public String toString() {
        return getValue();
    }
}
