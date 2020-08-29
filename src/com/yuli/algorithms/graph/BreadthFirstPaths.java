package com.yuli.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 描述 :广度优先搜索算法实现到路径查找
 *
 * @author yuli
 * @date 2020/8/6
 */
public class BreadthFirstPaths extends Paths{
    public BreadthFirstPaths(Graph graph, int s) {
        super(graph, s);

    }

    private void bfs(Graph graph,int s){
        Queue<Integer> queue = new LinkedList<>();
        //标记起点
        marked[s] = true;
        while (!queue.isEmpty()) {
            //从队列中删去下一个顶点
            Integer v = queue.poll();
            for (Integer w : graph.adj(v)) {
                //访问每个未被标记到相邻顶点
                if (!marked[w]) {
                    //保存最短路径到最后一条边
                    edgeTo[w] = v;
                    //标记它，因为最短路径已知
                    marked[w] = true;
                    //加入到队列中
                    queue.add(w);
                }
            }
        }

    }


}
