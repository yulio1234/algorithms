package com.yuli.algorithms.graph.shortest;

/**
 * 描述 : 加权有向边
 *
 * @author yuli
 * @date 2020/8/13
 */
public class DirectedEdge {
    /**
     * 边的起点
     */
    private final int v;
    /**
     * 边的重点
     */
    private final int w;
    /**
     * 边的权重
     */
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight(){
        return weight;
    }
    public int from(){
        return v;
    }
    public int to(){
        return w;
    }
}
