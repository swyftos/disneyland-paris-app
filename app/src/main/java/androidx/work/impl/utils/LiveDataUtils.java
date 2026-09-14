package androidx.work.impl.utils;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class LiveDataUtils {
    @NonNull
    @SuppressLint({"LambdaLast"})
    public static <In, Out> LiveData<Out> dedupedMappedLiveDataFor(@NonNull LiveData<In> liveData, @NonNull Function<In, Out> function, @NonNull TaskExecutor taskExecutor) {
        Object obj = new Object();
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new C16871(taskExecutor, obj, function, mediatorLiveData));
        return mediatorLiveData;
    }

    /* JADX INFO: renamed from: androidx.work.impl.utils.LiveDataUtils$1 */
    class C16871 implements Observer {
        Object mCurrentOutput = null;
        final /* synthetic */ Object val$lock;
        final /* synthetic */ Function val$mappingMethod;
        final /* synthetic */ MediatorLiveData val$outputLiveData;
        final /* synthetic */ TaskExecutor val$workTaskExecutor;

        C16871(TaskExecutor taskExecutor, Object obj, Function function, MediatorLiveData mediatorLiveData) {
            this.val$workTaskExecutor = taskExecutor;
            this.val$lock = obj;
            this.val$mappingMethod = function;
            this.val$outputLiveData = mediatorLiveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(final Object obj) {
            this.val$workTaskExecutor.executeOnTaskThread(new Runnable() { // from class: androidx.work.impl.utils.LiveDataUtils.1.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (C16871.this.val$lock) {
                        try {
                            Object objApply = C16871.this.val$mappingMethod.apply(obj);
                            C16871 c16871 = C16871.this;
                            Object obj2 = c16871.mCurrentOutput;
                            if (obj2 == null && objApply != null) {
                                c16871.mCurrentOutput = objApply;
                                c16871.val$outputLiveData.postValue(objApply);
                            } else if (obj2 != null && !obj2.equals(objApply)) {
                                C16871 c16872 = C16871.this;
                                c16872.mCurrentOutput = objApply;
                                c16872.val$outputLiveData.postValue(objApply);
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            });
        }
    }
}
