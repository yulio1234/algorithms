package com.yuli.algorithms.uf;

/**
 * 描述 :并查集
 *
 * @author yuli
 * @date 2020/8/8
 */
public class UF {
    private int[] id;
    private int count;

    public UF(int n){
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }
    public int count(){
        return count;
    }
    public boolean connected(int p,int q){
        return id[p] == id[q];
    }

}
