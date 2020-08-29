package com.yuli.algorithms.graph;

/**
 * 描述 : 检测是否存在环
 *
 * @author yuli
 * @date 2020/8/8
 */
public class Cycle {
    private boolean[] marked;
    private boolean hashCycle;
    public Cycle(Graph graph){
        marked = new boolean[graph.V()];
        for (int i = 0; i < graph.V(); i++) {
            if(!marked[i]){
                dfs(graph,i,i);
            }
        }
    }

    /**
     *
     * @param graph
     * @param v 当前遍历的顶点
     * @param u
     */
    private void dfs(Graph graph,int v ,int u){
        marked[v] = true;
        for (Integer w : graph.adj(v)) {
            if(!marked[w]){
                dfs(graph,w,v);
            }else if(w != u){
                hashCycle = true;
            }
        }
    }
    public boolean hasCycle(){
        return hashCycle;
    }
}
