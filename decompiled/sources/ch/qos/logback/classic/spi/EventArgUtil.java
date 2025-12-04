package ch.qos.logback.classic.spi;

/* loaded from: classes2.dex */
public class EventArgUtil {
    public static Object[] arrangeArguments(Object[] objArr) {
        return objArr;
    }

    public static final Throwable extractThrowable(Object[] objArr) {
        if (objArr != null && objArr.length != 0) {
            Object obj = objArr[objArr.length - 1];
            if (obj instanceof Throwable) {
                return (Throwable) obj;
            }
        }
        return null;
    }

    public static boolean successfulExtraction(Throwable th) {
        return th != null;
    }

    public static Object[] trimmedCopy(Object[] objArr) {
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        return objArr2;
    }
}
