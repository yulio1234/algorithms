package com.yuli.algorithms.graph;

/**
 * 描述: 图深度优先搜索
 *
 * @author yuli
 * @date 2020/8/4
 */
public class DepthFirstSearch implements Search{
    /**
     * 被访问过的顶点标记集合
     */
    private boolean[] marked;
    private int count;

    /**
     * 深度遍历图方法，递归
     * @param graph 图
     * @param vertex 开始顶点
     */
    public DepthFirstSearch(UndirectedGraph graph,int vertex){
        //将顶点标记为已经被访问
        marked = new boolean[graph.V()];
        dfs(graph,vertex);
    }

    /**
     * 深度遍历方法
     * @param graph 遍历的图
     * @param vertex 当前顶点下标
     */
    private void dfs(UndirectedGraph graph,int vertex){
        //标记当前顶点已经被访问
        marked[vertex] = true;
        count ++;
        //继续遍历相邻的顶点
        for (Integer v : graph.adj(vertex)) {
            //如果顶点没有被访问过，就递归访问
            if(!marked[v]){
                //递归
                dfs(graph,v);
            }
        }
    }

    @Override
    public boolean marked(int v) {
        return marked[v];
    }

    @Override
    public int count() {
        return count;
    }
}
