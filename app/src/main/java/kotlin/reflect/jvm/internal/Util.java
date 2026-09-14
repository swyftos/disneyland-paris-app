package kotlin.reflect.jvm.internal;

/* JADX INFO: loaded from: classes6.dex */
abstract class Util {
    public static Object getEnumConstantByName(Class cls, String str) {
        return Enum.valueOf(cls, str);
    }
}
