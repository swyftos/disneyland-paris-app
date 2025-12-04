package timber.log;

import com.michaelflisar.lumberjack.L;
import com.michaelflisar.lumberjack.LogUtil;
import com.michaelflisar.lumberjack.filter.ILogFilter;
import timber.log.Timber;

/* loaded from: classes.dex */
public abstract class BaseTree extends Timber.Tree {
    private static final int CALL_STACK_INDEX = 8;
    protected static final int MAX_LOG_LENGTH = 4000;
    protected final boolean mCombineTags;
    protected ILogFilter mFilter;
    protected final boolean mWithLink;
    final ThreadLocal<Integer> callStackCorrection = new ThreadLocal<>();
    protected LogUtil.StackData mStackData = null;

    protected abstract void doLog(int i, String str, String str2, Throwable th);

    protected boolean isReady() {
        return true;
    }

    public BaseTree(boolean z, boolean z2, ILogFilter iLogFilter) {
        this.mCombineTags = z;
        this.mWithLink = z2;
        this.mFilter = iLogFilter;
    }

    @Override // timber.log.Timber.Tree
    final String getTag() {
        String tag = super.getTag();
        if (tag != null && !this.mCombineTags) {
            return tag;
        }
        Integer callStackCorrection = getCallStackCorrection();
        if (callStackCorrection == null) {
            callStackCorrection = 0;
        }
        if (new Throwable().getStackTrace().length <= callStackCorrection.intValue() + 8) {
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }
        LogUtil.StackData stackData = LogUtil.getStackData(callStackCorrection.intValue() + 8);
        this.mStackData = stackData;
        String stackTag = stackData.getStackTag();
        return tag == null ? stackTag : L.getFormatter().combineTagAndGroup(stackTag, tag);
    }

    @Override // timber.log.Timber.Tree
    protected final void log(int i, String str, String str2, Throwable th) {
        if (isReady()) {
            String strExtractGroupFromTag = this.mCombineTags ? L.getFormatter().extractGroupFromTag(str) : str;
            ILogFilter iLogFilter = this.mFilter;
            if (iLogFilter == null || iLogFilter.valid(strExtractGroupFromTag, i)) {
                doLog(i, str, str2, th);
            }
        }
    }

    private Integer getCallStackCorrection() {
        Integer num = this.callStackCorrection.get();
        if (num != null) {
            this.callStackCorrection.remove();
        }
        return num;
    }
}
