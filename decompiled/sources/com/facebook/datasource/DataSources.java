package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import com.facebook.infer.annotation.Nullsafe;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

@Nullsafe(Nullsafe.Mode.LOCAL)
/* loaded from: classes3.dex */
public class DataSources {
    public static <T> DataSource<T> immediateFailedDataSource(Throwable th) {
        SimpleDataSource simpleDataSourceCreate = SimpleDataSource.create();
        simpleDataSourceCreate.setFailure(th);
        return simpleDataSourceCreate;
    }

    public static <T> DataSource<T> immediateDataSource(T t) {
        SimpleDataSource simpleDataSourceCreate = SimpleDataSource.create();
        simpleDataSourceCreate.setResult(t);
        return simpleDataSourceCreate;
    }

    public static DataSource<Void> immediateSuccessfulDataSource() {
        return SuccessfulVoidDataSource.INSTANCE;
    }

    public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(final Throwable th) {
        return new Supplier() { // from class: com.facebook.datasource.DataSources.1
            @Override // com.facebook.common.internal.Supplier
            public DataSource get() {
                return DataSources.immediateFailedDataSource(th);
            }
        };
    }

    @Nullable
    public static <T> T waitForFinalResult(DataSource<T> dataSource) throws Throwable {
        return (T) waitForFinalResult(dataSource, -1L, TimeUnit.MILLISECONDS);
    }

    @Nullable
    public static <T> T waitForFinalResult(DataSource<T> dataSource, long j, TimeUnit timeUnit) throws Throwable {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ValueHolder valueHolder = new ValueHolder();
        final ValueHolder valueHolder2 = new ValueHolder();
        dataSource.subscribe(new DataSubscriber() { // from class: com.facebook.datasource.DataSources.2
            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource dataSource2) {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource dataSource2) {
                if (dataSource2.isFinished()) {
                    try {
                        valueHolder.value = dataSource2.getResult();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource dataSource2) {
                try {
                    valueHolder2.value = dataSource2.getFailureCause();
                } finally {
                    countDownLatch.countDown();
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource dataSource2) {
                countDownLatch.countDown();
            }
        }, new Executor() { // from class: com.facebook.datasource.DataSources.3
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                runnable.run();
            }
        });
        if (j < 0) {
            countDownLatch.await();
        } else if (!countDownLatch.await(j, timeUnit)) {
            throw new TimeoutException();
        }
        Object obj = valueHolder2.value;
        if (obj != null) {
            throw ((Throwable) obj);
        }
        return (T) valueHolder.value;
    }

    private static class ValueHolder {
        public Object value;

        private ValueHolder() {
            this.value = null;
        }
    }
}
