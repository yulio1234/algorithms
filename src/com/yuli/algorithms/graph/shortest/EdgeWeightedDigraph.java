package com.yuli.algorithms.graph.shortest;

import com.yuli.algorithms.list.Bag;

/**
 * 描述 :
 *
 * @author yuli
 * @date 2020/8/13
 */
public class EdgeWeightedDigraph {
    /**
     * 顶点数量
     */
    private final int vertex;
    /**
     * 边的数量
     */
    private int edge;
    /**
     * 邻接表
     */
    private Bag<DirectedEdge>[] adj;
    public EdgeWeightedDigraph(int vertex){
        this.vertex=vertex;
        this.edge = 0;
        adj = new Bag[vertex];
    }
    public int V(){
        return vertex;
    }
    public int E(){
        return edge;
    }
    public void addEdge(DirectedEdge directedEdge){
        adj[directedEdge.from()].add(directedEdge);
        edge++;
    }

    public Iterable<DirectedEdge> adj(int v){
        return adj[v];
    }
}
