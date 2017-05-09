package org.stepic.hladush;

import java.util.*;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
public class ANDNode extends BinaryOperationsNode {
    public static final String VALUE = "AND";

    private boolean containsFalseInChildren;
    private Set<Node> children = new TreeSet<>((node1, node2) -> node1.toString().compareTo(node2.toString()));

    public ANDNode() {
        super(VALUE, 2);
    }

    @Override
    public void process(Deque<Node> operands, Deque<ProcessedNode> operations) {
        if (operands.size() < 2) {
            throw new IllegalArgumentException("Not enough operands for operations");
        }
        add(operands.pollLast());
        add(operands.pollLast());
        if (containsFalseInChildren) {
            operands.add(FalseNode.getInstance());
        } else {
            operands.add(this);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean firstAdded = false;
        if (children.size() == 1) {
            return children.iterator().next().toString();
        }
        for (Node child : children) {
            if (firstAdded) {
                sb.append("AND ");
            } else {
                firstAdded = true;
            }
            if ("OR".equals(child.getValue())) {
                sb.append("(");
                sb.append(child.toString());
                sb.append(") ");
            } else {
                sb.append(child.toString());
                sb.append(" ");
            }

        }

        return sb.toString().trim();
    }

    @Override
    protected void addFalseNode(Node falseNode) {
        if (!containsFalseInChildren) {
            containsFalseInChildren = true;
            children.clear();
            children.add(falseNode);
        }
    }

    @Override
    protected void addAndNode(ANDNode andNode) {
        if (andNode.isContainsFalseInChildren()) {
            containsFalseInChildren = true;
            children.clear();
        } else {
            children.addAll(andNode.getChildren());
        }
    }

    @Override
    protected void addOrNode(ORNode node) {
        if (node.getChildren().size() == 1) {
            add(node.getChildren().iterator().next());
        } else {
            addChild(node);
        }
    }

    @Override
    protected void addTrueNode(Node node) {
        //ignored because TRUE AND value = value
    }

    @Override
    protected void addChild(Node node) {
        if (!containsFalseInChildren) {
            children.add(node);

        }
    }

    @Override
    public Set<Node> getChildren() {
        return Collections.unmodifiableSet(children);
    }

    private boolean isContainsFalseInChildren() {
        return containsFalseInChildren;
    }
}