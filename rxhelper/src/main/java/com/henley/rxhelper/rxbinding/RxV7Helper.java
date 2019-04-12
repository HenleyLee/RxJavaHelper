package com.henley.rxhelper.rxbinding;

import android.support.annotation.NonNull;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.support.v7.widget.RxActionMenuView;
import com.jakewharton.rxbinding2.support.v7.widget.RxPopupMenu;
import com.jakewharton.rxbinding2.support.v7.widget.RxSearchView;
import com.jakewharton.rxbinding2.support.v7.widget.RxToolbar;
import com.jakewharton.rxbinding2.support.v7.widget.SearchViewQueryTextEvent;
import com.henley.rxhelper.rxjava.BaseObserver;
import com.henley.rxhelper.rxjava.RxJavaHelper;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * rxbinding-appcompat-v7辅助类
 *
 * @author Henley
 * @date 2017/7/12 18:30
 */
public class RxV7Helper {

    /**
     * Toolbar的菜单项点击事件处理
     *
     * @param view     观察的Toolbar对象
     * @param observer 观察者
     */
    public static Disposable itemClicks(@NonNull Toolbar view, BaseObserver<MenuItem> observer) {
        Observable<MenuItem> observable = RxToolbar.itemClicks(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * Toolbar的导航图标点击事件处理
     *
     * @param view     观察的Toolbar对象
     * @param observer 观察者
     */
    public static Disposable navigationClicks(@NonNull Toolbar view, BaseObserver<Object> observer) {
        Observable<Object> observable = RxToolbar.navigationClicks(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * ActionMenuView的菜单项点击事件处理
     *
     * @param view     观察的ActionMenuView对象
     * @param observer 观察者
     */
    public static Disposable itemClicks(@NonNull ActionMenuView view, BaseObserver<MenuItem> observer) {
        Observable<MenuItem> observable = RxActionMenuView.itemClicks(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * PopupMenu的菜单项点击事件处理
     *
     * @param view     观察的PopupMenu对象
     * @param observer 观察者
     */
    public static Disposable itemClicks(@NonNull PopupMenu view, BaseObserver<MenuItem> observer) {
        Observable<MenuItem> observable = RxPopupMenu.itemClicks(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * SearchView的Text改变过程事件处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable queryTextChanges(@NonNull SearchView view, BaseObserver<CharSequence> observer) {
        InitialValueObservable<CharSequence> observable = RxSearchView.queryTextChanges(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * SearchView的Text改变过程事件处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable queryTextChangeEvents(@NonNull SearchView view, BaseObserver<SearchViewQueryTextEvent> observer) {
        InitialValueObservable<SearchViewQueryTextEvent> observable = RxSearchView.queryTextChangeEvents(view);
        return RxJavaHelper.subscribe(observable, observer);
    }
}
