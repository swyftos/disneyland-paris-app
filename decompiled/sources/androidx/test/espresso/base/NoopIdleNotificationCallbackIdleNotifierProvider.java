package androidx.test.espresso.base;

import androidx.test.espresso.base.IdlingResourceRegistry;
import javax.inject.Provider;

/* loaded from: classes2.dex */
final class NoopIdleNotificationCallbackIdleNotifierProvider implements Provider<IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback>> {

    private static class NoopIdleNotificationCallbackIdleNotifier implements IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback> {
        private NoopIdleNotificationCallbackIdleNotifier() {
        }

        @Override // androidx.test.espresso.base.IdleNotifier
        public void cancelCallback() {
        }

        @Override // androidx.test.espresso.base.IdleNotifier
        public boolean isIdleNow() {
            return true;
        }

        @Override // androidx.test.espresso.base.IdleNotifier
        public void registerNotificationCallback(IdlingResourceRegistry.IdleNotificationCallback idleNotificationCallback) {
            idleNotificationCallback.allResourcesIdle();
        }
    }

    NoopIdleNotificationCallbackIdleNotifierProvider() {
    }

    @Override // javax.inject.Provider
    /* renamed from: get, reason: merged with bridge method [inline-methods] */
    public IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback> get2() {
        return new NoopIdleNotificationCallbackIdleNotifier();
    }
}
