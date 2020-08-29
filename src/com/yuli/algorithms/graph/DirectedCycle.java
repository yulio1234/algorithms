package com.yuli.algorithms.graph;

import java.util.Stack;

/**
 * 描述 : 寻找有向图的环
 * 使用深度优先搜索，如果在搜索中有一条有向边v->w且w已经存在于栈中，就找到了一个环。
 * 因为栈表示w到v到有向路径，而v到w正好补全了这个环。
 *
 * @author yuli
 * @date 2020/8/8
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    /**
     * 有向环中所有顶点
     */
    private Stack<Integer> cycle;
    //递归调用的栈上的所有顶点
    private boolean[] onStack;
    public DirectedCycle(DirectedGraph graph){
        onStack = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        marked = new boolean[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            if(!marked[v]) dfs(graph,v);
        }
    }

    private void dfs(DirectedGraph graph,int v){
        //将改顶点放入栈中，表示深度优先到访问路径已经经过这个顶点了
        onStack[v] = true;
        //标记已经访问过这个顶点了
        marked[v] = true;
        //从邻接表中获取顶点指向其他顶点
        for (Integer w : graph.adj(v)) {
            //如果已经形成环了就返回
            if(this.hasCycle()) return;
            //如果还没有访问过这个顶点就继续递归访问下一个顶点
            else if(!marked[w]){
                edgeTo[w] = v;
                dfs(graph,w);
            }
            //如果顶点指向到另一个顶点已经被访问过了，就代表访问路线上已经进过了，代表有环。一条边v->w且w在栈中。
            else if(onStack[w]){
                //定义一个站，通过路径把经过到顶点放到栈中
                cycle = new Stack<>();
                for(int x = v;x != w;x = edgeTo[x])
                    cycle.push(x);
                cycle.push(w);
                cycle.push(v);
            }
            //如果递归完成也没有发现环，就回复
            onStack[v] = false;
        }
    }
    public boolean hasCycle(){
        return cycle != null;
    }
    public Iterable<Integer> cycle(){
        return cycle;
    }
}
