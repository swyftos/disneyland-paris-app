package androidx.media3.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.Surface;
import androidx.media3.common.PlaybackException;
import androidx.media3.session.IMediaController;

/* loaded from: classes.dex */
public interface IMediaSession extends IInterface {
    public static final String DESCRIPTOR = "androidx.media3.session.IMediaSession";

    public static class Default implements IMediaSession {
        @Override // androidx.media3.session.IMediaSession
        public void addMediaItem(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void addMediaItemWithIndex(IMediaController iMediaController, int i, int i2, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void addMediaItems(IMediaController iMediaController, int i, IBinder iBinder) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void addMediaItemsWithIndex(IMediaController iMediaController, int i, int i2, IBinder iBinder) throws RemoteException {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // androidx.media3.session.IMediaSession
        public void clearMediaItems(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void connect(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void decreaseDeviceVolume(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void decreaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void flushCommandQueue(IMediaController iMediaController) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void getChildren(IMediaController iMediaController, int i, String str, int i2, int i3, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void getItem(IMediaController iMediaController, int i, String str) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void getLibraryRoot(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void getSearchResult(IMediaController iMediaController, int i, String str, int i2, int i3, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void increaseDeviceVolume(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void increaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void moveMediaItem(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void moveMediaItems(IMediaController iMediaController, int i, int i2, int i3, int i4) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void onControllerResult(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void onCustomCommand(IMediaController iMediaController, int i, Bundle bundle, Bundle bundle2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void pause(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void play(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void prepare(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void release(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void removeMediaItem(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void removeMediaItems(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void replaceMediaItem(IMediaController iMediaController, int i, int i2, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void replaceMediaItems(IMediaController iMediaController, int i, int i2, int i3, IBinder iBinder) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void search(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekBack(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekForward(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekTo(IMediaController iMediaController, int i, long j) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekToDefaultPosition(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekToDefaultPositionWithMediaItemIndex(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekToNext(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekToNextMediaItem(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekToPrevious(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekToPreviousMediaItem(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void seekToWithMediaItemIndex(IMediaController iMediaController, int i, int i2, long j) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setAudioAttributes(IMediaController iMediaController, int i, Bundle bundle, boolean z) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setDeviceMuted(IMediaController iMediaController, int i, boolean z) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setDeviceMutedWithFlags(IMediaController iMediaController, int i, boolean z, int i2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setDeviceVolume(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setMediaItem(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setMediaItemWithResetPosition(IMediaController iMediaController, int i, Bundle bundle, boolean z) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setMediaItemWithStartPosition(IMediaController iMediaController, int i, Bundle bundle, long j) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setMediaItems(IMediaController iMediaController, int i, IBinder iBinder) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setMediaItemsWithResetPosition(IMediaController iMediaController, int i, IBinder iBinder, boolean z) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setMediaItemsWithStartIndex(IMediaController iMediaController, int i, IBinder iBinder, int i2, long j) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setPlayWhenReady(IMediaController iMediaController, int i, boolean z) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setPlaybackParameters(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setPlaybackSpeed(IMediaController iMediaController, int i, float f) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setPlaylistMetadata(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setRating(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setRatingWithMediaId(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setRepeatMode(IMediaController iMediaController, int i, int i2) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setShuffleModeEnabled(IMediaController iMediaController, int i, boolean z) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setTrackSelectionParameters(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setVideoSurface(IMediaController iMediaController, int i, Surface surface) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void setVolume(IMediaController iMediaController, int i, float f) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void stop(IMediaController iMediaController, int i) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void subscribe(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException {
        }

        @Override // androidx.media3.session.IMediaSession
        public void unsubscribe(IMediaController iMediaController, int i, String str) throws RemoteException {
        }
    }

    void addMediaItem(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void addMediaItemWithIndex(IMediaController iMediaController, int i, int i2, Bundle bundle) throws RemoteException;

    void addMediaItems(IMediaController iMediaController, int i, IBinder iBinder) throws RemoteException;

    void addMediaItemsWithIndex(IMediaController iMediaController, int i, int i2, IBinder iBinder) throws RemoteException;

    void clearMediaItems(IMediaController iMediaController, int i) throws RemoteException;

    void connect(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void decreaseDeviceVolume(IMediaController iMediaController, int i) throws RemoteException;

    void decreaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void flushCommandQueue(IMediaController iMediaController) throws RemoteException;

    void getChildren(IMediaController iMediaController, int i, String str, int i2, int i3, Bundle bundle) throws RemoteException;

    void getItem(IMediaController iMediaController, int i, String str) throws RemoteException;

    void getLibraryRoot(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void getSearchResult(IMediaController iMediaController, int i, String str, int i2, int i3, Bundle bundle) throws RemoteException;

    void increaseDeviceVolume(IMediaController iMediaController, int i) throws RemoteException;

    void increaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void moveMediaItem(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException;

    void moveMediaItems(IMediaController iMediaController, int i, int i2, int i3, int i4) throws RemoteException;

    void onControllerResult(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void onCustomCommand(IMediaController iMediaController, int i, Bundle bundle, Bundle bundle2) throws RemoteException;

    void pause(IMediaController iMediaController, int i) throws RemoteException;

    void play(IMediaController iMediaController, int i) throws RemoteException;

    void prepare(IMediaController iMediaController, int i) throws RemoteException;

    void release(IMediaController iMediaController, int i) throws RemoteException;

    void removeMediaItem(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void removeMediaItems(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException;

    void replaceMediaItem(IMediaController iMediaController, int i, int i2, Bundle bundle) throws RemoteException;

    void replaceMediaItems(IMediaController iMediaController, int i, int i2, int i3, IBinder iBinder) throws RemoteException;

    void search(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException;

    void seekBack(IMediaController iMediaController, int i) throws RemoteException;

    void seekForward(IMediaController iMediaController, int i) throws RemoteException;

    void seekTo(IMediaController iMediaController, int i, long j) throws RemoteException;

    void seekToDefaultPosition(IMediaController iMediaController, int i) throws RemoteException;

    void seekToDefaultPositionWithMediaItemIndex(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void seekToNext(IMediaController iMediaController, int i) throws RemoteException;

    void seekToNextMediaItem(IMediaController iMediaController, int i) throws RemoteException;

    void seekToPrevious(IMediaController iMediaController, int i) throws RemoteException;

    void seekToPreviousMediaItem(IMediaController iMediaController, int i) throws RemoteException;

    void seekToWithMediaItemIndex(IMediaController iMediaController, int i, int i2, long j) throws RemoteException;

    void setAudioAttributes(IMediaController iMediaController, int i, Bundle bundle, boolean z) throws RemoteException;

    void setDeviceMuted(IMediaController iMediaController, int i, boolean z) throws RemoteException;

    void setDeviceMutedWithFlags(IMediaController iMediaController, int i, boolean z, int i2) throws RemoteException;

    void setDeviceVolume(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void setDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2, int i3) throws RemoteException;

    void setMediaItem(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void setMediaItemWithResetPosition(IMediaController iMediaController, int i, Bundle bundle, boolean z) throws RemoteException;

    void setMediaItemWithStartPosition(IMediaController iMediaController, int i, Bundle bundle, long j) throws RemoteException;

    void setMediaItems(IMediaController iMediaController, int i, IBinder iBinder) throws RemoteException;

    void setMediaItemsWithResetPosition(IMediaController iMediaController, int i, IBinder iBinder, boolean z) throws RemoteException;

    void setMediaItemsWithStartIndex(IMediaController iMediaController, int i, IBinder iBinder, int i2, long j) throws RemoteException;

    void setPlayWhenReady(IMediaController iMediaController, int i, boolean z) throws RemoteException;

    void setPlaybackParameters(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void setPlaybackSpeed(IMediaController iMediaController, int i, float f) throws RemoteException;

    void setPlaylistMetadata(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void setRating(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void setRatingWithMediaId(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException;

    void setRepeatMode(IMediaController iMediaController, int i, int i2) throws RemoteException;

    void setShuffleModeEnabled(IMediaController iMediaController, int i, boolean z) throws RemoteException;

    void setTrackSelectionParameters(IMediaController iMediaController, int i, Bundle bundle) throws RemoteException;

    void setVideoSurface(IMediaController iMediaController, int i, Surface surface) throws RemoteException;

    void setVolume(IMediaController iMediaController, int i, float f) throws RemoteException;

    void stop(IMediaController iMediaController, int i) throws RemoteException;

    void subscribe(IMediaController iMediaController, int i, String str, Bundle bundle) throws RemoteException;

    void unsubscribe(IMediaController iMediaController, int i, String str) throws RemoteException;

    public static abstract class Stub extends Binder implements IMediaSession {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IMediaSession.DESCRIPTOR);
        }

        public static IMediaSession asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(IMediaSession.DESCRIPTOR);
            if (iInterfaceQueryLocalInterface != null && (iInterfaceQueryLocalInterface instanceof IMediaSession)) {
                return (IMediaSession) iInterfaceQueryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IMediaSession.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IMediaSession.DESCRIPTOR);
                return true;
            }
            switch (i) {
                case PlaybackException.ERROR_CODE_PARSING_MANIFEST_MALFORMED /* 3002 */:
                    setVolume(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readFloat());
                    return true;
                case PlaybackException.ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED /* 3003 */:
                    setDeviceVolume(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case PlaybackException.ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED /* 3004 */:
                    increaseDeviceVolume(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3005:
                    decreaseDeviceVolume(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3006:
                    setDeviceMuted(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    return true;
                case 3007:
                    setMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3008:
                    setMediaItemWithStartPosition(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), parcel.readLong());
                    return true;
                case 3009:
                    setMediaItemWithResetPosition(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), parcel.readInt() != 0);
                    return true;
                case 3010:
                    setMediaItems(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder());
                    return true;
                case 3011:
                    setMediaItemsWithResetPosition(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder(), parcel.readInt() != 0);
                    return true;
                case 3012:
                    setMediaItemsWithStartIndex(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder(), parcel.readInt(), parcel.readLong());
                    return true;
                case 3013:
                    setPlayWhenReady(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    return true;
                case 3014:
                    onControllerResult(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3015:
                    connect(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3016:
                    IMediaController iMediaControllerAsInterface = IMediaController.Stub.asInterface(parcel.readStrongBinder());
                    int i3 = parcel.readInt();
                    Parcelable.Creator creator = Bundle.CREATOR;
                    onCustomCommand(iMediaControllerAsInterface, i3, (Bundle) _Parcel.readTypedObject(parcel, creator), (Bundle) _Parcel.readTypedObject(parcel, creator));
                    return true;
                case 3017:
                    setRepeatMode(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case 3018:
                    setShuffleModeEnabled(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0);
                    return true;
                case 3019:
                    removeMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case 3020:
                    removeMediaItems(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 3021:
                    clearMediaItems(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3022:
                    moveMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 3023:
                    moveMediaItems(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 3024:
                    play(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3025:
                    pause(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3026:
                    prepare(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3027:
                    setPlaybackParameters(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3028:
                    setPlaybackSpeed(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readFloat());
                    return true;
                case 3029:
                    addMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3030:
                    addMediaItemWithIndex(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3031:
                    addMediaItems(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readStrongBinder());
                    return true;
                case 3032:
                    addMediaItemsWithIndex(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readStrongBinder());
                    return true;
                case 3033:
                    setPlaylistMetadata(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3034:
                    stop(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3035:
                    release(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3036:
                    seekToDefaultPosition(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3037:
                    seekToDefaultPositionWithMediaItemIndex(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case 3038:
                    seekTo(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readLong());
                    return true;
                case 3039:
                    seekToWithMediaItemIndex(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readLong());
                    return true;
                case 3040:
                    seekBack(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3041:
                    seekForward(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3042:
                    seekToPreviousMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3043:
                    seekToNextMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3044:
                    setVideoSurface(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Surface) _Parcel.readTypedObject(parcel, Surface.CREATOR));
                    return true;
                case 3045:
                    flushCommandQueue(IMediaController.Stub.asInterface(parcel.readStrongBinder()));
                    return true;
                case 3046:
                    seekToPrevious(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3047:
                    seekToNext(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                    return true;
                case 3048:
                    setTrackSelectionParameters(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3049:
                    setRatingWithMediaId(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3050:
                    setRating(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3051:
                    setDeviceVolumeWithFlags(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt());
                    return true;
                case 3052:
                    increaseDeviceVolumeWithFlags(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case 3053:
                    decreaseDeviceVolumeWithFlags(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    return true;
                case 3054:
                    setDeviceMutedWithFlags(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt() != 0, parcel.readInt());
                    return true;
                case 3055:
                    replaceMediaItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                    return true;
                case 3056:
                    replaceMediaItems(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readStrongBinder());
                    return true;
                case 3057:
                    setAudioAttributes(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR), parcel.readInt() != 0);
                    return true;
                default:
                    switch (i) {
                        case PlaybackException.ERROR_CODE_DECODER_INIT_FAILED /* 4001 */:
                            getLibraryRoot(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                            return true;
                        case PlaybackException.ERROR_CODE_DECODER_QUERY_FAILED /* 4002 */:
                            getItem(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                            return true;
                        case PlaybackException.ERROR_CODE_DECODING_FAILED /* 4003 */:
                            getChildren(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                            return true;
                        case PlaybackException.ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES /* 4004 */:
                            search(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                            return true;
                        case PlaybackException.ERROR_CODE_DECODING_FORMAT_UNSUPPORTED /* 4005 */:
                            getSearchResult(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readInt(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                            return true;
                        case PlaybackException.ERROR_CODE_DECODING_RESOURCES_RECLAIMED /* 4006 */:
                            subscribe(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), (Bundle) _Parcel.readTypedObject(parcel, Bundle.CREATOR));
                            return true;
                        case 4007:
                            unsubscribe(IMediaController.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readString());
                            return true;
                        default:
                            return super.onTransact(i, parcel, parcel2, i2);
                    }
            }
        }

        private static class Proxy implements IMediaSession {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // androidx.media3.session.IMediaSession
            public void setVolume(IMediaController iMediaController, int i, float f) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeFloat(f);
                    this.mRemote.transact(PlaybackException.ERROR_CODE_PARSING_MANIFEST_MALFORMED, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setDeviceVolume(IMediaController iMediaController, int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.mRemote.transact(PlaybackException.ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.mRemote.transact(3051, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void increaseDeviceVolume(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(PlaybackException.ERROR_CODE_PARSING_MANIFEST_UNSUPPORTED, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void increaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.mRemote.transact(3052, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void decreaseDeviceVolume(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3005, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void decreaseDeviceVolumeWithFlags(IMediaController iMediaController, int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.mRemote.transact(3053, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setDeviceMuted(IMediaController iMediaController, int i, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(3006, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setDeviceMutedWithFlags(IMediaController iMediaController, int i, boolean z, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    parcelObtain.writeInt(i2);
                    this.mRemote.transact(3054, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setAudioAttributes(IMediaController iMediaController, int i, Bundle bundle, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(3057, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setMediaItem(IMediaController iMediaController, int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3007, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setMediaItemWithStartPosition(IMediaController iMediaController, int i, Bundle bundle, long j) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeLong(j);
                    this.mRemote.transact(3008, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setMediaItemWithResetPosition(IMediaController iMediaController, int i, Bundle bundle, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(3009, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setMediaItems(IMediaController iMediaController, int i, IBinder iBinder) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(3010, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setMediaItemsWithResetPosition(IMediaController iMediaController, int i, IBinder iBinder, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iBinder);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(3011, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setMediaItemsWithStartIndex(IMediaController iMediaController, int i, IBinder iBinder, int i2, long j) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iBinder);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    this.mRemote.transact(3012, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setPlayWhenReady(IMediaController iMediaController, int i, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(3013, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void onControllerResult(IMediaController iMediaController, int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3014, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void connect(IMediaController iMediaController, int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3015, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void onCustomCommand(IMediaController iMediaController, int i, Bundle bundle, Bundle bundle2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    _Parcel.writeTypedObject(parcelObtain, bundle2, 0);
                    this.mRemote.transact(3016, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setRepeatMode(IMediaController iMediaController, int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.mRemote.transact(3017, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setShuffleModeEnabled(IMediaController iMediaController, int i, boolean z) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(z ? 1 : 0);
                    this.mRemote.transact(3018, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void removeMediaItem(IMediaController iMediaController, int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.mRemote.transact(3019, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void removeMediaItems(IMediaController iMediaController, int i, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.mRemote.transact(3020, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void clearMediaItems(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3021, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void moveMediaItem(IMediaController iMediaController, int i, int i2, int i3) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    this.mRemote.transact(3022, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void moveMediaItems(IMediaController iMediaController, int i, int i2, int i3, int i4) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeInt(i4);
                    this.mRemote.transact(3023, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void replaceMediaItem(IMediaController iMediaController, int i, int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3055, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void replaceMediaItems(IMediaController iMediaController, int i, int i2, int i3, IBinder iBinder) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    parcelObtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(3056, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void play(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3024, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void pause(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3025, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void prepare(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3026, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setPlaybackParameters(IMediaController iMediaController, int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3027, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setPlaybackSpeed(IMediaController iMediaController, int i, float f) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeFloat(f);
                    this.mRemote.transact(3028, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void addMediaItem(IMediaController iMediaController, int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3029, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void addMediaItemWithIndex(IMediaController iMediaController, int i, int i2, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3030, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void addMediaItems(IMediaController iMediaController, int i, IBinder iBinder) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(3031, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void addMediaItemsWithIndex(IMediaController iMediaController, int i, int i2, IBinder iBinder) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeStrongBinder(iBinder);
                    this.mRemote.transact(3032, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setPlaylistMetadata(IMediaController iMediaController, int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3033, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void stop(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3034, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void release(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3035, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekToDefaultPosition(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3036, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekToDefaultPositionWithMediaItemIndex(IMediaController iMediaController, int i, int i2) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    this.mRemote.transact(3037, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekTo(IMediaController iMediaController, int i, long j) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeLong(j);
                    this.mRemote.transact(3038, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekToWithMediaItemIndex(IMediaController iMediaController, int i, int i2, long j) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeLong(j);
                    this.mRemote.transact(3039, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekBack(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3040, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekForward(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3041, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekToPreviousMediaItem(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3042, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekToNextMediaItem(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3043, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setVideoSurface(IMediaController iMediaController, int i, Surface surface) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, surface, 0);
                    this.mRemote.transact(3044, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void flushCommandQueue(IMediaController iMediaController) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    this.mRemote.transact(3045, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekToPrevious(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3046, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void seekToNext(IMediaController iMediaController, int i) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    this.mRemote.transact(3047, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setTrackSelectionParameters(IMediaController iMediaController, int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3048, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setRatingWithMediaId(IMediaController iMediaController, int i, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3049, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void setRating(IMediaController iMediaController, int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(3050, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void getLibraryRoot(IMediaController iMediaController, int i, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(PlaybackException.ERROR_CODE_DECODER_INIT_FAILED, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void getItem(IMediaController iMediaController, int i, String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(PlaybackException.ERROR_CODE_DECODER_QUERY_FAILED, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void getChildren(IMediaController iMediaController, int i, String str, int i2, int i3, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(PlaybackException.ERROR_CODE_DECODING_FAILED, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void search(IMediaController iMediaController, int i, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(PlaybackException.ERROR_CODE_DECODING_FORMAT_EXCEEDS_CAPABILITIES, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void getSearchResult(IMediaController iMediaController, int i, String str, int i2, int i3, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    parcelObtain.writeInt(i2);
                    parcelObtain.writeInt(i3);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(PlaybackException.ERROR_CODE_DECODING_FORMAT_UNSUPPORTED, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void subscribe(IMediaController iMediaController, int i, String str, Bundle bundle) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    _Parcel.writeTypedObject(parcelObtain, bundle, 0);
                    this.mRemote.transact(PlaybackException.ERROR_CODE_DECODING_RESOURCES_RECLAIMED, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }

            @Override // androidx.media3.session.IMediaSession
            public void unsubscribe(IMediaController iMediaController, int i, String str) {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(IMediaSession.DESCRIPTOR);
                    parcelObtain.writeStrongInterface(iMediaController);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeString(str);
                    this.mRemote.transact(4007, parcelObtain, null, 1);
                } finally {
                    parcelObtain.recycle();
                }
            }
        }
    }

    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static Object readTypedObject(Parcel parcel, Parcelable.Creator creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void writeTypedObject(Parcel parcel, Parcelable parcelable, int i) {
            if (parcelable != null) {
                parcel.writeInt(1);
                parcelable.writeToParcel(parcel, i);
            } else {
                parcel.writeInt(0);
            }
        }
    }
}
