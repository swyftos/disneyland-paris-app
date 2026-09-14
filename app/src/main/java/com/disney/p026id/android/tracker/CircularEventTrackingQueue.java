package com.disney.p026id.android.tracker;

import android.content.Context;
import android.content.SharedPreferences;
import com.contentsquare.android.core.utils.UriBuilder;
import com.disney.p026id.android.dagger.OneIDDagger;
import com.disney.p026id.android.logging.Logger;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p163io.CloseableKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\tJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001dJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u0004\u0018\u00010\tJ\b\u0010%\u001a\u00020\u001dH\u0002J\u0006\u0010&\u001a\u00020\"R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, m1836d2 = {"Lcom/disney/id/android/tracker/CircularEventTrackingQueue;", "", "context", "Landroid/content/Context;", "loggingFilePrefix", "", "(Landroid/content/Context;Ljava/lang/String;)V", "allStoredRequests", "", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "getAllStoredRequests", "()Ljava/util/List;", "appContext", UriBuilder.ANALYTICS_EVENT_ENDPOINT, "Ljava/util/Queue;", "getEvents$OneID_release", "()Ljava/util/Queue;", CircularEventTrackingQueue.FILE_POINTER_STORAGE_NAME, "Landroid/content/SharedPreferences;", "isQueueFull", "", "()Z", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "add", "", "event", "loggingAttemptSuccessful", "loggingAttemptUnexpectedFailure", "nextSafePosition", "", "current", "peek", "removeOldestRequest", TCEventPropertiesNames.TCP_SIZE, "Companion", "OneID_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nCircularEventTrackingQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircularEventTrackingQueue.kt\ncom/disney/id/android/tracker/CircularEventTrackingQueue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n1#2:159\n*E\n"})
public final class CircularEventTrackingQueue {

    @NotNull
    public static final String FILE_POINTER_STORAGE_NAME = "filePointerStorage";
    public static final int MAXIMUM_NUMBER_OF_REQUESTS = 256;

    @NotNull
    public static final String NEXT_FILE_TO_WRITE_POINTER = "currentFile";

    @NotNull
    public static final String OLDEST_FILE_POINTER = "oldestFile";
    private final Context appContext;
    private final Queue events;
    private final SharedPreferences filePointerStorage;

    @Inject
    public Logger logger;
    private final String loggingFilePrefix;
    private static final String TAG = CircularEventTrackingQueue.class.getSimpleName();

    public CircularEventTrackingQueue(@NotNull Context context, @NotNull String loggingFilePrefix) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(loggingFilePrefix, "loggingFilePrefix");
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.appContext = applicationContext;
        if (!StringsKt.endsWith$default(loggingFilePrefix, "_", false, 2, (Object) null)) {
            loggingFilePrefix = loggingFilePrefix + "_";
        }
        this.loggingFilePrefix = loggingFilePrefix;
        OneIDDagger.getComponent().inject(this);
        LinkedList linkedList = new LinkedList();
        this.events = linkedList;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(FILE_POINTER_STORAGE_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.filePointerStorage = sharedPreferences;
        linkedList.addAll(getAllStoredRequests());
        if (linkedList.isEmpty()) {
            sharedPreferences.edit().putInt(OLDEST_FILE_POINTER, 0).putInt(NEXT_FILE_TO_WRITE_POINTER, 0).apply();
        }
    }

    @NotNull
    public final Logger getLogger$OneID_release() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger;
        }
        Intrinsics.throwUninitializedPropertyAccessException("logger");
        return null;
    }

    public final void setLogger$OneID_release(@NotNull Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "<set-?>");
        this.logger = logger;
    }

    @NotNull
    public final Queue<OneIDTrackerEvent> getEvents$OneID_release() {
        return this.events;
    }

    private final boolean isQueueFull() {
        return this.events.size() == 256;
    }

    public final void add(@NotNull OneIDTrackerEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (isQueueFull()) {
            removeOldestRequest();
        }
        int i = this.filePointerStorage.getInt(NEXT_FILE_TO_WRITE_POINTER, 0);
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(this.appContext.openFileOutput(this.loggingFilePrefix + i, 0));
            try {
                objectOutputStream.writeObject(event);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(objectOutputStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(objectOutputStream, th);
                    throw th2;
                }
            }
        } catch (Exception e) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logger$OneID_release.mo1257e(TAG2, "Error writing event file", e);
        }
        SharedPreferences.Editor editorEdit = this.filePointerStorage.edit();
        editorEdit.putInt(NEXT_FILE_TO_WRITE_POINTER, nextSafePosition(i));
        editorEdit.apply();
        this.events.add(event);
    }

    @Nullable
    public final OneIDTrackerEvent peek() {
        return (OneIDTrackerEvent) this.events.peek();
    }

    public final int size() {
        return this.events.size();
    }

    public final void loggingAttemptSuccessful() {
        removeOldestRequest();
    }

    public final void loggingAttemptUnexpectedFailure() {
        removeOldestRequest();
    }

    private final void removeOldestRequest() {
        this.events.remove();
        int i = this.filePointerStorage.getInt(OLDEST_FILE_POINTER, 0);
        this.appContext.deleteFile(this.loggingFilePrefix + i);
        SharedPreferences.Editor editorEdit = this.filePointerStorage.edit();
        editorEdit.putInt(OLDEST_FILE_POINTER, nextSafePosition(i));
        editorEdit.apply();
    }

    private final int nextSafePosition(int current) {
        return (current + 1) % 256;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x006b  */
    /* JADX WARN: Code duplicated, block: B:38:0x006e A[SYNTHETIC] */
    @NotNull
    public final List<OneIDTrackerEvent> getAllStoredRequests() {
        OneIDTrackerEvent oneIDTrackerEvent;
        Throwable th;
        int iNextSafePosition = this.filePointerStorage.getInt(OLDEST_FILE_POINTER, 0);
        int i = this.filePointerStorage.getInt(NEXT_FILE_TO_WRITE_POINTER, 0);
        ArrayList arrayList = new ArrayList(Math.abs(i - iNextSafePosition));
        while (iNextSafePosition != i) {
            OneIDTrackerEvent oneIDTrackerEvent2 = null;
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(this.appContext.openFileInput(this.loggingFilePrefix + iNextSafePosition));
                try {
                    oneIDTrackerEvent = (OneIDTrackerEvent) objectInputStream.readObject();
                    try {
                        Unit unit = Unit.INSTANCE;
                        try {
                            CloseableKt.closeFinally(objectInputStream, null);
                        } catch (Exception unused) {
                            oneIDTrackerEvent2 = oneIDTrackerEvent;
                            Logger logger$OneID_release = getLogger$OneID_release();
                            String TAG2 = TAG;
                            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                            Logger.DefaultImpls.w$default(logger$OneID_release, TAG2, "Error reading event object", null, 4, null);
                            oneIDTrackerEvent = oneIDTrackerEvent2;
                            if (oneIDTrackerEvent != null) {
                                arrayList.add(oneIDTrackerEvent);
                            }
                            iNextSafePosition = nextSafePosition(iNextSafePosition);
                        }
                        if (oneIDTrackerEvent != null) {
                            arrayList.add(oneIDTrackerEvent);
                        }
                        iNextSafePosition = nextSafePosition(iNextSafePosition);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            throw th;
                        } catch (Throwable th3) {
                            CloseableKt.closeFinally(objectInputStream, th);
                            throw th3;
                        }
                    }
                } catch (Throwable th4) {
                    oneIDTrackerEvent = null;
                    th = th4;
                }
            } catch (Exception unused2) {
            }
        }
        return arrayList;
    }
}
