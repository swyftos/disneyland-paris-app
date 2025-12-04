package androidx.media3.session.legacy;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.KeyEvent;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.session.legacy.IMediaControllerCallback;
import androidx.media3.session.legacy.MediaSessionCompat;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
@UnstableApi
/* loaded from: classes.dex */
public interface IMediaSession extends IInterface {
    void addQueueItem(@Nullable MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    void addQueueItemAt(@Nullable MediaDescriptionCompat mediaDescriptionCompat, int i) throws RemoteException;

    void adjustVolume(int i, int i2, @Nullable String str) throws RemoteException;

    void fastForward() throws RemoteException;

    @Nullable
    Bundle getExtras() throws RemoteException;

    long getFlags() throws RemoteException;

    @Nullable
    PendingIntent getLaunchPendingIntent() throws RemoteException;

    @Nullable
    MediaMetadataCompat getMetadata() throws RemoteException;

    @Nullable
    String getPackageName() throws RemoteException;

    @Nullable
    PlaybackStateCompat getPlaybackState() throws RemoteException;

    @Nullable
    List<MediaSessionCompat.QueueItem> getQueue() throws RemoteException;

    @Nullable
    CharSequence getQueueTitle() throws RemoteException;

    int getRatingType() throws RemoteException;

    int getRepeatMode() throws RemoteException;

    @Nullable
    Bundle getSessionInfo() throws RemoteException;

    int getShuffleMode() throws RemoteException;

    @Nullable
    String getTag() throws RemoteException;

    @Nullable
    ParcelableVolumeInfo getVolumeAttributes() throws RemoteException;

    boolean isCaptioningEnabled() throws RemoteException;

    boolean isShuffleModeEnabledRemoved() throws RemoteException;

    boolean isTransportControlEnabled() throws RemoteException;

    void next() throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    void playFromMediaId(@Nullable String str, @Nullable Bundle bundle) throws RemoteException;

    void playFromSearch(@Nullable String str, @Nullable Bundle bundle) throws RemoteException;

    void playFromUri(@Nullable Uri uri, @Nullable Bundle bundle) throws RemoteException;

    void prepare() throws RemoteException;

    void prepareFromMediaId(@Nullable String str, @Nullable Bundle bundle) throws RemoteException;

    void prepareFromSearch(@Nullable String str, @Nullable Bundle bundle) throws RemoteException;

    void prepareFromUri(@Nullable Uri uri, @Nullable Bundle bundle) throws RemoteException;

    void previous() throws RemoteException;

    void rate(@Nullable RatingCompat ratingCompat) throws RemoteException;

    void rateWithExtras(@Nullable RatingCompat ratingCompat, @Nullable Bundle bundle) throws RemoteException;

    void registerCallbackListener(@Nullable IMediaControllerCallback iMediaControllerCallback) throws RemoteException;

    void removeQueueItem(@Nullable MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    void removeQueueItemAt(int i) throws RemoteException;

    void rewind() throws RemoteException;

    void seekTo(long j) throws RemoteException;

    void sendCommand(@Nullable String str, @Nullable Bundle bundle, @Nullable MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException;

    void sendCustomAction(@Nullable String str, @Nullable Bundle bundle) throws RemoteException;

    boolean sendMediaButton(@Nullable KeyEvent keyEvent) throws RemoteException;

    void setCaptioningEnabled(boolean z) throws RemoteException;

    void setPlaybackSpeed(float f) throws RemoteException;

    void setRepeatMode(int i) throws RemoteException;

    void setShuffleMode(int i) throws RemoteException;

    void setShuffleModeEnabledRemoved(boolean z) throws RemoteException;

    void setVolumeTo(int i, int i2, @Nullable String str) throws RemoteException;

    void skipToQueueItem(long j) throws RemoteException;

    void stop() throws RemoteException;

    void unregisterCallbackListener(@Nullable IMediaControllerCallback iMediaControllerCallback) throws RemoteException;

    public static abstract class Stub extends Binder implements IMediaSession {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, android.support.v4.media.session.IMediaSession.DESCRIPTOR);
        }

        public static IMediaSession asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMediaSession)) {
                return (IMediaSession) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, @Nullable Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                ((Parcel) Assertions.checkNotNull(parcel2)).writeString(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    sendCommand(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(parcel) : null);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    boolean zSendMediaButton = sendMediaButton(parcel.readInt() != 0 ? (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel) : null);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(zSendMediaButton ? 1 : 0);
                    return true;
                case 3:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    registerCallbackListener(IMediaControllerCallback.Stub.asInterface(parcel.readStrongBinder()));
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    unregisterCallbackListener(IMediaControllerCallback.Stub.asInterface(parcel.readStrongBinder()));
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    boolean zIsTransportControlEnabled = isTransportControlEnabled();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(zIsTransportControlEnabled ? 1 : 0);
                    return true;
                case 6:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    String packageName = getPackageName();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeString(packageName);
                    return true;
                case 7:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    String tag = getTag();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeString(tag);
                    return true;
                case 8:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    PendingIntent launchPendingIntent = getLaunchPendingIntent();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    if (launchPendingIntent != null) {
                        ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(1);
                        launchPendingIntent.writeToParcel(parcel2, 1);
                    } else {
                        ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(0);
                    }
                    return true;
                case 9:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    long flags = getFlags();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeLong(flags);
                    return true;
                case 10:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    ParcelableVolumeInfo volumeAttributes = getVolumeAttributes();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    if (volumeAttributes != null) {
                        ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(1);
                        volumeAttributes.writeToParcel(parcel2, 1);
                    } else {
                        ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(0);
                    }
                    return true;
                case 11:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    adjustVolume(parcel.readInt(), parcel.readInt(), parcel.readString());
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 12:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    setVolumeTo(parcel.readInt(), parcel.readInt(), parcel.readString());
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 13:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    play();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 14:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    playFromMediaId(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 15:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    playFromSearch(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 16:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    playFromUri(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    skipToQueueItem(parcel.readLong());
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 18:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    pause();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    stop();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 20:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    next();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 21:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    previous();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 22:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    fastForward();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 23:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    rewind();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 24:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    seekTo(parcel.readLong());
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 25:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    rate(parcel.readInt() != 0 ? RatingCompat.CREATOR.createFromParcel(parcel) : null);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 26:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    sendCustomAction(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 27:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    MediaMetadataCompat metadata = getMetadata();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    if (metadata != null) {
                        ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(1);
                        metadata.writeToParcel(parcel2, 1);
                    } else {
                        ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(0);
                    }
                    return true;
                case 28:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    PlaybackStateCompat playbackState = getPlaybackState();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    if (playbackState != null) {
                        ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(1);
                        playbackState.writeToParcel(parcel2, 1);
                    } else {
                        ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(0);
                    }
                    return true;
                case 29:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    List<MediaSessionCompat.QueueItem> queue = getQueue();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeTypedList(queue);
                    return true;
                case 30:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    CharSequence queueTitle = getQueueTitle();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    if (queueTitle != null) {
                        ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(1);
                        TextUtils.writeToParcel(queueTitle, parcel2, 1);
                    } else {
                        ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(0);
                    }
                    return true;
                case 31:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    Bundle extras = getExtras();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    if (extras != null) {
                        ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(1);
                        extras.writeToParcel(parcel2, 1);
                    } else {
                        ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(0);
                    }
                    return true;
                case 32:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    int ratingType = getRatingType();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(ratingType);
                    return true;
                case 33:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    prepare();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 34:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    prepareFromMediaId(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 35:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    prepareFromSearch(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 36:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    prepareFromUri(parcel.readInt() != 0 ? (Uri) Uri.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 37:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    int repeatMode = getRepeatMode();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(repeatMode);
                    return true;
                case 38:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    boolean zIsShuffleModeEnabledRemoved = isShuffleModeEnabledRemoved();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(zIsShuffleModeEnabledRemoved ? 1 : 0);
                    return true;
                case 39:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    setRepeatMode(parcel.readInt());
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 40:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    setShuffleModeEnabledRemoved(parcel.readInt() != 0);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 41:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    addQueueItem(parcel.readInt() != 0 ? MediaDescriptionCompat.CREATOR.createFromParcel(parcel) : null);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 42:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    addQueueItemAt(parcel.readInt() != 0 ? MediaDescriptionCompat.CREATOR.createFromParcel(parcel) : null, parcel.readInt());
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 43:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    removeQueueItem(parcel.readInt() != 0 ? MediaDescriptionCompat.CREATOR.createFromParcel(parcel) : null);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 44:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    removeQueueItemAt(parcel.readInt());
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 45:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    boolean zIsCaptioningEnabled = isCaptioningEnabled();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(zIsCaptioningEnabled ? 1 : 0);
                    return true;
                case 46:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    setCaptioningEnabled(parcel.readInt() != 0);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 47:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    int shuffleMode = getShuffleMode();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(shuffleMode);
                    return true;
                case 48:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    setShuffleMode(parcel.readInt());
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 49:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    setPlaybackSpeed(parcel.readFloat());
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                case 50:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    Bundle sessionInfo = getSessionInfo();
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    if (sessionInfo != null) {
                        ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(1);
                        sessionInfo.writeToParcel(parcel2, 1);
                    } else {
                        ((Parcel) Assertions.checkNotNull(parcel2)).writeInt(0);
                    }
                    return true;
                case 51:
                    parcel.enforceInterface(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    rateWithExtras(parcel.readInt() != 0 ? RatingCompat.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    ((Parcel) Assertions.checkNotNull(parcel2)).writeNoException();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        private static class Proxy implements IMediaSession {
            public static IMediaSession sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void sendCommand(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (resultReceiverWrapper != null) {
                        parcelObtain.writeInt(1);
                        resultReceiverWrapper.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(1, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).sendCommand(str, bundle, resultReceiverWrapper);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public boolean sendMediaButton(KeyEvent keyEvent) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (keyEvent != null) {
                        parcelObtain.writeInt(1);
                        keyEvent.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        boolean zSendMediaButton = ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).sendMediaButton(keyEvent);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return zSendMediaButton;
                    }
                    parcelObtain2.readException();
                    boolean z = parcelObtain2.readInt() != 0;
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return z;
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaControllerCallback != null ? iMediaControllerCallback.asBinder() : null);
                    if (!this.mRemote.transact(3, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).registerCallbackListener(iMediaControllerCallback);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback iMediaControllerCallback) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongBinder(iMediaControllerCallback != null ? iMediaControllerCallback.asBinder() : null);
                    if (!this.mRemote.transact(4, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).unregisterCallbackListener(iMediaControllerCallback);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public boolean isTransportControlEnabled() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(5, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).isTransportControlEnabled();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public String getPackageName() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(6, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).getPackageName();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public String getTag() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(7, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).getTag();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readString();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(8, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).getLaunchPendingIntent();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (PendingIntent) PendingIntent.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public long getFlags() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(9, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).getFlags();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readLong();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(10, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).getVolumeAttributes();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void adjustVolume(int i, int i2, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(11, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).adjustVolume(i, i2, str);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void setVolumeTo(int i, int i2, String str) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeString(str);
                    if (!this.mRemote.transact(12, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).setVolumeTo(i, i2, str);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public MediaMetadataCompat getMetadata() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(27, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).getMetadata();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(28, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).getPlaybackState();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public List getQueue() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(29, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).getQueue();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public CharSequence getQueueTitle() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(30, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).getQueueTitle();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public Bundle getExtras() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(31, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).getExtras();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public int getRatingType() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(32, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).getRatingType();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public boolean isCaptioningEnabled() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(45, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).isCaptioningEnabled();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public int getRepeatMode() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(37, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).getRepeatMode();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(38, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).isShuffleModeEnabledRemoved();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public int getShuffleMode() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(47, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).getShuffleMode();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt();
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void addQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (mediaDescriptionCompat != null) {
                        parcelObtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(41, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).addQueueItem(mediaDescriptionCompat);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (mediaDescriptionCompat != null) {
                        parcelObtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(42, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).addQueueItemAt(mediaDescriptionCompat, i);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat mediaDescriptionCompat) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (mediaDescriptionCompat != null) {
                        parcelObtain.writeInt(1);
                        mediaDescriptionCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(43, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).removeQueueItem(mediaDescriptionCompat);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void removeQueueItemAt(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(44, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).removeQueueItemAt(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public Bundle getSessionInfo() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(50, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        return ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).getSessionInfo();
                    }
                    parcelObtain2.readException();
                    return parcelObtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain2) : null;
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void prepare() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(33, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).prepare();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void prepareFromMediaId(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(34, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).prepareFromMediaId(str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void prepareFromSearch(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(35, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).prepareFromSearch(str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void prepareFromUri(Uri uri, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(36, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).prepareFromUri(uri, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void play() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(13, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).play();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void playFromMediaId(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(14, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).playFromMediaId(str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void playFromSearch(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(15, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).playFromSearch(str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void playFromUri(Uri uri, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (uri != null) {
                        parcelObtain.writeInt(1);
                        uri.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(16, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).playFromUri(uri, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void skipToQueueItem(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    if (!this.mRemote.transact(17, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).skipToQueueItem(j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void pause() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(18, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).pause();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void stop() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(19, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).stop();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void next() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(20, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).next();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void previous() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(21, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).previous();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void fastForward() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(22, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).fastForward();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void rewind() {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (!this.mRemote.transact(23, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).rewind();
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void seekTo(long j) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeLong(j);
                    if (!this.mRemote.transact(24, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).seekTo(j);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void rate(RatingCompat ratingCompat) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (ratingCompat != null) {
                        parcelObtain.writeInt(1);
                        ratingCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(25, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).rate(ratingCompat);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void rateWithExtras(RatingCompat ratingCompat, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    if (ratingCompat != null) {
                        parcelObtain.writeInt(1);
                        ratingCompat.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(51, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).rateWithExtras(ratingCompat, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void setPlaybackSpeed(float f) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeFloat(f);
                    if (!this.mRemote.transact(49, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).setPlaybackSpeed(f);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void setCaptioningEnabled(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(46, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).setCaptioningEnabled(z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void setRepeatMode(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(39, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).setRepeatMode(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeInt(z ? 1 : 0);
                    if (!this.mRemote.transact(40, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).setShuffleModeEnabledRemoved(z);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void setShuffleMode(int i) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeInt(i);
                    if (!this.mRemote.transact(48, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).setShuffleMode(i);
                    } else {
                        parcelObtain2.readException();
                    }
                } finally {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.legacy.IMediaSession
            public void sendCustomAction(String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(android.support.v4.media.session.IMediaSession.DESCRIPTOR);
                    parcelObtain.writeString(str);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(26, parcelObtain, parcelObtain2, 0) && Stub.getDefaultImpl() != null) {
                        ((IMediaSession) Assertions.checkNotNull(Stub.getDefaultImpl())).sendCustomAction(str, bundle);
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    } else {
                        parcelObtain2.readException();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                    }
                } catch (Throwable th) {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    throw th;
                }
            }
        }

        public static boolean setDefaultImpl(IMediaSession iMediaSession) {
            if (Proxy.sDefaultImpl != null) {
                throw new IllegalStateException("setDefaultImpl() called twice");
            }
            if (iMediaSession == null) {
                return false;
            }
            Proxy.sDefaultImpl = iMediaSession;
            return true;
        }

        @Nullable
        public static IMediaSession getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
