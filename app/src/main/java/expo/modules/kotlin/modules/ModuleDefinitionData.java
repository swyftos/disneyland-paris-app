package expo.modules.kotlin.modules;

import com.urbanairship.analytics.CustomEvent;
import expo.modules.kotlin.ConcatIterator;
import expo.modules.kotlin.activityresult.AppContextActivityResultCaller;
import expo.modules.kotlin.classcomponent.ClassDefinitionData;
import expo.modules.kotlin.events.EventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.EventsDefinition;
import expo.modules.kotlin.functions.AnyFunction;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.objects.ConstantComponent;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import expo.modules.kotlin.objects.PropertyComponent;
import expo.modules.kotlin.views.ViewManagerDefinition;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0080\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0007\u0012+\b\u0002\u0010\f\u001a%\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r¢\u0006\u0002\b\u0011\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR6\u0010\f\u001a%\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\r¢\u0006\u0002\b\u0011¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R%\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00070$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u001d\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020(0\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u001d\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020+0\u0007¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0013\u0010-\u001a\u0004\u0018\u00010.¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u001d\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002020\u0007¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001cR\u001d\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002050\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001cR\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020908¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;¨\u0006<"}, m1836d2 = {"Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "", "name", "", "objectDefinition", "Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "viewManagerDefinitions", "", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "eventListeners", "Lexpo/modules/kotlin/events/EventName;", "Lexpo/modules/kotlin/events/EventListener;", "registerContracts", "Lkotlin/Function2;", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultCaller;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "classData", "", "Lexpo/modules/kotlin/classcomponent/ClassDefinitionData;", "<init>", "(Ljava/lang/String;Lexpo/modules/kotlin/objects/ObjectDefinitionData;Ljava/util/Map;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "getObjectDefinition", "()Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "getViewManagerDefinitions", "()Ljava/util/Map;", "getEventListeners", "getRegisterContracts", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getClassData", "()Ljava/util/List;", "constantsProvider", "Lkotlin/Function0;", "getConstantsProvider", "()Lkotlin/jvm/functions/Function0;", "syncFunctions", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getSyncFunctions", "asyncFunctions", "Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "getAsyncFunctions", "eventsDefinition", "Lexpo/modules/kotlin/events/EventsDefinition;", "getEventsDefinition", "()Lexpo/modules/kotlin/events/EventsDefinition;", CustomEvent.PROPERTIES, "Lexpo/modules/kotlin/objects/PropertyComponent;", "getProperties", "constants", "Lexpo/modules/kotlin/objects/ConstantComponent;", "getConstants", "functions", "Lexpo/modules/kotlin/ConcatIterator;", "Lexpo/modules/kotlin/functions/AnyFunction;", "getFunctions", "()Lexpo/modules/kotlin/ConcatIterator;", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ModuleDefinitionData {
    private final Map asyncFunctions;
    private final List classData;
    private final Map constants;
    private final Function0 constantsProvider;
    private final Map eventListeners;
    private final EventsDefinition eventsDefinition;
    private final ConcatIterator functions;
    private final String name;
    private final ObjectDefinitionData objectDefinition;
    private final Map properties;
    private final Function2 registerContracts;
    private final Map syncFunctions;
    private final Map viewManagerDefinitions;

    public ModuleDefinitionData(@NotNull String name, @NotNull ObjectDefinitionData objectDefinition, @NotNull Map<String, ViewManagerDefinition> viewManagerDefinitions, @NotNull Map<EventName, ? extends EventListener> eventListeners, @Nullable Function2<? super AppContextActivityResultCaller, ? super Continuation<? super Unit>, ? extends Object> function2, @NotNull List<ClassDefinitionData> classData) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(objectDefinition, "objectDefinition");
        Intrinsics.checkNotNullParameter(viewManagerDefinitions, "viewManagerDefinitions");
        Intrinsics.checkNotNullParameter(eventListeners, "eventListeners");
        Intrinsics.checkNotNullParameter(classData, "classData");
        this.name = name;
        this.objectDefinition = objectDefinition;
        this.viewManagerDefinitions = viewManagerDefinitions;
        this.eventListeners = eventListeners;
        this.registerContracts = function2;
        this.classData = classData;
        this.constantsProvider = objectDefinition.getLegacyConstantsProvider();
        this.syncFunctions = objectDefinition.getSyncFunctions();
        this.asyncFunctions = objectDefinition.getAsyncFunctions();
        this.eventsDefinition = objectDefinition.getEventsDefinition();
        this.properties = objectDefinition.getProperties();
        this.constants = objectDefinition.getConstants();
        this.functions = objectDefinition.getFunctions();
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final ObjectDefinitionData getObjectDefinition() {
        return this.objectDefinition;
    }

    public /* synthetic */ ModuleDefinitionData(String str, ObjectDefinitionData objectDefinitionData, Map map, Map map2, Function2 function2, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, objectDefinitionData, (i & 4) != 0 ? MapsKt.emptyMap() : map, (i & 8) != 0 ? MapsKt.emptyMap() : map2, (i & 16) != 0 ? null : function2, (i & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    @NotNull
    public final Map<String, ViewManagerDefinition> getViewManagerDefinitions() {
        return this.viewManagerDefinitions;
    }

    @NotNull
    public final Map<EventName, EventListener> getEventListeners() {
        return this.eventListeners;
    }

    @Nullable
    public final Function2<AppContextActivityResultCaller, Continuation<? super Unit>, Object> getRegisterContracts() {
        return this.registerContracts;
    }

    @NotNull
    public final List<ClassDefinitionData> getClassData() {
        return this.classData;
    }

    @NotNull
    public final Function0<Map<String, Object>> getConstantsProvider() {
        return this.constantsProvider;
    }

    @NotNull
    public final Map<String, SyncFunctionComponent> getSyncFunctions() {
        return this.syncFunctions;
    }

    @NotNull
    public final Map<String, BaseAsyncFunctionComponent> getAsyncFunctions() {
        return this.asyncFunctions;
    }

    @Nullable
    public final EventsDefinition getEventsDefinition() {
        return this.eventsDefinition;
    }

    @NotNull
    public final Map<String, PropertyComponent> getProperties() {
        return this.properties;
    }

    @NotNull
    public final Map<String, ConstantComponent> getConstants() {
        return this.constants;
    }

    @NotNull
    public final ConcatIterator<AnyFunction> getFunctions() {
        return this.functions;
    }
}
