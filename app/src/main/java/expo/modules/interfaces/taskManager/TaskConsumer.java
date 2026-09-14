package expo.modules.interfaces.taskManager;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import expo.modules.core.interfaces.DoNotStrip;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TaskConsumer implements TaskConsumerInterface {

    @DoNotStrip
    public static int VERSION;
    private WeakReference mContextRef;
    private TaskManagerUtilsInterface mTaskManagerUtils;

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public boolean canReceiveCustomBroadcast(String str) {
        return false;
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public boolean didCancelJob(JobService jobService, JobParameters jobParameters) {
        return false;
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public boolean didExecuteJob(JobService jobService, JobParameters jobParameters) {
        return false;
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void didReceiveBroadcast(Intent intent) {
    }

    @Override // expo.modules.interfaces.taskManager.TaskConsumerInterface
    public void setOptions(Map<String, Object> map) {
    }

    public TaskConsumer(Context context, TaskManagerUtilsInterface taskManagerUtilsInterface) {
        this.mContextRef = new WeakReference(context);
        this.mTaskManagerUtils = taskManagerUtilsInterface;
    }

    protected Context getContext() {
        WeakReference weakReference = this.mContextRef;
        if (weakReference != null) {
            return (Context) weakReference.get();
        }
        return null;
    }

    protected TaskManagerUtilsInterface getTaskManagerUtils() {
        return this.mTaskManagerUtils;
    }
}
