package me.xujichang.lib.common.model;

public interface IEventFilter<T> {

    void onPass(T pT);

    boolean checkFilter(T pT);
}
