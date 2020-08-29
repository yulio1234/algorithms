package com.yuli.algorithms.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 描述 :
 *
 * @author yuli
 * @date 2020/8/8
 */
public class SymbolGraph {
    /**
     * 符号名->索引
     */
    private Map<String,Integer> st;
    /**
     * 索引->符号名
     */
    private String [] keys;
    //图
    private Graph graph;

    public SymbolGraph(String stream,String sp){
        st = new HashMap<>();

    }
}
