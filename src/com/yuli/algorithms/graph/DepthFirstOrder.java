package com.yuli.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 描述 : 有向图中基于深度优先搜索到顶点排序
 *
 * @author yuli
 * @date 2020/8/8
 */
public class DepthFirstOrder {
    private boolean[] marked;
    /**
     * 所有顶点到的序排序
     */
    private Queue<Integer> pre;
    /**
     * 所有顶点的后序排序
     */
    private Queue<Integer> post;
    /**
     * 所有顶点的逆后序排序
     */
    private Stack<Integer> reversePost;
    public DepthFirstOrder(DirectedGraph graph){
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();
        marked = new boolean[graph.V()];
        for (int v = 0; v < graph.V(); v++) {
            if(!marked[v]);
            dfs(graph,v);
        }
    }

    private void dfs(DirectedGraph graph,int v){
        pre.add(v);
        marked[v] = true;
        for (Integer w : graph.adj(v)) {
            if(!marked[w])
                dfs(graph,w);
        }
        post.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }
    public Iterable<Integer> post(){
        return post;
    }
    public  Iterable<Integer> reversePost(){
        return reversePost;
    }
}

