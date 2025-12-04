package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
abstract class TransferThreadPool {
    private static final Log LOGGER = LogFactory.getLog(TransferService.class);
    private static ExecutorService executorMainTask;
    private static ExecutorService executorPartTask;

    static synchronized void init(int i) {
        try {
            LOGGER.debug("Initializing the thread pool of size: " + i);
            int iMax = Math.max((int) Math.ceil(((double) i) / 2.0d), 1);
            if (executorMainTask == null) {
                executorMainTask = buildExecutor(iMax);
            }
            if (executorPartTask == null) {
                executorPartTask = buildExecutor(iMax);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static Future submitTask(Callable callable) {
        init(TransferUtilityOptions.getDefaultThreadPoolSize());
        if (callable instanceof UploadPartTask) {
            return executorPartTask.submit(callable);
        }
        return executorMainTask.submit(callable);
    }

    private static ExecutorService buildExecutor(int i) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }
}
