package com.yuli.algorithms.graph;

import com.yuli.algorithms.heap.IndexMinPQ;

import java.util.ArrayList;

/**
 * 描述 : prim算法即时版不用将考察顶点所有边加入到优先级队列中，只需要在队列中保存这条边离最小生成树最近到顶点。
 * 在搜索图到过程中，会不断到修改与树相连顶点离树距离树最近到那个顶点。
 * 并且会根据贪心原理，将优先队列里最小到那条边加入到树中。
 *
 * @author yuli
 * @date 2020/8/10
 */
public class PrimMST {
    /**
     * 距离树最近的边
     */
    private Edge[] edgeTo;
    /**
     * 距离树最近边的边的距离
     */
    private double[] distTo;
    /**
     * 如果顶点在树中就为true
     */
    private boolean[] marked;
    /**
     * 有效的横切边
     */
    private IndexMinPQ<Double> pq;

    public PrimMST(EdgeWeightedGraph graph){
        edgeTo = new Edge[graph.V()];
        distTo = new double[graph.V()];
        marked = new boolean[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            //先将顶点的距离设置为无限遥远，表示无法访问
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        pq = new IndexMinPQ<>(graph.V());
        distTo[0] = 0.0d;
        //用顶点0和权重0初始化优先队列
        pq.insert(0,0.0d);
        if (!pq.isEmpty()) {
            visit(graph,pq.delMin());
        }
    }

    private void visit(EdgeWeightedGraph graph,int v){
        //将顶点加入到树中
        marked[v] = true;
        for (Edge edge : graph.adj(v)) {
            int w = edge.other(v);
            //另一个顶点已经在树中了，跳过
            if (marked[w]) continue;
            //如果当前边到权重，小于距离顶点最近边到权重，就替换
            if (edge.weight() < distTo[w]) {
                //替换为距离被考察顶点（不在树中）最近到边
                edgeTo[w] = edge;
                //最近边到权重
                distTo[w] = edge.weight();
                //将顶点加入到优先级队列中
                if (pq.contains(w)) {
                    //修改最近边的距离
                    pq.changeKey(w,distTo[w]);
                }else {
                    pq.insert(w,distTo[w]);
                }
            }

        }
    }

    /**
     * 返回最小生成树
     * @return
     */
    public Iterable<Edge> edges(){
        ArrayList<Edge> tree = new ArrayList<Edge>();
        for (Edge edge : edgeTo) {
            tree.add(edge);
        }
        return tree;
    }
}
