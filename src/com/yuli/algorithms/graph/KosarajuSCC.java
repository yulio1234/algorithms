package com.yuli.algorithms.graph;

/**
 * 描述 : 计算有向图到强连通
 *
 * @author yuli
 * @date 2020/8/8
 */
public class KosarajuSCC {
    /**
     * 已经访问过到顶点
     */
    private boolean[] marked;
    /**
     * 强连通分量到标识符
     */
    private int[] id;
    /**
     * 强连通分量的数量
     */
    private int count;
    public KosarajuSCC(DirectedGraph graph) {
        marked = new boolean[graph.V()];
        id = new int[graph.V()];
        DepthFirstOrder depthFirstOrder = new DepthFirstOrder(graph.reverse());
        for (Integer s : depthFirstOrder.reversePost()) {
            if (!marked[s]) {
                dfs(graph,s);
                count++;
            }
        }
    }

    /**
     * 深度优先搜索
     * @param graph
     * @param v
     */
    private void dfs(DirectedGraph graph,int v){
        marked[v] = true;
        id[v] = count;
        for (Integer w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph,w);
            }
        }
    }
    public boolean stronglyConnected(int v,int w){
        return id[v] == id[w];
    }
    public int id(int v){
        return id(v);
    }
    public int count(){
        return count;
    }
}
