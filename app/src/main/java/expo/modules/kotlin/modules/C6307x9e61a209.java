package expo.modules.kotlin.modules;

import ch.qos.logback.core.net.SyslogConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: renamed from: expo.modules.kotlin.modules.InternalModuleDefinitionBuilder$Class$$inlined$toAnyType$default$1 */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1837k = 3, m1838mv = {2, 0, 0}, m1840xi = SyslogConstants.LOG_LOCAL6)
public final class C6307x9e61a209 implements Function0<KType> {
    public static final C6307x9e61a209 INSTANCE = new C6307x9e61a209();

    @Override // kotlin.jvm.functions.Function0
    public final KType invoke() {
        return Reflection.typeOf(Unit.class);
    }
}
