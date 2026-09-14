package expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.RuntimeContext;
import expo.modules.kotlin.events.KModuleEventEmitterWrapperKt;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.OnViewDidUpdatePropsException;
import expo.modules.kotlin.exception.UnexpectedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001eJ\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00070%2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'J\u000e\u0010(\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001eJ\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0019R\u001e\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011R\u001d\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001a0\u00198F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, m1836d2 = {"Lexpo/modules/kotlin/views/ViewManagerWrapperDelegate;", "", "moduleHolder", "Lexpo/modules/kotlin/ModuleHolder;", "definition", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "delegateName", "", "<init>", "(Lexpo/modules/kotlin/ModuleHolder;Lexpo/modules/kotlin/views/ViewManagerDefinition;Ljava/lang/String;)V", "getModuleHolder$expo_modules_core_release", "()Lexpo/modules/kotlin/ModuleHolder;", "setModuleHolder$expo_modules_core_release", "(Lexpo/modules/kotlin/ModuleHolder;)V", "getDefinition$expo_modules_core_release", "()Lexpo/modules/kotlin/views/ViewManagerDefinition;", "getDelegateName$expo_modules_core_release", "()Ljava/lang/String;", "viewGroupDefinition", "Lexpo/modules/kotlin/views/ViewGroupDefinition;", "getViewGroupDefinition$expo_modules_core_release", "()Lexpo/modules/kotlin/views/ViewGroupDefinition;", "name", "getName", "props", "", "Lexpo/modules/kotlin/views/AnyViewProp;", "getProps", "()Ljava/util/Map;", "createView", "Landroid/view/View;", "context", "Landroid/content/Context;", "onViewDidUpdateProps", "", "view", "updateProperties", "", "propsMap", "Lcom/facebook/react/bridge/ReadableMap;", "onDestroy", "getExportedCustomDirectEventTypeConstants", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nViewManagerWrapperDelegate.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewManagerWrapperDelegate.kt\nexpo/modules/kotlin/views/ViewManagerWrapperDelegate\n+ 2 ExceptionDecorator.kt\nexpo/modules/kotlin/exception/ExceptionDecoratorKt\n+ 3 CodedException.kt\nexpo/modules/kotlin/exception/CodedExceptionKt\n+ 4 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,120:1\n5#2,4:121\n11#3,6:125\n11#3,6:131\n11#3,6:137\n11#3,6:143\n13409#4,2:149\n*S KotlinDebug\n*F\n+ 1 ViewManagerWrapperDelegate.kt\nexpo/modules/kotlin/views/ViewManagerWrapperDelegate\n*L\n31#1:121,4\n31#1:125,6\n41#1:131,6\n73#1:137,6\n97#1:143,6\n111#1:149,2\n*E\n"})
public final class ViewManagerWrapperDelegate {
    private final ViewManagerDefinition definition;
    private final String delegateName;
    private ModuleHolder moduleHolder;

    public ViewManagerWrapperDelegate(@NotNull ModuleHolder<?> moduleHolder, @NotNull ViewManagerDefinition definition, @Nullable String str) {
        Intrinsics.checkNotNullParameter(moduleHolder, "moduleHolder");
        Intrinsics.checkNotNullParameter(definition, "definition");
        this.moduleHolder = moduleHolder;
        this.definition = definition;
        this.delegateName = str;
    }

    public /* synthetic */ ViewManagerWrapperDelegate(ModuleHolder moduleHolder, ViewManagerDefinition viewManagerDefinition, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(moduleHolder, viewManagerDefinition, (i & 4) != 0 ? null : str);
    }

    @NotNull
    /* JADX INFO: renamed from: getDefinition$expo_modules_core_release, reason: from getter */
    public final ViewManagerDefinition getDefinition() {
        return this.definition;
    }

    @Nullable
    /* JADX INFO: renamed from: getDelegateName$expo_modules_core_release, reason: from getter */
    public final String getDelegateName() {
        return this.delegateName;
    }

    @NotNull
    public final ModuleHolder<?> getModuleHolder$expo_modules_core_release() {
        return this.moduleHolder;
    }

    public final void setModuleHolder$expo_modules_core_release(@NotNull ModuleHolder<?> moduleHolder) {
        Intrinsics.checkNotNullParameter(moduleHolder, "<set-?>");
        this.moduleHolder = moduleHolder;
    }

    @Nullable
    public final ViewGroupDefinition getViewGroupDefinition$expo_modules_core_release() {
        return this.definition.getViewGroupDefinition();
    }

    @NotNull
    public final String getName() {
        String str = this.delegateName;
        if (str != null) {
            return str;
        }
        return this.moduleHolder.getName() + "_" + this.definition.getName();
    }

    @NotNull
    public final Map<String, AnyViewProp> getProps() {
        return this.definition.getProps$expo_modules_core_release();
    }

    @NotNull
    public final View createView(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return this.definition.createView(context, this.moduleHolder.getModule().getAppContext());
    }

    public final void onViewDidUpdateProps(@NotNull View view) {
        CodedException unexpectedException;
        CodedException unexpectedException2;
        Intrinsics.checkNotNullParameter(view, "view");
        Function1<View, Unit> onViewDidUpdateProps = this.definition.getOnViewDidUpdateProps();
        if (onViewDidUpdateProps != null) {
            try {
                onViewDidUpdateProps.invoke(view);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    if (th instanceof CodedException) {
                        unexpectedException2 = (CodedException) th;
                    } else if (th instanceof expo.modules.core.errors.CodedException) {
                        String code = ((expo.modules.core.errors.CodedException) th).getCode();
                        Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                        unexpectedException2 = new CodedException(code, ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause());
                    } else {
                        unexpectedException2 = new UnexpectedException(th);
                    }
                    throw new OnViewDidUpdatePropsException(JvmClassMappingKt.getKotlinClass(view.getClass()), unexpectedException2);
                } catch (Throwable th2) {
                    if (ErrorViewKt.isErrorView(view)) {
                        return;
                    }
                    if (th2 instanceof CodedException) {
                        unexpectedException = (CodedException) th2;
                    } else if (th2 instanceof expo.modules.core.errors.CodedException) {
                        expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th2;
                        String code2 = codedException.getCode();
                        Intrinsics.checkNotNullExpressionValue(code2, "getCode(...)");
                        unexpectedException = new CodedException(code2, codedException.getMessage(), codedException.getCause());
                    } else {
                        unexpectedException = new UnexpectedException(th2);
                    }
                    CoreLoggerKt.getLogger().error("❌ Error occurred when invoking 'onViewDidUpdateProps' on '" + view.getClass().getSimpleName() + "'", unexpectedException);
                    this.definition.handleException(view, unexpectedException);
                }
            }
        }
    }

    @NotNull
    public final List<String> updateProperties(@NotNull View view, @NotNull ReadableMap propsMap) {
        CodedException unexpectedException;
        CodedException codedException;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propsMap, "propsMap");
        Map<String, AnyViewProp> props = getProps();
        ArrayList arrayList = new ArrayList();
        ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = propsMap.keySetIterator();
        while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
            String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
            AnyViewProp anyViewProp = props.get(strNextKey);
            if (anyViewProp != null) {
                try {
                    Dynamic dynamic = propsMap.getDynamic(strNextKey);
                    RuntimeContext runtimeContext = this.moduleHolder.getModule().get_runtimeContext();
                    anyViewProp.set(dynamic, view, runtimeContext != null ? runtimeContext.getAppContext() : null);
                } catch (Throwable th) {
                    try {
                        if (!ErrorViewKt.isErrorView(view)) {
                            if (th instanceof CodedException) {
                                codedException = (CodedException) th;
                            } else {
                                if (th instanceof expo.modules.core.errors.CodedException) {
                                    String code = ((expo.modules.core.errors.CodedException) th).getCode();
                                    Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                                    unexpectedException = new CodedException(code, ((expo.modules.core.errors.CodedException) th).getMessage(), ((expo.modules.core.errors.CodedException) th).getCause());
                                } else {
                                    unexpectedException = new UnexpectedException(th);
                                }
                                codedException = unexpectedException;
                            }
                            CoreLoggerKt.getLogger().error("❌ Cannot set the '" + getName() + "' prop on the '" + view + "'", codedException);
                            this.definition.handleException(view, codedException);
                        }
                    } catch (Throwable th2) {
                        arrayList.add(strNextKey);
                        throw th2;
                    }
                }
                arrayList.add(strNextKey);
            }
        }
        return arrayList;
    }

    public final void onDestroy(@NotNull View view) {
        CodedException unexpectedException;
        CodedException codedException;
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            Function1<View, Unit> onViewDestroys = this.definition.getOnViewDestroys();
            if (onViewDestroys != null) {
                onViewDestroys.invoke(view);
            }
        } catch (Throwable th) {
            if (ErrorViewKt.isErrorView(view)) {
                return;
            }
            if (th instanceof CodedException) {
                codedException = (CodedException) th;
            } else {
                if (th instanceof expo.modules.core.errors.CodedException) {
                    expo.modules.core.errors.CodedException codedException2 = (expo.modules.core.errors.CodedException) th;
                    String code = codedException2.getCode();
                    Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                    unexpectedException = new CodedException(code, codedException2.getMessage(), codedException2.getCause());
                } else {
                    unexpectedException = new UnexpectedException(th);
                }
                codedException = unexpectedException;
            }
            CoreLoggerKt.getLogger().error("❌ '" + view + "' wasn't able to destroy itself", codedException);
            this.definition.handleException(view, codedException);
        }
    }

    @Nullable
    public final Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        String[] names;
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        CallbacksDefinition callbacksDefinition = this.definition.getCallbacksDefinition();
        if (callbacksDefinition != null && (names = callbacksDefinition.getNames()) != null) {
            for (String str : names) {
                mapCreateMapBuilder.put(KModuleEventEmitterWrapperKt.normalizeEventName(str), MapsKt.mapOf(TuplesKt.m1842to("registrationName", str)));
            }
        }
        return MapsKt.build(mapCreateMapBuilder);
    }
}
