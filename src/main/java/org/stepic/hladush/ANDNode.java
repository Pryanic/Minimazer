package org.stepic.hladush;

import java.util.*;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
public class ANDNode extends BinaryOperationsNode {
    public static final String VALUE = "AND";

    private boolean isFalseAdded;
    private Set<Node> children = new TreeSet<>(Comparator.comparing(Object::toString));
    private Set<Node> childrenWithNot = new TreeSet<>(Comparator.comparing(Object::toString));

    public ANDNode() {
        super(VALUE, 2);
    }

    @Override
    public void process(Deque<Node> operands) {
        if (operands.size() < 2) {
            throw new IllegalArgumentException("Not enough operands for operations");
        }
        add(operands.pollLast());
        add(operands.pollLast());
        if (isFalseAdded) {
            operands.add(FalseNode.getInstance());
        } else {
            operands.add(this);
        }
    }

    @Override
    public String toString() {
        if (isFalseAdded) {
            return FalseNode.VALUE;
        }
        StringBuilder sb = new StringBuilder();
        boolean firstAdded = false;
        if (children.size() == 1) {
            return children.iterator().next().toString();
        }
        for (Node child : children) {
            if (firstAdded) {
                sb.append(VALUE).append(" ");
            } else {
                firstAdded = true;
            }
            if (ORNode.VALUE.equals(child.getValue())) {
                sb.append(OpenBraceNode.VALUE);
                sb.append(child.toString());
                sb.append(CloseBraceNode.VALUE).append(" ");
            } else {
                sb.append(child.toString());
                sb.append(" ");
            }

        }

        return sb.toString().trim();
    }

    @Override
    protected void addFalseNode() {
        if (!isFalseAdded) {
            isFalseAdded = true;
            children.clear();
        }
    }

    @Override
    protected void addNotNode(NOTNode node) {
        if (children.contains(node.getSingleChild())) {
            addFalseNode();
        } else {
            childrenWithNot.add(node.getSingleChild());
            addChild(node);
        }
    }

    @Override
    protected void addAndNode(ANDNode andNode) {
        if (andNode.isFalseAdded()) {
            addFalseNode();
        } else {
            for (Node node : andNode.getChildren()) {
                if (childrenWithNot.contains(node)) {
                    addFalseNode();
                    break;
                } else {
                    children.add(node);
                }
            }

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
    protected void addTrueNode() {
        //ignored because TRUE AND value = value
    }

    @Override
    protected void addChild(Node node) {
        if (!isFalseAdded) {
            if (childrenWithNot.contains(node)) {
                addFalseNode();
            } else {
                children.add(node);
            }
        }
    }

    @Override
    public Set<Node> getChildren() {
        return Collections.unmodifiableSet(children);
    }

    private boolean isFalseAdded() {
        return isFalseAdded;
    }
}