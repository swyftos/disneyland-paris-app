package com.michaelflisar.lumberjack;

import android.os.Handler;
import android.os.HandlerThread;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.rolling.FixedWindowRollingPolicy;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import ch.qos.logback.core.util.FileSize;
import com.amazonaws.services.p017s3.model.InstructionFileId;
import com.michaelflisar.lumberjack.filter.ILogFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import timber.log.BaseTree;

/* JADX INFO: loaded from: classes4.dex */
public class FileLoggingTree extends BaseTree {
    private static Logger mLogger = LoggerFactory.getLogger((Class<?>) FileLoggingTree.class);
    private Handler mBackgroundHandler;

    public FileLoggingTree(boolean z, FileLoggingSetup fileLoggingSetup, ILogFilter iLogFilter) {
        super(z, false, iLogFilter);
        this.mBackgroundHandler = null;
        if (fileLoggingSetup.isLogOnBackgroundThread()) {
            HandlerThread handlerThread = new HandlerThread("lumberjack.FileLoggingTree");
            handlerThread.start();
            this.mBackgroundHandler = new Handler(handlerThread.getLooper());
        }
        init(fileLoggingSetup);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [ch.qos.logback.core.Appender, ch.qos.logback.core.FileAppender, ch.qos.logback.core.OutputStreamAppender, ch.qos.logback.core.rolling.RollingFileAppender, ch.qos.logback.core.spi.ContextAwareBase] */
    /* JADX WARN: Type inference failed for: r3v2, types: [ch.qos.logback.core.rolling.RollingPolicyBase, ch.qos.logback.core.rolling.TimeBasedRollingPolicy, ch.qos.logback.core.spi.ContextAwareBase] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [ch.qos.logback.core.rolling.RollingPolicyBase, ch.qos.logback.core.rolling.TimeBasedRollingPolicy, ch.qos.logback.core.spi.ContextAwareBase] */
    /* JADX WARN: Type inference failed for: r3v5, types: [ch.qos.logback.core.rolling.FixedWindowRollingPolicy, ch.qos.logback.core.rolling.RollingPolicy, ch.qos.logback.core.rolling.RollingPolicyBase, ch.qos.logback.core.spi.ContextAwareBase] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [ch.qos.logback.core.rolling.TriggeringPolicy, ch.qos.logback.core.spi.LifeCycle] */
    /* JADX WARN: Type inference failed for: r8v8, types: [ch.qos.logback.classic.Logger] */
    private void init(FileLoggingSetup fileLoggingSetup) {
        ?? r3;
        ?? r8;
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        loggerContext.reset();
        PatternLayoutEncoder patternLayoutEncoder = new PatternLayoutEncoder();
        patternLayoutEncoder.setContext(loggerContext);
        patternLayoutEncoder.setPattern(fileLoggingSetup.getLogPattern());
        patternLayoutEncoder.start();
        ?? rollingFileAppender = new RollingFileAppender();
        rollingFileAppender.setAppend(true);
        rollingFileAppender.setContext(loggerContext);
        int i = C44242.$SwitchMap$com$michaelflisar$lumberjack$FileLoggingMode[fileLoggingSetup.getFileLoggingMode().ordinal()];
        if (i == 1 || i == 2) {
            ?? timeBasedRollingPolicy = new TimeBasedRollingPolicy();
            timeBasedRollingPolicy.setFileNamePattern(fileLoggingSetup.getFolderPath() + "/" + fileLoggingSetup.getFileName() + fileLoggingSetup.getFileLoggingMode().getFileNamePattern() + InstructionFileId.DOT + fileLoggingSetup.getFileExtension());
            timeBasedRollingPolicy.setMaxHistory(fileLoggingSetup.getLogFilesToKeep());
            timeBasedRollingPolicy.setCleanHistoryOnStart(true);
            timeBasedRollingPolicy.setParent(rollingFileAppender);
            timeBasedRollingPolicy.setContext(loggerContext);
            timeBasedRollingPolicy.setTotalSizeCap(FileSize.valueOf(fileLoggingSetup.getFileSizeLimit()));
            r3 = timeBasedRollingPolicy;
        } else {
            if (i == 3) {
                ?? timeBasedRollingPolicy2 = new TimeBasedRollingPolicy();
                timeBasedRollingPolicy2.setFileNamePattern(fileLoggingSetup.getFolderPath() + "/" + fileLoggingSetup.getFileLoggingMode().getFileNamePattern() + fileLoggingSetup.getFileName() + InstructionFileId.DOT + fileLoggingSetup.getFileExtension());
                timeBasedRollingPolicy2.setMaxHistory(fileLoggingSetup.getLogFilesToKeep());
                timeBasedRollingPolicy2.setCleanHistoryOnStart(true);
                timeBasedRollingPolicy2.setParent(rollingFileAppender);
                timeBasedRollingPolicy2.setContext(loggerContext);
                timeBasedRollingPolicy2.setTotalSizeCap(FileSize.valueOf(fileLoggingSetup.getFileSizeLimit()));
                r3 = timeBasedRollingPolicy2;
            } else if (i == 4) {
                ?? fixedWindowRollingPolicy = new FixedWindowRollingPolicy();
                fixedWindowRollingPolicy.setFileNamePattern(fileLoggingSetup.getFolderPath() + "/" + fileLoggingSetup.getFileName() + fileLoggingSetup.getFileLoggingMode().getFileNamePattern() + InstructionFileId.DOT + fileLoggingSetup.getFileExtension());
                fixedWindowRollingPolicy.setMinIndex(1);
                fixedWindowRollingPolicy.setMaxIndex(fileLoggingSetup.getLogFilesToKeep());
                fixedWindowRollingPolicy.setParent(rollingFileAppender);
                fixedWindowRollingPolicy.setContext(loggerContext);
                SizeBasedTriggeringPolicy sizeBasedTriggeringPolicy = new SizeBasedTriggeringPolicy();
                sizeBasedTriggeringPolicy.setMaxFileSize(FileSize.valueOf(fileLoggingSetup.getFileSizeLimit()));
                rollingFileAppender.setFile(fileLoggingSetup.getFolderPath() + "/" + fileLoggingSetup.getFileName() + InstructionFileId.DOT + fileLoggingSetup.getFileExtension());
                rollingFileAppender.setRollingPolicy(fixedWindowRollingPolicy);
                fixedWindowRollingPolicy.start();
                r8 = sizeBasedTriggeringPolicy;
            } else {
                throw new IllegalStateException("UnImplemented case: " + fileLoggingSetup.getFileLoggingMode());
            }
            r8.start();
            rollingFileAppender.setTriggeringPolicy(r8);
            rollingFileAppender.setEncoder(patternLayoutEncoder);
            rollingFileAppender.start();
            ?? r9 = (ch.qos.logback.classic.Logger) mLogger;
            r9.detachAndStopAllAppenders();
            r9.addAppender(rollingFileAppender);
        }
        r8 = r3;
        r8.start();
        rollingFileAppender.setTriggeringPolicy(r8);
        rollingFileAppender.setEncoder(patternLayoutEncoder);
        rollingFileAppender.start();
        ?? r10 = (ch.qos.logback.classic.Logger) mLogger;
        r10.detachAndStopAllAppenders();
        r10.addAppender(rollingFileAppender);
    }

    /* JADX INFO: renamed from: com.michaelflisar.lumberjack.FileLoggingTree$2 */
    static /* synthetic */ class C44242 {
        static final /* synthetic */ int[] $SwitchMap$com$michaelflisar$lumberjack$FileLoggingMode;

        static {
            int[] iArr = new int[FileLoggingMode.values().length];
            $SwitchMap$com$michaelflisar$lumberjack$FileLoggingMode = iArr;
            try {
                iArr[FileLoggingMode.DAILY_ROLLOVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$michaelflisar$lumberjack$FileLoggingMode[FileLoggingMode.WEEKLY_ROLLOVER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$michaelflisar$lumberjack$FileLoggingMode[FileLoggingMode.MONTHLY_ROLLOVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$michaelflisar$lumberjack$FileLoggingMode[FileLoggingMode.FILE_SIZE_ROLLOVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // timber.log.BaseTree
    protected void doLog(final int i, String str, String str2, Throwable th) {
        final String line = C4425L.getFormatter().formatLine(str, str2);
        Handler handler = this.mBackgroundHandler;
        if (handler == null) {
            doRealLog(i, line);
        } else {
            handler.post(new Runnable() { // from class: com.michaelflisar.lumberjack.FileLoggingTree.1
                @Override // java.lang.Runnable
                public void run() {
                    FileLoggingTree.this.doRealLog(i, line);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRealLog(int i, String str) {
        if (i == 2) {
            mLogger.debug(str);
            return;
        }
        if (i == 3) {
            mLogger.debug(str);
            return;
        }
        if (i == 4) {
            mLogger.info(str);
            return;
        }
        if (i == 5) {
            mLogger.warn(str);
        } else if (i == 6) {
            mLogger.error(str);
        } else {
            mLogger.debug(str);
        }
    }
}
