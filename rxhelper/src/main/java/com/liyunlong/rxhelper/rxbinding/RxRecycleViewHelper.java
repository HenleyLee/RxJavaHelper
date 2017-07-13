package com.liyunlong.rxhelper.rxbinding;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;

import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.support.v7.widget.RecyclerViewChildAttachStateChangeEvent;
import com.jakewharton.rxbinding2.support.v7.widget.RecyclerViewScrollEvent;
import com.jakewharton.rxbinding2.support.v7.widget.RxRecyclerView;
import com.jakewharton.rxbinding2.support.v7.widget.RxRecyclerViewAdapter;
import com.liyunlong.rxhelper.rxjava.BaseObserver;
import com.liyunlong.rxhelper.rxjava.RxJavaHelper;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * rxbinding-recyclerview辅助类
 *
 * @author liyunlong
 * @date 2017/7/12 18:49
 */
public class RxRecycleViewHelper {

    /**
     * RecyclerView的子控件连接或脱离RecycleView事件处理
     *
     * @param view     观察的RecyclerView对象
     * @param observer 观察者
     */
    public static Disposable offsetChanges(@NonNull RecyclerView view, BaseObserver<RecyclerViewChildAttachStateChangeEvent> observer) {
        Observable<RecyclerViewChildAttachStateChangeEvent> observable = RxRecyclerView.childAttachStateChangeEvents(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * RecyclerView的滑动事件处理
     *
     * @param view     观察的RecyclerView对象
     * @param observer 观察者
     */
    public static Disposable scrollEvents(@NonNull RecyclerView view, BaseObserver<RecyclerViewScrollEvent> observer) {
        Observable<RecyclerViewScrollEvent> observable = RxRecyclerView.scrollEvents(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * RecyclerView的滑动状态改变事件处理
     *
     * @param view     观察的RecyclerView对象
     * @param observer 观察者
     */
    public static Disposable scrollStateChanges(@NonNull RecyclerView view, BaseObserver<Integer> observer) {
        Observable<Integer> observable = RxRecyclerView.scrollStateChanges(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * Adapter的数据改变事件处理
     *
     * @param adapter  观察的Adapter对象
     * @param observer 观察者
     */
    public static <T extends Adapter<? extends ViewHolder>> Disposable scrollStateChanges(@NonNull T adapter, BaseObserver<T> observer) {
        InitialValueObservable<T> observable = RxRecyclerViewAdapter.dataChanges(adapter);
        return RxJavaHelper.subscribe(observable, observer);
    }

}
