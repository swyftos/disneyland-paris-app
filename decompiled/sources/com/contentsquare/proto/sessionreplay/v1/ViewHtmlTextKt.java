package com.contentsquare.proto.sessionreplay.v1;

import com.contentsquare.proto.sessionreplay.v1.SessionRecordingV1;
import com.facebook.react.uimanager.ViewProps;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import com.urbanairship.channel.AttributeMutation;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/ViewHtmlTextKt;", "", "()V", "Dsl", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ViewHtmlTextKt {

    @NotNull
    public static final ViewHtmlTextKt INSTANCE = new ViewHtmlTextKt();

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\f\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002*+B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0001J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001aJ%\u0010\u001c\u001a\u00020\u001a*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001dJ+\u0010\u001e\u001a\u00020\u001a*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 H\u0007¢\u0006\u0002\b!J\u001d\u0010\"\u001a\u00020\u001a*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\rH\u0007¢\u0006\u0002\b#J&\u0010$\u001a\u00020\u001a*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\n¢\u0006\u0002\b%J,\u0010$\u001a\u00020\u001a*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 H\u0087\n¢\u0006\u0002\b&J.\u0010'\u001a\u00020\u001a*\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010(\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\u0002¢\u0006\u0002\b)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\r8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00118G@GX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/ViewHtmlTextKt$Dsl;", "", "_builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewHtmlText$Builder;", "(Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewHtmlText$Builder;)V", "value", "", "content", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "fontNames", "Lcom/google/protobuf/kotlin/DslList;", "Lcom/contentsquare/proto/sessionreplay/v1/ViewHtmlTextKt$Dsl$FontNamesProxy;", "getFontNames", "()Lcom/google/protobuf/kotlin/DslList;", "", ViewProps.NUMBER_OF_LINES, "getNumberOfLines", "()I", "setNumberOfLines", "(I)V", "_build", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewHtmlText;", "clearContent", "", "clearNumberOfLines", "add", "addFontNames", "addAll", "values", "", "addAllFontNames", "clear", "clearFontNames", "plusAssign", "plusAssignFontNames", "plusAssignAllFontNames", AttributeMutation.ATTRIBUTE_ACTION_SET, "index", "setFontNames", "Companion", "FontNamesProxy", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @ProtoDslMarker
    public static final class Dsl {

        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);

        @NotNull
        private final SessionRecordingV1.ViewHtmlText.Builder _builder;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/ViewHtmlTextKt$Dsl$Companion;", "", "()V", "_create", "Lcom/contentsquare/proto/sessionreplay/v1/ViewHtmlTextKt$Dsl;", "builder", "Lcom/contentsquare/proto/sessionreplay/v1/SessionRecordingV1$ViewHtmlText$Builder;", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            @PublishedApi
            public final /* synthetic */ Dsl _create(SessionRecordingV1.ViewHtmlText.Builder builder) {
                Intrinsics.checkNotNullParameter(builder, "builder");
                return new Dsl(builder, null);
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/contentsquare/proto/sessionreplay/v1/ViewHtmlTextKt$Dsl$FontNamesProxy;", "Lcom/google/protobuf/kotlin/DslProxy;", "()V", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class FontNamesProxy extends DslProxy {
            private FontNamesProxy() {
            }
        }

        private Dsl(SessionRecordingV1.ViewHtmlText.Builder builder) {
            this._builder = builder;
        }

        @PublishedApi
        public final /* synthetic */ SessionRecordingV1.ViewHtmlText _build() {
            SessionRecordingV1.ViewHtmlText viewHtmlTextBuild = this._builder.build();
            Intrinsics.checkNotNullExpressionValue(viewHtmlTextBuild, "_builder.build()");
            return viewHtmlTextBuild;
        }

        @JvmName(name = "addAllFontNames")
        public final /* synthetic */ void addAllFontNames(DslList dslList, Iterable values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            this._builder.addAllFontNames(values);
        }

        @JvmName(name = "addFontNames")
        public final /* synthetic */ void addFontNames(DslList dslList, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.addFontNames(value);
        }

        public final void clearContent() {
            this._builder.clearContent();
        }

        @JvmName(name = "clearFontNames")
        public final /* synthetic */ void clearFontNames(DslList dslList) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            this._builder.clearFontNames();
        }

        public final void clearNumberOfLines() {
            this._builder.clearNumberOfLines();
        }

        @JvmName(name = "getContent")
        @NotNull
        public final String getContent() {
            String content = this._builder.getContent();
            Intrinsics.checkNotNullExpressionValue(content, "_builder.getContent()");
            return content;
        }

        @NotNull
        public final DslList<String, FontNamesProxy> getFontNames() {
            List<String> fontNamesList = this._builder.getFontNamesList();
            Intrinsics.checkNotNullExpressionValue(fontNamesList, "_builder.getFontNamesList()");
            return new DslList<>(fontNamesList);
        }

        @JvmName(name = "getNumberOfLines")
        public final int getNumberOfLines() {
            return this._builder.getNumberOfLines();
        }

        @JvmName(name = "plusAssignAllFontNames")
        public final /* synthetic */ void plusAssignAllFontNames(DslList<String, FontNamesProxy> dslList, Iterable<String> values) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(values, "values");
            addAllFontNames(dslList, values);
        }

        @JvmName(name = "plusAssignFontNames")
        public final /* synthetic */ void plusAssignFontNames(DslList<String, FontNamesProxy> dslList, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            addFontNames(dslList, value);
        }

        @JvmName(name = "setContent")
        public final void setContent(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setContent(value);
        }

        @JvmName(name = "setFontNames")
        public final /* synthetic */ void setFontNames(DslList dslList, int i, String value) {
            Intrinsics.checkNotNullParameter(dslList, "<this>");
            Intrinsics.checkNotNullParameter(value, "value");
            this._builder.setFontNames(i, value);
        }

        @JvmName(name = "setNumberOfLines")
        public final void setNumberOfLines(int i) {
            this._builder.setNumberOfLines(i);
        }

        public /* synthetic */ Dsl(SessionRecordingV1.ViewHtmlText.Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
            this(builder);
        }
    }

    private ViewHtmlTextKt() {
    }
}
