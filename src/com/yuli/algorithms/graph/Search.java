package com.yuli.algorithms.graph;

/**
 * 描述 图搜索api
 *
 * @author yuli
 * @date 2020/8/4
 */
public interface Search {
    /**
     * 找到和起点s连同的所有起点
     * @param graph
     * @param s
     */
//    Search(UndirectedGraph graph,int s);

    /**
     * v和s是连通的么
     * @param v
     * @return
     */
    boolean marked(int v);

    /**
     * 与s连通的顶点数
     * @param v
     * @return
     */
    int count();
}
