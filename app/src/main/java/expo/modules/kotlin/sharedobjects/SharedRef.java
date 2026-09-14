package expo.modules.kotlin.sharedobjects;

import ch.qos.logback.core.joran.action.ActionConst;
import expo.modules.core.interfaces.DoNotStrip;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.RuntimeContext;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0017\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, m1836d2 = {"Lexpo/modules/kotlin/sharedobjects/SharedRef;", "RefType", "Lexpo/modules/kotlin/sharedobjects/SharedObject;", ActionConst.REF_ATTRIBUTE, "runtimeContext", "Lexpo/modules/kotlin/RuntimeContext;", "<init>", "(Ljava/lang/Object;Lexpo/modules/kotlin/RuntimeContext;)V", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Ljava/lang/Object;Lexpo/modules/kotlin/AppContext;)V", "getRef", "()Ljava/lang/Object;", "Ljava/lang/Object;", "nativeRefType", "", "getNativeRefType", "()Ljava/lang/String;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@DoNotStrip
public class SharedRef<RefType> extends SharedObject {
    private final String nativeRefType;
    private final Object ref;

    public /* synthetic */ SharedRef(Object obj, RuntimeContext runtimeContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i & 2) != 0 ? null : runtimeContext);
    }

    public final RefType getRef() {
        return (RefType) this.ref;
    }

    public SharedRef(RefType reftype, @Nullable RuntimeContext runtimeContext) {
        super(runtimeContext);
        this.ref = reftype;
        this.nativeRefType = "unknown";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SharedRef(RefType reftype, @NotNull AppContext appContext) {
        this(reftype, appContext.getHostingRuntimeContext());
        Intrinsics.checkNotNullParameter(appContext, "appContext");
    }

    @NotNull
    public String getNativeRefType() {
        return this.nativeRefType;
    }
}
