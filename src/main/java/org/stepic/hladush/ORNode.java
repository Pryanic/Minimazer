package org.stepic.hladush;

import java.util.*;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
public class ORNode extends BinaryOperationsNode {
    public static final String VALUE = "OR";
    private boolean trueAdd;

    private Set<Node> children = new TreeSet<>(Comparator.comparing(Object::toString));
    private Set<Node> childrenWithNot = new TreeSet<>(Comparator.comparing(Object::toString));

    public ORNode() {
        super(VALUE, 1);
    }

    @Override
    public void process(Deque<Node> operands) {
        if (operands.size() < 2) {
            throw new IllegalArgumentException("Not enough operands for operations");
        }
        add(operands.pollLast());
        add(operands.pollLast());
        if (trueAdd) {
            operands.add(TrueNode.getInstance());
        } else {
            operands.add(this);
        }
    }


    @Override
    protected void addChild(Node node) {
        if (!trueAdd) {
            if (childrenWithNot.contains(node)) {
                addTrueNode();
            } else {
                children.add(node);
            }
        }
    }


    protected void addAndNode(ANDNode node) {
        if (node.getChildren().size() == 1) {
            add(node.getChildren().iterator().next());
        } else {
            addChild(node);
        }
    }

    @Override
    protected void addFalseNode() {
        //empty because  false OR value =value
    }

    @Override
    protected void addNotNode(NOTNode node) {
        if (children.contains(node.getSingleChild())) {
            addTrueNode();
        } else {
            childrenWithNot.add(node.getSingleChild());
            addChild(node);
        }
    }

    @Override
    protected void addOrNode(ORNode orNode) {
        if (orNode.isTrueAdd()) {
            addTrueNode();
            childrenWithNot.clear();
        } else {
            for (Node node : orNode.getChildren()) {
                if (childrenWithNot.contains(node)) {
                    addTrueNode();
                    break;
                } else {
                    children.add(node);
                }
            }

        }
    }

    @Override
    protected void addTrueNode() {
        if (!trueAdd) {
            trueAdd = true;
            children.clear();
            childrenWithNot.clear();
        }
    }

    private boolean isTrueAdd() {
        return trueAdd;
    }

    @Override
    public Set<Node> getChildren() {
        return Collections.unmodifiableSet(children);
    }

    @Override
    public String toString() {
        if (isTrueAdd()) {
            return TrueNode.VALUE;
        }
        StringBuilder sb = new StringBuilder();
        if (children.size() == 1) {
            return children.toArray()[0].toString();
        }
        boolean firstAdded = false;
        for (Node child : children) {
            if (firstAdded) {
                sb.append("OR ");
            } else {
                firstAdded = true;
            }
            sb.append(child.toString());
            sb.append(" ");
        }

        return sb.toString().trim();
    }


}
