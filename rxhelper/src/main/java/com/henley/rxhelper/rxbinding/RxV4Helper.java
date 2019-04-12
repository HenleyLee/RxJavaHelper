package com.henley.rxhelper.rxbinding;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SlidingPaneLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.MenuItem;

import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.support.v4.view.RxMenuItemCompat;
import com.jakewharton.rxbinding2.support.v4.view.RxViewPager;
import com.jakewharton.rxbinding2.support.v4.widget.RxDrawerLayout;
import com.jakewharton.rxbinding2.support.v4.widget.RxNestedScrollView;
import com.jakewharton.rxbinding2.support.v4.widget.RxSlidingPaneLayout;
import com.jakewharton.rxbinding2.support.v4.widget.RxSwipeRefreshLayout;
import com.jakewharton.rxbinding2.view.MenuItemActionViewEvent;
import com.jakewharton.rxbinding2.view.ViewScrollChangeEvent;
import com.henley.rxhelper.rxjava.BaseObserver;
import com.henley.rxhelper.rxjava.RxJavaHelper;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * rxbinding-support-v4辅助类
 *
 * @author Henley
 * @date 2017/7/12 18:07
 */
public class RxV4Helper {

    /**
     * ViewPager的页面滑动状态改变事件处理
     *
     * @param view     观察的ViewPager对象
     * @param observer 观察者
     */
    public static Disposable pageScrollStateChanges(@NonNull ViewPager view, BaseObserver<Integer> observer) {
        Observable<Integer> observable = RxViewPager.pageScrollStateChanges(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * ViewPager的页面页面被选中事件处理
     *
     * @param view     观察的ViewPager对象
     * @param observer 观察者
     */
    public static Disposable pageSelected(@NonNull ViewPager view, BaseObserver<Integer> observer) {
        Observable<Integer> observable = RxViewPager.pageSelections(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * MenuItem的视图展开或折叠事件处理
     *
     * @param menuItem 观察的MenuItem对象
     * @param observer 观察者
     */
    public static Disposable actionViewEvents(@NonNull MenuItem menuItem, BaseObserver<MenuItemActionViewEvent> observer) {
        Observable<MenuItemActionViewEvent> observable = RxMenuItemCompat.actionViewEvents(menuItem);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * DrawerLayout的视图打开或关闭事件处理
     *
     * @param view     观察的DrawerLayout对象
     * @param observer 观察者
     */
    public static Disposable drawerOpen(@NonNull DrawerLayout view, int gravity, BaseObserver<Boolean> observer) {
        InitialValueObservable<Boolean> observable = RxDrawerLayout.drawerOpen(view, gravity);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * NestedScrollView的滑动事件处理
     *
     * @param view     观察的NestedScrollView对象
     * @param observer 观察者
     */
    public static Disposable scrollChangeEvents(@NonNull NestedScrollView view, BaseObserver<ViewScrollChangeEvent> observer) {
        Observable<ViewScrollChangeEvent> observable = RxNestedScrollView.scrollChangeEvents(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * SlidingPaneLayout的打开或关闭事件处理
     *
     * @param view     观察的SlidingPaneLayout对象
     * @param observer 观察者
     */
    public static Disposable panelOpens(@NonNull SlidingPaneLayout view, BaseObserver<Boolean> observer) {
        InitialValueObservable<Boolean> observable = RxSlidingPaneLayout.panelOpens(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * SlidingPaneLayout的滑动事件处理
     *
     * @param view     观察的SlidingPaneLayout对象
     * @param observer 观察者
     */
    public static Disposable panelSlides(@NonNull SlidingPaneLayout view, BaseObserver<Float> observer) {
        Observable<Float> observable = RxSlidingPaneLayout.panelSlides(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * SwipeRefreshLayout的刷新事件处理
     *
     * @param view     观察的SwipeRefreshLayout对象
     * @param observer 观察者
     */
    public static Disposable refreshes(@NonNull SwipeRefreshLayout view, BaseObserver<Object> observer) {
        Observable<Object> observable = RxSwipeRefreshLayout.refreshes(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

}
