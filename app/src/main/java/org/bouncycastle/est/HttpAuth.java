package org.bouncycastle.est;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.allegion.accessblecredential.communication.AlCBORMessage;
import com.google.common.net.HttpHeaders;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cms.CMSAttributeTableGenerator;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Hex;

/* JADX INFO: loaded from: classes6.dex */
public class HttpAuth implements ESTAuth {
    private static final DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder = new DefaultDigestAlgorithmIdentifierFinder();
    private static final Set validParts;
    private final DigestCalculatorProvider digestCalculatorProvider;
    private final SecureRandom nonceGenerator;
    private final char[] password;
    private final String realm;
    private final String username;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("realm");
        hashSet.add(AlCBORMessage.NONCE);
        hashSet.add("opaque");
        hashSet.add("algorithm");
        hashSet.add("qop");
        validParts = Collections.unmodifiableSet(hashSet);
    }

    public HttpAuth(String str, String str2, char[] cArr) {
        this(str, str2, cArr, null, null);
    }

    public HttpAuth(String str, String str2, char[] cArr, SecureRandom secureRandom, DigestCalculatorProvider digestCalculatorProvider) {
        this.realm = str;
        this.username = str2;
        this.password = cArr;
        this.nonceGenerator = secureRandom;
        this.digestCalculatorProvider = digestCalculatorProvider;
    }

    public HttpAuth(String str, char[] cArr) {
        this(null, str, cArr, null, null);
    }

    public HttpAuth(String str, char[] cArr, SecureRandom secureRandom, DigestCalculatorProvider digestCalculatorProvider) {
        this(null, str, cArr, secureRandom, digestCalculatorProvider);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:76:0x02b2  */
    public ESTResponse doDigestFunction(ESTResponse eSTResponse) throws IOException {
        String str;
        String str2;
        eSTResponse.close();
        ESTRequest originalRequest = eSTResponse.getOriginalRequest();
        try {
            Map mapSplitCSL = HttpUtil.splitCSL("Digest", eSTResponse.getHeader(HttpHeaders.WWW_AUTHENTICATE));
            try {
                String path = originalRequest.getURL().toURI().getPath();
                for (Object obj : mapSplitCSL.keySet()) {
                    if (!validParts.contains(obj)) {
                        throw new ESTException("Unrecognised entry in WWW-Authenticate header: '" + obj + "'");
                    }
                }
                String method = originalRequest.getMethod();
                String str3 = (String) mapSplitCSL.get("realm");
                String str4 = (String) mapSplitCSL.get(AlCBORMessage.NONCE);
                String str5 = (String) mapSplitCSL.get("opaque");
                String str6 = "algorithm";
                String str7 = (String) mapSplitCSL.get("algorithm");
                String str8 = "qop";
                String str9 = (String) mapSplitCSL.get("qop");
                ArrayList arrayList = new ArrayList();
                String str10 = this.realm;
                if (str10 != null && !str10.equals(str3)) {
                    throw new ESTException("Supplied realm '" + this.realm + "' does not match server realm '" + str3 + "'", null, TypedValues.CycleType.TYPE_CURVE_FIT, null);
                }
                if (str7 == null) {
                    str7 = MessageDigestAlgorithms.MD5;
                }
                if (str7.length() == 0) {
                    throw new ESTException("WWW-Authenticate no algorithm defined.");
                }
                String upperCase = Strings.toUpperCase(str7);
                if (str9 == null) {
                    throw new ESTException("Qop is not defined in WWW-Authenticate header.");
                }
                if (str9.length() == 0) {
                    throw new ESTException("QoP value is empty.");
                }
                String[] strArrSplit = Strings.toLowerCase(str9).split(",");
                int i = 0;
                while (true) {
                    String str11 = str6;
                    String str12 = str8;
                    if (i == strArrSplit.length) {
                        AlgorithmIdentifier algorithmIdentifierLookupDigest = lookupDigest(upperCase);
                        if (algorithmIdentifierLookupDigest == null || algorithmIdentifierLookupDigest.getAlgorithm() == null) {
                            throw new IOException("auth digest algorithm unknown: " + upperCase);
                        }
                        DigestCalculator digestCalculator = getDigestCalculator(upperCase, algorithmIdentifierLookupDigest);
                        OutputStream outputStream = digestCalculator.getOutputStream();
                        String strMakeNonce = makeNonce(10);
                        update(outputStream, this.username);
                        update(outputStream, ":");
                        update(outputStream, str3);
                        update(outputStream, ":");
                        update(outputStream, this.password);
                        outputStream.close();
                        byte[] digest = digestCalculator.getDigest();
                        if (upperCase.endsWith("-SESS")) {
                            DigestCalculator digestCalculator2 = getDigestCalculator(upperCase, algorithmIdentifierLookupDigest);
                            OutputStream outputStream2 = digestCalculator2.getOutputStream();
                            update(outputStream2, Hex.toHexString(digest));
                            update(outputStream2, ":");
                            update(outputStream2, str4);
                            update(outputStream2, ":");
                            update(outputStream2, strMakeNonce);
                            outputStream2.close();
                            digest = digestCalculator2.getDigest();
                        }
                        String hexString = Hex.toHexString(digest);
                        DigestCalculator digestCalculator3 = getDigestCalculator(upperCase, algorithmIdentifierLookupDigest);
                        OutputStream outputStream3 = digestCalculator3.getOutputStream();
                        if (((String) arrayList.get(0)).equals("auth-int")) {
                            DigestCalculator digestCalculator4 = getDigestCalculator(upperCase, algorithmIdentifierLookupDigest);
                            str = "auth-int";
                            OutputStream outputStream4 = digestCalculator4.getOutputStream();
                            originalRequest.writeData(outputStream4);
                            outputStream4.close();
                            byte[] digest2 = digestCalculator4.getDigest();
                            update(outputStream3, method);
                            update(outputStream3, ":");
                            update(outputStream3, path);
                            update(outputStream3, ":");
                            update(outputStream3, Hex.toHexString(digest2));
                        } else {
                            str = "auth-int";
                            if (((String) arrayList.get(0)).equals("auth")) {
                                update(outputStream3, method);
                                update(outputStream3, ":");
                                update(outputStream3, path);
                            }
                        }
                        outputStream3.close();
                        String hexString2 = Hex.toHexString(digestCalculator3.getDigest());
                        DigestCalculator digestCalculator5 = getDigestCalculator(upperCase, algorithmIdentifierLookupDigest);
                        OutputStream outputStream5 = digestCalculator5.getOutputStream();
                        boolean zContains = arrayList.contains("missing");
                        update(outputStream5, hexString);
                        update(outputStream5, ":");
                        update(outputStream5, str4);
                        update(outputStream5, ":");
                        if (zContains) {
                            update(outputStream5, hexString2);
                            str2 = str;
                        } else {
                            update(outputStream5, "00000001");
                            update(outputStream5, ":");
                            update(outputStream5, strMakeNonce);
                            update(outputStream5, ":");
                            str2 = str;
                            if (((String) arrayList.get(0)).equals(str2)) {
                                update(outputStream5, str2);
                            } else {
                                update(outputStream5, "auth");
                            }
                            update(outputStream5, ":");
                            update(outputStream5, hexString2);
                        }
                        outputStream5.close();
                        String hexString3 = Hex.toHexString(digestCalculator5.getDigest());
                        HashMap map = new HashMap();
                        map.put("username", this.username);
                        map.put("realm", str3);
                        map.put(AlCBORMessage.NONCE, str4);
                        map.put(ReactNativeBlobUtilConst.DATA_ENCODE_URI, path);
                        map.put("response", hexString3);
                        if (!((String) arrayList.get(0)).equals(str2)) {
                            if (((String) arrayList.get(0)).equals("auth")) {
                                map.put(str12, "auth");
                            }
                            map.put(str11, upperCase);
                            if (str5 != null || str5.length() == 0) {
                                map.put("opaque", makeNonce(20));
                            }
                            ESTRequestBuilder eSTRequestBuilderWithHijacker = new ESTRequestBuilder(originalRequest).withHijacker(null);
                            eSTRequestBuilderWithHijacker.setHeader("Authorization", HttpUtil.mergeCSL("Digest", map));
                            return originalRequest.getClient().doRequest(eSTRequestBuilderWithHijacker.build());
                        }
                        map.put(str12, str2);
                        map.put("nc", "00000001");
                        map.put("cnonce", strMakeNonce);
                        map.put(str11, upperCase);
                        if (str5 != null) {
                            map.put("opaque", makeNonce(20));
                        } else {
                            map.put("opaque", makeNonce(20));
                        }
                        ESTRequestBuilder eSTRequestBuilderWithHijacker2 = new ESTRequestBuilder(originalRequest).withHijacker(null);
                        eSTRequestBuilderWithHijacker2.setHeader("Authorization", HttpUtil.mergeCSL("Digest", map));
                        return originalRequest.getClient().doRequest(eSTRequestBuilderWithHijacker2.build());
                    }
                    if (!strArrSplit[i].equals("auth") && !strArrSplit[i].equals("auth-int")) {
                        throw new ESTException("QoP value unknown: '" + i + "'");
                    }
                    String strTrim = strArrSplit[i].trim();
                    if (!arrayList.contains(strTrim)) {
                        arrayList.add(strTrim);
                    }
                    i++;
                    str6 = str11;
                    str8 = str12;
                }
            } catch (Exception e) {
                throw new IOException("unable to process URL in request: " + e.getMessage());
            }
        } catch (Throwable th) {
            throw new ESTException("Parsing WWW-Authentication header: " + th.getMessage(), th, eSTResponse.getStatusCode(), new ByteArrayInputStream(eSTResponse.getHeader(HttpHeaders.WWW_AUTHENTICATE).getBytes()));
        }
    }

    private DigestCalculator getDigestCalculator(String str, AlgorithmIdentifier algorithmIdentifier) throws IOException {
        try {
            return this.digestCalculatorProvider.get(algorithmIdentifier);
        } catch (OperatorCreationException e) {
            throw new IOException("cannot create digest calculator for " + str + ": " + e.getMessage());
        }
    }

    private AlgorithmIdentifier lookupDigest(String str) {
        if (str.endsWith("-SESS")) {
            str = str.substring(0, str.length() - 5);
        }
        return str.equals("SHA-512-256") ? new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_256, DERNull.INSTANCE) : digestAlgorithmIdentifierFinder.find(str);
    }

    private String makeNonce(int i) {
        byte[] bArr = new byte[i];
        this.nonceGenerator.nextBytes(bArr);
        return Hex.toHexString(bArr);
    }

    private void update(OutputStream outputStream, String str) throws IOException {
        outputStream.write(Strings.toUTF8ByteArray(str));
    }

    private void update(OutputStream outputStream, char[] cArr) throws IOException {
        outputStream.write(Strings.toUTF8ByteArray(cArr));
    }

    @Override // org.bouncycastle.est.ESTAuth
    public void applyAuth(ESTRequestBuilder eSTRequestBuilder) {
        eSTRequestBuilder.withHijacker(new ESTHijacker() { // from class: org.bouncycastle.est.HttpAuth.1
            @Override // org.bouncycastle.est.ESTHijacker
            public ESTResponse hijack(ESTRequest eSTRequest, Source source) throws IOException {
                ESTResponse eSTResponse = new ESTResponse(eSTRequest, source);
                if (eSTResponse.getStatusCode() != 401) {
                    return eSTResponse;
                }
                String header = eSTResponse.getHeader(HttpHeaders.WWW_AUTHENTICATE);
                if (header == null) {
                    throw new ESTException("Status of 401 but no WWW-Authenticate header");
                }
                String lowerCase = Strings.toLowerCase(header);
                if (lowerCase.startsWith(CMSAttributeTableGenerator.DIGEST)) {
                    return HttpAuth.this.doDigestFunction(eSTResponse);
                }
                if (!lowerCase.startsWith("basic")) {
                    throw new ESTException("Unknown auth mode: " + lowerCase);
                }
                eSTResponse.close();
                Map mapSplitCSL = HttpUtil.splitCSL("Basic", eSTResponse.getHeader(HttpHeaders.WWW_AUTHENTICATE));
                if (HttpAuth.this.realm != null && !HttpAuth.this.realm.equals(mapSplitCSL.get("realm"))) {
                    throw new ESTException("Supplied realm '" + HttpAuth.this.realm + "' does not match server realm '" + ((String) mapSplitCSL.get("realm")) + "'", null, TypedValues.CycleType.TYPE_CURVE_FIT, null);
                }
                ESTRequestBuilder eSTRequestBuilderWithHijacker = new ESTRequestBuilder(eSTRequest).withHijacker(null);
                if (HttpAuth.this.realm != null && HttpAuth.this.realm.length() > 0) {
                    eSTRequestBuilderWithHijacker.setHeader(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=\"" + HttpAuth.this.realm + "\"");
                }
                if (HttpAuth.this.username.contains(":")) {
                    throw new IllegalArgumentException("User must not contain a ':'");
                }
                char[] cArr = new char[HttpAuth.this.username.length() + 1 + HttpAuth.this.password.length];
                System.arraycopy(HttpAuth.this.username.toCharArray(), 0, cArr, 0, HttpAuth.this.username.length());
                cArr[HttpAuth.this.username.length()] = ':';
                System.arraycopy(HttpAuth.this.password, 0, cArr, HttpAuth.this.username.length() + 1, HttpAuth.this.password.length);
                eSTRequestBuilderWithHijacker.setHeader("Authorization", "Basic " + Base64.toBase64String(Strings.toByteArray(cArr)));
                ESTResponse eSTResponseDoRequest = eSTRequest.getClient().doRequest(eSTRequestBuilderWithHijacker.build());
                Arrays.fill(cArr, (char) 0);
                return eSTResponseDoRequest;
            }
        });
    }
}
