package expo.modules.core.interfaces.services;

import android.os.Bundle;

/* JADX INFO: loaded from: classes5.dex */
public interface EventEmitter {

    public static abstract class BaseEvent implements Event {
        @Override // expo.modules.core.interfaces.services.EventEmitter.Event
        public boolean canCoalesce() {
            return true;
        }

        @Override // expo.modules.core.interfaces.services.EventEmitter.Event
        public short getCoalescingKey() {
            return (short) 0;
        }
    }

    public interface Event {
        boolean canCoalesce();

        short getCoalescingKey();

        Bundle getEventBody();

        String getEventName();
    }

    void emit(int i, Event event);

    void emit(int i, String str, Bundle bundle);

    void emit(String str, Bundle bundle);
}
