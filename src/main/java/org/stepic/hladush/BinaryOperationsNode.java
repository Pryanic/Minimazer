package org.stepic.hladush;

import java.util.Deque;

/**
 * Created by ihladush on 08.05.17.
 */
public abstract class BinaryOperationsNode extends OperationsNode {
    public BinaryOperationsNode(String value, int priority) {
        super(value, priority);
    }

    @Override
    public void calculate(Deque<Node> operands, Deque<ProcessedNode> operations) {
        if (operations.isEmpty()) {
            operations.add(this);
        } else {
            while (!operations.isEmpty()
                    && operations.peekLast().getPriority() >= this.getPriority()) {
                operations.pollLast().process(operands, operations);
            }
            operations.add(this);
        }

    }
}
