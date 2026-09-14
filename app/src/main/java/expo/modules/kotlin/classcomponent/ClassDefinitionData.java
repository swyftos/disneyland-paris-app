package expo.modules.kotlin.classcomponent;

import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0012¨\u0006\u0013"}, m1836d2 = {"Lexpo/modules/kotlin/classcomponent/ClassDefinitionData;", "", "name", "", "constructor", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "objectDefinition", "Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "isSharedRef", "", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/functions/SyncFunctionComponent;Lexpo/modules/kotlin/objects/ObjectDefinitionData;Z)V", "getName", "()Ljava/lang/String;", "getConstructor", "()Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getObjectDefinition", "()Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "()Z", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ClassDefinitionData {
    private final SyncFunctionComponent constructor;
    private final boolean isSharedRef;
    private final String name;
    private final ObjectDefinitionData objectDefinition;

    public ClassDefinitionData(@NotNull String name, @NotNull SyncFunctionComponent constructor, @NotNull ObjectDefinitionData objectDefinition, boolean z) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(constructor, "constructor");
        Intrinsics.checkNotNullParameter(objectDefinition, "objectDefinition");
        this.name = name;
        this.constructor = constructor;
        this.objectDefinition = objectDefinition;
        this.isSharedRef = z;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final SyncFunctionComponent getConstructor() {
        return this.constructor;
    }

    @NotNull
    public final ObjectDefinitionData getObjectDefinition() {
        return this.objectDefinition;
    }

    /* JADX INFO: renamed from: isSharedRef, reason: from getter */
    public final boolean getIsSharedRef() {
        return this.isSharedRef;
    }
}
