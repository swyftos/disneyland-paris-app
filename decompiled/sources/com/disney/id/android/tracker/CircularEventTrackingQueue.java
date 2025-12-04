package com.disney.id.android.tracker;

import android.content.Context;
import android.content.SharedPreferences;
import com.contentsquare.android.core.utils.UriBuilder;
import com.disney.id.android.dagger.OneIDDagger;
import com.disney.id.android.logging.Logger;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Queue;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001'B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\tJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\u001dJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u0004\u0018\u00010\tJ\b\u0010%\u001a\u00020\u001dH\u0002J\u0006\u0010&\u001a\u00020\"R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0000@\u0000X\u0081.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/disney/id/android/tracker/CircularEventTrackingQueue;", "", "context", "Landroid/content/Context;", "loggingFilePrefix", "", "(Landroid/content/Context;Ljava/lang/String;)V", "allStoredRequests", "", "Lcom/disney/id/android/tracker/OneIDTrackerEvent;", "getAllStoredRequests", "()Ljava/util/List;", "appContext", UriBuilder.ANALYTICS_EVENT_ENDPOINT, "Ljava/util/Queue;", "getEvents$OneID_release", "()Ljava/util/Queue;", CircularEventTrackingQueue.FILE_POINTER_STORAGE_NAME, "Landroid/content/SharedPreferences;", "isQueueFull", "", "()Z", "logger", "Lcom/disney/id/android/logging/Logger;", "getLogger$OneID_release", "()Lcom/disney/id/android/logging/Logger;", "setLogger$OneID_release", "(Lcom/disney/id/android/logging/Logger;)V", "add", "", "event", "loggingAttemptSuccessful", "loggingAttemptUnexpectedFailure", "nextSafePosition", "", "current", "peek", "removeOldestRequest", TCEventPropertiesNames.TCP_SIZE, "Companion", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCircularEventTrackingQueue.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CircularEventTrackingQueue.kt\ncom/disney/id/android/tracker/CircularEventTrackingQueue\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,158:1\n1#2:159\n*E\n"})
/* loaded from: classes3.dex */
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
            } finally {
            }
        } catch (Exception e) {
            Logger logger$OneID_release = getLogger$OneID_release();
            String TAG2 = TAG;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            logger$OneID_release.e(TAG2, "Error writing event file", e);
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

    /* JADX WARN: Removed duplicated region for block: B:21:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.disney.id.android.tracker.OneIDTrackerEvent> getAllStoredRequests() {
        /*
            r11 = this;
            android.content.SharedPreferences r0 = r11.filePointerStorage
            java.lang.String r1 = "oldestFile"
            r2 = 0
            int r0 = r0.getInt(r1, r2)
            android.content.SharedPreferences r1 = r11.filePointerStorage
            java.lang.String r3 = "currentFile"
            int r1 = r1.getInt(r3, r2)
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = r1 - r0
            int r3 = java.lang.Math.abs(r3)
            r2.<init>(r3)
        L1c:
            if (r0 == r1) goto L73
            r3 = 0
            java.io.ObjectInputStream r4 = new java.io.ObjectInputStream     // Catch: java.lang.Exception -> L55
            android.content.Context r5 = r11.appContext     // Catch: java.lang.Exception -> L55
            java.lang.String r6 = r11.loggingFilePrefix     // Catch: java.lang.Exception -> L55
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L55
            r7.<init>()     // Catch: java.lang.Exception -> L55
            r7.append(r6)     // Catch: java.lang.Exception -> L55
            r7.append(r0)     // Catch: java.lang.Exception -> L55
            java.lang.String r6 = r7.toString()     // Catch: java.lang.Exception -> L55
            java.io.FileInputStream r5 = r5.openFileInput(r6)     // Catch: java.lang.Exception -> L55
            r4.<init>(r5)     // Catch: java.lang.Exception -> L55
            java.lang.Object r5 = r4.readObject()     // Catch: java.lang.Throwable -> L4b
            com.disney.id.android.tracker.OneIDTrackerEvent r5 = (com.disney.id.android.tracker.OneIDTrackerEvent) r5     // Catch: java.lang.Throwable -> L4b
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L49
            kotlin.io.CloseableKt.closeFinally(r4, r3)     // Catch: java.lang.Exception -> L47
            goto L69
        L47:
            r3 = r5
            goto L55
        L49:
            r3 = move-exception
            goto L4f
        L4b:
            r5 = move-exception
            r10 = r5
            r5 = r3
            r3 = r10
        L4f:
            throw r3     // Catch: java.lang.Throwable -> L50
        L50:
            r6 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r3)     // Catch: java.lang.Exception -> L47
            throw r6     // Catch: java.lang.Exception -> L47
        L55:
            com.disney.id.android.logging.Logger r4 = r11.getLogger$OneID_release()
            java.lang.String r5 = com.disney.id.android.tracker.CircularEventTrackingQueue.TAG
            java.lang.String r6 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r8 = 4
            r9 = 0
            java.lang.String r6 = "Error reading event object"
            r7 = 0
            com.disney.id.android.logging.Logger.DefaultImpls.w$default(r4, r5, r6, r7, r8, r9)
            r5 = r3
        L69:
            if (r5 == 0) goto L6e
            r2.add(r5)
        L6e:
            int r0 = r11.nextSafePosition(r0)
            goto L1c
        L73:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disney.id.android.tracker.CircularEventTrackingQueue.getAllStoredRequests():java.util.List");
    }
}
