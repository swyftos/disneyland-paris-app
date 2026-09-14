package expo.modules.kotlin.exception;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m1836d2 = {"Lexpo/modules/kotlin/exception/InvalidSharedObjectIdException;", "Lexpo/modules/kotlin/exception/CodedException;", "<init>", "()V", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class InvalidSharedObjectIdException extends CodedException {
    public InvalidSharedObjectIdException() {
        super("Cannot convert provided JavaScriptObject to the SharedObject, because it doesn't contain valid id", null, 2, null);
    }
}
