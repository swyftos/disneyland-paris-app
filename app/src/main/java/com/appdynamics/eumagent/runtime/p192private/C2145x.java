package com.appdynamics.eumagent.runtime.p192private;

import com.appdynamics.eumagent.runtime.logging.ADLog;
import com.appdynamics.repacked.gson.stream.JsonReader;
import com.appdynamics.repacked.gson.stream.JsonToken;
import java.io.IOException;
import java.io.StringReader;

/* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.x */
/* JADX INFO: loaded from: classes2.dex */
public final class C2145x {

    /* JADX INFO: renamed from: com.appdynamics.eumagent.runtime.private.x$a */
    static class a {

        /* JADX INFO: renamed from: a */
        String f960a;

        /* JADX INFO: renamed from: b */
        String f961b;

        /* JADX INFO: renamed from: c */
        Integer f962c;

        /* JADX INFO: renamed from: d */
        String f963d;

        /* JADX INFO: renamed from: e */
        Integer f964e;

        /* JADX INFO: renamed from: f */
        Long f965f;

        /* JADX INFO: renamed from: g */
        String f966g;

        /* JADX INFO: renamed from: h */
        String f967h;

        a() {
        }
    }

    /* JADX INFO: renamed from: a */
    public final a m723a(String str) {
        a aVar = new a();
        aVar.f960a = str;
        try {
            JsonReader jsonReader = new JsonReader(new StringReader(aVar.f960a));
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String strNextName = jsonReader.nextName();
                Long lValueOf = null;
                String strNextString = null;
                if (aVar.f961b != null || !"eid".equals(strNextName)) {
                    if (aVar.f965f != null || !"st".equals(strNextName)) {
                        if (aVar.f966g == null && "androidCrashReport".equals(strNextName)) {
                            aVar.f964e = 0;
                            m721a(aVar, jsonReader);
                        } else if (aVar.f966g == null && "clrCrashReport".equals(strNextName)) {
                            aVar.f964e = 1;
                            m722b(aVar, jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    } else {
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                        } else {
                            lValueOf = Long.valueOf(jsonReader.nextLong());
                        }
                        aVar.f965f = lValueOf;
                    }
                } else {
                    if (jsonReader.peek() == JsonToken.NULL) {
                        jsonReader.nextNull();
                    } else {
                        strNextString = jsonReader.nextString();
                    }
                    aVar.f961b = strNextString;
                }
            }
            jsonReader.endObject();
        } catch (Throwable th) {
            ADLog.logAgentError("Failed to parse crash summary from serialized crash report", th);
        }
        return aVar;
    }

    /* JADX INFO: renamed from: a */
    private void m721a(a aVar, JsonReader jsonReader) throws IOException {
        String strNextString;
        String strNextString2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            String strNextString3 = null;
            if (aVar.f966g != null || !"stackTrace".equals(strNextName)) {
                if (aVar.f963d != null || !"thread".equals(strNextName)) {
                    jsonReader.skipValue();
                } else {
                    if (jsonReader.peek() == JsonToken.NULL) {
                        jsonReader.nextNull();
                    } else {
                        strNextString3 = jsonReader.nextString();
                    }
                    aVar.f963d = strNextString3;
                }
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if (aVar.f966g != null || !"exceptionClassName".equals(strNextName2)) {
                        if (aVar.f967h != null || !"message".equals(strNextName2)) {
                            jsonReader.skipValue();
                        } else {
                            if (jsonReader.peek() == JsonToken.NULL) {
                                jsonReader.nextNull();
                                strNextString = null;
                            } else {
                                strNextString = jsonReader.nextString();
                            }
                            aVar.f967h = strNextString;
                        }
                    } else {
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            strNextString2 = null;
                        } else {
                            strNextString2 = jsonReader.nextString();
                        }
                        aVar.f966g = strNextString2;
                    }
                }
                jsonReader.endObject();
            }
        }
        jsonReader.endObject();
    }

    /* JADX INFO: renamed from: b */
    private void m722b(a aVar, JsonReader jsonReader) throws IOException {
        Integer numValueOf;
        String strNextString;
        String strNextString2;
        String strNextString3;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (aVar.f966g != null || !"stackTrace".equals(strNextName)) {
                if (aVar.f962c != null || !"thread".equals(strNextName)) {
                    jsonReader.skipValue();
                } else {
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        if (aVar.f963d != null || !"name".equals(strNextName2)) {
                            if (aVar.f962c != null || !"id".equals(strNextName2)) {
                                jsonReader.skipValue();
                            } else {
                                if (jsonReader.peek() == JsonToken.NULL) {
                                    jsonReader.nextNull();
                                    numValueOf = null;
                                } else {
                                    numValueOf = Integer.valueOf(jsonReader.nextInt());
                                }
                                aVar.f962c = numValueOf;
                            }
                        } else {
                            if (jsonReader.peek() == JsonToken.NULL) {
                                jsonReader.nextNull();
                                strNextString = null;
                            } else {
                                strNextString = jsonReader.nextString();
                            }
                            aVar.f963d = strNextString;
                        }
                    }
                    jsonReader.endObject();
                }
            } else {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName3 = jsonReader.nextName();
                    if (aVar.f966g != null || !"exceptionClassName".equals(strNextName3)) {
                        if (aVar.f967h != null || !"message".equals(strNextName3)) {
                            jsonReader.skipValue();
                        } else {
                            if (jsonReader.peek() == JsonToken.NULL) {
                                jsonReader.nextNull();
                                strNextString2 = null;
                            } else {
                                strNextString2 = jsonReader.nextString();
                            }
                            aVar.f967h = strNextString2;
                        }
                    } else {
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            strNextString3 = null;
                        } else {
                            strNextString3 = jsonReader.nextString();
                        }
                        aVar.f966g = strNextString3;
                    }
                }
                jsonReader.endObject();
            }
        }
    }
}
