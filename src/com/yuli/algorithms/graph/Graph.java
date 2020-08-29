package com.yuli.algorithms.graph;

import com.yuli.algorithms.list.Bag;

/**
 * 描述 :图抽象类
 *
 * @author yuli
 * @date 2020/8/5
 */
public abstract class Graph {
    protected final int vertex;
    protected int edge;
    protected Bag<Integer>[] adj;

    public Graph(int vertex) {
        this.vertex = vertex;
        this.edge = 0;
        adj = new Bag[vertex];
        for (int i = 0; i < vertex; i++) {
            adj[i] = new Bag<>();
        }
    }


    /**
     * 向图中添加一条无向边边v-w
     *
     * @param v
     * @param w
     */
    abstract void addEdge(int v, int w);

    /**
     * 与顶点v相邻的所有边
     *
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v){
        return adj[v];
    }
    /**
     * 顶点数
     *
     * @return
     */
   public int V() {
        return vertex;
    }

    /**
     * 边数
     *
     * @return
     */
    public int E(){
        return edge;
    }
}
