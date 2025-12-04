package androidx.media3.session;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Consumer;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceBitmapLoader;
import androidx.media3.session.MediaController;
import androidx.media3.session.MediaLibraryService;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* loaded from: classes.dex */
public final class MediaBrowser extends MediaController {
    private MediaBrowserImpl impl;

    public interface Listener extends MediaController.Listener {
        default void onChildrenChanged(MediaBrowser mediaBrowser, String str, @IntRange(from = 0) int i, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        }

        default void onSearchResultChanged(MediaBrowser mediaBrowser, String str, @IntRange(from = 0) int i, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        }
    }

    interface MediaBrowserImpl extends MediaController.MediaControllerImpl {
        ListenableFuture getChildren(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture getItem(String str);

        ListenableFuture getLibraryRoot(MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture getSearchResult(String str, int i, int i2, MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture search(String str, MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture subscribe(String str, MediaLibraryService.LibraryParams libraryParams);

        ListenableFuture unsubscribe(String str);
    }

    public static final class Builder {
        private androidx.media3.common.util.BitmapLoader bitmapLoader;
        private final Context context;
        private final SessionToken token;
        private Bundle connectionHints = Bundle.EMPTY;
        private Listener listener = new Listener() { // from class: androidx.media3.session.MediaBrowser.Builder.1
        };
        private Looper applicationLooper = Util.getCurrentOrMainLooper();

        public Builder(Context context, SessionToken sessionToken) {
            this.context = (Context) Assertions.checkNotNull(context);
            this.token = (SessionToken) Assertions.checkNotNull(sessionToken);
        }

        @CanIgnoreReturnValue
        public Builder setConnectionHints(Bundle bundle) {
            this.connectionHints = new Bundle((Bundle) Assertions.checkNotNull(bundle));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setListener(Listener listener) {
            this.listener = (Listener) Assertions.checkNotNull(listener);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setApplicationLooper(Looper looper) {
            this.applicationLooper = (Looper) Assertions.checkNotNull(looper);
            return this;
        }

        @CanIgnoreReturnValue
        @UnstableApi
        public Builder setBitmapLoader(androidx.media3.common.util.BitmapLoader bitmapLoader) {
            this.bitmapLoader = (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(bitmapLoader);
            return this;
        }

        public ListenableFuture<MediaBrowser> buildAsync() {
            final MediaControllerHolder mediaControllerHolder = new MediaControllerHolder(this.applicationLooper);
            if (this.token.isLegacySession() && this.bitmapLoader == null) {
                this.bitmapLoader = new CacheBitmapLoader(new DataSourceBitmapLoader(this.context));
            }
            final MediaBrowser mediaBrowser = new MediaBrowser(this.context, this.token, this.connectionHints, this.listener, this.applicationLooper, mediaControllerHolder, this.bitmapLoader);
            Util.postOrRun(new Handler(this.applicationLooper), new Runnable() { // from class: androidx.media3.session.MediaBrowser$Builder$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    mediaControllerHolder.setController(mediaBrowser);
                }
            });
            return mediaControllerHolder;
        }
    }

    MediaBrowser(Context context, SessionToken sessionToken, Bundle bundle, Listener listener, Looper looper, MediaController.ConnectionCallback connectionCallback, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        super(context, sessionToken, bundle, listener, looper, connectionCallback, bitmapLoader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.media3.session.MediaController
    public MediaBrowserImpl createImpl(Context context, SessionToken sessionToken, Bundle bundle, Looper looper, androidx.media3.common.util.BitmapLoader bitmapLoader) {
        MediaBrowserImpl mediaBrowserImplBase;
        if (sessionToken.isLegacySession()) {
            mediaBrowserImplBase = new MediaBrowserImplLegacy(context, this, sessionToken, looper, (androidx.media3.common.util.BitmapLoader) Assertions.checkNotNull(bitmapLoader));
        } else {
            mediaBrowserImplBase = new MediaBrowserImplBase(context, this, sessionToken, bundle, looper);
        }
        this.impl = mediaBrowserImplBase;
        return mediaBrowserImplBase;
    }

    public ListenableFuture<LibraryResult<MediaItem>> getLibraryRoot(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        verifyApplicationThread();
        if (isConnected()) {
            return ((MediaBrowserImpl) Assertions.checkNotNull(this.impl)).getLibraryRoot(libraryParams);
        }
        return createDisconnectedFuture();
    }

    public ListenableFuture<LibraryResult<Void>> subscribe(String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        verifyApplicationThread();
        Assertions.checkNotEmpty(str, "parentId must not be empty");
        if (isConnected()) {
            return ((MediaBrowserImpl) Assertions.checkNotNull(this.impl)).subscribe(str, libraryParams);
        }
        return createDisconnectedFuture();
    }

    public ListenableFuture<LibraryResult<Void>> unsubscribe(String str) {
        verifyApplicationThread();
        Assertions.checkNotEmpty(str, "parentId must not be empty");
        if (isConnected()) {
            return ((MediaBrowserImpl) Assertions.checkNotNull(this.impl)).unsubscribe(str);
        }
        return createDisconnectedFuture();
    }

    public ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> getChildren(String str, @IntRange(from = 0) int i, @IntRange(from = 1) int i2, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        verifyApplicationThread();
        Assertions.checkNotEmpty(str, "parentId must not be empty");
        Assertions.checkArgument(i >= 0, "page must not be negative");
        Assertions.checkArgument(i2 >= 1, "pageSize must not be less than 1");
        if (isConnected()) {
            return ((MediaBrowserImpl) Assertions.checkNotNull(this.impl)).getChildren(str, i, i2, libraryParams);
        }
        return createDisconnectedFuture();
    }

    public ListenableFuture<LibraryResult<MediaItem>> getItem(String str) {
        verifyApplicationThread();
        Assertions.checkNotEmpty(str, "mediaId must not be empty");
        if (isConnected()) {
            return ((MediaBrowserImpl) Assertions.checkNotNull(this.impl)).getItem(str);
        }
        return createDisconnectedFuture();
    }

    public ListenableFuture<LibraryResult<Void>> search(String str, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        verifyApplicationThread();
        Assertions.checkNotEmpty(str, "query must not be empty");
        if (isConnected()) {
            return ((MediaBrowserImpl) Assertions.checkNotNull(this.impl)).search(str, libraryParams);
        }
        return createDisconnectedFuture();
    }

    public ListenableFuture<LibraryResult<ImmutableList<MediaItem>>> getSearchResult(String str, @IntRange(from = 0) int i, @IntRange(from = 1) int i2, @Nullable MediaLibraryService.LibraryParams libraryParams) {
        verifyApplicationThread();
        Assertions.checkNotEmpty(str, "query must not be empty");
        Assertions.checkArgument(i >= 0, "page must not be negative");
        Assertions.checkArgument(i2 >= 1, "pageSize must not be less than 1");
        if (isConnected()) {
            return ((MediaBrowserImpl) Assertions.checkNotNull(this.impl)).getSearchResult(str, i, i2, libraryParams);
        }
        return createDisconnectedFuture();
    }

    private static ListenableFuture createDisconnectedFuture() {
        return Futures.immediateFuture(LibraryResult.ofError(-100));
    }

    private void verifyApplicationThread() {
        Assertions.checkState(Looper.myLooper() == getApplicationLooper(), "MediaBrowser method is called from a wrong thread. See javadoc of MediaController for details.");
    }

    void notifyBrowserListener(final Consumer consumer) {
        final Listener listener = (Listener) this.listener;
        if (listener != null) {
            Util.postOrRun(this.applicationHandler, new Runnable() { // from class: androidx.media3.session.MediaBrowser$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    consumer.accept(listener);
                }
            });
        }
    }
}
