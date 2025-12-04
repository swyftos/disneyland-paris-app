package androidx.media3.session;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.Log;
import androidx.media3.session.MediaBrowser;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.legacy.MediaBrowserCompat;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class MediaBrowserImplLegacy extends MediaControllerImplLegacy implements MediaBrowser.MediaBrowserImpl {
    private final HashMap browserCompats;
    private final MediaBrowser instance;
    private final HashMap subscribeCallbacks;

    MediaBrowserImplLegacy(Context context, MediaBrowser mediaBrowser, SessionToken sessionToken, Looper looper, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        super(context, mediaBrowser, sessionToken, looper, bitmapLoader);
        this.browserCompats = new HashMap();
        this.subscribeCallbacks = new HashMap();
        this.instance = mediaBrowser;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media3.session.MediaControllerImplLegacy
    public MediaBrowser getInstance() {
        return this.instance;
    }

    @Override // androidx.media3.session.MediaControllerImplLegacy, androidx.media3.session.MediaController.MediaControllerImpl
    public void release() {
        Iterator it = this.browserCompats.values().iterator();
        while (it.hasNext()) {
            ((MediaBrowserCompat) it.next()).disconnect();
        }
        this.browserCompats.clear();
        super.release();
    }

    @Override // androidx.media3.session.MediaControllerImplLegacy, androidx.media3.session.MediaController.MediaControllerImpl
    public SessionCommands getAvailableSessionCommands() {
        if (getBrowserCompat() != null) {
            return super.getAvailableSessionCommands().buildUpon().addAllLibraryCommands().build();
        }
        return super.getAvailableSessionCommands();
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture getLibraryRoot(MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(50000)) {
            return Futures.immediateFuture(LibraryResult.ofError(-4));
        }
        SettableFuture settableFutureCreate = SettableFuture.create();
        MediaBrowserCompat browserCompat = getBrowserCompat(libraryParams);
        if (browserCompat != null) {
            settableFutureCreate.set(LibraryResult.ofItem(createRootMediaItem(browserCompat), null));
        } else {
            MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(getContext(), getConnectedToken().getComponentName(), new GetLibraryRootCallback(settableFutureCreate, libraryParams), LegacyConversions.convertToRootHints(libraryParams));
            this.browserCompats.put(libraryParams, mediaBrowserCompat);
            mediaBrowserCompat.connect();
        }
        return settableFutureCreate;
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture subscribe(String str, MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_SUBSCRIBE)) {
            return Futures.immediateFuture(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return Futures.immediateFuture(LibraryResult.ofError(-100));
        }
        SettableFuture settableFutureCreate = SettableFuture.create();
        SubscribeCallback subscribeCallback = new SubscribeCallback(settableFutureCreate);
        List arrayList = (List) this.subscribeCallbacks.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.subscribeCallbacks.put(str, arrayList);
        }
        arrayList.add(subscribeCallback);
        browserCompat.subscribe(str, createOptions(libraryParams), subscribeCallback);
        return settableFutureCreate;
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture unsubscribe(String str) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_UNSUBSCRIBE)) {
            return Futures.immediateFuture(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return Futures.immediateFuture(LibraryResult.ofError(-100));
        }
        List list = (List) this.subscribeCallbacks.get(str);
        if (list == null) {
            return Futures.immediateFuture(LibraryResult.ofError(-3));
        }
        for (int i = 0; i < list.size(); i++) {
            browserCompat.unsubscribe(str, (MediaBrowserCompat.SubscriptionCallback) list.get(i));
        }
        return Futures.immediateFuture(LibraryResult.ofVoid());
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture getChildren(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_GET_CHILDREN)) {
            return Futures.immediateFuture(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return Futures.immediateFuture(LibraryResult.ofError(-100));
        }
        SettableFuture settableFutureCreate = SettableFuture.create();
        browserCompat.subscribe(str, createOptions(libraryParams, i, i2), new GetChildrenCallback(settableFutureCreate, str));
        return settableFutureCreate;
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture getItem(String str) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_GET_ITEM)) {
            return Futures.immediateFuture(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return Futures.immediateFuture(LibraryResult.ofError(-100));
        }
        final SettableFuture settableFutureCreate = SettableFuture.create();
        browserCompat.getItem(str, new MediaBrowserCompat.ItemCallback() { // from class: androidx.media3.session.MediaBrowserImplLegacy.1
            @Override // androidx.media3.session.legacy.MediaBrowserCompat.ItemCallback
            public void onItemLoaded(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem != null) {
                    settableFutureCreate.set(LibraryResult.ofItem(LegacyConversions.convertToMediaItem(mediaItem), null));
                } else {
                    settableFutureCreate.set(LibraryResult.ofError(-3));
                }
            }

            @Override // androidx.media3.session.legacy.MediaBrowserCompat.ItemCallback
            public void onError(String str2) {
                settableFutureCreate.set(LibraryResult.ofError(-1));
            }
        });
        return settableFutureCreate;
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture search(String str, MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_SEARCH)) {
            return Futures.immediateFuture(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return Futures.immediateFuture(LibraryResult.ofError(-100));
        }
        browserCompat.search(str, getExtras(libraryParams), new AnonymousClass2());
        return Futures.immediateFuture(LibraryResult.ofVoid());
    }

    /* renamed from: androidx.media3.session.MediaBrowserImplLegacy$2, reason: invalid class name */
    class AnonymousClass2 extends MediaBrowserCompat.SearchCallback {
        AnonymousClass2() {
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SearchCallback
        public void onSearchResult(final String str, Bundle bundle, final List list) {
            MediaBrowserImplLegacy.this.getInstance().notifyBrowserListener(new Consumer() { // from class: androidx.media3.session.MediaBrowserImplLegacy$2$$ExternalSyntheticLambda0
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$onSearchResult$0(str, list, (MediaBrowser.Listener) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSearchResult$0(String str, List list, MediaBrowser.Listener listener) {
            listener.onSearchResultChanged(MediaBrowserImplLegacy.this.getInstance(), str, list.size(), null);
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SearchCallback
        public void onError(final String str, Bundle bundle) {
            MediaBrowserImplLegacy.this.getInstance().notifyBrowserListener(new Consumer() { // from class: androidx.media3.session.MediaBrowserImplLegacy$2$$ExternalSyntheticLambda1
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$onError$1(str, (MediaBrowser.Listener) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$1(String str, MediaBrowser.Listener listener) {
            listener.onSearchResultChanged(MediaBrowserImplLegacy.this.getInstance(), str, 0, null);
        }
    }

    @Override // androidx.media3.session.MediaBrowser.MediaBrowserImpl
    public ListenableFuture getSearchResult(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams) {
        if (!getInstance().isSessionCommandAvailable(SessionCommand.COMMAND_CODE_LIBRARY_GET_SEARCH_RESULT)) {
            return Futures.immediateFuture(LibraryResult.ofError(-4));
        }
        MediaBrowserCompat browserCompat = getBrowserCompat();
        if (browserCompat == null) {
            return Futures.immediateFuture(LibraryResult.ofError(-100));
        }
        final SettableFuture settableFutureCreate = SettableFuture.create();
        Bundle bundleCreateOptions = createOptions(libraryParams, i, i2);
        bundleCreateOptions.putInt("android.media.browse.extra.PAGE", i);
        bundleCreateOptions.putInt("android.media.browse.extra.PAGE_SIZE", i2);
        browserCompat.search(str, bundleCreateOptions, new MediaBrowserCompat.SearchCallback() { // from class: androidx.media3.session.MediaBrowserImplLegacy.3
            @Override // androidx.media3.session.legacy.MediaBrowserCompat.SearchCallback
            public void onSearchResult(String str2, Bundle bundle, List list) {
                settableFutureCreate.set(LibraryResult.ofItemList(LegacyConversions.convertBrowserItemListToMediaItemList(list), null));
            }

            @Override // androidx.media3.session.legacy.MediaBrowserCompat.SearchCallback
            public void onError(String str2, Bundle bundle) {
                settableFutureCreate.set(LibraryResult.ofError(-1));
            }
        });
        return settableFutureCreate;
    }

    private MediaBrowserCompat getBrowserCompat(MediaLibraryService.LibraryParams libraryParams) {
        return (MediaBrowserCompat) this.browserCompats.get(libraryParams);
    }

    private static Bundle createOptions(MediaLibraryService.LibraryParams libraryParams) {
        return libraryParams == null ? new Bundle() : new Bundle(libraryParams.extras);
    }

    private static Bundle createOptions(MediaLibraryService.LibraryParams libraryParams, int i, int i2) {
        Bundle bundleCreateOptions = createOptions(libraryParams);
        bundleCreateOptions.putInt("android.media.browse.extra.PAGE", i);
        bundleCreateOptions.putInt("android.media.browse.extra.PAGE_SIZE", i2);
        return bundleCreateOptions;
    }

    private static Bundle getExtras(MediaLibraryService.LibraryParams libraryParams) {
        if (libraryParams != null) {
            return libraryParams.extras;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MediaItem createRootMediaItem(MediaBrowserCompat mediaBrowserCompat) {
        String root = mediaBrowserCompat.getRoot();
        return new MediaItem.Builder().setMediaId(root).setMediaMetadata(new MediaMetadata.Builder().setIsBrowsable(Boolean.TRUE).setMediaType(20).setIsPlayable(Boolean.FALSE).setExtras(mediaBrowserCompat.getExtras()).build()).build();
    }

    private class GetLibraryRootCallback extends MediaBrowserCompat.ConnectionCallback {
        private final MediaLibraryService.LibraryParams params;
        private final SettableFuture result;

        public GetLibraryRootCallback(SettableFuture settableFuture, MediaLibraryService.LibraryParams libraryParams) {
            this.result = settableFuture;
            this.params = libraryParams;
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public void onConnected() {
            MediaBrowserCompat mediaBrowserCompat = (MediaBrowserCompat) MediaBrowserImplLegacy.this.browserCompats.get(this.params);
            if (mediaBrowserCompat == null) {
                this.result.set(LibraryResult.ofError(-1));
            } else {
                this.result.set(LibraryResult.ofItem(MediaBrowserImplLegacy.this.createRootMediaItem(mediaBrowserCompat), LegacyConversions.convertToLibraryParams(MediaBrowserImplLegacy.this.context, mediaBrowserCompat.getExtras())));
            }
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public void onConnectionSuspended() {
            onConnectionFailed();
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.ConnectionCallback
        public void onConnectionFailed() {
            this.result.set(LibraryResult.ofError(-3));
            MediaBrowserImplLegacy.this.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class SubscribeCallback extends MediaBrowserCompat.SubscriptionCallback {
        private final SettableFuture future;

        public SubscribeCallback(SettableFuture settableFuture) {
            this.future = settableFuture;
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public void onError(String str) {
            onErrorInternal();
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public void onError(String str, Bundle bundle) {
            onErrorInternal();
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(String str, List list) {
            onChildrenLoadedInternal(str, list);
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(String str, List list, Bundle bundle) {
            onChildrenLoadedInternal(str, list);
        }

        private void onErrorInternal() {
            this.future.set(LibraryResult.ofError(-1));
        }

        private void onChildrenLoadedInternal(final String str, List list) {
            if (TextUtils.isEmpty(str)) {
                Log.w("MB2ImplLegacy", "SubscribeCallback.onChildrenLoaded(): Ignoring empty parentId");
                return;
            }
            MediaBrowserCompat browserCompat = MediaBrowserImplLegacy.this.getBrowserCompat();
            if (browserCompat == null || list == null) {
                return;
            }
            final int size = list.size();
            final MediaLibraryService.LibraryParams libraryParamsConvertToLibraryParams = LegacyConversions.convertToLibraryParams(MediaBrowserImplLegacy.this.context, browserCompat.getNotifyChildrenChangedOptions());
            MediaBrowserImplLegacy.this.getInstance().notifyBrowserListener(new Consumer() { // from class: androidx.media3.session.MediaBrowserImplLegacy$SubscribeCallback$$ExternalSyntheticLambda0
                @Override // androidx.media3.common.util.Consumer
                public final void accept(Object obj) {
                    this.f$0.lambda$onChildrenLoadedInternal$0(str, size, libraryParamsConvertToLibraryParams, (MediaBrowser.Listener) obj);
                }
            });
            this.future.set(LibraryResult.ofVoid());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onChildrenLoadedInternal$0(String str, int i, MediaLibraryService.LibraryParams libraryParams, MediaBrowser.Listener listener) {
            listener.onChildrenChanged(MediaBrowserImplLegacy.this.getInstance(), str, i, libraryParams);
        }
    }

    private class GetChildrenCallback extends MediaBrowserCompat.SubscriptionCallback {
        private final SettableFuture future;
        private final String parentId;

        public GetChildrenCallback(SettableFuture settableFuture, String str) {
            this.future = settableFuture;
            this.parentId = str;
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public void onError(String str) {
            onErrorInternal();
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public void onError(String str, Bundle bundle) {
            onErrorInternal();
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(String str, List list) {
            onChildrenLoadedInternal(str, list);
        }

        @Override // androidx.media3.session.legacy.MediaBrowserCompat.SubscriptionCallback
        public void onChildrenLoaded(String str, List list, Bundle bundle) {
            onChildrenLoadedInternal(str, list);
        }

        private void onErrorInternal() {
            this.future.set(LibraryResult.ofError(-1));
        }

        private void onChildrenLoadedInternal(String str, List list) {
            if (TextUtils.isEmpty(str)) {
                Log.w("MB2ImplLegacy", "GetChildrenCallback.onChildrenLoaded(): Ignoring empty parentId");
                return;
            }
            MediaBrowserCompat browserCompat = MediaBrowserImplLegacy.this.getBrowserCompat();
            if (browserCompat == null) {
                this.future.set(LibraryResult.ofError(-100));
                return;
            }
            browserCompat.unsubscribe(this.parentId, this);
            if (list == null) {
                this.future.set(LibraryResult.ofError(-1));
            } else {
                this.future.set(LibraryResult.ofItemList(LegacyConversions.convertBrowserItemListToMediaItemList(list), null));
            }
        }
    }
}
