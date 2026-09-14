package ch.qos.logback.core.joran.action;

import ch.qos.logback.core.joran.spi.InterpretationContext;
import ch.qos.logback.core.util.ContextUtil;
import ch.qos.logback.core.util.OptionHelper;
import java.util.Properties;

/* JADX INFO: loaded from: classes2.dex */
public class ActionUtil {

    /* JADX INFO: renamed from: ch.qos.logback.core.joran.action.ActionUtil$1 */
    static /* synthetic */ class C17181 {
        static final /* synthetic */ int[] $SwitchMap$ch$qos$logback$core$joran$action$ActionUtil$Scope;

        static {
            int[] iArr = new int[Scope.values().length];
            $SwitchMap$ch$qos$logback$core$joran$action$ActionUtil$Scope = iArr;
            try {
                iArr[Scope.LOCAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$joran$action$ActionUtil$Scope[Scope.CONTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$ch$qos$logback$core$joran$action$ActionUtil$Scope[Scope.SYSTEM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum Scope {
        LOCAL,
        CONTEXT,
        SYSTEM
    }

    public static void setProperties(InterpretationContext interpretationContext, Properties properties, Scope scope) {
        int i = C17181.$SwitchMap$ch$qos$logback$core$joran$action$ActionUtil$Scope[scope.ordinal()];
        if (i == 1) {
            interpretationContext.addSubstitutionProperties(properties);
        } else if (i == 2) {
            new ContextUtil(interpretationContext.getContext()).addProperties(properties);
        } else {
            if (i != 3) {
                return;
            }
            OptionHelper.setSystemProperties(interpretationContext, properties);
        }
    }

    public static void setProperty(InterpretationContext interpretationContext, String str, String str2, Scope scope) {
        int i = C17181.$SwitchMap$ch$qos$logback$core$joran$action$ActionUtil$Scope[scope.ordinal()];
        if (i == 1) {
            interpretationContext.addSubstitutionProperty(str, str2);
        } else if (i == 2) {
            interpretationContext.getContext().putProperty(str, str2);
        } else {
            if (i != 3) {
                return;
            }
            OptionHelper.setSystemProperty(interpretationContext, str, str2);
        }
    }

    public static Scope stringToScope(String str) {
        Scope scope = Scope.SYSTEM;
        if (scope.toString().equalsIgnoreCase(str)) {
            return scope;
        }
        Scope scope2 = Scope.CONTEXT;
        return scope2.toString().equalsIgnoreCase(str) ? scope2 : Scope.LOCAL;
    }
}
