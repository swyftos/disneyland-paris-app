package com.contentsquare.android.internal.features.webviewbridge.assets;

import com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"com/contentsquare/android/internal/features/webviewbridge/assets/WebViewAsset.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/contentsquare/android/internal/features/webviewbridge/assets/WebViewAsset;", "<init>", "()V", "library_release"}, k = 1, mv = {1, 8, 0})
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes2.dex */
public final class WebViewAsset$$serializer implements GeneratedSerializer<WebViewAsset> {

    @NotNull
    public static final WebViewAsset$$serializer INSTANCE;
    public static final /* synthetic */ PluginGeneratedSerialDescriptor a;

    static {
        WebViewAsset$$serializer webViewAsset$$serializer = new WebViewAsset$$serializer();
        INSTANCE = webViewAsset$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset", webViewAsset$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("assetId", false);
        pluginGeneratedSerialDescriptor.addElement("assetRawPath", false);
        pluginGeneratedSerialDescriptor.addElement("assetBasePath", false);
        pluginGeneratedSerialDescriptor.addElement("retrievedAssetContent", true);
        pluginGeneratedSerialDescriptor.addElement("hash", true);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("serializationId", true);
        a = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    @NotNull
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = WebViewAsset.k;
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        return new KSerializer[]{stringSerializer, stringSerializer, stringSerializer, BuiltinSerializersKt.getNullable(WebViewAssetContent$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(stringSerializer), kSerializerArr[5], BuiltinSerializersKt.getNullable(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final Object deserialize(Decoder decoder) {
        Object objDecodeNullableSerializableElement;
        int i;
        Object objDecodeNullableSerializableElement2;
        Object objDecodeSerializableElement;
        String str;
        String strDecodeStringElement;
        String strDecodeStringElement2;
        Object objDecodeNullableSerializableElement3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = a;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
        KSerializer<Object>[] kSerializerArr = WebViewAsset.k;
        String strDecodeStringElement3 = null;
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement4 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
            strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 1);
            strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 2);
            Object objDecodeNullableSerializableElement4 = compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, WebViewAssetContent$$serializer.INSTANCE, null);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            objDecodeNullableSerializableElement3 = compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, stringSerializer, null);
            objDecodeSerializableElement = compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 5, kSerializerArr[5], null);
            objDecodeNullableSerializableElement2 = compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 6, stringSerializer, null);
            i = 127;
            objDecodeNullableSerializableElement = objDecodeNullableSerializableElement4;
            str = strDecodeStringElement4;
        } else {
            boolean z = true;
            int i2 = 0;
            Object objDecodeNullableSerializableElement5 = null;
            Object objDecodeSerializableElement2 = null;
            String strDecodeStringElement5 = null;
            String strDecodeStringElement6 = null;
            objDecodeNullableSerializableElement = null;
            Object objDecodeNullableSerializableElement6 = null;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        i2 |= 1;
                        strDecodeStringElement3 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                        continue;
                    case 1:
                        i2 |= 2;
                        strDecodeStringElement5 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 1);
                        continue;
                    case 2:
                        strDecodeStringElement6 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 2);
                        i2 |= 4;
                        continue;
                    case 3:
                        objDecodeNullableSerializableElement = compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, WebViewAssetContent$$serializer.INSTANCE, objDecodeNullableSerializableElement);
                        i2 |= 8;
                        break;
                    case 4:
                        objDecodeNullableSerializableElement6 = compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, StringSerializer.INSTANCE, objDecodeNullableSerializableElement6);
                        i2 |= 16;
                        break;
                    case 5:
                        objDecodeSerializableElement2 = compositeDecoderBeginStructure.decodeSerializableElement(pluginGeneratedSerialDescriptor, 5, kSerializerArr[5], objDecodeSerializableElement2);
                        i2 |= 32;
                        break;
                    case 6:
                        objDecodeNullableSerializableElement5 = compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 6, StringSerializer.INSTANCE, objDecodeNullableSerializableElement5);
                        i2 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            i = i2;
            objDecodeNullableSerializableElement2 = objDecodeNullableSerializableElement5;
            objDecodeSerializableElement = objDecodeSerializableElement2;
            str = strDecodeStringElement3;
            strDecodeStringElement = strDecodeStringElement5;
            strDecodeStringElement2 = strDecodeStringElement6;
            objDecodeNullableSerializableElement3 = objDecodeNullableSerializableElement6;
        }
        compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
        return new WebViewAsset(i, str, strDecodeStringElement, strDecodeStringElement2, (WebViewAssetContent) objDecodeNullableSerializableElement, (String) objDecodeNullableSerializableElement3, (WebViewAsset.a) objDecodeSerializableElement, (String) objDecodeNullableSerializableElement2);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    @NotNull
    public final SerialDescriptor getDescriptor() {
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    @Override // kotlinx.serialization.SerializationStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void serialize(kotlinx.serialization.encoding.Encoder r7, java.lang.Object r8) {
        /*
            r6 = this;
            com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset r8 = (com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset) r8
            java.lang.String r6 = "encoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r6)
            java.lang.String r6 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r6)
            kotlinx.serialization.internal.PluginGeneratedSerialDescriptor r6 = com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset$$serializer.a
            kotlinx.serialization.encoding.CompositeEncoder r7 = r7.beginStructure(r6)
            kotlinx.serialization.KSerializer<java.lang.Object>[] r0 = com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset.k
            java.lang.String r1 = r8.a
            r2 = 0
            r7.encodeStringElement(r6, r2, r1)
            java.lang.String r1 = r8.b
            r2 = 1
            r7.encodeStringElement(r6, r2, r1)
            java.lang.String r1 = r8.c
            r2 = 2
            r7.encodeStringElement(r6, r2, r1)
            r1 = 3
            boolean r2 = r7.shouldEncodeElementDefault(r6, r1)
            if (r2 == 0) goto L2f
            goto L33
        L2f:
            com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAssetContent r2 = r8.d
            if (r2 == 0) goto L3a
        L33:
            com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAssetContent$$serializer r2 = com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAssetContent$$serializer.INSTANCE
            com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAssetContent r3 = r8.d
            r7.encodeNullableSerializableElement(r6, r1, r2, r3)
        L3a:
            r1 = 4
            boolean r2 = r7.shouldEncodeElementDefault(r6, r1)
            if (r2 == 0) goto L42
            goto L73
        L42:
            java.lang.String r2 = r8.e
            com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAssetContent r3 = r8.d
            if (r3 == 0) goto L6c
            byte[] r3 = r3.c
            if (r3 == 0) goto L6c
            com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset$c r4 = com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset.Companion
            r4.getClass()
            kotlin.Lazy<java.security.MessageDigest> r4 = com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset.i
            java.lang.Object r4 = r4.getValue()
            java.lang.String r5 = "<get-hashMessageDigest>(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.security.MessageDigest r4 = (java.security.MessageDigest) r4
            byte[] r3 = r4.digest(r3)
            java.lang.String r4 = "hashMessageDigest.digest(it)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            java.lang.String r3 = com.contentsquare.android.core.utils.ExtensionsKt.toHexString(r3)
            goto L6d
        L6c:
            r3 = 0
        L6d:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L7a
        L73:
            kotlinx.serialization.internal.StringSerializer r2 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.String r3 = r8.e
            r7.encodeNullableSerializableElement(r6, r1, r2, r3)
        L7a:
            r1 = 5
            boolean r2 = r7.shouldEncodeElementDefault(r6, r1)
            if (r2 == 0) goto L82
            goto La3
        L82:
            com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset$a r2 = r8.f
            boolean r3 = r8.b()
            if (r3 == 0) goto L8d
            com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset$a r3 = com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset.a.DATA_CSS
            goto La1
        L8d:
            boolean r3 = r8.a()
            if (r3 == 0) goto L96
            com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset$a r3 = com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset.a.DATA
            goto La1
        L96:
            boolean r3 = r8.c()
            if (r3 == 0) goto L9f
            com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset$a r3 = com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset.a.REMOTE
            goto La1
        L9f:
            com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset$a r3 = com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset.a.UNSUPPORTED
        La1:
            if (r2 == r3) goto Laa
        La3:
            r0 = r0[r1]
            com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset$a r2 = r8.f
            r7.encodeSerializableElement(r6, r1, r0, r2)
        Laa:
            r0 = 6
            boolean r1 = r7.shouldEncodeElementDefault(r6, r0)
            if (r1 == 0) goto Lb2
            goto Lb6
        Lb2:
            java.lang.String r1 = r8.g
            if (r1 == 0) goto Lbd
        Lb6:
            kotlinx.serialization.internal.StringSerializer r1 = kotlinx.serialization.internal.StringSerializer.INSTANCE
            java.lang.String r8 = r8.g
            r7.encodeNullableSerializableElement(r6, r0, r1, r8)
        Lbd:
            r7.endStructure(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset$$serializer.serialize(kotlinx.serialization.encoding.Encoder, java.lang.Object):void");
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    @NotNull
    public final KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
