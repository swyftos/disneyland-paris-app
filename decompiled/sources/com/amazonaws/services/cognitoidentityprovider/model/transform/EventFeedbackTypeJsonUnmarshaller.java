package com.amazonaws.services.cognitoidentityprovider.model.transform;

import com.amazonaws.services.cognitoidentityprovider.model.EventFeedbackType;
import com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazonaws.transform.SimpleTypeJsonUnmarshallers;
import com.amazonaws.transform.Unmarshaller;
import com.amazonaws.util.json.AwsJsonReader;
import java.io.IOException;

/* loaded from: classes2.dex */
class EventFeedbackTypeJsonUnmarshaller implements Unmarshaller<EventFeedbackType, JsonUnmarshallerContext> {
    private static EventFeedbackTypeJsonUnmarshaller instance;

    EventFeedbackTypeJsonUnmarshaller() {
    }

    @Override // com.amazonaws.transform.Unmarshaller
    public EventFeedbackType unmarshall(JsonUnmarshallerContext jsonUnmarshallerContext) throws IOException {
        AwsJsonReader reader = jsonUnmarshallerContext.getReader();
        if (!reader.isContainer()) {
            reader.skipValue();
            return null;
        }
        EventFeedbackType eventFeedbackType = new EventFeedbackType();
        reader.beginObject();
        while (reader.hasNext()) {
            String strNextName = reader.nextName();
            if (strNextName.equals("FeedbackValue")) {
                eventFeedbackType.setFeedbackValue(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("Provider")) {
                eventFeedbackType.setProvider(SimpleTypeJsonUnmarshallers.StringJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else if (strNextName.equals("FeedbackDate")) {
                eventFeedbackType.setFeedbackDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshaller.getInstance().unmarshall(jsonUnmarshallerContext));
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return eventFeedbackType;
    }

    public static EventFeedbackTypeJsonUnmarshaller getInstance() {
        if (instance == null) {
            instance = new EventFeedbackTypeJsonUnmarshaller();
        }
        return instance;
    }
}
