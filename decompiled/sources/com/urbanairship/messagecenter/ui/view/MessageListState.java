package com.urbanairship.messagecenter.ui.view;

import android.os.Parcel;
import android.os.Parcelable;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.messagecenter.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageListState;", "", "()V", "Content", "Error", "Loading", "Lcom/urbanairship/messagecenter/ui/view/MessageListState$Content;", "Lcom/urbanairship/messagecenter/ui/view/MessageListState$Error;", "Lcom/urbanairship/messagecenter/ui/view/MessageListState$Loading;", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class MessageListState {
    public /* synthetic */ MessageListState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MessageListState() {
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageListState$Loading;", "Lcom/urbanairship/messagecenter/ui/view/MessageListState;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Loading extends MessageListState {

        @NotNull
        public static final Loading INSTANCE = new Loading();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof Loading);
        }

        public int hashCode() {
            return -1030128184;
        }

        @NotNull
        public String toString() {
            return "Loading";
        }

        private Loading() {
            super(null);
        }
    }

    @Parcelize
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\tHÆ\u0003J/\u0010\u0013\u001a\u00020\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0015HÖ\u0001J\b\u0010\u001a\u001a\u00020\tH\u0016J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageListState$Content;", "Lcom/urbanairship/messagecenter/ui/view/MessageListState;", "Landroid/os/Parcelable;", "messages", "", "Lcom/urbanairship/messagecenter/Message;", "isRefreshing", "", "highlightedMessageId", "", "(Ljava/util/List;ZLjava/lang/String;)V", "getHighlightedMessageId", "()Ljava/lang/String;", "()Z", "getMessages", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "describeContents", "", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Content extends MessageListState implements Parcelable {

        @NotNull
        public static final Parcelable.Creator<Content> CREATOR = new Creator();
        private final String highlightedMessageId;
        private final boolean isRefreshing;
        private final List messages;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<Content> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Content createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                int i = parcel.readInt();
                ArrayList arrayList = new ArrayList(i);
                for (int i2 = 0; i2 != i; i2++) {
                    arrayList.add(Message.CREATOR.createFromParcel(parcel));
                }
                return new Content(arrayList, parcel.readInt() != 0, parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Content[] newArray(int i) {
                return new Content[i];
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Content copy$default(Content content, List list, boolean z, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                list = content.messages;
            }
            if ((i & 2) != 0) {
                z = content.isRefreshing;
            }
            if ((i & 4) != 0) {
                str = content.highlightedMessageId;
            }
            return content.copy(list, z, str);
        }

        @NotNull
        public final List<Message> component1() {
            return this.messages;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsRefreshing() {
            return this.isRefreshing;
        }

        @Nullable
        /* renamed from: component3, reason: from getter */
        public final String getHighlightedMessageId() {
            return this.highlightedMessageId;
        }

        @NotNull
        public final Content copy(@NotNull List<Message> messages, boolean isRefreshing, @Nullable String highlightedMessageId) {
            Intrinsics.checkNotNullParameter(messages, "messages");
            return new Content(messages, isRefreshing, highlightedMessageId);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Content)) {
                return false;
            }
            Content content = (Content) other;
            return Intrinsics.areEqual(this.messages, content.messages) && this.isRefreshing == content.isRefreshing && Intrinsics.areEqual(this.highlightedMessageId, content.highlightedMessageId);
        }

        public int hashCode() {
            int iHashCode = ((this.messages.hashCode() * 31) + Boolean.hashCode(this.isRefreshing)) * 31;
            String str = this.highlightedMessageId;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int flags) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            List list = this.messages;
            parcel.writeInt(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((Message) it.next()).writeToParcel(parcel, flags);
            }
            parcel.writeInt(this.isRefreshing ? 1 : 0);
            parcel.writeString(this.highlightedMessageId);
        }

        public /* synthetic */ Content(List list, boolean z, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, z, (i & 4) != 0 ? null : str);
        }

        @NotNull
        public final List<Message> getMessages() {
            return this.messages;
        }

        public final boolean isRefreshing() {
            return this.isRefreshing;
        }

        @Nullable
        public final String getHighlightedMessageId() {
            return this.highlightedMessageId;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Content(@NotNull List<Message> messages, boolean z, @Nullable String str) {
            super(null);
            Intrinsics.checkNotNullParameter(messages, "messages");
            this.messages = messages;
            this.isRefreshing = z;
            this.highlightedMessageId = str;
        }

        @NotNull
        public String toString() {
            return "Content(messages=[size=" + this.messages.size() + "], isRefreshing=" + this.isRefreshing + ", highlightedMessageId=" + this.highlightedMessageId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0007\u001a\u00020\bHÖ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/messagecenter/ui/view/MessageListState$Error;", "Lcom/urbanairship/messagecenter/ui/view/MessageListState;", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-message-center_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Error extends MessageListState {

        @NotNull
        public static final Error INSTANCE = new Error();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof Error);
        }

        public int hashCode() {
            return 1923293588;
        }

        @NotNull
        public String toString() {
            return "Error";
        }

        private Error() {
            super(null);
        }
    }
}
