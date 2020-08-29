package com.yuli.algorithms.graph;

import com.yuli.algorithms.list.Bag;

/**
 * 描述 : 连通分量
 *
 * @author yuli
 * @date 2020/8/7
 */
public class CC {
    private boolean[] marked;
    //记录顶点所在的连通分量ID
    private int[] id;
    //找到的连通分量数，没发现一个连通分量就+1，也是当前连通分量的id
    private int count;
    public CC(Graph graph){
        marked = new boolean[graph.V()];
        id = new int[graph.V()];
        //循环进行深度优先搜索，直到找到所有连通分量
        for(int s = 0;s<graph.V();s++){
            //如果没有被访问过就进行搜索
            if(!marked[s]){
                dfs(graph,s);
                //没找到一个连通分量，都让连通分量加+1，也是当前连通分量的id
                count++;
            }
        }
    }
    private void dfs(Graph graph,int v){
        marked[v] = true;
        //当前节点的连通分量id
        id[v] = count;
        for (int w : graph.adj(v)) {
            if(!marked[w]){
                dfs(graph,w);
            }
        }
    }
    /**
     * v和w是否是连通的，通过比较顶点是否在一个连通分量id里
     * @param v
     * @param w
     * @return
     */
    boolean connected(int v,int w){
     return id[v]==id[w];
    }

    /**
     * 连通分量数
     * @return
     */
    int count(){
        return count;
    };

}
