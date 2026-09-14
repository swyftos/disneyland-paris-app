package expo.modules.kotlin.events;

import com.tagcommander.lib.p193serverside.ETCPaymentMethod;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\u0000H\u0086\u0002R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, m1836d2 = {"Lexpo/modules/kotlin/events/EventsDefinition;", "", "names", "", "", "<init>", "([Ljava/lang/String;)V", "getNames", "()[Ljava/lang/String;", "[Ljava/lang/String;", "plus", ETCPaymentMethod.OTHER, "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class EventsDefinition {
    private final String[] names;

    public EventsDefinition(@NotNull String[] names) {
        Intrinsics.checkNotNullParameter(names, "names");
        this.names = names;
    }

    @NotNull
    public final String[] getNames() {
        return this.names;
    }

    @NotNull
    public final EventsDefinition plus(@Nullable EventsDefinition other) {
        return other == null ? this : new EventsDefinition((String[]) ArraysKt.plus((Object[]) this.names, (Object[]) other.names));
    }
}
