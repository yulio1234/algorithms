package com.yuli.algorithms.graph;

/**
 * 描述 : 有向图
 *
 * @author yuli
 * @date 2020/8/8
 */
public class DirectedGraph extends Graph{
    public DirectedGraph(int vertex) {
        super(vertex);
    }

    @Override
    void addEdge(int v, int w) {
        adj[v].add(w);
        edge++;
    }

    /**
     * 有向图取反
     * @return
     */
    public DirectedGraph reverse(){
        DirectedGraph directedGraph = new DirectedGraph(vertex);
        for (int v = 0; v < vertex; v++) {
            //将顶点指向的顶点翻转
            for (Integer w : adj(v)) {
                directedGraph.addEdge(w,v);
            }
        }
        return directedGraph;
    }
}
