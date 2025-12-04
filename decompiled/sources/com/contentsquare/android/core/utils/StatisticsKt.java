package com.contentsquare.android.core.utils;

import androidx.camera.video.AudioStats;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.common.callercontext.ContextChain;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u001c\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\u0010 \n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0004\u001a)\u0010\u0005\u001a\u00020\u0003\"\u0014\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00060\u0007*\b\u0012\u0004\u0012\u0002H\u00060\bH\u0086\b\u001a6\u0010\t\u001a\u0002H\u0006\"\u0014\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00060\u0007*\b\u0012\u0004\u0012\u0002H\u00060\b2\u0006\u0010\n\u001a\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"convert", "R", "", "", "(D)Ljava/lang/Number;", "median", ExifInterface.GPS_DIRECTION_TRUE, "", "", "percentile", ContextChain.TAG_PRODUCT, "(Ljava/util/List;D)Ljava/lang/Number;", "core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nStatistics.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Statistics.kt\ncom/contentsquare/android/core/utils/StatisticsKt\n*L\n1#1,72:1\n63#1,8:73\n63#1,8:81\n*S KotlinDebug\n*F\n+ 1 Statistics.kt\ncom/contentsquare/android/core/utils/StatisticsKt\n*L\n16#1:73,8\n33#1:81,8\n*E\n"})
/* loaded from: classes2.dex */
public final class StatisticsKt {
    public static final /* synthetic */ <R extends Number> R convert(double d) {
        R rValueOf;
        Intrinsics.reifiedOperationMarker(4, "R");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Number.class);
        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
            rValueOf = Integer.valueOf((int) d);
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
            rValueOf = Long.valueOf((long) d);
        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
            rValueOf = Float.valueOf((float) d);
        } else {
            Class cls = Double.TYPE;
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                rValueOf = Double.valueOf(d);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                rValueOf = Short.valueOf((short) d);
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                    throw new IllegalArgumentException("Unsupported number type: " + Reflection.getOrCreateKotlinClass(cls).getSimpleName());
                }
                rValueOf = Byte.valueOf((byte) d);
            }
        }
        Intrinsics.reifiedOperationMarker(1, "R");
        return rValueOf;
    }

    public static final /* synthetic */ <T extends Number & Comparable<? super T>> double median(List<? extends T> list) {
        T t;
        Intrinsics.checkNotNullParameter(list, "<this>");
        int size = list.size();
        List listSorted = CollectionsKt.sorted(list);
        if (size == 0) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        if (size == 1) {
            t = list.get(0);
        } else {
            int i = size % 2;
            int i2 = size / 2;
            if (i != 1) {
                return (((Number) listSorted.get(i2)).doubleValue() + ((Number) listSorted.get(i2 - 1)).doubleValue()) / 2;
            }
            t = (T) listSorted.get(i2);
        }
        return t.doubleValue();
    }

    public static final /* synthetic */ <T extends Number & Comparable<? super T>> T percentile(List<? extends T> list, double d) {
        T tValueOf;
        Object obj;
        T tValueOf2;
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Number.class);
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                tValueOf2 = Integer.valueOf((int) AudioStats.AUDIO_AMPLITUDE_NONE);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                tValueOf2 = Long.valueOf((long) AudioStats.AUDIO_AMPLITUDE_NONE);
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                tValueOf2 = Float.valueOf((float) AudioStats.AUDIO_AMPLITUDE_NONE);
            } else {
                Class cls = Double.TYPE;
                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(cls))) {
                    tValueOf2 = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                    tValueOf2 = Short.valueOf((short) AudioStats.AUDIO_AMPLITUDE_NONE);
                } else {
                    if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                        throw new IllegalArgumentException("Unsupported number type: " + Reflection.getOrCreateKotlinClass(cls).getSimpleName());
                    }
                    tValueOf2 = Byte.valueOf((byte) AudioStats.AUDIO_AMPLITUDE_NONE);
                }
            }
            Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return tValueOf2;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        List listSorted = CollectionsKt.sorted(list);
        int size = listSorted.size();
        double d2 = (d * (size + 1)) / 100;
        int iFloor = (int) Math.floor(d2);
        double d3 = d2 - iFloor;
        if (d2 < 1.0d) {
            obj = listSorted.get(0);
        } else {
            if (d2 < size) {
                double dDoubleValue = ((Number) listSorted.get(iFloor - 1)).doubleValue();
                double dDoubleValue2 = dDoubleValue + (d3 * (((Number) listSorted.get(iFloor)).doubleValue() - dDoubleValue));
                Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
                KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(Number.class);
                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.TYPE))) {
                    tValueOf = Integer.valueOf((int) dDoubleValue2);
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    tValueOf = Long.valueOf((long) dDoubleValue2);
                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    tValueOf = Float.valueOf((float) dDoubleValue2);
                } else {
                    Class cls2 = Double.TYPE;
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(cls2))) {
                        tValueOf = Double.valueOf(dDoubleValue2);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Short.TYPE))) {
                        tValueOf = Short.valueOf((short) dDoubleValue2);
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Byte.TYPE))) {
                            throw new IllegalArgumentException("Unsupported number type: " + Reflection.getOrCreateKotlinClass(cls2).getSimpleName());
                        }
                        tValueOf = Byte.valueOf((byte) dDoubleValue2);
                    }
                }
                Intrinsics.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
                return tValueOf;
            }
            obj = listSorted.get(size - 1);
        }
        return (T) ((Number) obj);
    }
}
