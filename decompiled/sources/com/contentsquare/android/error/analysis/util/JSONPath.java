package com.contentsquare.android.error.analysis.util;

import android.util.LruCache;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.exoplayer.upstream.CmcdData;
import ch.qos.logback.core.CoreConstants;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.contentsquare.android.error.analysis.util.JSONPath;
import com.facebook.imageutils.JfifUtil;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001/B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0016\u001a\u00020\u00172\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00192\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J$\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\u000e\u0010$\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\u000bJ\u0010\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u000bH\u0002J?\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010)\"\u0004\b\u0001\u0010(*\u000e\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u0002H(0\n2\u0006\u0010*\u001a\u0002H)2\f\u0010+\u001a\b\u0012\u0004\u0012\u0002H(0,H\u0002¢\u0006\u0002\u0010-J\u0018\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019*\b\u0012\u0004\u0012\u00020\u000b0\u0019H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R(\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\b\u001a\u0004\b\u0014\u0010\u0006¨\u00060"}, d2 = {"Lcom/contentsquare/android/error/analysis/util/JSONPath;", "", "()V", "bracketsRegex", "Lkotlin/text/Regex;", "getBracketsRegex", "()Lkotlin/text/Regex;", "bracketsRegex$delegate", "Lkotlin/Lazy;", "cache", "Landroid/util/LruCache;", "", "Lcom/contentsquare/android/error/analysis/util/JSONPath$CachedPath;", "getCache$annotations", "getCache", "()Landroid/util/LruCache;", "maxNumberDataPointsPerRule", "", "maxNumberRules", "validTokenRegex", "getValidTokenRegex", "validTokenRegex$delegate", "buildCache", "", "paths", "", "context", "Lkotlin/coroutines/CoroutineContext;", "getDelimitedTokens", "jsonPath", "getJSONPathValue", "json", "Lcom/contentsquare/android/error/analysis/util/JSONBody;", "allowObjectNodes", "", "getOrPutCachedPath", "isValidJSONPath", "validateBrackets", CmcdData.Factory.STREAMING_FORMAT_SS, "getOrPut", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "K", "key", "block", "Lkotlin/Function0;", "(Landroid/util/LruCache;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "removeTokenDelimiters", "CachedPath", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nJSONPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JSONPath.kt\ncom/contentsquare/android/error/analysis/util/JSONPath\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,182:1\n1#2:183\n1360#3:184\n1446#3,2:185\n766#3:187\n857#3,2:188\n1448#3,3:190\n1549#3:193\n1620#3,3:194\n*S KotlinDebug\n*F\n+ 1 JSONPath.kt\ncom/contentsquare/android/error/analysis/util/JSONPath\n*L\n126#1:184\n126#1:185,2\n132#1:187\n132#1:188,2\n126#1:190,3\n165#1:193\n165#1:194,3\n*E\n"})
/* loaded from: classes2.dex */
public final class JSONPath {
    private static final int maxNumberDataPointsPerRule = 15;
    private static final int maxNumberRules = 15;

    @NotNull
    public static final JSONPath INSTANCE = new JSONPath();

    @NotNull
    private static final LruCache<String, CachedPath> cache = new LruCache<>(JfifUtil.MARKER_APP1);

    /* renamed from: bracketsRegex$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy bracketsRegex = LazyKt.lazy(new Function0<Regex>() { // from class: com.contentsquare.android.error.analysis.util.JSONPath$bracketsRegex$2
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Regex invoke() {
            return new Regex("[\\[\\]]");
        }
    });

    /* renamed from: validTokenRegex$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy validTokenRegex = LazyKt.lazy(new Function0<Regex>() { // from class: com.contentsquare.android.error.analysis.util.JSONPath$validTokenRegex$2
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final Regex invoke() {
            return new Regex("^([0-9]\\d*|[\\w-]+|('([^']*)'|\"([^\"]*)\"))$");
        }
    });

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/contentsquare/android/error/analysis/util/JSONPath$CachedPath;", "", "isPathValid", "", "tokens", "", "", "(ZLjava/util/List;)V", "()Z", "getTokens", "()Ljava/util/List;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class CachedPath {
        private final boolean isPathValid;

        @NotNull
        private final List<String> tokens;

        public CachedPath(boolean z, List<String> tokens) {
            Intrinsics.checkNotNullParameter(tokens, "tokens");
            this.isPathValid = z;
            this.tokens = tokens;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CachedPath copy$default(CachedPath cachedPath, boolean z, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                z = cachedPath.isPathValid;
            }
            if ((i & 2) != 0) {
                list = cachedPath.tokens;
            }
            return cachedPath.copy(z, list);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsPathValid() {
            return this.isPathValid;
        }

        @NotNull
        public final List<String> component2() {
            return this.tokens;
        }

        @NotNull
        public final CachedPath copy(boolean isPathValid, List<String> tokens) {
            Intrinsics.checkNotNullParameter(tokens, "tokens");
            return new CachedPath(isPathValid, tokens);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CachedPath)) {
                return false;
            }
            CachedPath cachedPath = (CachedPath) other;
            return this.isPathValid == cachedPath.isPathValid && Intrinsics.areEqual(this.tokens, cachedPath.tokens);
        }

        @NotNull
        public final List<String> getTokens() {
            return this.tokens;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        public int hashCode() {
            boolean z = this.isPathValid;
            ?? r0 = z;
            if (z) {
                r0 = 1;
            }
            return this.tokens.hashCode() + (r0 * 31);
        }

        public final boolean isPathValid() {
            return this.isPathValid;
        }

        @NotNull
        public String toString() {
            return "CachedPath(isPathValid=" + this.isPathValid + ", tokens=" + this.tokens + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.contentsquare.android.error.analysis.util.JSONPath$buildCache$1", f = "JSONPath.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    @SourceDebugExtension({"SMAP\nJSONPath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JSONPath.kt\ncom/contentsquare/android/error/analysis/util/JSONPath$buildCache$1\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,182:1\n1855#2,2:183\n*S KotlinDebug\n*F\n+ 1 JSONPath.kt\ncom/contentsquare/android/error/analysis/util/JSONPath$buildCache$1\n*L\n178#1:183,2\n*E\n"})
    /* renamed from: com.contentsquare.android.error.analysis.util.JSONPath$buildCache$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $paths;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List<String> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$paths = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$paths, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List<String> list = this.$paths;
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    JSONPath.INSTANCE.getOrPutCachedPath((String) it.next());
                }
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private JSONPath() {
    }

    public static /* synthetic */ void buildCache$default(JSONPath jSONPath, List list, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = Dispatchers.getIO();
        }
        jSONPath.buildCache(list, coroutineContext);
    }

    private final Regex getBracketsRegex() {
        return (Regex) bracketsRegex.getValue();
    }

    @VisibleForTesting
    public static /* synthetic */ void getCache$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> getDelimitedTokens(String jsonPath) {
        Collection collectionListOf;
        List<String> listSplit = getBracketsRegex().split(StringsKt.removePrefix(jsonPath, (CharSequence) "$"), 0);
        ArrayList arrayList = new ArrayList();
        for (String str : listSplit) {
            if (StringsKt.startsWith$default(str, "'", false, 2, (Object) null) || StringsKt.startsWith$default((CharSequence) str, '\"', false, 2, (Object) null)) {
                collectionListOf = CollectionsKt.listOf(str);
            } else {
                List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{InstructionFileId.DOT}, false, 0, 6, (Object) null);
                collectionListOf = new ArrayList();
                for (Object obj : listSplit$default) {
                    if (((String) obj).length() > 0) {
                        collectionListOf.add(obj);
                    }
                }
            }
            CollectionsKt.addAll(arrayList, collectionListOf);
        }
        return arrayList;
    }

    public static /* synthetic */ String getJSONPathValue$default(JSONPath jSONPath, String str, JSONBody jSONBody, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return jSONPath.getJSONPathValue(str, jSONBody, z);
    }

    private final <K, V> V getOrPut(LruCache<K, V> lruCache, K k, Function0<? extends V> function0) {
        V vInvoke;
        synchronized (cache) {
            vInvoke = lruCache.get(k);
            if (vInvoke == null) {
                vInvoke = function0.invoke();
                lruCache.put(k, vInvoke);
            }
        }
        return vInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CachedPath getOrPutCachedPath(final String jsonPath) {
        return (CachedPath) getOrPut(cache, jsonPath, new Function0<CachedPath>() { // from class: com.contentsquare.android.error.analysis.util.JSONPath.getOrPutCachedPath.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CachedPath invoke() {
                JSONPath jSONPath = JSONPath.INSTANCE;
                List delimitedTokens = jSONPath.getDelimitedTokens(jsonPath);
                boolean z = false;
                if (jSONPath.validateBrackets(jsonPath) && !StringsKt.endsWith$default(jsonPath, InstructionFileId.DOT, false, 2, (Object) null)) {
                    if (delimitedTokens == null || !delimitedTokens.isEmpty()) {
                        Iterator it = delimitedTokens.iterator();
                        while (it.hasNext()) {
                            if (!JSONPath.INSTANCE.getValidTokenRegex().matches((String) it.next())) {
                                break;
                            }
                        }
                        z = true;
                    } else {
                        z = true;
                    }
                }
                return new CachedPath(z, z ? JSONPath.INSTANCE.removeTokenDelimiters(delimitedTokens) : CollectionsKt.emptyList());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Regex getValidTokenRegex() {
        return (Regex) validTokenRegex.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<String> removeTokenDelimiters(List<String> list) {
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt.removeSurrounding(StringsKt.removeSurrounding((String) it.next(), (CharSequence) "'"), (CharSequence) "\""));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean validateBrackets(String s) {
        Character ch2;
        Stack stack = new Stack();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = s.charAt(i);
            if (cCharAt == '[') {
                stack.push(Character.valueOf(cCharAt));
            } else if (cCharAt == ']' && (stack.isEmpty() || (ch2 = (Character) stack.pop()) == null || ch2.charValue() != '[')) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public final void buildCache(List<String> paths, CoroutineContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(context), null, null, new AnonymousClass1(paths, null), 3, null);
    }

    @NotNull
    public final LruCache<String, CachedPath> getCache() {
        return cache;
    }

    @Nullable
    public final String getJSONPathValue(final String jsonPath, JSONBody json, boolean allowObjectNodes) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(jsonPath, "jsonPath");
        if (StringsKt.isBlank(jsonPath) || json == null || !isValidJSONPath(jsonPath)) {
            return null;
        }
        List<String> tokens = ((CachedPath) getOrPut(cache, jsonPath, new Function0<CachedPath>() { // from class: com.contentsquare.android.error.analysis.util.JSONPath$getJSONPathValue$tokens$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final JSONPath.CachedPath invoke() {
                JSONPath jSONPath = JSONPath.INSTANCE;
                return new JSONPath.CachedPath(true, jSONPath.removeTokenDelimiters(jSONPath.getDelimitedTokens(jsonPath)));
            }
        })).getTokens();
        Object jsonObject = json.getJsonObject();
        if (jsonObject == null) {
            jsonObject = json.getJsonArray();
        }
        for (String str : tokens) {
            if (jsonObject instanceof JSONObject) {
                jsonObject = ((JSONObject) jsonObject).opt(str);
            } else if (!(jsonObject instanceof JSONArray) || (intOrNull = StringsKt.toIntOrNull(str)) == null) {
                jsonObject = null;
            } else {
                int iIntValue = intOrNull.intValue();
                Intrinsics.checkNotNull(jsonObject, "null cannot be cast to non-null type org.json.JSONArray");
                jsonObject = ((JSONArray) jsonObject).opt(iIntValue);
            }
        }
        if ((((jsonObject instanceof JSONObject) || (jsonObject instanceof JSONArray)) && !allowObjectNodes) || jsonObject == null) {
            return null;
        }
        return jsonObject.toString();
    }

    public final boolean isValidJSONPath(String jsonPath) {
        Intrinsics.checkNotNullParameter(jsonPath, "jsonPath");
        return getOrPutCachedPath(jsonPath).isPathValid();
    }
}
