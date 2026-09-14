package expo.modules.kotlin.views.decorators;

import ch.qos.logback.core.net.SyslogConstants;
import com.facebook.react.bridge.ReadableArray;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = SyslogConstants.LOG_LOCAL6)
public final class CSSPropsKt$UseBoxShadowProp$$inlined$Prop$1 implements Function0<KType> {
    public static final CSSPropsKt$UseBoxShadowProp$$inlined$Prop$1 INSTANCE = new CSSPropsKt$UseBoxShadowProp$$inlined$Prop$1();

    @Override // kotlin.jvm.functions.Function0
    public final KType invoke() {
        return Reflection.nullableTypeOf(ReadableArray.class);
    }
}
