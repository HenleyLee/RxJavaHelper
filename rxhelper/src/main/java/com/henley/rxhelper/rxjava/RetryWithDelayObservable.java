package com.henley.rxhelper.rxjava;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * RxJava重试机制
 *
 * @author Henley
 * @date 2017/7/5 15:52
 */
public class RetryWithDelayObservable implements Function<Observable<? extends Throwable>, ObservableSource<?>> {

    private static final String TAG = "RetryWithDelayObservable";
    private int retryCount;
    private int maxRetryCount;
    private int retryDelayMillis;

    /**
     * 构造方法
     *
     * @param maxRetryCount    最大重试次数
     * @param retryDelayMillis 重试延迟时间
     */
    public RetryWithDelayObservable(int maxRetryCount, int retryDelayMillis) {
        this.maxRetryCount = maxRetryCount;
        this.retryDelayMillis = retryDelayMillis;
    }

    @Override
    public ObservableSource<?> apply(@NonNull Observable<? extends Throwable> observable) throws Exception {
        return observable.flatMap(new Function<Throwable, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(@NonNull Throwable throwable) throws Exception {
                if (++retryCount <= maxRetryCount) {
                    Log.i(TAG, "发生错误，" + retryDelayMillis + "毫秒后将重试，当前重试次数为" + retryCount + "\n" + throwable.toString());
                    return Observable.timer(retryDelayMillis, TimeUnit.MILLISECONDS);
                }
                Log.i(TAG, "重试次数超过最大次数！" + "\n" + throwable.toString());
                return Observable.error(new IllegalArgumentException("重试次数超过最大次数！"));
            }
        });
    }
}
