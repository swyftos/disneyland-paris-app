package timber.log;

import android.util.Log;
import com.michaelflisar.lumberjack.L;
import com.michaelflisar.lumberjack.LogUtil;
import com.michaelflisar.lumberjack.filter.ILogFilter;

/* loaded from: classes.dex */
public class ConsoleTree extends BaseTree {
    public ConsoleTree(boolean z, boolean z2, ILogFilter iLogFilter) {
        super(z, z2, iLogFilter);
    }

    @Override // timber.log.BaseTree
    protected void doLog(int i, String str, String str2, Throwable th) {
        int iMin;
        LogUtil.StackData stackData = this.mStackData;
        if (stackData != null && this.mWithLink) {
            str2 = stackData.appendLink(str2);
        }
        if (str2.length() < 4000) {
            logLine(i, str, str2);
            return;
        }
        int length = str2.length();
        int i2 = 0;
        while (i2 < length) {
            int iIndexOf = str2.indexOf(10, i2);
            if (iIndexOf == -1) {
                iIndexOf = length;
            }
            while (true) {
                iMin = Math.min(iIndexOf, i2 + 4000);
                logLine(i, str, str2.substring(i2, iMin));
                if (iMin >= iIndexOf) {
                    break;
                } else {
                    i2 = iMin;
                }
            }
            i2 = iMin + 1;
        }
    }

    private void logLine(int i, String str, String str2) {
        String line = L.getFormatter().formatLine(str, str2);
        if (i == 7) {
            Log.wtf(str, line);
        } else {
            Log.println(i, str, line);
        }
    }
}
