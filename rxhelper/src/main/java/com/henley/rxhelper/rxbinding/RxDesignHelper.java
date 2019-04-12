package com.henley.rxhelper.rxbinding;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.design.widget.TabLayout;
import android.view.MenuItem;
import android.view.View;

import com.jakewharton.rxbinding2.support.design.widget.RxAppBarLayout;
import com.jakewharton.rxbinding2.support.design.widget.RxBottomNavigationView;
import com.jakewharton.rxbinding2.support.design.widget.RxNavigationView;
import com.jakewharton.rxbinding2.support.design.widget.RxSnackbar;
import com.jakewharton.rxbinding2.support.design.widget.RxSwipeDismissBehavior;
import com.jakewharton.rxbinding2.support.design.widget.RxTabLayout;
import com.henley.rxhelper.rxjava.BaseObserver;
import com.henley.rxhelper.rxjava.RxJavaHelper;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * rxbinding-design辅助类
 *
 * @author Henley
 * @date 2017/7/12 18:37
 */
public class RxDesignHelper {

    /**
     * AppBarLayout的垂直方向偏移量改变事件处理
     *
     * @param view     观察的AppBarLayout对象
     * @param observer 观察者
     */
    public static Disposable offsetChanges(@NonNull AppBarLayout view, BaseObserver<Integer> observer) {
        Observable<Integer> observable = RxAppBarLayout.offsetChanges(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * BottomNavigationView的导航菜单项选中事件处理
     *
     * @param view     观察的BottomNavigationView对象
     * @param observer 观察者
     */
    public static Disposable itemSelections(@NonNull BottomNavigationView view, BaseObserver<MenuItem> observer) {
        Observable<MenuItem> observable = RxBottomNavigationView.itemSelections(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * NavigationView的菜单项选中事件处理
     *
     * @param view     观察的NavigationView对象
     * @param observer 观察者
     */
    public static Disposable itemSelections(@NonNull NavigationView view, BaseObserver<MenuItem> observer) {
        Observable<MenuItem> observable = RxNavigationView.itemSelections(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * Snackbar的消失事件处理
     *
     * @param view     观察的Snackbar对象
     * @param observer 观察者
     */
    public static Disposable dismisses(@NonNull Snackbar view, BaseObserver<Integer> observer) {
        Observable<Integer> observable = RxSnackbar.dismisses(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * View在{@link SwipeDismissBehavior}中的消失事件处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable dismisses(@NonNull View view, BaseObserver<View> observer) {
        Observable<View> observable = RxSwipeDismissBehavior.dismisses(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * TabLayout的标签选中事件处理
     *
     * @param view     观察的TabLayout对象
     * @param observer 观察者
     */
    public static Disposable selections(@NonNull TabLayout view, BaseObserver<TabLayout.Tab> observer) {
        Observable<TabLayout.Tab> observable = RxTabLayout.selections(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

}
