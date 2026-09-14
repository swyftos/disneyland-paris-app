package coil3.content;

import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\n¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0086\n¢\u0006\u0004\b\u0006\u0010\u0004\u001a-\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\b0\fH\u0080\b\u001a3\u0010\r\u001a\u00020\b\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\n2\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\b0\u000eH\u0080\b\u001a?\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\b\u0000\u0010\t\"\b\b\u0001\u0010\u0010*\u00020\u0011*\b\u0012\u0004\u0012\u0002H\t0\n2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u0002H\t\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\fH\u0080\b\u001a?\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00100\n\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\t0\n2\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\n0\fH\u0080\b\u001aF\u0010\u0014\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\t\"\u0004\b\u0001\u0010\u0010*\b\u0012\u0004\u0012\u0002H\t0\n2\u0006\u0010\u0015\u001a\u0002H\u00102\u0018\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\u00100\u000eH\u0080\b¢\u0006\u0002\u0010\u0017\u001a<\u0010\u0018\u001a\u0004\u0018\u0001H\t\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\t*\b\u0012\u0004\u0012\u0002H\u00100\n2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\t0\fH\u0080\b¢\u0006\u0002\u0010\u0019\u001a-\u0010\u001a\u001a\u00020\b\"\u0004\b\u0000\u0010\t*\b\u0012\u0004\u0012\u0002H\t0\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u001d0\fH\u0080\b¨\u0006\u001e"}, m1836d2 = {"component1", "", "Lcoil3/util/IntPair;", "component1-wuMLFU8", "(J)I", "component2", "component2-wuMLFU8", "forEachIndices", "", ExifInterface.GPS_DIRECTION_TRUE, "", "action", "Lkotlin/Function1;", "forEachIndexedIndices", "Lkotlin/Function2;", "mapNotNullIndices", "R", "", ViewProps.TRANSFORM, "flatMapIndices", "foldIndices", "initial", "operation", "(Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "firstNotNullOfOrNullIndices", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "removeIfIndices", "", "predicate", "", "coil-core_release"}, m1837k = 2, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\ncollections.kt\nKotlin\n*S Kotlin\n*F\n+ 1 collections.kt\ncoil3/util/CollectionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,110:1\n1#2:111\n*E\n"})
public final class CollectionsKt {
    /* JADX INFO: renamed from: component1-wuMLFU8, reason: not valid java name */
    public static final int m2806component1wuMLFU8(long j) {
        return IntPair.m2813getFirstimpl(j);
    }

    /* JADX INFO: renamed from: component2-wuMLFU8, reason: not valid java name */
    public static final int m2807component2wuMLFU8(long j) {
        return IntPair.m2814getSecondimpl(j);
    }

    public static final <T> void forEachIndices(@NotNull List<? extends T> list, @NotNull Function1<? super T, Unit> function1) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            function1.invoke(list.get(i));
        }
    }

    public static final <T> void forEachIndexedIndices(@NotNull List<? extends T> list, @NotNull Function2<? super Integer, ? super T, Unit> function2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            function2.invoke(Integer.valueOf(i), list.get(i));
        }
    }

    @NotNull
    public static final <T, R> List<R> mapNotNullIndices(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends R> function1) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            R rInvoke = function1.invoke(list.get(i));
            if (rInvoke != null) {
                arrayList.add(rInvoke);
            }
        }
        return arrayList;
    }

    @NotNull
    public static final <T, R> List<R> flatMapIndices(@NotNull List<? extends T> list, @NotNull Function1<? super T, ? extends List<? extends R>> function1) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            kotlin.collections.CollectionsKt.addAll(arrayList, function1.invoke(list.get(i)));
        }
        return arrayList;
    }

    public static final <T, R> R foldIndices(@NotNull List<? extends T> list, R r, @NotNull Function2<? super R, ? super T, ? extends R> function2) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            r = function2.invoke(r, list.get(i));
        }
        return r;
    }

    @Nullable
    public static final <R, T> T firstNotNullOfOrNullIndices(@NotNull List<? extends R> list, @NotNull Function1<? super R, ? extends T> function1) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            T tInvoke = function1.invoke(list.get(i));
            if (tInvoke != null) {
                return tInvoke;
            }
        }
        return null;
    }

    public static final <T> void removeIfIndices(@NotNull List<T> list, @NotNull Function1<? super T, Boolean> function1) {
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = i2 - i;
            if (function1.invoke(list.get(i3)).booleanValue()) {
                list.remove(i3);
                i++;
            }
        }
    }
}
