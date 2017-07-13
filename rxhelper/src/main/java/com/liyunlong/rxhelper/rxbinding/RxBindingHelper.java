package com.liyunlong.rxhelper.rxbinding;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.CompoundButton;
import android.widget.PopupMenu;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toolbar;

import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.view.RxMenuItem;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.view.ViewScrollChangeEvent;
import com.jakewharton.rxbinding2.widget.AbsListViewScrollEvent;
import com.jakewharton.rxbinding2.widget.AdapterViewItemClickEvent;
import com.jakewharton.rxbinding2.widget.RatingBarChangeEvent;
import com.jakewharton.rxbinding2.widget.RxAbsListView;
import com.jakewharton.rxbinding2.widget.RxAdapter;
import com.jakewharton.rxbinding2.widget.RxAdapterView;
import com.jakewharton.rxbinding2.widget.RxAutoCompleteTextView;
import com.jakewharton.rxbinding2.widget.RxCompoundButton;
import com.jakewharton.rxbinding2.widget.RxPopupMenu;
import com.jakewharton.rxbinding2.widget.RxRadioGroup;
import com.jakewharton.rxbinding2.widget.RxRatingBar;
import com.jakewharton.rxbinding2.widget.RxSearchView;
import com.jakewharton.rxbinding2.widget.RxSeekBar;
import com.jakewharton.rxbinding2.widget.RxTextView;
import com.jakewharton.rxbinding2.widget.RxToolbar;
import com.jakewharton.rxbinding2.widget.SearchViewQueryTextEvent;
import com.jakewharton.rxbinding2.widget.TextViewAfterTextChangeEvent;
import com.jakewharton.rxbinding2.widget.TextViewBeforeTextChangeEvent;
import com.jakewharton.rxbinding2.widget.TextViewTextChangeEvent;
import com.liyunlong.rxhelper.rxjava.BaseObserver;
import com.liyunlong.rxhelper.rxjava.RxJavaHelper;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * RxView辅助类
 *
 * @author liyunlong
 * @date 2017/7/12 15:49
 */
public class RxBindingHelper {

    /**
     * 防抖处理，指定的跳过时间之内只取一个点击事件
     *
     * @param view         观察的View对象
     * @param skipDuration 跳过时间
     * @param unit         时间单位
     * @param observer     观察者
     */
    public static Disposable throttleFirst(@NonNull View view, long skipDuration, TimeUnit unit, BaseObserver<Object> observer) {
        Observable<Object> observable = RxView.clicks(view)
                .throttleFirst(skipDuration, unit);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * View的点击事件处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable clicks(@NonNull View view, BaseObserver<Object> observer) {
        Observable<Object> observable = RxView.clicks(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * View的长点击事件处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable longClicks(@NonNull View view, BaseObserver<Object> observer) {
        Observable<Object> observable = RxView.longClicks(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * View的焦点改变处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable focusChanges(@NonNull View view, BaseObserver<Boolean> observer) {
        InitialValueObservable<Boolean> observable = RxView.focusChanges(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * View的布局改变处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable layoutChanges(@NonNull View view, BaseObserver<Object> observer) {
        Observable<Object> observable = RxView.layoutChanges(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * 视图树的布局改变处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable globalLayouts(@NonNull View view, BaseObserver<Object> observer) {
        Observable<Object> observable = RxView.globalLayouts(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * View的滑动事件处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    @RequiresApi(api = Build.VERSION_CODES.M)
    public static Disposable scrollChangeEvents(@NonNull View view, BaseObserver<ViewScrollChangeEvent> observer) {
        Observable<ViewScrollChangeEvent> observable = RxView.scrollChangeEvents(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * TextView的Text改变过程事件处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable textChanges(@NonNull TextView view, BaseObserver<CharSequence> observer) {
        InitialValueObservable<CharSequence> observable = RxTextView.textChanges(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * TextView的Text改变过程事件处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable textChangeEvents(@NonNull TextView view, BaseObserver<TextViewTextChangeEvent> observer) {
        InitialValueObservable<TextViewTextChangeEvent> observable = RxTextView.textChangeEvents(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * TextView的Text改变之前事件处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable beforeTextChangeEvents(@NonNull TextView view, BaseObserver<TextViewBeforeTextChangeEvent> observer) {
        InitialValueObservable<TextViewBeforeTextChangeEvent> observable = RxTextView.beforeTextChangeEvents(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * TextView的Text改变之前事件处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable afterTextChangeEvents(@NonNull TextView view, BaseObserver<TextViewAfterTextChangeEvent> observer) {
        InitialValueObservable<TextViewAfterTextChangeEvent> observable = RxTextView.afterTextChangeEvents(view);
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

    /**
     * AutoCompleteTextView的下拉列表中的Item点击事件处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable itemClickEvents(@NonNull AutoCompleteTextView view, BaseObserver<AdapterViewItemClickEvent> observer) {
        Observable<AdapterViewItemClickEvent> observable = RxAutoCompleteTextView.itemClickEvents(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * 复选框选中状态改变处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable checkedChanges(@NonNull CompoundButton view, BaseObserver<Boolean> observer) {
        InitialValueObservable<Boolean> observable = RxCompoundButton.checkedChanges(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * 单选按钮组选中状态改变处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable checkedChanges(@NonNull RadioGroup view, BaseObserver<Integer> observer) {
        InitialValueObservable<Integer> observable = RxRadioGroup.checkedChanges(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * SeekBar进度改变处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable changes(@NonNull SeekBar view, BaseObserver<Integer> observer) {
        InitialValueObservable<Integer> observable = RxSeekBar.changes(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * RatingBar星型数量改变事件处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable ratingChangeEvents(@NonNull RatingBar view, BaseObserver<RatingBarChangeEvent> observer) {
        InitialValueObservable<RatingBarChangeEvent> observable = RxRatingBar.ratingChangeEvents(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * AbsListView的滑动事件处理
     *
     * @param view     观察的View对象
     * @param observer 观察者
     */
    public static Disposable scrollEvents(@NonNull AbsListView view, BaseObserver<AbsListViewScrollEvent> observer) {
        Observable<AbsListViewScrollEvent> observable = RxAbsListView.scrollEvents(view);
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
     * PopupMenu的菜单消失事件处理
     *
     * @param view     观察的PopupMenu对象
     * @param observer 观察者
     */
    public static Disposable dismisses(@NonNull PopupMenu view, BaseObserver<Object> observer) {
        Observable<Object> observable = RxPopupMenu.dismisses(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * Toolbar的菜单项点击事件处理
     *
     * @param view     观察的Toolbar对象
     * @param observer 观察者
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
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
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static Disposable navigationClicks(@NonNull Toolbar view, BaseObserver<Object> observer) {
        Observable<Object> observable = RxToolbar.navigationClicks(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * MenuItem的点击事件处理
     *
     * @param menuItem 观察的MenuItem对象
     * @param observer 观察者
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static Disposable clicks(@NonNull MenuItem menuItem, BaseObserver<Object> observer) {
        Observable<Object> observable = RxMenuItem.clicks(menuItem);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * AdapterView的Item点击事件处理
     *
     * @param view     观察的AdapterView对象
     * @param observer 观察者
     */
    public static <T extends Adapter> Disposable itemClicks(@NonNull AdapterView<T> view, BaseObserver<Integer> observer) {
        Observable<Integer> observable = RxAdapterView.itemClicks(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * AdapterView的Item长点击事件处理
     *
     * @param view     观察的AdapterView对象
     * @param observer 观察者
     */
    public static <T extends Adapter> Disposable itemLongClicks(@NonNull AdapterView<T> view, BaseObserver<Integer> observer) {
        Observable<Integer> observable = RxAdapterView.itemLongClicks(view);
        return RxJavaHelper.subscribe(observable, observer);
    }

    /**
     * Adapter的数据改变事件处理
     *
     * @param adapter  观察的Adapter对象
     * @param observer 观察者
     */
    public static <T extends Adapter> Disposable dataChanges(@NonNull T adapter, BaseObserver<T> observer) {
        InitialValueObservable<T> observable = RxAdapter.dataChanges(adapter);
        return RxJavaHelper.subscribe(observable, observer);
    }

}
