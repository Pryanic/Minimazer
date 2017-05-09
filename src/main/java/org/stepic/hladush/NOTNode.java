package org.stepic.hladush;

import java.util.Collections;
import java.util.Deque;
import java.util.Set;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
//todo Overloading for TRUE,FALSE and operations Node
public class NOTNode extends UnaryOperationsNode {
    public static final String VALUE = "NOT";
    private String stringValue;
    private Node state;
    private Node child;

    public NOTNode() {
        super(VALUE, 3);
    }

    @Override
    public void process(Deque<Node> operands) {
        if (operands.isEmpty()) {
            throw new IllegalStateException("Not correct State");
        }
        add(operands.pollLast());
        operands.add(state);
    }

    @Override
    public void calculate(Deque<Node> operands, Deque<ProcessedNode> operations) {

        if (!operations.isEmpty()
                && operations.peekLast().getPriority() >= this.getPriority()) {
            operations.pollLast();
        } else {
            operations.add(this);
        }
    }

    @Override
    public Set<Node> getChildren() {
        return Collections.singleton(state);
    }

    @Override
    public String toString() {
        if (stringValue == null) {
            StringBuilder sb = new StringBuilder(VALUE);
            sb.append("(");
            sb.append(child.toString());
            sb.append(")");
            stringValue = sb.toString();
        }
        return stringValue;
    }

    @Override
    protected void addOrNode(ORNode node) {
        ANDNode newRootNode = new ANDNode();
        for (Node childe : node.getChildren()) {
            NOTNode notNode = new NOTNode();
            notNode.add(childe);
            newRootNode.add(notNode);
        }
        state = newRootNode;

    }

    @Override
    protected void addTrueNode() {
        state = FalseNode.getInstance();
    }

    @Override
    protected void addChild(Node node) {
        child = node;
        state = this;
    }

    @Override
    protected void addAndNode(ANDNode node) {
        ORNode newRootNode = new ORNode();
        for (Node childe : node.getChildren()) {
            NOTNode notNode = new NOTNode();
            notNode.add(childe);
            newRootNode.add(notNode);
        }
        state = newRootNode;

    }

    @Override
    protected void addFalseNode() {
        state = TrueNode.getInstance();
    }

    @Override
    protected void addNotNode(NOTNode node) {
        state = node.getChildren().iterator().next();
    }


    @Override
    public Node getSingleChild() {
        return child;
    }
}
