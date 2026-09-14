package expo.modules.kotlin.objects;

import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import com.urbanairship.analytics.CustomEvent;
import expo.modules.kotlin.ConcatIterator;
import expo.modules.kotlin.events.EventsDefinition;
import expo.modules.kotlin.functions.AnyFunction;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B}\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u0004\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010 \u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0000H\u0086\u0002R%\u0010\u0002\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006\""}, m1836d2 = {"Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "", "legacyConstantsProvider", "Lkotlin/Function0;", "", "", "syncFunctions", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "asyncFunctions", "Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "eventsDefinition", "Lexpo/modules/kotlin/events/EventsDefinition;", CustomEvent.PROPERTIES, "Lexpo/modules/kotlin/objects/PropertyComponent;", "constants", "Lexpo/modules/kotlin/objects/ConstantComponent;", "<init>", "(Lkotlin/jvm/functions/Function0;Ljava/util/Map;Ljava/util/Map;Lexpo/modules/kotlin/events/EventsDefinition;Ljava/util/Map;Ljava/util/Map;)V", "getLegacyConstantsProvider", "()Lkotlin/jvm/functions/Function0;", "getSyncFunctions", "()Ljava/util/Map;", "getAsyncFunctions", "getEventsDefinition", "()Lexpo/modules/kotlin/events/EventsDefinition;", "getProperties", "getConstants", "functions", "Lexpo/modules/kotlin/ConcatIterator;", "Lexpo/modules/kotlin/functions/AnyFunction;", "getFunctions", "()Lexpo/modules/kotlin/ConcatIterator;", "plus", ETCPaymentMethod.OTHER, "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ObjectDefinitionData {
    private final Map asyncFunctions;
    private final Map constants;
    private final EventsDefinition eventsDefinition;
    private final Function0 legacyConstantsProvider;
    private final Map properties;
    private final Map syncFunctions;

    public ObjectDefinitionData(@NotNull Function0<? extends Map<String, ? extends Object>> legacyConstantsProvider, @NotNull Map<String, SyncFunctionComponent> syncFunctions, @NotNull Map<String, ? extends BaseAsyncFunctionComponent> asyncFunctions, @Nullable EventsDefinition eventsDefinition, @NotNull Map<String, PropertyComponent> properties, @NotNull Map<String, ConstantComponent> constants) {
        Intrinsics.checkNotNullParameter(legacyConstantsProvider, "legacyConstantsProvider");
        Intrinsics.checkNotNullParameter(syncFunctions, "syncFunctions");
        Intrinsics.checkNotNullParameter(asyncFunctions, "asyncFunctions");
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(constants, "constants");
        this.legacyConstantsProvider = legacyConstantsProvider;
        this.syncFunctions = syncFunctions;
        this.asyncFunctions = asyncFunctions;
        this.eventsDefinition = eventsDefinition;
        this.properties = properties;
        this.constants = constants;
    }

    @NotNull
    public final Function0<Map<String, Object>> getLegacyConstantsProvider() {
        return this.legacyConstantsProvider;
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
        return new ConcatIterator<>(this.syncFunctions.values().iterator(), this.asyncFunctions.values().iterator());
    }

    @NotNull
    public final ObjectDefinitionData plus(@Nullable final ObjectDefinitionData other) {
        if (other == null) {
            return this;
        }
        Function0 function0 = new Function0() { // from class: expo.modules.kotlin.objects.ObjectDefinitionData$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ObjectDefinitionData.plus$lambda$0(this.f$0, other);
            }
        };
        Map mapPlus = MapsKt.plus(this.syncFunctions, other.syncFunctions);
        Map mapPlus2 = MapsKt.plus(this.asyncFunctions, other.asyncFunctions);
        EventsDefinition eventsDefinition = this.eventsDefinition;
        return new ObjectDefinitionData(function0, mapPlus, mapPlus2, eventsDefinition != null ? eventsDefinition.plus(other.eventsDefinition) : null, MapsKt.plus(this.properties, other.properties), MapsKt.plus(this.constants, other.constants));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map plus$lambda$0(ObjectDefinitionData objectDefinitionData, ObjectDefinitionData objectDefinitionData2) {
        return MapsKt.plus((Map) objectDefinitionData.legacyConstantsProvider.invoke(), (Map) objectDefinitionData2.legacyConstantsProvider.invoke());
    }
}
