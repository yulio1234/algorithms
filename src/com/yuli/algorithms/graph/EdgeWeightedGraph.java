package com.yuli.algorithms.graph;

import com.yuli.algorithms.list.Bag;

/**
 * 描述 : 带权重带图
 *
 * @author yuli
 * @date 2020/8/9
 */
public class EdgeWeightedGraph {
    /**
     * 顶点的总数
     */
    private final int v;
    /**
     * 边的总数
     */
    private int e;
    /**
     * 邻接表
     */
    private Bag<Edge>[] adj;
    public EdgeWeightedGraph(int v){
        this.v = v;
        this.e = 0;
        adj = new Bag[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new Bag<>();
        }
    }

    public int V(){
        return v;
    }
    public int E(){
        return e;
    }

    public Iterable<Edge> edges(){
        Bag<Edge> edges = new Bag<>();
        for (int i = 0; i < v; i++) {
            for (Edge edge : adj(i)) {
                if (edge.other(i) < i) {
                    edges.add(edge);
                }
            }
        }
        return edges;
    }
    public void addEdge(Edge edge){
        int v = edge.either();
        int w = edge.other(v);
        adj[v].add(edge);
        adj[w].add(edge);
        e++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }
}
