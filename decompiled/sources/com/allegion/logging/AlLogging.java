package com.allegion.logging;

import androidx.exifinterface.media.ExifInterface;
import com.allegion.logging.entry.IAlEntry;
import com.allegion.logging.property.AlProperty;
import com.contentsquare.android.core.utils.UriBuilder;
import com.urbanairship.analytics.CustomEvent;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0011\u001a\u00020\u0012\"\b\b\u0000\u0010\u0013*\u00020\u00052\u0006\u0010\u0014\u001a\u0002H\u0013H\u0007¢\u0006\u0002\u0010\u0015R\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0002\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/allegion/logging/AlLogging;", "", "()V", "entries", "Lio/reactivex/Observable;", "Lcom/allegion/logging/entry/IAlEntry;", "entries$annotations", "getEntries", "()Lio/reactivex/Observable;", UriBuilder.ANALYTICS_EVENT_ENDPOINT, "Lio/reactivex/subjects/Subject;", CustomEvent.PROPERTIES, "", "Lcom/allegion/logging/property/AlProperty;", "properties$annotations", "getProperties", "()Ljava/util/Set;", "publish", "", ExifInterface.GPS_DIRECTION_TRUE, "entry", "(Lcom/allegion/logging/entry/IAlEntry;)V", "AlLogging_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlLogging {
    public static final AlLogging INSTANCE = new AlLogging();

    @NotNull
    private static final Observable<IAlEntry> entries;
    private static final Subject<IAlEntry> events;

    @NotNull
    private static final Set<AlProperty> properties;

    @JvmStatic
    public static /* synthetic */ void entries$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void properties$annotations() {
    }

    static {
        Subject serialized = PublishSubject.create().toSerialized();
        Intrinsics.checkExpressionValueIsNotNull(serialized, "PublishSubject.create<IAlEntry>().toSerialized()");
        events = serialized;
        Observable<IAlEntry> observableSerialize = serialized.serialize();
        Intrinsics.checkExpressionValueIsNotNull(observableSerialize, "this.events.serialize()");
        entries = observableSerialize;
        Set setNewSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
        if (setNewSetFromMap == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableSet<com.allegion.logging.property.AlProperty>");
        }
        properties = TypeIntrinsics.asMutableSet(setNewSetFromMap);
    }

    private AlLogging() {
    }

    @JvmStatic
    public static final <T extends IAlEntry> void publish(@NotNull T entry) {
        Intrinsics.checkParameterIsNotNull(entry, "entry");
        events.onNext(entry);
    }

    @NotNull
    public static final Observable<IAlEntry> getEntries() {
        return entries;
    }

    @NotNull
    public static final Set<AlProperty> getProperties() {
        return properties;
    }
}
