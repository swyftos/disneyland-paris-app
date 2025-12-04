package androidx.media3.session;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.util.ObjectsCompat;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class SessionCommands {
    public static final SessionCommands EMPTY = new Builder().build();
    private static final String FIELD_SESSION_COMMANDS = Util.intToStringMaxRadix(0);
    public final ImmutableSet<SessionCommand> commands;

    public static final class Builder {
        private final Set commands;

        public Builder() {
            this.commands = new HashSet();
        }

        private Builder(SessionCommands sessionCommands) {
            this.commands = new HashSet(((SessionCommands) Assertions.checkNotNull(sessionCommands)).commands);
        }

        @CanIgnoreReturnValue
        public Builder add(SessionCommand sessionCommand) {
            this.commands.add((SessionCommand) Assertions.checkNotNull(sessionCommand));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder add(int i) {
            Assertions.checkArgument(i != 0);
            this.commands.add(new SessionCommand(i));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addSessionCommands(Collection<SessionCommand> collection) {
            this.commands.addAll(collection);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder remove(SessionCommand sessionCommand) {
            this.commands.remove(Assertions.checkNotNull(sessionCommand));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder remove(int i) {
            Assertions.checkArgument(i != 0);
            Iterator it = this.commands.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SessionCommand sessionCommand = (SessionCommand) it.next();
                if (sessionCommand.commandCode == i) {
                    this.commands.remove(sessionCommand);
                    break;
                }
            }
            return this;
        }

        Builder addAllSessionCommands() {
            addCommandCodes(SessionCommand.SESSION_COMMANDS);
            return this;
        }

        Builder addAllLibraryCommands() {
            addCommandCodes(SessionCommand.LIBRARY_COMMANDS);
            return this;
        }

        private void addCommandCodes(List list) {
            for (int i = 0; i < list.size(); i++) {
                add(new SessionCommand(((Integer) list.get(i)).intValue()));
            }
        }

        public SessionCommands build() {
            return new SessionCommands(this.commands);
        }
    }

    private SessionCommands(Collection collection) {
        this.commands = ImmutableSet.copyOf(collection);
    }

    public boolean contains(SessionCommand sessionCommand) {
        return this.commands.contains(Assertions.checkNotNull(sessionCommand));
    }

    public boolean contains(int i) {
        Assertions.checkArgument(i != 0, "Use contains(Command) for custom command");
        return containsCommandCode(this.commands, i);
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SessionCommands) {
            return this.commands.equals(((SessionCommands) obj).commands);
        }
        return false;
    }

    public int hashCode() {
        return ObjectsCompat.hash(this.commands);
    }

    private static boolean containsCommandCode(Collection collection, int i) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((SessionCommand) it.next()).commandCode == i) {
                return true;
            }
        }
        return false;
    }

    @UnstableApi
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        UnmodifiableIterator<SessionCommand> it = this.commands.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toBundle());
        }
        bundle.putParcelableArrayList(FIELD_SESSION_COMMANDS, arrayList);
        return bundle;
    }

    @UnstableApi
    public static SessionCommands fromBundle(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(FIELD_SESSION_COMMANDS);
        if (parcelableArrayList == null) {
            Log.w("SessionCommands", "Missing commands. Creating an empty SessionCommands");
            return EMPTY;
        }
        Builder builder = new Builder();
        for (int i = 0; i < parcelableArrayList.size(); i++) {
            builder.add(SessionCommand.fromBundle((Bundle) parcelableArrayList.get(i)));
        }
        return builder.build();
    }
}
