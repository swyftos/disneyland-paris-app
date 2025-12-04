package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.ChallengeResponseType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
class ChallengeResponseTypeJsonUnmarshaller implements Unmarshaller<ChallengeResponseType, JsonUnmarshallerContext> {
    private static ChallengeResponseTypeJsonUnmarshaller instance;

    ChallengeResponseTypeJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public ChallengeResponseType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        ChallengeResponseType challengeResponseType = new ChallengeResponseType();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("ChallengeName")) {
                challengeResponseType.setChallengeName(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("ChallengeResponse")) {
                challengeResponseType.setChallengeResponse(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return challengeResponseType;
    }

    public static ChallengeResponseTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ChallengeResponseTypeJsonUnmarshaller();
        }
        return instance;
    }
}
