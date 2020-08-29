package com.yuli.algorithms.graph;

import java.util.Stack;

/**
 * 描述 :基于深度优先的路径搜索
 *
 * @author yuli
 * @date 2020/8/6
 */
public class DepthFirstPaths extends Paths {


    public DepthFirstPaths(Graph graph, int s) {
        super(graph, s);
        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        //首先标记顶点已经被访问
        marked[v] = true;
        //在循环访问与顶点相邻到顶点
        for (Integer w : graph.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    @Override
    public boolean hasPathTo(int v) {
        //是否访问过顶点v
        return marked[v];
    }
}
