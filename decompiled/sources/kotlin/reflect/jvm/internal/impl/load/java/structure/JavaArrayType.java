package kotlin.reflect.jvm.internal.impl.load.java.structure;

import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public interface JavaArrayType extends JavaType {
    @NotNull
    JavaType getComponentType();
}
