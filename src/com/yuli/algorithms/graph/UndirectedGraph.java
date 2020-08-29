package com.yuli.algorithms.graph;

/**
 * 描述：无向图
 *
 * @author yuli
 * @date 2020/8/1
 */
public class UndirectedGraph extends Graph{


    /**
     * 创建一个含有V个顶点但不包含边但图
     *
     * @param v
     */
    public UndirectedGraph(int v) {
        super(v);
    }



    /**
     * 向图中添加一条无向边边v-w
     *
     * @param v
     * @param w
     */
    @Override
    void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        edge++;
    }
}
