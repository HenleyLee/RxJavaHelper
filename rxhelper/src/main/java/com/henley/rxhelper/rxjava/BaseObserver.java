package com.henley.rxhelper.rxjava;

import java.util.concurrent.atomic.AtomicReference;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * 基于Observable的观察者基类
 *
 * @author Henley
 * @date 2017/5/24 17:51
 */
public class BaseObserver<T> extends AtomicReference<Disposable> implements Observer<T>, Disposable {

    @Override
    public void onSubscribe(@NonNull Disposable disposable) {

    }

    @Override
    public void onNext(@NonNull T t) {

    }

    @Override
    public void onError(@NonNull Throwable throwable) {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override
    public boolean isDisposed() {
        return this.get() == DisposableHelper.DISPOSED;
    }
}
