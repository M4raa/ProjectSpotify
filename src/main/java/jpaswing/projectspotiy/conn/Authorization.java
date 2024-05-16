package jpaswing.projectspotiy.conn;

import org.json.JSONObject;
import java.io.IOException;

public class Authorization {
    public static JSONObject getAuth() throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Authorization", "Bearer " + TokenRequest.getToken());
        return jsonObject;
    }
    public static String getBearer() throws IOException {
        return "Bearer " + TokenRequest.getToken();
    }
}
