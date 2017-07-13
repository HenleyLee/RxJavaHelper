package com.liyunlong.rxhelper.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.liyunlong.rxhelper.rxjava.BaseObserver;
import com.liyunlong.rxhelper.rxjava.RxJavaHelper;

import java.util.concurrent.TimeUnit;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxJavaHelper.interval(0, 2, TimeUnit.SECONDS, new BaseObserver<Long>() {

            @Override
            public void onSubscribe(@NonNull Disposable disposable) {
                super.onSubscribe(disposable);
                Log.i("TAG", "开始打印");
            }

            @Override
            public void onNext(Long aLong) {
                super.onNext(aLong);
                Log.i("TAG", "aLong = " + aLong);
            }
        });
    }
}
