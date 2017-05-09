package org.stepic.hladush;

import java.util.*;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
public class ORNode extends BinaryOperationsNode {
    public static final String VALUE="OR";
    private boolean trueAdd;
    private Set<Node> children = new TreeSet<>((node1, node2) -> node1.toString().compareTo(node2.toString()));

    public ORNode() {
        super(VALUE, 1);
    }

    @Override
    public void process(Deque<Node> operands, Deque<ProcessedNode> operations) {
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
            children.add(node);
        }
    }


    protected void addAndNode(ANDNode node) {
        if(node.getChildren().size()==1){
            add(node.getChildren().iterator().next());
        }else {
            addChild(node);
        }
    }

    @Override
    protected void addFalseNode(Node node) {

    }

    @Override
    protected void addOrNode(ORNode orNode) {
        if (orNode.isTrueAdd()) {
            trueAdd = true;
            children.clear();
        } else {
            children.addAll(orNode.getChildren());
        }
    }

    @Override
    protected void addTrueNode(Node trueNode) {
        if (!trueAdd) {
            trueAdd = true;
            children.clear();
            children.add(trueNode);
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
        StringBuilder sb = new StringBuilder();
        if(children.size()==1){
            return  children.toArray()[0].toString();
        }
        boolean firstAdded=false;
        for (Node child : children) {
            if(firstAdded){
                sb.append("OR ");
            }else{
                firstAdded=true;
            }
            sb.append(child.toString());
            sb.append(" ");
        }

        return sb.toString().trim();
    }



}
