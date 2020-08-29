package com.yuli.algorithms.graph;

/**
 * 描述 :拓扑排序
 *
 * @author yuli
 * @date 2020/8/8
 */
public class Topological {
    /**
     * 顶点的拓扑顺序
     */
    private Iterable<Integer> order;
    public Topological(DirectedGraph graph){
        DirectedCycle directedCycle = new DirectedCycle(graph);
        if (!directedCycle.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(graph);
            order = dfs.reversePost();
        }
    }
    public Iterable<Integer> order(){
        return order;
    }
    public boolean isDAG(){
        return order != null;
    }
}
