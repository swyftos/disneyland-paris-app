package com.urbanairship.contacts;

import androidx.camera.video.AudioStats;
import ch.qos.logback.core.CoreConstants;
import com.allegion.accesssdk.BuildConfig;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.urbanairship.UALog;
import com.urbanairship.config.AirshipRuntimeConfig;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestAuth;
import com.urbanairship.http.RequestResult;
import com.urbanairship.http.ResponseParser;
import com.urbanairship.http.SuspendingRequestSession;
import com.urbanairship.http.SuspendingRequestSessionKt;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.util.UAHttpStatusUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0080@¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m1836d2 = {"Lcom/urbanairship/contacts/ContactChannelsApiClient;", "", "runtimeConfig", "Lcom/urbanairship/config/AirshipRuntimeConfig;", BuildConfig.SESSION_KEY_REFERENCE, "Lcom/urbanairship/http/SuspendingRequestSession;", "(Lcom/urbanairship/config/AirshipRuntimeConfig;Lcom/urbanairship/http/SuspendingRequestSession;)V", "fetch", "Lcom/urbanairship/http/RequestResult;", "", "Lcom/urbanairship/contacts/ContactChannel;", "contactId", "", "fetch$urbanairship_core_release", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseChannels", "responseBody", "Companion", "urbanairship-core_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
@SourceDebugExtension({"SMAP\nContactChannelsApiClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContactChannelsApiClient.kt\ncom/urbanairship/contacts/ContactChannelsApiClient\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,111:1\n1549#2:112\n1620#2,3:113\n1603#2,9:116\n1855#2:125\n1856#2:232\n1612#2:233\n44#3,15:126\n44#3,15:141\n44#3,15:156\n44#3,15:171\n44#3,15:186\n44#3,15:201\n44#3,15:216\n1#4:231\n*S KotlinDebug\n*F\n+ 1 ContactChannelsApiClient.kt\ncom/urbanairship/contacts/ContactChannelsApiClient\n*L\n55#1:112\n55#1:113,3\n56#1:116,9\n56#1:125\n56#1:232\n56#1:233\n57#1:126,15\n61#1:141,15\n62#1:156,15\n73#1:171,15\n74#1:186,15\n75#1:201,15\n76#1:216,15\n56#1:231\n*E\n"})
public final class ContactChannelsApiClient {
    private static final Companion Companion = new Companion(null);
    private final AirshipRuntimeConfig runtimeConfig;
    private final SuspendingRequestSession session;

    public ContactChannelsApiClient(@NotNull AirshipRuntimeConfig runtimeConfig, @NotNull SuspendingRequestSession session) {
        Intrinsics.checkNotNullParameter(runtimeConfig, "runtimeConfig");
        Intrinsics.checkNotNullParameter(session, "session");
        this.runtimeConfig = runtimeConfig;
        this.session = session;
    }

    public /* synthetic */ ContactChannelsApiClient(AirshipRuntimeConfig airshipRuntimeConfig, SuspendingRequestSession suspendingRequestSession, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(airshipRuntimeConfig, (i & 2) != 0 ? SuspendingRequestSessionKt.toSuspendingRequestSession(airshipRuntimeConfig.getRequestSession()) : suspendingRequestSession);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Nullable
    public final Object fetch$urbanairship_core_release(@NotNull final String str, @NotNull Continuation<? super RequestResult<List<ContactChannel>>> continuation) {
        ContactChannelsApiClient$fetch$1 contactChannelsApiClient$fetch$1;
        if (continuation instanceof ContactChannelsApiClient$fetch$1) {
            contactChannelsApiClient$fetch$1 = (ContactChannelsApiClient$fetch$1) continuation;
            int i = contactChannelsApiClient$fetch$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                contactChannelsApiClient$fetch$1.label = i - Integer.MIN_VALUE;
            } else {
                contactChannelsApiClient$fetch$1 = new ContactChannelsApiClient$fetch$1(this, continuation);
            }
        } else {
            contactChannelsApiClient$fetch$1 = new ContactChannelsApiClient$fetch$1(this, continuation);
        }
        Object objExecute = contactChannelsApiClient$fetch$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = contactChannelsApiClient$fetch$1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objExecute);
            final Request request = new Request(this.runtimeConfig.getDeviceUrl().appendEncodedPath("api/contacts/associated_types/" + str).build(), "GET", new RequestAuth.ContactTokenAuth(str), null, MapsKt.mapOf(TuplesKt.m1842to("Accept", "application/vnd.urbanairship+json; version=3;")), false, 40, null);
            UALog.d$default(null, new Function0() { // from class: com.urbanairship.contacts.ContactChannelsApiClient$fetch$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "Fetching contact channels for " + str + " request: " + request;
                }
            }, 1, null);
            SuspendingRequestSession suspendingRequestSession = this.session;
            ResponseParser responseParser = new ResponseParser() { // from class: com.urbanairship.contacts.ContactChannelsApiClient$$ExternalSyntheticLambda0
                @Override // com.urbanairship.http.ResponseParser
                public final Object parseResponse(int i3, Map map, String str2) {
                    return ContactChannelsApiClient.fetch$lambda$0(this.f$0, i3, map, str2);
                }
            };
            contactChannelsApiClient$fetch$1.L$0 = str;
            contactChannelsApiClient$fetch$1.label = 1;
            objExecute = suspendingRequestSession.execute(request, responseParser, contactChannelsApiClient$fetch$1);
            if (objExecute == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) contactChannelsApiClient$fetch$1.L$0;
            ResultKt.throwOnFailure(objExecute);
        }
        final RequestResult requestResult = (RequestResult) objExecute;
        SuspendingRequestSessionKt.log(requestResult, new Function0() { // from class: com.urbanairship.contacts.ContactChannelsApiClient$fetch$4$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "Fetching contact channels for " + str + " finished with result: " + requestResult;
            }
        });
        return objExecute;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List fetch$lambda$0(ContactChannelsApiClient this$0, int i, Map map, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(map, "<anonymous parameter 1>");
        if (UAHttpStatusUtil.inSuccessRange(i)) {
            return this$0.parseChannels(str);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0281  */
    /* JADX WARN: Code duplicated, block: B:102:0x028f  */
    /* JADX WARN: Code duplicated, block: B:104:0x029a  */
    /* JADX WARN: Code duplicated, block: B:105:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:107:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:109:0x02bb  */
    /* JADX WARN: Code duplicated, block: B:112:0x02c6  */
    /* JADX WARN: Code duplicated, block: B:114:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:116:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:119:0x02e1  */
    /* JADX WARN: Code duplicated, block: B:121:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:123:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:126:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:128:0x030f  */
    /* JADX WARN: Code duplicated, block: B:133:0x031f  */
    /* JADX WARN: Code duplicated, block: B:135:0x0329  */
    /* JADX WARN: Code duplicated, block: B:140:0x0336  */
    /* JADX WARN: Code duplicated, block: B:142:0x0342  */
    /* JADX WARN: Code duplicated, block: B:143:0x034e  */
    /* JADX WARN: Code duplicated, block: B:145:0x035a  */
    /* JADX WARN: Code duplicated, block: B:146:0x0367  */
    /* JADX WARN: Code duplicated, block: B:148:0x0373  */
    /* JADX WARN: Code duplicated, block: B:149:0x0382  */
    /* JADX WARN: Code duplicated, block: B:151:0x038e  */
    /* JADX WARN: Code duplicated, block: B:152:0x039c  */
    /* JADX WARN: Code duplicated, block: B:154:0x03a8  */
    /* JADX WARN: Code duplicated, block: B:155:0x03b5  */
    /* JADX WARN: Code duplicated, block: B:157:0x03bf  */
    /* JADX WARN: Code duplicated, block: B:158:0x03cc  */
    /* JADX WARN: Code duplicated, block: B:160:0x03d7  */
    /* JADX WARN: Code duplicated, block: B:161:0x03e7  */
    /* JADX WARN: Code duplicated, block: B:163:0x03f1  */
    /* JADX WARN: Code duplicated, block: B:165:0x03f7  */
    /* JADX WARN: Code duplicated, block: B:168:0x0401  */
    /* JADX WARN: Code duplicated, block: B:170:0x040b  */
    /* JADX WARN: Code duplicated, block: B:172:0x0411  */
    /* JADX WARN: Code duplicated, block: B:175:0x041b  */
    /* JADX WARN: Code duplicated, block: B:177:0x0425  */
    /* JADX WARN: Code duplicated, block: B:179:0x042b  */
    /* JADX WARN: Code duplicated, block: B:193:0x04e0  */
    /* JADX WARN: Code duplicated, block: B:195:0x04ec  */
    /* JADX WARN: Code duplicated, block: B:197:0x04f6  */
    /* JADX WARN: Code duplicated, block: B:199:0x0507  */
    /* JADX WARN: Code duplicated, block: B:204:0x0517  */
    /* JADX WARN: Code duplicated, block: B:206:0x0521  */
    /* JADX WARN: Code duplicated, block: B:211:0x052e  */
    /* JADX WARN: Code duplicated, block: B:213:0x053a  */
    /* JADX WARN: Code duplicated, block: B:214:0x0546  */
    /* JADX WARN: Code duplicated, block: B:216:0x0552  */
    /* JADX WARN: Code duplicated, block: B:217:0x0562  */
    /* JADX WARN: Code duplicated, block: B:219:0x056e  */
    /* JADX WARN: Code duplicated, block: B:220:0x0580  */
    /* JADX WARN: Code duplicated, block: B:222:0x058c  */
    /* JADX WARN: Code duplicated, block: B:223:0x059a  */
    /* JADX WARN: Code duplicated, block: B:225:0x05a6  */
    /* JADX WARN: Code duplicated, block: B:226:0x05b3  */
    /* JADX WARN: Code duplicated, block: B:228:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:229:0x05c9  */
    /* JADX WARN: Code duplicated, block: B:231:0x05d4  */
    /* JADX WARN: Code duplicated, block: B:232:0x05e3  */
    /* JADX WARN: Code duplicated, block: B:234:0x05ed  */
    /* JADX WARN: Code duplicated, block: B:236:0x05f3  */
    /* JADX WARN: Code duplicated, block: B:239:0x05fc  */
    /* JADX WARN: Code duplicated, block: B:241:0x0606  */
    /* JADX WARN: Code duplicated, block: B:243:0x060c  */
    /* JADX WARN: Code duplicated, block: B:246:0x0615  */
    /* JADX WARN: Code duplicated, block: B:248:0x061f  */
    /* JADX WARN: Code duplicated, block: B:250:0x0625  */
    /* JADX WARN: Code duplicated, block: B:253:0x062f  */
    /* JADX WARN: Code duplicated, block: B:255:0x0640  */
    /* JADX WARN: Code duplicated, block: B:260:0x064f  */
    /* JADX WARN: Code duplicated, block: B:262:0x0659  */
    /* JADX WARN: Code duplicated, block: B:267:0x0666  */
    /* JADX WARN: Code duplicated, block: B:269:0x0672  */
    /* JADX WARN: Code duplicated, block: B:270:0x067e  */
    /* JADX WARN: Code duplicated, block: B:272:0x068a  */
    /* JADX WARN: Code duplicated, block: B:273:0x069a  */
    /* JADX WARN: Code duplicated, block: B:275:0x06a7  */
    /* JADX WARN: Code duplicated, block: B:276:0x06b9  */
    /* JADX WARN: Code duplicated, block: B:278:0x06c5  */
    /* JADX WARN: Code duplicated, block: B:279:0x06d3  */
    /* JADX WARN: Code duplicated, block: B:281:0x06df  */
    /* JADX WARN: Code duplicated, block: B:282:0x06ec  */
    /* JADX WARN: Code duplicated, block: B:284:0x06f6  */
    /* JADX WARN: Code duplicated, block: B:285:0x0703  */
    /* JADX WARN: Code duplicated, block: B:287:0x070e  */
    /* JADX WARN: Code duplicated, block: B:288:0x071d  */
    /* JADX WARN: Code duplicated, block: B:290:0x0727  */
    /* JADX WARN: Code duplicated, block: B:292:0x072d  */
    /* JADX WARN: Code duplicated, block: B:295:0x0736  */
    /* JADX WARN: Code duplicated, block: B:297:0x0740  */
    /* JADX WARN: Code duplicated, block: B:299:0x0746  */
    /* JADX WARN: Code duplicated, block: B:302:0x074f  */
    /* JADX WARN: Code duplicated, block: B:304:0x0759  */
    /* JADX WARN: Code duplicated, block: B:306:0x075f  */
    /* JADX WARN: Code duplicated, block: B:309:0x0769  */
    /* JADX WARN: Code duplicated, block: B:311:0x0784  */
    /* JADX WARN: Code duplicated, block: B:313:0x078a  */
    /* JADX WARN: Code duplicated, block: B:317:0x0797  */
    /* JADX WARN: Code duplicated, block: B:319:0x07a1  */
    /* JADX WARN: Code duplicated, block: B:321:0x07a7  */
    /* JADX WARN: Code duplicated, block: B:324:0x07b0  */
    /* JADX WARN: Code duplicated, block: B:326:0x07bc  */
    /* JADX WARN: Code duplicated, block: B:327:0x07c6  */
    /* JADX WARN: Code duplicated, block: B:329:0x07d2  */
    /* JADX WARN: Code duplicated, block: B:330:0x07e3  */
    /* JADX WARN: Code duplicated, block: B:332:0x07f0  */
    /* JADX WARN: Code duplicated, block: B:333:0x0802  */
    /* JADX WARN: Code duplicated, block: B:335:0x080e  */
    /* JADX WARN: Code duplicated, block: B:336:0x081c  */
    /* JADX WARN: Code duplicated, block: B:338:0x0828  */
    /* JADX WARN: Code duplicated, block: B:339:0x0835  */
    /* JADX WARN: Code duplicated, block: B:341:0x083f  */
    /* JADX WARN: Code duplicated, block: B:342:0x084b  */
    /* JADX WARN: Code duplicated, block: B:344:0x0856  */
    /* JADX WARN: Code duplicated, block: B:345:0x0865  */
    /* JADX WARN: Code duplicated, block: B:347:0x086f  */
    /* JADX WARN: Code duplicated, block: B:349:0x0875  */
    /* JADX WARN: Code duplicated, block: B:352:0x087e  */
    /* JADX WARN: Code duplicated, block: B:354:0x0888  */
    /* JADX WARN: Code duplicated, block: B:356:0x088e  */
    /* JADX WARN: Code duplicated, block: B:359:0x0897  */
    /* JADX WARN: Code duplicated, block: B:361:0x08a1  */
    /* JADX WARN: Code duplicated, block: B:363:0x08a7  */
    /* JADX WARN: Code duplicated, block: B:366:0x08b5  */
    /* JADX WARN: Code duplicated, block: B:368:0x08c6  */
    /* JADX WARN: Code duplicated, block: B:373:0x08d4  */
    /* JADX WARN: Code duplicated, block: B:375:0x08de  */
    /* JADX WARN: Code duplicated, block: B:380:0x08ec  */
    /* JADX WARN: Code duplicated, block: B:382:0x08f8  */
    /* JADX WARN: Code duplicated, block: B:383:0x0905  */
    /* JADX WARN: Code duplicated, block: B:385:0x0911  */
    /* JADX WARN: Code duplicated, block: B:386:0x091f  */
    /* JADX WARN: Code duplicated, block: B:388:0x0929  */
    /* JADX WARN: Code duplicated, block: B:389:0x093b  */
    /* JADX WARN: Code duplicated, block: B:391:0x0947  */
    /* JADX WARN: Code duplicated, block: B:392:0x0955  */
    /* JADX WARN: Code duplicated, block: B:394:0x0961  */
    /* JADX WARN: Code duplicated, block: B:395:0x096e  */
    /* JADX WARN: Code duplicated, block: B:397:0x0978  */
    /* JADX WARN: Code duplicated, block: B:398:0x0984  */
    /* JADX WARN: Code duplicated, block: B:400:0x098f  */
    /* JADX WARN: Code duplicated, block: B:401:0x099e  */
    /* JADX WARN: Code duplicated, block: B:403:0x09a8  */
    /* JADX WARN: Code duplicated, block: B:405:0x09ae  */
    /* JADX WARN: Code duplicated, block: B:408:0x09b7  */
    /* JADX WARN: Code duplicated, block: B:410:0x09c1  */
    /* JADX WARN: Code duplicated, block: B:412:0x09c7  */
    /* JADX WARN: Code duplicated, block: B:415:0x09d0  */
    /* JADX WARN: Code duplicated, block: B:417:0x09da  */
    /* JADX WARN: Code duplicated, block: B:419:0x09e0  */
    /* JADX WARN: Code duplicated, block: B:445:0x0b0e  */
    /* JADX WARN: Code duplicated, block: B:448:0x0b2c  */
    /* JADX WARN: Code duplicated, block: B:466:0x04c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:467:0x01d2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:468:0x01e9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:469:0x02c0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:470:0x02db A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:471:0x04a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:472:0x049c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:473:0x0482 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:474:0x0319 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:475:0x0330 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:476:0x03fb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:477:0x0415 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:478:0x045e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:479:0x0458 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:480:0x0af3 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:481:0x0511 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:482:0x0528 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:483:0x05f6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:484:0x060f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:485:0x0acd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:486:0x0ac7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:487:0x0aab A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:488:0x0649 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:489:0x0660 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:490:0x0730 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:491:0x0749 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:492:0x0a83 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:493:0x0a7d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:494:0x0a61 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:495:0x0791 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:496:0x07aa A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:497:0x0878 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:498:0x0891 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:499:0x0a39 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:500:0x0a33 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:501:0x0a17 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:502:0x08ce A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:503:0x08e6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:504:0x09b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:505:0x09ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:506:0x09f1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:507:0x09eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:509:0x0b2f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:69:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:71:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:77:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:79:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:84:0x01ef  */
    /* JADX WARN: Code duplicated, block: B:86:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:87:0x0207  */
    /* JADX WARN: Code duplicated, block: B:89:0x0213  */
    /* JADX WARN: Code duplicated, block: B:90:0x0223  */
    /* JADX WARN: Code duplicated, block: B:92:0x0230  */
    /* JADX WARN: Code duplicated, block: B:93:0x0242  */
    /* JADX WARN: Code duplicated, block: B:95:0x024e  */
    /* JADX WARN: Code duplicated, block: B:96:0x025d  */
    /* JADX WARN: Code duplicated, block: B:98:0x0269  */
    /* JADX WARN: Code duplicated, block: B:99:0x0277  */
    /* JADX WARN: Instruction removed from duplicated block: B:445:0x0b0e, please report this as an issue */
    private final List parseChannels(String responseBody) throws JsonException {
        String str;
        String strOptString;
        ArrayList arrayList;
        Iterator it;
        ArrayList arrayList2;
        Object sms;
        JsonValue jsonValue;
        KClass orCreateKotlinClass;
        Object jsonValue2;
        String strOptString2;
        Object objOptMap;
        Object objOptList;
        JsonValue jsonValue3;
        KClass orCreateKotlinClass2;
        String str2;
        Object jsonValue4;
        String strOptString3;
        Object objOptMap2;
        Object objOptList2;
        JsonValue jsonValue5;
        KClass orCreateKotlinClass3;
        String str3;
        String str4;
        String str5;
        Object jsonValue6;
        Boolean boolValueOf;
        Object objOptMap3;
        Object objOptList3;
        Object objOptString;
        boolean zBooleanValue;
        JsonValue jsonValue7;
        KClass orCreateKotlinClass4;
        Object jsonValue8;
        String strOptString4;
        Object objOptMap4;
        Object objOptList4;
        Object objOptString2;
        JsonValue jsonValue9;
        KClass orCreateKotlinClass5;
        ArrayList arrayList3;
        Object jsonValue10;
        String strOptString5;
        Object objOptMap5;
        Object objOptList5;
        String str6;
        JsonValue jsonValue11;
        KClass orCreateKotlinClass6;
        Object jsonValue12;
        String strOptString6;
        Object objOptMap6;
        Object objOptList6;
        JsonList jsonListRequireList = JsonValue.parseString(responseBody).requireMap().require("channels").requireList();
        Intrinsics.checkNotNullExpressionValue(jsonListRequireList, "requireList(...)");
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
        Iterator<JsonValue> it2 = jsonListRequireList.iterator();
        while (it2.hasNext()) {
            arrayList4.add(it2.next().requireMap());
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            JsonMap jsonMap = (JsonMap) it3.next();
            Intrinsics.checkNotNull(jsonMap);
            JsonValue jsonValue13 = jsonMap.get("type");
            if (jsonValue13 == null) {
                throw new JsonException("Missing required field: 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
            }
            Intrinsics.checkNotNull(jsonValue13);
            KClass orCreateKotlinClass7 = Reflection.getOrCreateKotlinClass(String.class);
            if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(String.class))) {
                strOptString = jsonValue13.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                strOptString = jsonValue13.optString();
                if (strOptString == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            } else {
                if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString = (String) Boolean.valueOf(jsonValue13.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    str = "null cannot be cast to non-null type kotlin.String";
                    strOptString = (String) Long.valueOf(jsonValue13.getLong(0L));
                } else {
                    str = "null cannot be cast to non-null type kotlin.String";
                    if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue13.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString = (String) Double.valueOf(jsonValue13.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString = (String) Float.valueOf(jsonValue13.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString = (String) Integer.valueOf(jsonValue13.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue13.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        Object objOptList7 = jsonValue13.optList();
                        if (objOptList7 == null) {
                            throw new NullPointerException(str);
                        }
                        strOptString = (String) objOptList7;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        Object objOptMap7 = jsonValue13.optMap();
                        if (objOptMap7 == null) {
                            throw new NullPointerException(str);
                        }
                        strOptString = (String) objOptMap7;
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass7, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'type" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Object jsonValue14 = jsonValue13.getJsonValue();
                        if (jsonValue14 == null) {
                            throw new NullPointerException(str);
                        }
                        strOptString = (String) jsonValue14;
                    }
                }
                if (Intrinsics.areEqual(strOptString, "email")) {
                    jsonValue9 = jsonMap.get("channel_id");
                    if (jsonValue9 != null) {
                        throw new JsonException("Missing required field: 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue9);
                    orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString5 = jsonValue9.optString();
                        if (strOptString5 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString5 = jsonValue9.optString();
                        if (strOptString5 == null) {
                            throw new NullPointerException(str);
                        }
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString5 = (String) Boolean.valueOf(jsonValue9.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            arrayList3 = arrayList5;
                            it = it3;
                            strOptString5 = (String) Long.valueOf(jsonValue9.getLong(0L));
                        } else {
                            arrayList3 = arrayList5;
                            it = it3;
                            if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString5 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue9.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString5 = (String) Double.valueOf(jsonValue9.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString5 = (String) Float.valueOf(jsonValue9.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString5 = (String) Integer.valueOf(jsonValue9.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString5 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue9.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList5 = jsonValue9.optList();
                                if (objOptList5 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString5 = (String) objOptList5;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap5 = jsonValue9.optMap();
                                if (objOptMap5 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString5 = (String) objOptMap5;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue10 = jsonValue9.getJsonValue();
                                if (jsonValue10 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString5 = (String) jsonValue10;
                            }
                        }
                        str6 = strOptString5;
                        jsonValue11 = jsonMap.get("email_address");
                        if (jsonValue11 != null) {
                            throw new JsonException("Missing required field: 'email_address" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue11);
                        orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                            strOptString6 = jsonValue11.optString();
                            if (strOptString6 == null) {
                                throw new NullPointerException(str);
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString6 = jsonValue11.optString();
                            if (strOptString6 == null) {
                                throw new NullPointerException(str);
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString6 = (String) Boolean.valueOf(jsonValue11.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString6 = (String) Long.valueOf(jsonValue11.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString6 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue11.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString6 = (String) Double.valueOf(jsonValue11.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString6 = (String) Float.valueOf(jsonValue11.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString6 = (String) Integer.valueOf(jsonValue11.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString6 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue11.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList6 = jsonValue11.optList();
                            if (objOptList6 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString6 = (String) objOptList6;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap6 = jsonValue11.optMap();
                            if (objOptMap6 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString6 = (String) objOptMap6;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'email_address" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue12 = jsonValue11.getJsonValue();
                            if (jsonValue12 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString6 = (String) jsonValue12;
                        }
                        arrayList2 = arrayList3;
                        sms = new ContactChannel.Email(new ContactChannel.Email.RegistrationInfo.Registered(str6, strOptString6, JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "transactional_opted_in", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "transactional_opted_out", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "commercial_opted_in", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "commercial_opted_out", null, 2, null)));
                    }
                    arrayList3 = arrayList5;
                    it = it3;
                    str6 = strOptString5;
                    jsonValue11 = jsonMap.get("email_address");
                    if (jsonValue11 != null) {
                        throw new JsonException("Missing required field: 'email_address" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue11);
                    orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString6 = jsonValue11.optString();
                        if (strOptString6 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString6 = jsonValue11.optString();
                        if (strOptString6 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString6 = (String) Boolean.valueOf(jsonValue11.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString6 = (String) Long.valueOf(jsonValue11.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString6 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue11.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString6 = (String) Double.valueOf(jsonValue11.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString6 = (String) Float.valueOf(jsonValue11.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString6 = (String) Integer.valueOf(jsonValue11.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString6 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue11.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList6 = jsonValue11.optList();
                        if (objOptList6 != null) {
                            throw new NullPointerException(str);
                        }
                        strOptString6 = (String) objOptList6;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap6 = jsonValue11.optMap();
                        if (objOptMap6 != null) {
                            throw new NullPointerException(str);
                        }
                        strOptString6 = (String) objOptMap6;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'email_address" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue12 = jsonValue11.getJsonValue();
                        if (jsonValue12 != null) {
                            throw new NullPointerException(str);
                        }
                        strOptString6 = (String) jsonValue12;
                    }
                    arrayList2 = arrayList3;
                    sms = new ContactChannel.Email(new ContactChannel.Email.RegistrationInfo.Registered(str6, strOptString6, JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "transactional_opted_in", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "transactional_opted_out", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "commercial_opted_in", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "commercial_opted_out", null, 2, null)));
                } else {
                    arrayList = arrayList5;
                    it = it3;
                    if (Intrinsics.areEqual(strOptString, "sms")) {
                        jsonValue = jsonMap.get("channel_id");
                        if (jsonValue != null) {
                            throw new JsonException("Missing required field: 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue);
                        orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                            strOptString2 = jsonValue.optString();
                            if (strOptString2 == null) {
                                throw new NullPointerException(str);
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString2 = jsonValue.optString();
                            if (strOptString2 == null) {
                                throw new NullPointerException(str);
                            }
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString2 = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                arrayList2 = arrayList;
                                strOptString2 = (String) Long.valueOf(jsonValue.getLong(0L));
                            } else {
                                arrayList2 = arrayList;
                                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString2 = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    strOptString2 = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString2 = (String) Integer.valueOf(jsonValue.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList = jsonValue.optList();
                                    if (objOptList != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString2 = (String) objOptList;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap = jsonValue.optMap();
                                    if (objOptMap != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString2 = (String) objOptMap;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue2 = jsonValue.getJsonValue();
                                    if (jsonValue2 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString2 = (String) jsonValue2;
                                }
                            }
                            jsonValue3 = jsonMap.get("msisdn");
                            if (jsonValue3 != null) {
                                throw new JsonException("Missing required field: 'msisdn" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue3);
                            orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString3 = jsonValue3.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException(str);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString3 = jsonValue3.optString();
                                if (strOptString3 == null) {
                                    throw new NullPointerException(str);
                                }
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                    strOptString3 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    str2 = "Missing required field: '";
                                    strOptString3 = (String) Long.valueOf(jsonValue3.getLong(0L));
                                } else {
                                    str2 = "Missing required field: '";
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                        strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        strOptString3 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                        strOptString3 = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                        strOptString3 = (String) Integer.valueOf(jsonValue3.getInt(0));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                        strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                        objOptList2 = jsonValue3.optList();
                                        if (objOptList2 != null) {
                                            throw new NullPointerException(str);
                                        }
                                        strOptString3 = (String) objOptList2;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                        objOptMap2 = jsonValue3.optMap();
                                        if (objOptMap2 != null) {
                                            throw new NullPointerException(str);
                                        }
                                        strOptString3 = (String) objOptMap2;
                                    } else {
                                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'msisdn" + CoreConstants.SINGLE_QUOTE_CHAR);
                                        }
                                        jsonValue4 = jsonValue3.getJsonValue();
                                        if (jsonValue4 != null) {
                                            throw new NullPointerException(str);
                                        }
                                        strOptString3 = (String) jsonValue4;
                                    }
                                }
                                jsonValue5 = jsonMap.get("opt_in");
                                if (jsonValue5 != null) {
                                    throw new JsonException(str2 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                Intrinsics.checkNotNull(jsonValue5);
                                orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
                                str3 = str2;
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                    objOptString2 = jsonValue5.optString();
                                    if (objOptString2 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    boolValueOf = (Boolean) objOptString2;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                    objOptString = jsonValue5.optString();
                                    if (objOptString != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    boolValueOf = (Boolean) objOptString;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        boolValueOf = Boolean.valueOf(jsonValue5.getBoolean(false));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        str4 = "' for field '";
                                        str5 = "Invalid type '";
                                        boolValueOf = (Boolean) Long.valueOf(jsonValue5.getLong(0L));
                                    } else {
                                        str4 = "' for field '";
                                        str5 = "Invalid type '";
                                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                            boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                            boolValueOf = (Boolean) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                            boolValueOf = (Boolean) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                            boolValueOf = (Boolean) Integer.valueOf(jsonValue5.getInt(0));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                            boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                            objOptList3 = jsonValue5.optList();
                                            if (objOptList3 != null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                            }
                                            boolValueOf = (Boolean) objOptList3;
                                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                            objOptMap3 = jsonValue5.optMap();
                                            if (objOptMap3 != null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                            }
                                            boolValueOf = (Boolean) objOptMap3;
                                        } else {
                                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                                throw new JsonException(str5 + Boolean.class.getSimpleName() + str4 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                                            }
                                            jsonValue6 = jsonValue5.getJsonValue();
                                            if (jsonValue6 != null) {
                                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                            }
                                            boolValueOf = (Boolean) jsonValue6;
                                        }
                                    }
                                    zBooleanValue = boolValueOf.booleanValue();
                                    jsonValue7 = jsonMap.get("sender");
                                    if (jsonValue7 != null) {
                                        throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    Intrinsics.checkNotNull(jsonValue7);
                                    orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                        strOptString4 = jsonValue7.optString();
                                        if (strOptString4 == null) {
                                            throw new NullPointerException(str);
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                        strOptString4 = jsonValue7.optString();
                                        if (strOptString4 == null) {
                                            throw new NullPointerException(str);
                                        }
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                        strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                        strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                        strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                        strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                        strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                        strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                        objOptList4 = jsonValue7.optList();
                                        if (objOptList4 != null) {
                                            throw new NullPointerException(str);
                                        }
                                        strOptString4 = (String) objOptList4;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                        objOptMap4 = jsonValue7.optMap();
                                        if (objOptMap4 != null) {
                                            throw new NullPointerException(str);
                                        }
                                        strOptString4 = (String) objOptMap4;
                                    } else {
                                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                            throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                        }
                                        jsonValue8 = jsonValue7.getJsonValue();
                                        if (jsonValue8 != null) {
                                            throw new NullPointerException(str);
                                        }
                                        strOptString4 = (String) jsonValue8;
                                    }
                                    sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                                }
                                str4 = "' for field '";
                                str5 = "Invalid type '";
                                zBooleanValue = boolValueOf.booleanValue();
                                jsonValue7 = jsonMap.get("sender");
                                if (jsonValue7 != null) {
                                    throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                Intrinsics.checkNotNull(jsonValue7);
                                orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                    strOptString4 = jsonValue7.optString();
                                    if (strOptString4 == null) {
                                        throw new NullPointerException(str);
                                    }
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                    strOptString4 = jsonValue7.optString();
                                    if (strOptString4 == null) {
                                        throw new NullPointerException(str);
                                    }
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                    strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList4 = jsonValue7.optList();
                                    if (objOptList4 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString4 = (String) objOptList4;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap4 = jsonValue7.optMap();
                                    if (objOptMap4 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString4 = (String) objOptMap4;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue8 = jsonValue7.getJsonValue();
                                    if (jsonValue8 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString4 = (String) jsonValue8;
                                }
                                sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                            }
                            str2 = "Missing required field: '";
                            jsonValue5 = jsonMap.get("opt_in");
                            if (jsonValue5 != null) {
                                throw new JsonException(str2 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue5);
                            orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
                            str3 = str2;
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                objOptString2 = jsonValue5.optString();
                                if (objOptString2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolValueOf = (Boolean) objOptString2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                objOptString = jsonValue5.optString();
                                if (objOptString != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolValueOf = (Boolean) objOptString;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                    boolValueOf = Boolean.valueOf(jsonValue5.getBoolean(false));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    str4 = "' for field '";
                                    str5 = "Invalid type '";
                                    boolValueOf = (Boolean) Long.valueOf(jsonValue5.getLong(0L));
                                } else {
                                    str4 = "' for field '";
                                    str5 = "Invalid type '";
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                        boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        boolValueOf = (Boolean) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                        boolValueOf = (Boolean) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                        boolValueOf = (Boolean) Integer.valueOf(jsonValue5.getInt(0));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                        boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                        objOptList3 = jsonValue5.optList();
                                        if (objOptList3 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                        }
                                        boolValueOf = (Boolean) objOptList3;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                        objOptMap3 = jsonValue5.optMap();
                                        if (objOptMap3 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                        }
                                        boolValueOf = (Boolean) objOptMap3;
                                    } else {
                                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                            throw new JsonException(str5 + Boolean.class.getSimpleName() + str4 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                                        }
                                        jsonValue6 = jsonValue5.getJsonValue();
                                        if (jsonValue6 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                        }
                                        boolValueOf = (Boolean) jsonValue6;
                                    }
                                }
                                zBooleanValue = boolValueOf.booleanValue();
                                jsonValue7 = jsonMap.get("sender");
                                if (jsonValue7 != null) {
                                    throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                Intrinsics.checkNotNull(jsonValue7);
                                orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                    strOptString4 = jsonValue7.optString();
                                    if (strOptString4 == null) {
                                        throw new NullPointerException(str);
                                    }
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                    strOptString4 = jsonValue7.optString();
                                    if (strOptString4 == null) {
                                        throw new NullPointerException(str);
                                    }
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                    strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList4 = jsonValue7.optList();
                                    if (objOptList4 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString4 = (String) objOptList4;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap4 = jsonValue7.optMap();
                                    if (objOptMap4 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString4 = (String) objOptMap4;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue8 = jsonValue7.getJsonValue();
                                    if (jsonValue8 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString4 = (String) jsonValue8;
                                }
                                sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                            }
                            str4 = "' for field '";
                            str5 = "Invalid type '";
                            zBooleanValue = boolValueOf.booleanValue();
                            jsonValue7 = jsonMap.get("sender");
                            if (jsonValue7 != null) {
                                throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue7);
                            orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString4 = jsonValue7.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString4 = jsonValue7.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList4 = jsonValue7.optList();
                                if (objOptList4 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) objOptList4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap4 = jsonValue7.optMap();
                                if (objOptMap4 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) objOptMap4;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue8 = jsonValue7.getJsonValue();
                                if (jsonValue8 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) jsonValue8;
                            }
                            sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                        }
                        arrayList2 = arrayList;
                        jsonValue3 = jsonMap.get("msisdn");
                        if (jsonValue3 != null) {
                            throw new JsonException("Missing required field: 'msisdn" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue3);
                        orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                            strOptString3 = jsonValue3.optString();
                            if (strOptString3 == null) {
                                throw new NullPointerException(str);
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString3 = jsonValue3.optString();
                            if (strOptString3 == null) {
                                throw new NullPointerException(str);
                            }
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString3 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                str2 = "Missing required field: '";
                                strOptString3 = (String) Long.valueOf(jsonValue3.getLong(0L));
                            } else {
                                str2 = "Missing required field: '";
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString3 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    strOptString3 = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString3 = (String) Integer.valueOf(jsonValue3.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList2 = jsonValue3.optList();
                                    if (objOptList2 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString3 = (String) objOptList2;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap2 = jsonValue3.optMap();
                                    if (objOptMap2 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString3 = (String) objOptMap2;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'msisdn" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue4 = jsonValue3.getJsonValue();
                                    if (jsonValue4 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString3 = (String) jsonValue4;
                                }
                            }
                            jsonValue5 = jsonMap.get("opt_in");
                            if (jsonValue5 != null) {
                                throw new JsonException(str2 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue5);
                            orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
                            str3 = str2;
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                objOptString2 = jsonValue5.optString();
                                if (objOptString2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolValueOf = (Boolean) objOptString2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                objOptString = jsonValue5.optString();
                                if (objOptString != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolValueOf = (Boolean) objOptString;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                    boolValueOf = Boolean.valueOf(jsonValue5.getBoolean(false));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    str4 = "' for field '";
                                    str5 = "Invalid type '";
                                    boolValueOf = (Boolean) Long.valueOf(jsonValue5.getLong(0L));
                                } else {
                                    str4 = "' for field '";
                                    str5 = "Invalid type '";
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                        boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        boolValueOf = (Boolean) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                        boolValueOf = (Boolean) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                        boolValueOf = (Boolean) Integer.valueOf(jsonValue5.getInt(0));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                        boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                        objOptList3 = jsonValue5.optList();
                                        if (objOptList3 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                        }
                                        boolValueOf = (Boolean) objOptList3;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                        objOptMap3 = jsonValue5.optMap();
                                        if (objOptMap3 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                        }
                                        boolValueOf = (Boolean) objOptMap3;
                                    } else {
                                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                            throw new JsonException(str5 + Boolean.class.getSimpleName() + str4 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                                        }
                                        jsonValue6 = jsonValue5.getJsonValue();
                                        if (jsonValue6 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                        }
                                        boolValueOf = (Boolean) jsonValue6;
                                    }
                                }
                                zBooleanValue = boolValueOf.booleanValue();
                                jsonValue7 = jsonMap.get("sender");
                                if (jsonValue7 != null) {
                                    throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                Intrinsics.checkNotNull(jsonValue7);
                                orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                    strOptString4 = jsonValue7.optString();
                                    if (strOptString4 == null) {
                                        throw new NullPointerException(str);
                                    }
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                    strOptString4 = jsonValue7.optString();
                                    if (strOptString4 == null) {
                                        throw new NullPointerException(str);
                                    }
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                    strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList4 = jsonValue7.optList();
                                    if (objOptList4 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString4 = (String) objOptList4;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap4 = jsonValue7.optMap();
                                    if (objOptMap4 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString4 = (String) objOptMap4;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue8 = jsonValue7.getJsonValue();
                                    if (jsonValue8 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString4 = (String) jsonValue8;
                                }
                                sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                            }
                            str4 = "' for field '";
                            str5 = "Invalid type '";
                            zBooleanValue = boolValueOf.booleanValue();
                            jsonValue7 = jsonMap.get("sender");
                            if (jsonValue7 != null) {
                                throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue7);
                            orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString4 = jsonValue7.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString4 = jsonValue7.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList4 = jsonValue7.optList();
                                if (objOptList4 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) objOptList4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap4 = jsonValue7.optMap();
                                if (objOptMap4 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) objOptMap4;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue8 = jsonValue7.getJsonValue();
                                if (jsonValue8 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) jsonValue8;
                            }
                            sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                        }
                        str2 = "Missing required field: '";
                        jsonValue5 = jsonMap.get("opt_in");
                        if (jsonValue5 != null) {
                            throw new JsonException(str2 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue5);
                        orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
                        str3 = str2;
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                            objOptString2 = jsonValue5.optString();
                            if (objOptString2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) objOptString2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            objOptString = jsonValue5.optString();
                            if (objOptString != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) objOptString;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                boolValueOf = Boolean.valueOf(jsonValue5.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                str4 = "' for field '";
                                str5 = "Invalid type '";
                                boolValueOf = (Boolean) Long.valueOf(jsonValue5.getLong(0L));
                            } else {
                                str4 = "' for field '";
                                str5 = "Invalid type '";
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    boolValueOf = (Boolean) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    boolValueOf = (Boolean) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    boolValueOf = (Boolean) Integer.valueOf(jsonValue5.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList3 = jsonValue5.optList();
                                    if (objOptList3 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    boolValueOf = (Boolean) objOptList3;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap3 = jsonValue5.optMap();
                                    if (objOptMap3 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    boolValueOf = (Boolean) objOptMap3;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException(str5 + Boolean.class.getSimpleName() + str4 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue6 = jsonValue5.getJsonValue();
                                    if (jsonValue6 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    boolValueOf = (Boolean) jsonValue6;
                                }
                            }
                            zBooleanValue = boolValueOf.booleanValue();
                            jsonValue7 = jsonMap.get("sender");
                            if (jsonValue7 != null) {
                                throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue7);
                            orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString4 = jsonValue7.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString4 = jsonValue7.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList4 = jsonValue7.optList();
                                if (objOptList4 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) objOptList4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap4 = jsonValue7.optMap();
                                if (objOptMap4 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) objOptMap4;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue8 = jsonValue7.getJsonValue();
                                if (jsonValue8 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) jsonValue8;
                            }
                            sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                        }
                        str4 = "' for field '";
                        str5 = "Invalid type '";
                        zBooleanValue = boolValueOf.booleanValue();
                        jsonValue7 = jsonMap.get("sender");
                        if (jsonValue7 != null) {
                            throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue7);
                        orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                            strOptString4 = jsonValue7.optString();
                            if (strOptString4 == null) {
                                throw new NullPointerException(str);
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString4 = jsonValue7.optString();
                            if (strOptString4 == null) {
                                throw new NullPointerException(str);
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList4 = jsonValue7.optList();
                            if (objOptList4 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString4 = (String) objOptList4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap4 = jsonValue7.optMap();
                            if (objOptMap4 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString4 = (String) objOptMap4;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue8 = jsonValue7.getJsonValue();
                            if (jsonValue8 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString4 = (String) jsonValue8;
                        }
                        sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                    } else {
                        arrayList2 = arrayList;
                        UALog.m1754w("Unrecognized contact channel type " + strOptString, new Object[0]);
                        sms = null;
                    }
                }
                arrayList5 = arrayList2;
                if (sms != null) {
                    arrayList5.add(sms);
                }
                it3 = it;
            }
            str = "null cannot be cast to non-null type kotlin.String";
            if (Intrinsics.areEqual(strOptString, "email")) {
                jsonValue9 = jsonMap.get("channel_id");
                if (jsonValue9 != null) {
                    throw new JsonException("Missing required field: 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Intrinsics.checkNotNull(jsonValue9);
                orCreateKotlinClass5 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString5 = jsonValue9.optString();
                    if (strOptString5 == null) {
                        throw new NullPointerException(str);
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString5 = jsonValue9.optString();
                    if (strOptString5 == null) {
                        throw new NullPointerException(str);
                    }
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString5 = (String) Boolean.valueOf(jsonValue9.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        arrayList3 = arrayList5;
                        it = it3;
                        strOptString5 = (String) Long.valueOf(jsonValue9.getLong(0L));
                    } else {
                        arrayList3 = arrayList5;
                        it = it3;
                        if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString5 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue9.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString5 = (String) Double.valueOf(jsonValue9.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString5 = (String) Float.valueOf(jsonValue9.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString5 = (String) Integer.valueOf(jsonValue9.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString5 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue9.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList5 = jsonValue9.optList();
                            if (objOptList5 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString5 = (String) objOptList5;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap5 = jsonValue9.optMap();
                            if (objOptMap5 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString5 = (String) objOptMap5;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass5, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue10 = jsonValue9.getJsonValue();
                            if (jsonValue10 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString5 = (String) jsonValue10;
                        }
                    }
                    str6 = strOptString5;
                    jsonValue11 = jsonMap.get("email_address");
                    if (jsonValue11 != null) {
                        throw new JsonException("Missing required field: 'email_address" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue11);
                    orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString6 = jsonValue11.optString();
                        if (strOptString6 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString6 = jsonValue11.optString();
                        if (strOptString6 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString6 = (String) Boolean.valueOf(jsonValue11.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString6 = (String) Long.valueOf(jsonValue11.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString6 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue11.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString6 = (String) Double.valueOf(jsonValue11.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString6 = (String) Float.valueOf(jsonValue11.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString6 = (String) Integer.valueOf(jsonValue11.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString6 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue11.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList6 = jsonValue11.optList();
                        if (objOptList6 != null) {
                            throw new NullPointerException(str);
                        }
                        strOptString6 = (String) objOptList6;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap6 = jsonValue11.optMap();
                        if (objOptMap6 != null) {
                            throw new NullPointerException(str);
                        }
                        strOptString6 = (String) objOptMap6;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'email_address" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue12 = jsonValue11.getJsonValue();
                        if (jsonValue12 != null) {
                            throw new NullPointerException(str);
                        }
                        strOptString6 = (String) jsonValue12;
                    }
                    arrayList2 = arrayList3;
                    sms = new ContactChannel.Email(new ContactChannel.Email.RegistrationInfo.Registered(str6, strOptString6, JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "transactional_opted_in", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "transactional_opted_out", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "commercial_opted_in", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "commercial_opted_out", null, 2, null)));
                }
                arrayList3 = arrayList5;
                it = it3;
                str6 = strOptString5;
                jsonValue11 = jsonMap.get("email_address");
                if (jsonValue11 != null) {
                    throw new JsonException("Missing required field: 'email_address" + CoreConstants.SINGLE_QUOTE_CHAR);
                }
                Intrinsics.checkNotNull(jsonValue11);
                orCreateKotlinClass6 = Reflection.getOrCreateKotlinClass(String.class);
                if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(String.class))) {
                    strOptString6 = jsonValue11.optString();
                    if (strOptString6 == null) {
                        throw new NullPointerException(str);
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                    strOptString6 = jsonValue11.optString();
                    if (strOptString6 == null) {
                        throw new NullPointerException(str);
                    }
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                    strOptString6 = (String) Boolean.valueOf(jsonValue11.getBoolean(false));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                    strOptString6 = (String) Long.valueOf(jsonValue11.getLong(0L));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(ULong.class))) {
                    strOptString6 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue11.getLong(0L)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                    strOptString6 = (String) Double.valueOf(jsonValue11.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                    strOptString6 = (String) Float.valueOf(jsonValue11.getFloat(BitmapDescriptorFactory.HUE_RED));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(Integer.class))) {
                    strOptString6 = (String) Integer.valueOf(jsonValue11.getInt(0));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(UInt.class))) {
                    strOptString6 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue11.getInt(0)));
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                    objOptList6 = jsonValue11.optList();
                    if (objOptList6 != null) {
                        throw new NullPointerException(str);
                    }
                    strOptString6 = (String) objOptList6;
                } else if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                    objOptMap6 = jsonValue11.optMap();
                    if (objOptMap6 != null) {
                        throw new NullPointerException(str);
                    }
                    strOptString6 = (String) objOptMap6;
                } else {
                    if (Intrinsics.areEqual(orCreateKotlinClass6, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'email_address" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    jsonValue12 = jsonValue11.getJsonValue();
                    if (jsonValue12 != null) {
                        throw new NullPointerException(str);
                    }
                    strOptString6 = (String) jsonValue12;
                }
                arrayList2 = arrayList3;
                sms = new ContactChannel.Email(new ContactChannel.Email.RegistrationInfo.Registered(str6, strOptString6, JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "transactional_opted_in", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "transactional_opted_out", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "commercial_opted_in", null, 2, null), JsonExtensionsKt.isoDateAsMilliseconds$default(jsonMap, "commercial_opted_out", null, 2, null)));
            } else {
                arrayList = arrayList5;
                it = it3;
                if (Intrinsics.areEqual(strOptString, "sms")) {
                    jsonValue = jsonMap.get("channel_id");
                    if (jsonValue != null) {
                        throw new JsonException("Missing required field: 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue);
                    orCreateKotlinClass = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString2 = jsonValue.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString2 = jsonValue.optString();
                        if (strOptString2 == null) {
                            throw new NullPointerException(str);
                        }
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString2 = (String) Boolean.valueOf(jsonValue.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            arrayList2 = arrayList;
                            strOptString2 = (String) Long.valueOf(jsonValue.getLong(0L));
                        } else {
                            arrayList2 = arrayList;
                            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString2 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString2 = (String) Double.valueOf(jsonValue.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString2 = (String) Float.valueOf(jsonValue.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString2 = (String) Integer.valueOf(jsonValue.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString2 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList = jsonValue.optList();
                                if (objOptList != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString2 = (String) objOptList;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap = jsonValue.optMap();
                                if (objOptMap != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString2 = (String) objOptMap;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'channel_id" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue2 = jsonValue.getJsonValue();
                                if (jsonValue2 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString2 = (String) jsonValue2;
                            }
                        }
                        jsonValue3 = jsonMap.get("msisdn");
                        if (jsonValue3 != null) {
                            throw new JsonException("Missing required field: 'msisdn" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue3);
                        orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                            strOptString3 = jsonValue3.optString();
                            if (strOptString3 == null) {
                                throw new NullPointerException(str);
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString3 = jsonValue3.optString();
                            if (strOptString3 == null) {
                                throw new NullPointerException(str);
                            }
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString3 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                str2 = "Missing required field: '";
                                strOptString3 = (String) Long.valueOf(jsonValue3.getLong(0L));
                            } else {
                                str2 = "Missing required field: '";
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString3 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    strOptString3 = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString3 = (String) Integer.valueOf(jsonValue3.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList2 = jsonValue3.optList();
                                    if (objOptList2 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString3 = (String) objOptList2;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap2 = jsonValue3.optMap();
                                    if (objOptMap2 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString3 = (String) objOptMap2;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'msisdn" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue4 = jsonValue3.getJsonValue();
                                    if (jsonValue4 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString3 = (String) jsonValue4;
                                }
                            }
                            jsonValue5 = jsonMap.get("opt_in");
                            if (jsonValue5 != null) {
                                throw new JsonException(str2 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue5);
                            orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
                            str3 = str2;
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                                objOptString2 = jsonValue5.optString();
                                if (objOptString2 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolValueOf = (Boolean) objOptString2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                objOptString = jsonValue5.optString();
                                if (objOptString != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolValueOf = (Boolean) objOptString;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                    boolValueOf = Boolean.valueOf(jsonValue5.getBoolean(false));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    str4 = "' for field '";
                                    str5 = "Invalid type '";
                                    boolValueOf = (Boolean) Long.valueOf(jsonValue5.getLong(0L));
                                } else {
                                    str4 = "' for field '";
                                    str5 = "Invalid type '";
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                        boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                        boolValueOf = (Boolean) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                        boolValueOf = (Boolean) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                        boolValueOf = (Boolean) Integer.valueOf(jsonValue5.getInt(0));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                        boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                        objOptList3 = jsonValue5.optList();
                                        if (objOptList3 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                        }
                                        boolValueOf = (Boolean) objOptList3;
                                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                        objOptMap3 = jsonValue5.optMap();
                                        if (objOptMap3 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                        }
                                        boolValueOf = (Boolean) objOptMap3;
                                    } else {
                                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                            throw new JsonException(str5 + Boolean.class.getSimpleName() + str4 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                                        }
                                        jsonValue6 = jsonValue5.getJsonValue();
                                        if (jsonValue6 != null) {
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                        }
                                        boolValueOf = (Boolean) jsonValue6;
                                    }
                                }
                                zBooleanValue = boolValueOf.booleanValue();
                                jsonValue7 = jsonMap.get("sender");
                                if (jsonValue7 != null) {
                                    throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                Intrinsics.checkNotNull(jsonValue7);
                                orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                    strOptString4 = jsonValue7.optString();
                                    if (strOptString4 == null) {
                                        throw new NullPointerException(str);
                                    }
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                    strOptString4 = jsonValue7.optString();
                                    if (strOptString4 == null) {
                                        throw new NullPointerException(str);
                                    }
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                    strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                    strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList4 = jsonValue7.optList();
                                    if (objOptList4 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString4 = (String) objOptList4;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap4 = jsonValue7.optMap();
                                    if (objOptMap4 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString4 = (String) objOptMap4;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue8 = jsonValue7.getJsonValue();
                                    if (jsonValue8 != null) {
                                        throw new NullPointerException(str);
                                    }
                                    strOptString4 = (String) jsonValue8;
                                }
                                sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                            }
                            str4 = "' for field '";
                            str5 = "Invalid type '";
                            zBooleanValue = boolValueOf.booleanValue();
                            jsonValue7 = jsonMap.get("sender");
                            if (jsonValue7 != null) {
                                throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue7);
                            orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString4 = jsonValue7.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString4 = jsonValue7.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList4 = jsonValue7.optList();
                                if (objOptList4 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) objOptList4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap4 = jsonValue7.optMap();
                                if (objOptMap4 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) objOptMap4;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue8 = jsonValue7.getJsonValue();
                                if (jsonValue8 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) jsonValue8;
                            }
                            sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                        }
                        str2 = "Missing required field: '";
                        jsonValue5 = jsonMap.get("opt_in");
                        if (jsonValue5 != null) {
                            throw new JsonException(str2 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue5);
                        orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
                        str3 = str2;
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                            objOptString2 = jsonValue5.optString();
                            if (objOptString2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) objOptString2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            objOptString = jsonValue5.optString();
                            if (objOptString != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) objOptString;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                boolValueOf = Boolean.valueOf(jsonValue5.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                str4 = "' for field '";
                                str5 = "Invalid type '";
                                boolValueOf = (Boolean) Long.valueOf(jsonValue5.getLong(0L));
                            } else {
                                str4 = "' for field '";
                                str5 = "Invalid type '";
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    boolValueOf = (Boolean) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    boolValueOf = (Boolean) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    boolValueOf = (Boolean) Integer.valueOf(jsonValue5.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList3 = jsonValue5.optList();
                                    if (objOptList3 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    boolValueOf = (Boolean) objOptList3;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap3 = jsonValue5.optMap();
                                    if (objOptMap3 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    boolValueOf = (Boolean) objOptMap3;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException(str5 + Boolean.class.getSimpleName() + str4 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue6 = jsonValue5.getJsonValue();
                                    if (jsonValue6 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    boolValueOf = (Boolean) jsonValue6;
                                }
                            }
                            zBooleanValue = boolValueOf.booleanValue();
                            jsonValue7 = jsonMap.get("sender");
                            if (jsonValue7 != null) {
                                throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue7);
                            orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString4 = jsonValue7.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString4 = jsonValue7.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList4 = jsonValue7.optList();
                                if (objOptList4 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) objOptList4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap4 = jsonValue7.optMap();
                                if (objOptMap4 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) objOptMap4;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue8 = jsonValue7.getJsonValue();
                                if (jsonValue8 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) jsonValue8;
                            }
                            sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                        }
                        str4 = "' for field '";
                        str5 = "Invalid type '";
                        zBooleanValue = boolValueOf.booleanValue();
                        jsonValue7 = jsonMap.get("sender");
                        if (jsonValue7 != null) {
                            throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue7);
                        orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                            strOptString4 = jsonValue7.optString();
                            if (strOptString4 == null) {
                                throw new NullPointerException(str);
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString4 = jsonValue7.optString();
                            if (strOptString4 == null) {
                                throw new NullPointerException(str);
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList4 = jsonValue7.optList();
                            if (objOptList4 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString4 = (String) objOptList4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap4 = jsonValue7.optMap();
                            if (objOptMap4 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString4 = (String) objOptMap4;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue8 = jsonValue7.getJsonValue();
                            if (jsonValue8 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString4 = (String) jsonValue8;
                        }
                        sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                    }
                    arrayList2 = arrayList;
                    jsonValue3 = jsonMap.get("msisdn");
                    if (jsonValue3 != null) {
                        throw new JsonException("Missing required field: 'msisdn" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue3);
                    orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString3 = jsonValue3.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString3 = jsonValue3.optString();
                        if (strOptString3 == null) {
                            throw new NullPointerException(str);
                        }
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString3 = (String) Boolean.valueOf(jsonValue3.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            str2 = "Missing required field: '";
                            strOptString3 = (String) Long.valueOf(jsonValue3.getLong(0L));
                        } else {
                            str2 = "Missing required field: '";
                            if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString3 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue3.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString3 = (String) Double.valueOf(jsonValue3.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString3 = (String) Float.valueOf(jsonValue3.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString3 = (String) Integer.valueOf(jsonValue3.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString3 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue3.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList2 = jsonValue3.optList();
                                if (objOptList2 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString3 = (String) objOptList2;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap2 = jsonValue3.optMap();
                                if (objOptMap2 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString3 = (String) objOptMap2;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass2, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException("Invalid type '" + String.class.getSimpleName() + "' for field 'msisdn" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue4 = jsonValue3.getJsonValue();
                                if (jsonValue4 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString3 = (String) jsonValue4;
                            }
                        }
                        jsonValue5 = jsonMap.get("opt_in");
                        if (jsonValue5 != null) {
                            throw new JsonException(str2 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue5);
                        orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
                        str3 = str2;
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                            objOptString2 = jsonValue5.optString();
                            if (objOptString2 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) objOptString2;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            objOptString = jsonValue5.optString();
                            if (objOptString != null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                            }
                            boolValueOf = (Boolean) objOptString;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                boolValueOf = Boolean.valueOf(jsonValue5.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                str4 = "' for field '";
                                str5 = "Invalid type '";
                                boolValueOf = (Boolean) Long.valueOf(jsonValue5.getLong(0L));
                            } else {
                                str4 = "' for field '";
                                str5 = "Invalid type '";
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                    boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                    boolValueOf = (Boolean) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                    boolValueOf = (Boolean) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                    boolValueOf = (Boolean) Integer.valueOf(jsonValue5.getInt(0));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                    boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                    objOptList3 = jsonValue5.optList();
                                    if (objOptList3 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    boolValueOf = (Boolean) objOptList3;
                                } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                    objOptMap3 = jsonValue5.optMap();
                                    if (objOptMap3 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    boolValueOf = (Boolean) objOptMap3;
                                } else {
                                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                        throw new JsonException(str5 + Boolean.class.getSimpleName() + str4 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                                    }
                                    jsonValue6 = jsonValue5.getJsonValue();
                                    if (jsonValue6 != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                    }
                                    boolValueOf = (Boolean) jsonValue6;
                                }
                            }
                            zBooleanValue = boolValueOf.booleanValue();
                            jsonValue7 = jsonMap.get("sender");
                            if (jsonValue7 != null) {
                                throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            Intrinsics.checkNotNull(jsonValue7);
                            orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                                strOptString4 = jsonValue7.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                                strOptString4 = jsonValue7.optString();
                                if (strOptString4 == null) {
                                    throw new NullPointerException(str);
                                }
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                                strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                                strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList4 = jsonValue7.optList();
                                if (objOptList4 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) objOptList4;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap4 = jsonValue7.optMap();
                                if (objOptMap4 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) objOptMap4;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue8 = jsonValue7.getJsonValue();
                                if (jsonValue8 != null) {
                                    throw new NullPointerException(str);
                                }
                                strOptString4 = (String) jsonValue8;
                            }
                            sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                        }
                        str4 = "' for field '";
                        str5 = "Invalid type '";
                        zBooleanValue = boolValueOf.booleanValue();
                        jsonValue7 = jsonMap.get("sender");
                        if (jsonValue7 != null) {
                            throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue7);
                        orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                            strOptString4 = jsonValue7.optString();
                            if (strOptString4 == null) {
                                throw new NullPointerException(str);
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString4 = jsonValue7.optString();
                            if (strOptString4 == null) {
                                throw new NullPointerException(str);
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList4 = jsonValue7.optList();
                            if (objOptList4 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString4 = (String) objOptList4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap4 = jsonValue7.optMap();
                            if (objOptMap4 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString4 = (String) objOptMap4;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue8 = jsonValue7.getJsonValue();
                            if (jsonValue8 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString4 = (String) jsonValue8;
                        }
                        sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                    }
                    str2 = "Missing required field: '";
                    jsonValue5 = jsonMap.get("opt_in");
                    if (jsonValue5 != null) {
                        throw new JsonException(str2 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue5);
                    orCreateKotlinClass3 = Reflection.getOrCreateKotlinClass(Boolean.class);
                    str3 = str2;
                    if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(String.class))) {
                        objOptString2 = jsonValue5.optString();
                        if (objOptString2 != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        boolValueOf = (Boolean) objOptString2;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        objOptString = jsonValue5.optString();
                        if (objOptString != null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                        }
                        boolValueOf = (Boolean) objOptString;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            boolValueOf = Boolean.valueOf(jsonValue5.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            str4 = "' for field '";
                            str5 = "Invalid type '";
                            boolValueOf = (Boolean) Long.valueOf(jsonValue5.getLong(0L));
                        } else {
                            str4 = "' for field '";
                            str5 = "Invalid type '";
                            if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(ULong.class))) {
                                boolValueOf = (Boolean) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue5.getLong(0L)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                                boolValueOf = (Boolean) Double.valueOf(jsonValue5.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                                boolValueOf = (Boolean) Float.valueOf(jsonValue5.getFloat(BitmapDescriptorFactory.HUE_RED));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(Integer.class))) {
                                boolValueOf = (Boolean) Integer.valueOf(jsonValue5.getInt(0));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(UInt.class))) {
                                boolValueOf = (Boolean) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue5.getInt(0)));
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                                objOptList3 = jsonValue5.optList();
                                if (objOptList3 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolValueOf = (Boolean) objOptList3;
                            } else if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                                objOptMap3 = jsonValue5.optMap();
                                if (objOptMap3 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolValueOf = (Boolean) objOptMap3;
                            } else {
                                if (Intrinsics.areEqual(orCreateKotlinClass3, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                    throw new JsonException(str5 + Boolean.class.getSimpleName() + str4 + "opt_in" + CoreConstants.SINGLE_QUOTE_CHAR);
                                }
                                jsonValue6 = jsonValue5.getJsonValue();
                                if (jsonValue6 != null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
                                }
                                boolValueOf = (Boolean) jsonValue6;
                            }
                        }
                        zBooleanValue = boolValueOf.booleanValue();
                        jsonValue7 = jsonMap.get("sender");
                        if (jsonValue7 != null) {
                            throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        Intrinsics.checkNotNull(jsonValue7);
                        orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                            strOptString4 = jsonValue7.optString();
                            if (strOptString4 == null) {
                                throw new NullPointerException(str);
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                            strOptString4 = jsonValue7.optString();
                            if (strOptString4 == null) {
                                throw new NullPointerException(str);
                            }
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                            strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                            strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                            strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                            strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                            strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                            strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                            strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                            objOptList4 = jsonValue7.optList();
                            if (objOptList4 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString4 = (String) objOptList4;
                        } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                            objOptMap4 = jsonValue7.optMap();
                            if (objOptMap4 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString4 = (String) objOptMap4;
                        } else {
                            if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                                throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                            }
                            jsonValue8 = jsonValue7.getJsonValue();
                            if (jsonValue8 != null) {
                                throw new NullPointerException(str);
                            }
                            strOptString4 = (String) jsonValue8;
                        }
                        sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                    }
                    str4 = "' for field '";
                    str5 = "Invalid type '";
                    zBooleanValue = boolValueOf.booleanValue();
                    jsonValue7 = jsonMap.get("sender");
                    if (jsonValue7 != null) {
                        throw new JsonException(str3 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                    }
                    Intrinsics.checkNotNull(jsonValue7);
                    orCreateKotlinClass4 = Reflection.getOrCreateKotlinClass(String.class);
                    if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(String.class))) {
                        strOptString4 = jsonValue7.optString();
                        if (strOptString4 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(CharSequence.class))) {
                        strOptString4 = jsonValue7.optString();
                        if (strOptString4 == null) {
                            throw new NullPointerException(str);
                        }
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Boolean.TYPE))) {
                        strOptString4 = (String) Boolean.valueOf(jsonValue7.getBoolean(false));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Long.TYPE))) {
                        strOptString4 = (String) Long.valueOf(jsonValue7.getLong(0L));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(ULong.class))) {
                        strOptString4 = (String) ULong.m5336boximpl(ULong.m5337constructorimpl(jsonValue7.getLong(0L)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Double.TYPE))) {
                        strOptString4 = (String) Double.valueOf(jsonValue7.getDouble(AudioStats.AUDIO_AMPLITUDE_NONE));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Float.TYPE))) {
                        strOptString4 = (String) Float.valueOf(jsonValue7.getFloat(BitmapDescriptorFactory.HUE_RED));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(Integer.class))) {
                        strOptString4 = (String) Integer.valueOf(jsonValue7.getInt(0));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(UInt.class))) {
                        strOptString4 = (String) UInt.m5311boximpl(UInt.m5312constructorimpl(jsonValue7.getInt(0)));
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonList.class))) {
                        objOptList4 = jsonValue7.optList();
                        if (objOptList4 != null) {
                            throw new NullPointerException(str);
                        }
                        strOptString4 = (String) objOptList4;
                    } else if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonMap.class))) {
                        objOptMap4 = jsonValue7.optMap();
                        if (objOptMap4 != null) {
                            throw new NullPointerException(str);
                        }
                        strOptString4 = (String) objOptMap4;
                    } else {
                        if (Intrinsics.areEqual(orCreateKotlinClass4, Reflection.getOrCreateKotlinClass(JsonValue.class))) {
                            throw new JsonException(str5 + String.class.getSimpleName() + str4 + "sender" + CoreConstants.SINGLE_QUOTE_CHAR);
                        }
                        jsonValue8 = jsonValue7.getJsonValue();
                        if (jsonValue8 != null) {
                            throw new NullPointerException(str);
                        }
                        strOptString4 = (String) jsonValue8;
                    }
                    sms = new ContactChannel.Sms(new ContactChannel.Sms.RegistrationInfo.Registered(strOptString2, strOptString3, zBooleanValue, strOptString4));
                } else {
                    arrayList2 = arrayList;
                    UALog.m1754w("Unrecognized contact channel type " + strOptString, new Object[0]);
                    sms = null;
                }
            }
            arrayList5 = arrayList2;
            if (sms != null) {
                arrayList5.add(sms);
            }
            it3 = it;
        }
        return arrayList5;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
