package com.facebook.react.common.mapbuffer;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(m1835d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u001a\u001b\u001cJ\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H&J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\u0017\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0004H&J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00000\u00192\u0006\u0010\t\u001a\u00020\u0004H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001dÀ\u0006\u0001"}, m1836d2 = {"Lcom/facebook/react/common/mapbuffer/MapBuffer;", "", "Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", "count", "", "getCount", "()I", "contains", "", "key", "getKeyOffset", "entryAt", TypedValues.CycleType.S_WAVE_OFFSET, "getType", "Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "getBoolean", "getInt", "getLong", "", "getDouble", "", "getString", "", "getMapBuffer", "getMapBufferList", "", "Companion", "DataType", "Entry", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public interface MapBuffer extends Iterable<Entry>, KMappedMarker {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m1836d2 = {"Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "", "<init>", "(Ljava/lang/String;I)V", "BOOL", "INT", "DOUBLE", "STRING", "MAP", "LONG", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public enum DataType {
        BOOL,
        INT,
        DOUBLE,
        STRING,
        MAP,
        LONG;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        @NotNull
        public static EnumEntries<DataType> getEntries() {
            return $ENTRIES;
        }
    }

    @Metadata(m1835d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0005R\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006 À\u0006\u0001"}, m1836d2 = {"Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", "", "key", "", "getKey", "()I", "type", "Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "getType", "()Lcom/facebook/react/common/mapbuffer/MapBuffer$DataType;", "booleanValue", "", "getBooleanValue", "()Z", "intValue", "getIntValue", "longValue", "", "getLongValue", "()J", "doubleValue", "", "getDoubleValue", "()D", "stringValue", "", "getStringValue", "()Ljava/lang/String;", "mapBufferValue", "Lcom/facebook/react/common/mapbuffer/MapBuffer;", "getMapBufferValue", "()Lcom/facebook/react/common/mapbuffer/MapBuffer;", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public interface Entry {
        boolean getBooleanValue();

        double getDoubleValue();

        int getIntValue();

        int getKey();

        long getLongValue();

        @NotNull
        MapBuffer getMapBufferValue();

        @NotNull
        String getStringValue();

        @NotNull
        DataType getType();
    }

    boolean contains(int key);

    @NotNull
    Entry entryAt(int offset);

    boolean getBoolean(int key);

    int getCount();

    double getDouble(int key);

    int getInt(int key);

    int getKeyOffset(int key);

    long getLong(int key);

    @NotNull
    MapBuffer getMapBuffer(int key);

    @NotNull
    List<MapBuffer> getMapBufferList(int key);

    @NotNull
    String getString(int key);

    @NotNull
    DataType getType(int key);

    @Metadata(m1835d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m1836d2 = {"Lcom/facebook/react/common/mapbuffer/MapBuffer$Companion;", "", "<init>", "()V", "KEY_RANGE", "Lkotlin/ranges/IntRange;", "getKEY_RANGE$ReactAndroid_release", "()Lkotlin/ranges/IntRange;", "ReactAndroid_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        @NotNull
        private static final IntRange KEY_RANGE = new IntRange(0, 65535);

        private Companion() {
        }

        @NotNull
        public final IntRange getKEY_RANGE$ReactAndroid_release() {
            return KEY_RANGE;
        }
    }
}
