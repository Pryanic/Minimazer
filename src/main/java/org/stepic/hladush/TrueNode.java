package org.stepic.hladush;

/**
 * @author Ivan Gladush
 * @since 05.05.17.
 */
//todo make this singletone
public class TrueNode extends Node{
    private static TrueNode instance=new TrueNode();
    private TrueNode() {
        super(false,"TRUE");
    }
    public static Node getInstance(){
        return instance;
    }
}
