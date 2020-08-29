package com.yuli.algorithms.graph;

/**
 * 描述 : 是否是二分图
 *
 * @author yuli
 * @date 2020/8/8
 */
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean  isTwoColorable = true;
    public TwoColor(Graph graph){
        marked = new boolean[graph.V()];
        color = new boolean[graph.V()];
        for (int s = 0; s < graph.V(); s++) {
            if(!marked[s]){
                dfs(graph,s);
            }
        }
    }
    private void dfs(Graph graph,int v){
        marked[v] = true;
        for (Integer w : graph.adj(v)) {
            if(!marked[w]){
                color[w] = !color[v];
                dfs(graph,w);
            }
            else if(color[w] = color[v]){
                isTwoColorable = false;
            }
        }
    }
    public boolean isBipartite(){
        return isTwoColorable;
    }
}
