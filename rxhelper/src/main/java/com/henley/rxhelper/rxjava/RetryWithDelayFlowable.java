package com.henley.rxhelper.rxjava;

import android.util.Log;

import org.reactivestreams.Publisher;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * RxJava重试机制
 *
 * @author Henley
 * @date 2017/5/24 10:19
 */
public class RetryWithDelayFlowable implements Function<Flowable<? extends Throwable>, Publisher<?>> {

    private static final String TAG = "RetryWithDelayFlowable";
    private int retryCount;
    private int maxRetryCount;
    private int retryDelayMillis;

    /**
     * 构造方法
     *
     * @param maxRetryCount    最大重试次数
     * @param retryDelayMillis 重试延迟时间
     */
    public RetryWithDelayFlowable(int maxRetryCount, int retryDelayMillis) {
        this.maxRetryCount = maxRetryCount;
        this.retryDelayMillis = retryDelayMillis;
    }

    @Override
    public Publisher<?> apply(@NonNull Flowable<? extends Throwable> flowable) throws Exception {
        return flowable.flatMap(new Function<Throwable, Publisher<?>>() {
            @Override
            public Publisher<?> apply(@NonNull Throwable throwable) throws Exception {
                if (++retryCount <= maxRetryCount) {
                    Log.i(TAG, "发生错误，" + retryDelayMillis + "毫秒后将重试，当前重试次数为" + retryCount + "\n" + throwable.toString());
                    return Flowable.timer(retryDelayMillis, TimeUnit.MILLISECONDS);
                }
                Log.i(TAG, "重试次数超过最大次数！" + "\n" + throwable.toString());
                return Flowable.error(new IllegalArgumentException("重试次数超过最大次数！"));
            }
        });
    }
}
