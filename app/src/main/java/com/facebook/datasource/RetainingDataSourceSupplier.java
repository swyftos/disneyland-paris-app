package com.facebook.datasource;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.internal.Supplier;
import com.facebook.infer.annotation.Nullsafe;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: loaded from: classes3.dex */
@NotThreadSafe
@Nullsafe(Nullsafe.Mode.LOCAL)
public class RetainingDataSourceSupplier<T> implements Supplier<DataSource<T>> {
    private final Set mDataSources = Collections.newSetFromMap(new WeakHashMap());
    private Supplier mCurrentDataSourceSupplier = null;

    @Override // com.facebook.common.internal.Supplier
    public DataSource<T> get() {
        RetainingDataSource retainingDataSource = new RetainingDataSource();
        retainingDataSource.setSupplier(this.mCurrentDataSourceSupplier);
        this.mDataSources.add(retainingDataSource);
        return retainingDataSource;
    }

    public void replaceSupplier(Supplier<DataSource<T>> supplier) {
        this.mCurrentDataSourceSupplier = supplier;
        for (RetainingDataSource retainingDataSource : this.mDataSources) {
            if (!retainingDataSource.isClosed()) {
                retainingDataSource.setSupplier(supplier);
            }
        }
    }

    private static class RetainingDataSource extends AbstractDataSource {
        private DataSource mDataSource;

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceFailed() {
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean hasMultipleResults() {
            return true;
        }

        private RetainingDataSource() {
            this.mDataSource = null;
        }

        public void setSupplier(Supplier supplier) {
            if (isClosed()) {
                return;
            }
            DataSource dataSource = supplier != null ? (DataSource) supplier.get() : null;
            synchronized (this) {
                try {
                    if (isClosed()) {
                        closeSafely(dataSource);
                        return;
                    }
                    DataSource dataSource2 = this.mDataSource;
                    this.mDataSource = dataSource;
                    if (dataSource != null) {
                        dataSource.subscribe(new InternalDataSubscriber(), CallerThreadExecutor.getInstance());
                    }
                    closeSafely(dataSource2);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized Object getResult() {
            DataSource dataSource;
            dataSource = this.mDataSource;
            return dataSource != null ? dataSource.getResult() : null;
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public synchronized boolean hasResult() {
            DataSource dataSource;
            dataSource = this.mDataSource;
            return dataSource != null && dataSource.hasResult();
        }

        @Override // com.facebook.datasource.AbstractDataSource, com.facebook.datasource.DataSource
        public boolean close() {
            synchronized (this) {
                try {
                    if (!super.close()) {
                        return false;
                    }
                    DataSource dataSource = this.mDataSource;
                    this.mDataSource = null;
                    closeSafely(dataSource);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDataSourceNewResult(DataSource dataSource) {
            if (dataSource == this.mDataSource) {
                setResult(null, false, dataSource.getExtras());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onDatasourceProgress(DataSource dataSource) {
            if (dataSource == this.mDataSource) {
                setProgress(dataSource.getProgress());
            }
        }

        private static void closeSafely(DataSource dataSource) {
            if (dataSource != null) {
                dataSource.close();
            }
        }

        private class InternalDataSubscriber implements DataSubscriber {
            @Override // com.facebook.datasource.DataSubscriber
            public void onCancellation(DataSource dataSource) {
            }

            private InternalDataSubscriber() {
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onNewResult(DataSource dataSource) {
                if (dataSource.hasResult()) {
                    RetainingDataSource.this.onDataSourceNewResult(dataSource);
                } else if (dataSource.isFinished()) {
                    RetainingDataSource.this.onDataSourceFailed();
                }
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onFailure(DataSource dataSource) {
                RetainingDataSource.this.onDataSourceFailed();
            }

            @Override // com.facebook.datasource.DataSubscriber
            public void onProgressUpdate(DataSource dataSource) {
                RetainingDataSource.this.onDatasourceProgress(dataSource);
            }
        }
    }
}
