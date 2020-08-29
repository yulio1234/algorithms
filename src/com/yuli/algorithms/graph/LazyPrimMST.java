package com.yuli.algorithms.graph;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 描述 :基于懒惰prim算法的最小生成树.
 * prim算法将顶点分为两个顶点集，一个最小生成树等顶点集，一个待访问等顶点集。
 * 横切边：连接两个顶点集等边。
 * 生成最小生成树的方法是通过贪心算法，每次将最小生成树横切边里最小的那条边加入到最小生成树中。让树慢慢扩展到整个图。
 * 为了保证没有环，如果两个顶点都被访问过，就跳过。
 *
 * @author yuli
 * @date 2020/8/9
 */
public class LazyPrimMST {
    /**
     * 最小生成树的顶点
     */
    private boolean[] marked;
    /**
     * 最小生成树的边
     */
    private Queue<Edge> mst;
    /**
     * 横切边的优先级队列
     */
    private PriorityQueue<Edge> pq;

    public LazyPrimMST(EdgeWeightedGraph graph){
        pq = new PriorityQueue<>();
        marked = new boolean[graph.V()];
        mst = new LinkedList<>();
        visit(graph,0);
        //遍历横切边
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int v = edge.either();
            int w = edge.other(v);
            //如果访问过就不加入，这样也不会生成环了。
            if(marked[v] && marked[w])
                continue;
            mst.add(edge);
            //把没访问过到的顶点加入到优先级队列中
            if(!marked[v])
                visit(graph,v);
            if(!marked[w])
                visit(graph,w);
        }

    }

    private void visit(EdgeWeightedGraph graph,int v){
        //标记顶点已经被访问过了
        marked[v] = true;
        //将相邻的未被标记过的顶点的横切边加入到优先级队列中
        for (Edge edge : graph.adj(v)) {
            if (!marked[edge.other(v)]) {
                pq.add(edge);
            }
        }
    }

    public Iterable<Edge> edges(){
        return mst;
    }
}
