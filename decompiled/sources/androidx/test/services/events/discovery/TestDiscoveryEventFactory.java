package androidx.test.services.events.discovery;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.test.services.events.discovery.TestDiscoveryEvent;

/* loaded from: classes2.dex */
final class TestDiscoveryEventFactory implements Parcelable.Creator<TestDiscoveryEvent> {
    TestDiscoveryEventFactory() {
    }

    /* renamed from: androidx.test.services.events.discovery.TestDiscoveryEventFactory$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$test$services$events$discovery$TestDiscoveryEvent$EventType;

        static {
            int[] iArr = new int[TestDiscoveryEvent.EventType.values().length];
            $SwitchMap$androidx$test$services$events$discovery$TestDiscoveryEvent$EventType = iArr;
            try {
                iArr[TestDiscoveryEvent.EventType.STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$test$services$events$discovery$TestDiscoveryEvent$EventType[TestDiscoveryEvent.EventType.TEST_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$test$services$events$discovery$TestDiscoveryEvent$EventType[TestDiscoveryEvent.EventType.FINISHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TestDiscoveryEvent createFromParcel(Parcel parcel) {
        TestDiscoveryEvent.EventType eventTypeValueOf = TestDiscoveryEvent.EventType.valueOf(parcel.readString());
        int i = AnonymousClass1.$SwitchMap$androidx$test$services$events$discovery$TestDiscoveryEvent$EventType[eventTypeValueOf.ordinal()];
        if (i == 1) {
            return new TestDiscoveryStartedEvent();
        }
        if (i == 2) {
            return new TestFoundEvent(parcel);
        }
        if (i == 3) {
            return new TestDiscoveryFinishedEvent();
        }
        String strValueOf = String.valueOf(eventTypeValueOf);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
        sb.append("Unhandled event type: ");
        sb.append(strValueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public TestDiscoveryEvent[] newArray(int i) {
        return new TestDiscoveryEvent[i];
    }
}
