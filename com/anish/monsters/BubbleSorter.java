package com.anish.monsters;

import java.util.ArrayList;

public class BubbleSorter<T extends Comparable<T>> implements Sorter<T> {

    private ArrayList<T>  a = new ArrayList<>();

    @Override
    public void load(T[] a) {
        for(T t: a){
            this.a.add(t);
        }
    }
    @Override
    public void load(T[][] a) {
        for(T[] t1: a){
            for(T t2: t1)
                this.a.add(t2);
        }
    }

    private void swap(int i, int j) {
        T temp;
        temp = a.get(i);
        a.set(i,a.get(j));
        a.set(j,temp);
        plan += "" + a.get(i) + "<->" + a.get(j) + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < a.size() - 1; i++) {
                if (a.get(i).compareTo(a.get(i + 1)) > 0) {
                    swap(i, i + 1);
                    sorted = false;
                }
            }
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}