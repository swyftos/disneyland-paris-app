package com.urbanairship.util;

import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0016B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001b\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/util/CachedList;", ExifInterface.GPS_DIRECTION_TRUE, "", "clock", "Lcom/urbanairship/util/Clock;", "(Lcom/urbanairship/util/Clock;)V", "entries", "", "Lcom/urbanairship/util/CachedList$Entry;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "values", "", "getValues", "()Ljava/util/List;", "append", "", "value", "expiresInMilliseconds", "", "(Ljava/lang/Object;J)V", "trim", "Entry", "urbanairship-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCachedList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CachedList.kt\ncom/urbanairship/util/CachedList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,40:1\n1549#2:41\n1620#2,3:42\n*S KotlinDebug\n*F\n+ 1 CachedList.kt\ncom/urbanairship/util/CachedList\n*L\n15#1:41\n15#1:42,3\n*E\n"})
/* loaded from: classes5.dex */
public final class CachedList<T> {
    private final Clock clock;
    private final List entries;
    private final ReentrantLock lock;

    public CachedList() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public CachedList(@NotNull Clock clock) {
        Intrinsics.checkNotNullParameter(clock, "clock");
        this.clock = clock;
        this.lock = new ReentrantLock();
        this.entries = new ArrayList();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CachedList(Clock DEFAULT_CLOCK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            DEFAULT_CLOCK = Clock.DEFAULT_CLOCK;
            Intrinsics.checkNotNullExpressionValue(DEFAULT_CLOCK, "DEFAULT_CLOCK");
        }
        this(DEFAULT_CLOCK);
    }

    @NotNull
    public final List<T> getValues() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            trim();
            List list = this.entries;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((Entry) it.next()).getValue());
            }
            return arrayList;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void trim() {
        final long jCurrentTimeMillis = this.clock.currentTimeMillis();
        CollectionsKt.removeAll(this.entries, new Function1() { // from class: com.urbanairship.util.CachedList.trim.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Entry entry) {
                Intrinsics.checkNotNullParameter(entry, "entry");
                return Boolean.valueOf(jCurrentTimeMillis >= entry.getExpiration());
            }
        });
    }

    public final void append(T value, long expiresInMilliseconds) {
        Entry entry = new Entry(value, this.clock.currentTimeMillis() + expiresInMilliseconds);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            trim();
            this.entries.add(entry);
        } finally {
            reentrantLock.unlock();
        }
    }

    private static final class Entry {
        private final long expiration;
        private final Object value;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            return Intrinsics.areEqual(this.value, entry.value) && this.expiration == entry.expiration;
        }

        public int hashCode() {
            Object obj = this.value;
            return ((obj == null ? 0 : obj.hashCode()) * 31) + Long.hashCode(this.expiration);
        }

        public String toString() {
            return "Entry(value=" + this.value + ", expiration=" + this.expiration + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Entry(Object obj, long j) {
            this.value = obj;
            this.expiration = j;
        }

        public final long getExpiration() {
            return this.expiration;
        }

        public final Object getValue() {
            return this.value;
        }
    }
}
