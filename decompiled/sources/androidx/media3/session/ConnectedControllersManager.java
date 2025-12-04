package androidx.media3.session;

import androidx.collection.ArrayMap;
import androidx.media3.common.Player;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.session.MediaSession;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
final class ConnectedControllersManager {
    private final ArrayMap controllerInfoMap = new ArrayMap();
    private final ArrayMap controllerRecords = new ArrayMap();
    private final Object lock = new Object();
    private final WeakReference sessionImpl;

    public interface AsyncCommand {
        ListenableFuture<Void> run();
    }

    public ConnectedControllersManager(MediaSessionImpl mediaSessionImpl) {
        this.sessionImpl = new WeakReference(mediaSessionImpl);
    }

    public void addController(Object obj, MediaSession.ControllerInfo controllerInfo, SessionCommands sessionCommands, Player.Commands commands) {
        synchronized (this.lock) {
            try {
                MediaSession.ControllerInfo controller = getController(obj);
                if (controller == null) {
                    this.controllerInfoMap.put(obj, controllerInfo);
                    this.controllerRecords.put(controllerInfo, new ConnectedControllerRecord(obj, new SequencedFutureManager(), sessionCommands, commands));
                } else {
                    ConnectedControllerRecord connectedControllerRecord = (ConnectedControllerRecord) Assertions.checkStateNotNull((ConnectedControllerRecord) this.controllerRecords.get(controller));
                    connectedControllerRecord.sessionCommands = sessionCommands;
                    connectedControllerRecord.playerCommands = commands;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void updateCommandsFromSession(MediaSession.ControllerInfo controllerInfo, SessionCommands sessionCommands, Player.Commands commands) {
        synchronized (this.lock) {
            try {
                ConnectedControllerRecord connectedControllerRecord = (ConnectedControllerRecord) this.controllerRecords.get(controllerInfo);
                if (connectedControllerRecord != null) {
                    connectedControllerRecord.sessionCommands = sessionCommands;
                    connectedControllerRecord.playerCommands = commands;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Player.Commands getAvailablePlayerCommands(MediaSession.ControllerInfo controllerInfo) {
        synchronized (this.lock) {
            try {
                ConnectedControllerRecord connectedControllerRecord = (ConnectedControllerRecord) this.controllerRecords.get(controllerInfo);
                if (connectedControllerRecord == null) {
                    return null;
                }
                return connectedControllerRecord.playerCommands;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void removeController(Object obj) {
        MediaSession.ControllerInfo controller = getController(obj);
        if (controller != null) {
            removeController(controller);
        }
    }

    public void removeController(final MediaSession.ControllerInfo controllerInfo) {
        synchronized (this.lock) {
            try {
                ConnectedControllerRecord connectedControllerRecord = (ConnectedControllerRecord) this.controllerRecords.remove(controllerInfo);
                if (connectedControllerRecord == null) {
                    return;
                }
                this.controllerInfoMap.remove(connectedControllerRecord.controllerKey);
                connectedControllerRecord.sequencedFutureManager.release();
                final MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.sessionImpl.get();
                if (mediaSessionImpl == null || mediaSessionImpl.isReleased()) {
                    return;
                }
                Util.postOrRun(mediaSessionImpl.getApplicationHandler(), new Runnable() { // from class: androidx.media3.session.ConnectedControllersManager$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ConnectedControllersManager.lambda$removeController$0(mediaSessionImpl, controllerInfo);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$removeController$0(MediaSessionImpl mediaSessionImpl, MediaSession.ControllerInfo controllerInfo) {
        if (mediaSessionImpl.isReleased()) {
            return;
        }
        mediaSessionImpl.onDisconnectedOnHandler(controllerInfo);
    }

    public ImmutableList getConnectedControllers() {
        ImmutableList immutableListCopyOf;
        synchronized (this.lock) {
            immutableListCopyOf = ImmutableList.copyOf(this.controllerInfoMap.values());
        }
        return immutableListCopyOf;
    }

    public boolean isConnected(MediaSession.ControllerInfo controllerInfo) {
        boolean z;
        synchronized (this.lock) {
            z = this.controllerRecords.get(controllerInfo) != null;
        }
        return z;
    }

    public SequencedFutureManager getSequencedFutureManager(MediaSession.ControllerInfo controllerInfo) {
        ConnectedControllerRecord connectedControllerRecord;
        synchronized (this.lock) {
            connectedControllerRecord = (ConnectedControllerRecord) this.controllerRecords.get(controllerInfo);
        }
        if (connectedControllerRecord != null) {
            return connectedControllerRecord.sequencedFutureManager;
        }
        return null;
    }

    public SequencedFutureManager getSequencedFutureManager(Object obj) {
        ConnectedControllerRecord connectedControllerRecord;
        synchronized (this.lock) {
            try {
                MediaSession.ControllerInfo controller = getController(obj);
                connectedControllerRecord = controller != null ? (ConnectedControllerRecord) this.controllerRecords.get(controller) : null;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (connectedControllerRecord != null) {
            return connectedControllerRecord.sequencedFutureManager;
        }
        return null;
    }

    public boolean isSessionCommandAvailable(MediaSession.ControllerInfo controllerInfo, SessionCommand sessionCommand) {
        ConnectedControllerRecord connectedControllerRecord;
        synchronized (this.lock) {
            connectedControllerRecord = (ConnectedControllerRecord) this.controllerRecords.get(controllerInfo);
        }
        return connectedControllerRecord != null && connectedControllerRecord.sessionCommands.contains(sessionCommand);
    }

    public boolean isSessionCommandAvailable(MediaSession.ControllerInfo controllerInfo, int i) {
        ConnectedControllerRecord connectedControllerRecord;
        synchronized (this.lock) {
            connectedControllerRecord = (ConnectedControllerRecord) this.controllerRecords.get(controllerInfo);
        }
        return connectedControllerRecord != null && connectedControllerRecord.sessionCommands.contains(i);
    }

    public boolean isPlayerCommandAvailable(MediaSession.ControllerInfo controllerInfo, int i) {
        ConnectedControllerRecord connectedControllerRecord;
        synchronized (this.lock) {
            connectedControllerRecord = (ConnectedControllerRecord) this.controllerRecords.get(controllerInfo);
        }
        MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.sessionImpl.get();
        return connectedControllerRecord != null && connectedControllerRecord.playerCommands.contains(i) && mediaSessionImpl != null && mediaSessionImpl.getPlayerWrapper().getAvailableCommands().contains(i);
    }

    public MediaSession.ControllerInfo getController(Object obj) {
        MediaSession.ControllerInfo controllerInfo;
        synchronized (this.lock) {
            controllerInfo = (MediaSession.ControllerInfo) this.controllerInfoMap.get(obj);
        }
        return controllerInfo;
    }

    public void addToCommandQueue(MediaSession.ControllerInfo controllerInfo, int i, AsyncCommand asyncCommand) {
        synchronized (this.lock) {
            try {
                ConnectedControllerRecord connectedControllerRecord = (ConnectedControllerRecord) this.controllerRecords.get(controllerInfo);
                if (connectedControllerRecord != null) {
                    connectedControllerRecord.commandQueuePlayerCommands = connectedControllerRecord.commandQueuePlayerCommands.buildUpon().add(i).build();
                    connectedControllerRecord.commandQueue.add(asyncCommand);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void flushCommandQueue(final MediaSession.ControllerInfo controllerInfo) {
        synchronized (this.lock) {
            try {
                ConnectedControllerRecord connectedControllerRecord = (ConnectedControllerRecord) this.controllerRecords.get(controllerInfo);
                if (connectedControllerRecord == null) {
                    return;
                }
                final Player.Commands commands = connectedControllerRecord.commandQueuePlayerCommands;
                connectedControllerRecord.commandQueuePlayerCommands = Player.Commands.EMPTY;
                connectedControllerRecord.commandQueue.add(new AsyncCommand() { // from class: androidx.media3.session.ConnectedControllersManager$$ExternalSyntheticLambda1
                    @Override // androidx.media3.session.ConnectedControllersManager.AsyncCommand
                    public final ListenableFuture run() {
                        return this.f$0.lambda$flushCommandQueue$1(controllerInfo, commands);
                    }
                });
                if (connectedControllerRecord.commandQueueIsFlushing) {
                    return;
                }
                connectedControllerRecord.commandQueueIsFlushing = true;
                flushCommandQueue(connectedControllerRecord);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ListenableFuture lambda$flushCommandQueue$1(MediaSession.ControllerInfo controllerInfo, Player.Commands commands) {
        MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.sessionImpl.get();
        if (mediaSessionImpl != null) {
            mediaSessionImpl.onPlayerInteractionFinishedOnHandler(controllerInfo, commands);
        }
        return Futures.immediateVoidFuture();
    }

    private void flushCommandQueue(final ConnectedControllerRecord connectedControllerRecord) {
        MediaSessionImpl mediaSessionImpl = (MediaSessionImpl) this.sessionImpl.get();
        if (mediaSessionImpl == null) {
            return;
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        while (atomicBoolean.get()) {
            atomicBoolean.set(false);
            final AsyncCommand asyncCommand = (AsyncCommand) connectedControllerRecord.commandQueue.poll();
            if (asyncCommand == null) {
                connectedControllerRecord.commandQueueIsFlushing = false;
                return;
            } else {
                final AtomicBoolean atomicBoolean2 = new AtomicBoolean(true);
                Util.postOrRun(mediaSessionImpl.getApplicationHandler(), mediaSessionImpl.callWithControllerForCurrentRequestSet(getController(connectedControllerRecord.controllerKey), new Runnable() { // from class: androidx.media3.session.ConnectedControllersManager$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$flushCommandQueue$3(asyncCommand, atomicBoolean2, connectedControllerRecord, atomicBoolean);
                    }
                }));
                atomicBoolean2.set(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$flushCommandQueue$3(AsyncCommand asyncCommand, final AtomicBoolean atomicBoolean, final ConnectedControllerRecord connectedControllerRecord, final AtomicBoolean atomicBoolean2) {
        asyncCommand.run().addListener(new Runnable() { // from class: androidx.media3.session.ConnectedControllersManager$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$flushCommandQueue$2(atomicBoolean, connectedControllerRecord, atomicBoolean2);
            }
        }, MoreExecutors.directExecutor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$flushCommandQueue$2(AtomicBoolean atomicBoolean, ConnectedControllerRecord connectedControllerRecord, AtomicBoolean atomicBoolean2) {
        synchronized (this.lock) {
            try {
                if (!atomicBoolean.get()) {
                    flushCommandQueue(connectedControllerRecord);
                } else {
                    atomicBoolean2.set(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class ConnectedControllerRecord {
        public boolean commandQueueIsFlushing;
        public final Object controllerKey;
        public Player.Commands playerCommands;
        public final SequencedFutureManager sequencedFutureManager;
        public SessionCommands sessionCommands;
        public final Deque commandQueue = new ArrayDeque();
        public Player.Commands commandQueuePlayerCommands = Player.Commands.EMPTY;

        public ConnectedControllerRecord(Object obj, SequencedFutureManager sequencedFutureManager, SessionCommands sessionCommands, Player.Commands commands) {
            this.controllerKey = obj;
            this.sequencedFutureManager = sequencedFutureManager;
            this.sessionCommands = sessionCommands;
            this.playerCommands = commands;
        }
    }
}
