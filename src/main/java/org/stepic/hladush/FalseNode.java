package org.stepic.hladush;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
public class FalseNode extends Node {
    private static FalseNode instance=new FalseNode();
    private FalseNode() {
        super(false, "FALSE");
    }
    public static Node getInstance(){
        return instance;
    }
}
