package androidx.test.espresso.base;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes2.dex */
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
    /* JADX INFO: renamed from: get, reason: merged with bridge method [inline-methods] */
    public IdleNotifier<IdlingResourceRegistry.IdleNotificationCallback> get2() {
        return new NoopIdleNotificationCallbackIdleNotifier();
    }
}
