package expo.modules.kotlin.events;

import androidx.core.app.NotificationCompat;
import com.urbanairship.actions.RateAppAction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0002\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, m1836d2 = {"Lexpo/modules/kotlin/events/EventListenerWithPayload;", "Payload", "Lexpo/modules/kotlin/events/EventListener;", "eventName", "Lexpo/modules/kotlin/events/EventName;", RateAppAction.BODY_KEY, "Lkotlin/Function1;", "", "<init>", "(Lexpo/modules/kotlin/events/EventName;Lkotlin/jvm/functions/Function1;)V", "getBody", "()Lkotlin/jvm/functions/Function1;", NotificationCompat.CATEGORY_CALL, "sender", "(Ljava/lang/Object;)V", "expo-modules-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class EventListenerWithPayload<Payload> extends EventListener {
    private final Function1 body;

    @NotNull
    public final Function1<Payload, Unit> getBody() {
        return this.body;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EventListenerWithPayload(@NotNull EventName eventName, @NotNull Function1<? super Payload, Unit> body) {
        super(eventName, null);
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(body, "body");
        this.body = body;
    }

    public final void call(Payload sender) {
        this.body.invoke(sender);
    }
}
