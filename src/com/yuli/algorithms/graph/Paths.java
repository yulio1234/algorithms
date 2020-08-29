package com.yuli.algorithms.graph;

import java.util.Stack;

/**
 * 描述 :路径接口
 *
 * @author yuli
 * @date 2020/8/6
 */
public abstract class Paths {
    /**
     * 标记这个顶点是否访问过了
     */
    protected boolean[] marked;
    /**
     * 从起点到一个顶点到已知路径上最后一个顶点
     * 标记每个与s连通到顶点回到s到路径
     */
    protected int[] edgeTo;
    /**
     * 起点
     */
    protected final int s;


    public Paths(Graph graph,int s) {
        this.s = s;
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
    }
    /**
     * 是否包含到v到路径
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }
    /**
     * edgeTo[] 保存到是从图转换到树的边集，代表访问路径。
     * 要找到v到s到路径，就从s访问父节点，直到找到s
     * @param v
     * @return
     */
    public Iterable<Integer> pathTo(int v) {
        boolean hasPathTo = hasPathTo(v);
        if(hasPathTo)return null;
        Stack<Integer> path = new Stack<>();
        for (int x= v;x !=s;x = edgeTo[x])
            path.push(x);
        path.push(s);
        return path;
    }
}
