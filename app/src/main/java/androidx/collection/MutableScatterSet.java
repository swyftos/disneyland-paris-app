package androidx.collection;

import androidx.annotation.IntRange;
import androidx.exifinterface.media.ExifInterface;
import com.urbanairship.channel.AttributeMutation;
import com.urbanairship.json.matchers.ArrayContainsMatcher;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ULong;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.markers.KMutableSet;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes.dex */
@Metadata(m1835d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010#\n\u0002\b\u0013\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001=B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\b2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b\u0010\u0010\u0013J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b\u0010\u0010\u0015J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0010\u0010\u0016J\u001b\u0010\u0010\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b\u0010\u0010\u0018J \u0010\f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000eH\u0086\u0002¢\u0006\u0004\b\f\u0010\u0019J\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\u0002¢\u0006\u0004\b\f\u0010\u001aJ\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086\u0002¢\u0006\u0004\b\f\u0010\u001bJ\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002¢\u0006\u0004\b\f\u0010\u001cJ\u001e\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\u0002¢\u0006\u0004\b\f\u0010\u001dJ\u0015\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0004\b\u001e\u0010\nJ\u0018\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u001f\u0010\rJ\u001d\u0010 \u001a\u00020\b2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000e¢\u0006\u0004\b \u0010\u0011J\u001b\u0010 \u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\u0004\b \u0010\u0015J\u001b\u0010 \u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012¢\u0006\u0004\b \u0010\u0013J\u001b\u0010 \u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b \u0010\u0016J\u001b\u0010 \u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017¢\u0006\u0004\b \u0010\u0018J \u0010\u001f\u001a\u00020\u000b2\u000e\u0010\u000f\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000eH\u0086\u0002¢\u0006\u0004\b\u001f\u0010\u0019J\u001e\u0010\u001f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0086\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ\u001e\u0010\u001f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0086\u0002¢\u0006\u0004\b\u001f\u0010\u001aJ\u001e\u0010\u001f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086\u0002¢\u0006\u0004\b\u001f\u0010\u001cJ\u001e\u0010\u001f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0017H\u0086\u0002¢\u0006\u0004\b\u001f\u0010\u001dJ'\u0010#\u001a\u00020\u000b2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0!H\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020\u0003H\u0001¢\u0006\u0004\b&\u0010\u0006J\r\u0010'\u001a\u00020\u000b¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0003H\u0007¢\u0006\u0004\b)\u0010*J\u0013\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000+¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b.\u0010\u0006J\u0017\u00100\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u0003H\u0002¢\u0006\u0004\b0\u0010\u0006J\u000f\u00101\u001a\u00020\u000bH\u0002¢\u0006\u0004\b1\u0010(J\u0017\u00102\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00105\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0003H\u0002¢\u0006\u0004\b5\u00106J\u000f\u00107\u001a\u00020\u000bH\u0002¢\u0006\u0004\b7\u0010(J\u0017\u00109\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u0003H\u0002¢\u0006\u0004\b9\u0010\u0006J\u000f\u0010:\u001a\u00020\u000bH\u0002¢\u0006\u0004\b:\u0010(R\u0016\u0010;\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006>"}, m1836d2 = {"Landroidx/collection/MutableScatterSet;", ExifInterface.LONGITUDE_EAST, "Landroidx/collection/ScatterSet;", "", "initialCapacity", "<init>", "(I)V", "element", "", "add", "(Ljava/lang/Object;)Z", "", "plusAssign", "(Ljava/lang/Object;)V", "", "elements", "addAll", "([Ljava/lang/Object;)Z", "", "(Ljava/lang/Iterable;)Z", "Lkotlin/sequences/Sequence;", "(Lkotlin/sequences/Sequence;)Z", "(Landroidx/collection/ScatterSet;)Z", "Landroidx/collection/ObjectList;", "(Landroidx/collection/ObjectList;)Z", "([Ljava/lang/Object;)V", "(Ljava/lang/Iterable;)V", "(Lkotlin/sequences/Sequence;)V", "(Landroidx/collection/ScatterSet;)V", "(Landroidx/collection/ObjectList;)V", AttributeMutation.ATTRIBUTE_ACTION_REMOVE, "minusAssign", "removeAll", "Lkotlin/Function1;", "predicate", "removeIf", "(Lkotlin/jvm/functions/Function1;)V", ArrayContainsMatcher.INDEX_KEY, "removeElementAt", "clear", "()V", "trim", "()I", "", "asMutableSet", "()Ljava/util/Set;", "initializeStorage", "capacity", "initializeMetadata", "initializeGrowth", "findAbsoluteInsertIndex", "(Ljava/lang/Object;)I", "hash1", "findFirstAvailableSlot", "(I)I", "adjustStorage", "newCapacity", "resizeStorage", "removeDeletedMarkers", "growthLimit", "I", "MutableSetWrapper", "collection"}, m1837k = 1, m1838mv = {1, 8, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nScatterSet.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScatterSet.kt\nandroidx/collection/MutableScatterSet\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ScatterMap.kt\nandroidx/collection/ScatterMapKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 5 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 6 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 7 ScatterSet.kt\nandroidx/collection/ScatterSet\n+ 8 ObjectList.kt\nandroidx/collection/ObjectList\n*L\n1#1,1100:1\n1018#1,2:1285\n1022#1,5:1293\n1018#1,2:1324\n1022#1,5:1332\n1018#1,2:1349\n1022#1,5:1357\n1018#1,2:1363\n1022#1,5:1371\n1#2:1101\n1672#3,6:1102\n1826#3:1125\n1688#3:1129\n1605#3,3:1148\n1619#3:1152\n1615#3:1155\n1795#3,3:1159\n1809#3,3:1163\n1733#3:1167\n1721#3:1169\n1715#3:1170\n1728#3:1175\n1818#3:1177\n1605#3,3:1187\n1619#3:1191\n1615#3:1194\n1795#3,3:1198\n1809#3,3:1202\n1733#3:1206\n1721#3:1208\n1715#3:1209\n1728#3:1214\n1818#3:1216\n1826#3:1242\n1688#3:1246\n1826#3:1271\n1688#3:1275\n1672#3,6:1287\n1672#3,6:1298\n1605#3,3:1304\n1615#3:1307\n1619#3:1308\n1795#3,3:1309\n1809#3,3:1312\n1733#3:1315\n1721#3:1316\n1715#3:1317\n1728#3:1318\n1818#3:1319\n1682#3:1320\n1661#3:1321\n1680#3:1322\n1661#3:1323\n1672#3,6:1326\n1795#3,3:1337\n1826#3:1340\n1715#3:1341\n1685#3:1342\n1661#3:1343\n1605#3,3:1344\n1615#3:1347\n1619#3:1348\n1672#3,6:1351\n1661#3:1362\n1672#3,6:1365\n1672#3,6:1376\n1672#3,6:1382\n13579#4,2:1108\n13579#4,2:1225\n1855#5,2:1110\n1855#5,2:1229\n1295#6,2:1112\n1295#6,2:1227\n267#7,4:1114\n237#7,7:1118\n248#7,3:1126\n251#7,2:1130\n272#7,2:1132\n254#7,6:1134\n274#7:1140\n433#7:1147\n434#7:1151\n436#7,2:1153\n438#7,3:1156\n441#7:1162\n442#7:1166\n443#7:1168\n444#7,4:1171\n450#7:1176\n451#7,8:1178\n433#7:1186\n434#7:1190\n436#7,2:1192\n438#7,3:1195\n441#7:1201\n442#7:1205\n443#7:1207\n444#7,4:1210\n450#7:1215\n451#7,8:1217\n267#7,4:1231\n237#7,7:1235\n248#7,3:1243\n251#7,2:1247\n272#7,2:1249\n254#7,6:1251\n274#7:1257\n237#7,7:1264\n248#7,3:1272\n251#7,9:1276\n305#8,6:1141\n305#8,6:1258\n*S KotlinDebug\n*F\n+ 1 ScatterSet.kt\nandroidx/collection/MutableScatterSet\n*L\n857#1:1285,2\n857#1:1293,5\n917#1:1324,2\n917#1:1332,5\n989#1:1349,2\n989#1:1357,5\n1004#1:1363,2\n1004#1:1371,5\n567#1:1102,6\n692#1:1125\n692#1:1129\n714#1:1148,3\n714#1:1152\n714#1:1155\n714#1:1159,3\n714#1:1163,3\n714#1:1167\n714#1:1169\n714#1:1170\n714#1:1175\n714#1:1177\n727#1:1187,3\n727#1:1191\n727#1:1194\n727#1:1198,3\n727#1:1202,3\n727#1:1206\n727#1:1208\n727#1:1209\n727#1:1214\n727#1:1216\n823#1:1242\n823#1:1246\n843#1:1271\n843#1:1275\n857#1:1287,6\n868#1:1298,6\n882#1:1304,3\n883#1:1307\n884#1:1308\n891#1:1309,3\n892#1:1312,3\n893#1:1315\n894#1:1316\n894#1:1317\n898#1:1318\n901#1:1319\n910#1:1320\n910#1:1321\n916#1:1322\n916#1:1323\n917#1:1326,6\n931#1:1337,3\n932#1:1340\n934#1:1341\n984#1:1342\n984#1:1343\n986#1:1344,3\n987#1:1347\n989#1:1348\n989#1:1351,6\n1002#1:1362\n1004#1:1365,6\n1019#1:1376,6\n1025#1:1382,6\n662#1:1108,2\n793#1:1225,2\n672#1:1110,2\n813#1:1229,2\n682#1:1112,2\n803#1:1227,2\n692#1:1114,4\n692#1:1118,7\n692#1:1126,3\n692#1:1130,2\n692#1:1132,2\n692#1:1134,6\n692#1:1140\n714#1:1147\n714#1:1151\n714#1:1153,2\n714#1:1156,3\n714#1:1162\n714#1:1166\n714#1:1168\n714#1:1171,4\n714#1:1176\n714#1:1178,8\n727#1:1186\n727#1:1190\n727#1:1192,2\n727#1:1195,3\n727#1:1201\n727#1:1205\n727#1:1207\n727#1:1210,4\n727#1:1215\n727#1:1217,8\n823#1:1231,4\n823#1:1235,7\n823#1:1243,3\n823#1:1247,2\n823#1:1249,2\n823#1:1251,6\n823#1:1257\n843#1:1264,7\n843#1:1272,3\n843#1:1276,9\n702#1:1141,6\n833#1:1258,6\n*E\n"})
public final class MutableScatterSet<E> extends ScatterSet<E> {
    private int growthLimit;

    public MutableScatterSet() {
        this(0, 1, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(@NotNull ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        minusAssign(objArr[(i << 3) + i3]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(@NotNull ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = elements.elements;
        long[] jArr = elements.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        plusAssign(objArr[(i << 3) + i3]);
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void minusAssign(@NotNull ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = elements.content;
        int i = elements._size;
        for (int i2 = 0; i2 < i; i2++) {
            minusAssign(objArr[i2]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void plusAssign(@NotNull ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object[] objArr = elements.content;
        int i = elements._size;
        for (int i2 = 0; i2 < i; i2++) {
            plusAssign(objArr[i2]);
        }
    }

    public /* synthetic */ MutableScatterSet(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 6 : i);
    }

    public MutableScatterSet(int i) {
        super(null);
        if (i < 0) {
            throw new IllegalArgumentException("Capacity must be a positive value.");
        }
        initializeStorage(ScatterMapKt.unloadedCapacity(i));
    }

    private final void initializeStorage(int initialCapacity) {
        int iMax = initialCapacity > 0 ? Math.max(7, ScatterMapKt.normalizeCapacity(initialCapacity)) : 0;
        this._capacity = iMax;
        initializeMetadata(iMax);
        this.elements = new Object[iMax];
    }

    private final void initializeMetadata(int capacity) {
        long[] jArr;
        if (capacity == 0) {
            jArr = ScatterMapKt.EmptyGroup;
        } else {
            jArr = new long[((capacity + 15) & (-8)) >> 3];
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
        }
        this.metadata = jArr;
        int i = capacity >> 3;
        long j = 255 << ((capacity & 7) << 3);
        jArr[i] = (jArr[i] & (~j)) | j;
        initializeGrowth();
    }

    private final void initializeGrowth() {
        this.growthLimit = ScatterMapKt.loadedCapacity(get_capacity()) - this._size;
    }

    public final boolean add(E element) {
        int i = get_size();
        this.elements[findAbsoluteInsertIndex(element)] = element;
        return get_size() != i;
    }

    public final void plusAssign(E element) {
        this.elements[findAbsoluteInsertIndex(element)] = element;
    }

    public final boolean addAll(@NotNull E[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = get_size();
        plusAssign((Object[]) elements);
        return i != get_size();
    }

    public final boolean addAll(@NotNull Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = get_size();
        plusAssign((Iterable) elements);
        return i != get_size();
    }

    public final boolean addAll(@NotNull Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = get_size();
        plusAssign((Sequence) elements);
        return i != get_size();
    }

    public final boolean addAll(@NotNull ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = get_size();
        plusAssign((ScatterSet) elements);
        return i != get_size();
    }

    public final boolean addAll(@NotNull ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = get_size();
        plusAssign((ObjectList) elements);
        return i != get_size();
    }

    public final boolean removeAll(@NotNull E[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = get_size();
        minusAssign((Object[]) elements);
        return i != get_size();
    }

    public final boolean removeAll(@NotNull Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = get_size();
        minusAssign((Sequence) elements);
        return i != get_size();
    }

    public final boolean removeAll(@NotNull Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = get_size();
        minusAssign((Iterable) elements);
        return i != get_size();
    }

    public final boolean removeAll(@NotNull ScatterSet<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = get_size();
        minusAssign((ScatterSet) elements);
        return i != get_size();
    }

    public final boolean removeAll(@NotNull ObjectList<E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i = get_size();
        minusAssign((ObjectList) elements);
        return i != get_size();
    }

    public final void removeIf(@NotNull Function1<? super E, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        Object[] objArr = this.elements;
        long[] jArr = this.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        if (predicate.invoke(objArr[i4]).booleanValue()) {
                            removeElementAt(i4);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    @PublishedApi
    public final void removeElementAt(int index) {
        this._size--;
        long[] jArr = this.metadata;
        int i = index >> 3;
        int i2 = (index & 7) << 3;
        jArr[i] = (jArr[i] & (~(255 << i2))) | (254 << i2);
        int i3 = this._capacity;
        int i4 = ((index - 7) & i3) + (i3 & 7);
        int i5 = i4 >> 3;
        int i6 = (i4 & 7) << 3;
        jArr[i5] = (jArr[i5] & (~(255 << i6))) | (254 << i6);
        this.elements[index] = null;
    }

    public final void clear() {
        this._size = 0;
        long[] jArr = this.metadata;
        if (jArr != ScatterMapKt.EmptyGroup) {
            ArraysKt.fill$default(jArr, -9187201950435737472L, 0, 0, 6, (Object) null);
            long[] jArr2 = this.metadata;
            int i = this._capacity;
            int i2 = i >> 3;
            long j = 255 << ((i & 7) << 3);
            jArr2[i2] = (jArr2[i2] & (~j)) | j;
        }
        ArraysKt.fill(this.elements, (Object) null, 0, this._capacity);
        initializeGrowth();
    }

    private final int findFirstAvailableSlot(int hash1) {
        int i = this._capacity;
        int i2 = hash1 & i;
        int i3 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i4 = i2 >> 3;
            int i5 = (i2 & 7) << 3;
            long j = ((jArr[i4 + 1] << (64 - i5)) & ((-i5) >> 63)) | (jArr[i4] >>> i5);
            long j2 = j & ((~j) << 7) & (-9187201950435737472L);
            if (j2 != 0) {
                return (i2 + (Long.numberOfTrailingZeros(j2) >> 3)) & i;
            }
            i3 += 8;
            i2 = (i2 + i3) & i;
        }
    }

    @IntRange(from = 0)
    public final int trim() {
        int i = this._capacity;
        int iNormalizeCapacity = ScatterMapKt.normalizeCapacity(ScatterMapKt.unloadedCapacity(this._size));
        if (iNormalizeCapacity >= i) {
            return 0;
        }
        resizeStorage(iNormalizeCapacity);
        return i - this._capacity;
    }

    private final void adjustStorage() {
        if (this._capacity > 8 && Long.compareUnsigned(ULong.m5337constructorimpl(ULong.m5337constructorimpl(this._size) * 32), ULong.m5337constructorimpl(ULong.m5337constructorimpl(this._capacity) * 25)) <= 0) {
            removeDeletedMarkers();
        } else {
            resizeStorage(ScatterMapKt.nextCapacity(this._capacity));
        }
    }

    private final void resizeStorage(int newCapacity) {
        long[] jArr = this.metadata;
        Object[] objArr = this.elements;
        int i = this._capacity;
        initializeStorage(newCapacity);
        Object[] objArr2 = this.elements;
        for (int i2 = 0; i2 < i; i2++) {
            if (((jArr[i2 >> 3] >> ((i2 & 7) << 3)) & 255) < 128) {
                Object obj = objArr[i2];
                int iHashCode = (obj != null ? obj.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
                int i3 = iHashCode ^ (iHashCode << 16);
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i3 >>> 7);
                long j = i3 & 127;
                long[] jArr2 = this.metadata;
                int i4 = iFindFirstAvailableSlot >> 3;
                int i5 = (iFindFirstAvailableSlot & 7) << 3;
                jArr2[i4] = (jArr2[i4] & (~(255 << i5))) | (j << i5);
                int i6 = this._capacity;
                int i7 = ((iFindFirstAvailableSlot - 7) & i6) + (i6 & 7);
                int i8 = i7 >> 3;
                int i9 = (i7 & 7) << 3;
                jArr2[i8] = ((~(255 << i9)) & jArr2[i8]) | (j << i9);
                objArr2[iFindFirstAvailableSlot] = obj;
            }
        }
    }

    private final void removeDeletedMarkers() {
        long[] jArr = this.metadata;
        int i = this._capacity;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 >> 3;
            int i5 = (i3 & 7) << 3;
            if (((jArr[i4] >> i5) & 255) == 254) {
                long[] jArr2 = this.metadata;
                jArr2[i4] = (128 << i5) | (jArr2[i4] & (~(255 << i5)));
                int i6 = this._capacity;
                int i7 = ((i3 - 7) & i6) + (i6 & 7);
                int i8 = i7 >> 3;
                int i9 = (i7 & 7) << 3;
                jArr2[i8] = ((~(255 << i9)) & jArr2[i8]) | (128 << i9);
                i2++;
            }
        }
        this.growthLimit += i2;
    }

    @NotNull
    public final Set<E> asMutableSet() {
        return new MutableSetWrapper();
    }

    private final class MutableSetWrapper extends ScatterSet.SetWrapper implements Set, KMutableSet {
        public MutableSetWrapper() {
            super();
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            return MutableScatterSet.this.add(obj);
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean addAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return MutableScatterSet.this.addAll(elements);
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public void clear() {
            MutableScatterSet.this.clear();
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new MutableScatterSet$MutableSetWrapper$iterator$1(MutableScatterSet.this);
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            return MutableScatterSet.this.remove(obj);
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean retainAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            MutableScatterSet mutableScatterSet = MutableScatterSet.this;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            boolean z = false;
            if (length >= 0) {
                int i = 0;
                boolean z2 = false;
                while (true) {
                    long j = jArr[i];
                    if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i2 = 8 - ((~(i - length)) >>> 31);
                        for (int i3 = 0; i3 < i2; i3++) {
                            if ((255 & j) < 128) {
                                int i4 = (i << 3) + i3;
                                if (!elements.contains(mutableScatterSet.elements[i4])) {
                                    mutableScatterSet.removeElementAt(i4);
                                    z2 = true;
                                }
                            }
                            j >>= 8;
                        }
                        if (i2 != 8) {
                            return z2;
                        }
                    }
                    if (i != length) {
                        i++;
                    } else {
                        z = z2;
                    }
                }
            }
            return z;
        }

        @Override // androidx.collection.ScatterSet.SetWrapper, java.util.Set, java.util.Collection
        public boolean removeAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            int i = MutableScatterSet.this.get_size();
            Iterator<E> it = elements.iterator();
            while (it.hasNext()) {
                MutableScatterSet.this.minusAssign(it.next());
            }
            return i != MutableScatterSet.this.get_size();
        }
    }

    public final void plusAssign(@NotNull E[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (E e : elements) {
            plusAssign(e);
        }
    }

    public final void plusAssign(@NotNull Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            plusAssign(it.next());
        }
    }

    public final void minusAssign(@NotNull E[] elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        for (E e : elements) {
            minusAssign(e);
        }
    }

    public final void minusAssign(@NotNull Sequence<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            minusAssign(it.next());
        }
    }

    private final int findAbsoluteInsertIndex(Object element) {
        int iHashCode = (element != null ? element.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i >>> 7;
        int i3 = i & 127;
        int i4 = this._capacity;
        int i5 = i2 & i4;
        int i6 = 0;
        while (true) {
            long[] jArr = this.metadata;
            int i7 = i5 >> 3;
            int i8 = (i5 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = i3;
            int i9 = i3;
            long j3 = j ^ (j2 * ScatterMapKt.BitmaskLsb);
            for (long j4 = (~j3) & (j3 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j4 != 0; j4 &= j4 - 1) {
                int iNumberOfTrailingZeros = (i5 + (Long.numberOfTrailingZeros(j4) >> 3)) & i4;
                if (Intrinsics.areEqual(this.elements[iNumberOfTrailingZeros], element)) {
                    return iNumberOfTrailingZeros;
                }
            }
            if ((((~j) << 6) & j & (-9187201950435737472L)) != 0) {
                int iFindFirstAvailableSlot = findFirstAvailableSlot(i2);
                if (this.growthLimit == 0 && ((this.metadata[iFindFirstAvailableSlot >> 3] >> ((iFindFirstAvailableSlot & 7) << 3)) & 255) != 254) {
                    adjustStorage();
                    iFindFirstAvailableSlot = findFirstAvailableSlot(i2);
                }
                this._size++;
                int i10 = this.growthLimit;
                long[] jArr2 = this.metadata;
                int i11 = iFindFirstAvailableSlot >> 3;
                long j5 = jArr2[i11];
                int i12 = (iFindFirstAvailableSlot & 7) << 3;
                this.growthLimit = i10 - (((j5 >> i12) & 255) == 128 ? 1 : 0);
                jArr2[i11] = (j5 & (~(255 << i12))) | (j2 << i12);
                int i13 = this._capacity;
                int i14 = ((iFindFirstAvailableSlot - 7) & i13) + (i13 & 7);
                int i15 = i14 >> 3;
                int i16 = (i14 & 7) << 3;
                jArr2[i15] = ((~(255 << i16)) & jArr2[i15]) | (j2 << i16);
                return iFindFirstAvailableSlot;
            }
            i6 += 8;
            i5 = (i5 + i6) & i4;
            i3 = i9;
        }
    }

    public final void minusAssign(E element) {
        int iNumberOfTrailingZeros;
        int i = 0;
        int iHashCode = (element != null ? element.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i2 = iHashCode ^ (iHashCode << 16);
        int i3 = i2 & 127;
        int i4 = this._capacity;
        int i5 = i2 >>> 7;
        loop0: while (true) {
            int i6 = i5 & i4;
            long[] jArr = this.metadata;
            int i7 = i6 >> 3;
            int i8 = (i6 & 7) << 3;
            long j = ((jArr[i7 + 1] << (64 - i8)) & ((-i8) >> 63)) | (jArr[i7] >>> i8);
            long j2 = (((long) i3) * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i6) & i4;
                if (Intrinsics.areEqual(this.elements[iNumberOfTrailingZeros], element)) {
                    break loop0;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            } else {
                i += 8;
                i5 = i6 + i;
            }
        }
        if (iNumberOfTrailingZeros >= 0) {
            removeElementAt(iNumberOfTrailingZeros);
        }
    }

    public final boolean remove(E element) {
        int iNumberOfTrailingZeros;
        int iHashCode = (element != null ? element.hashCode() : 0) * ScatterMapKt.MurmurHashC1;
        int i = iHashCode ^ (iHashCode << 16);
        int i2 = i & 127;
        int i3 = this._capacity;
        int i4 = (i >>> 7) & i3;
        int i5 = 0;
        loop0: while (true) {
            long[] jArr = this.metadata;
            int i6 = i4 >> 3;
            int i7 = (i4 & 7) << 3;
            long j = ((jArr[i6 + 1] << (64 - i7)) & ((-i7) >> 63)) | (jArr[i6] >>> i7);
            long j2 = (((long) i2) * ScatterMapKt.BitmaskLsb) ^ j;
            for (long j3 = (~j2) & (j2 - ScatterMapKt.BitmaskLsb) & (-9187201950435737472L); j3 != 0; j3 &= j3 - 1) {
                iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j3) >> 3) + i4) & i3;
                if (Intrinsics.areEqual(this.elements[iNumberOfTrailingZeros], element)) {
                    break loop0;
                }
            }
            if ((j & ((~j) << 6) & (-9187201950435737472L)) != 0) {
                iNumberOfTrailingZeros = -1;
                break;
            }
            i5 += 8;
            i4 = (i4 + i5) & i3;
        }
        boolean z = iNumberOfTrailingZeros >= 0;
        if (z) {
            removeElementAt(iNumberOfTrailingZeros);
        }
        return z;
    }

    public final void minusAssign(@NotNull Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            minusAssign(it.next());
        }
    }

    public final void plusAssign(@NotNull Iterable<? extends E> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            plusAssign(it.next());
        }
    }
}
