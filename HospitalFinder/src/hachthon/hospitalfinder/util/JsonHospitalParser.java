
package hachthon.hospitalfinder.util;

import hachthon.hospitalfinder.HospitalListInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonHospitalParser {
    public static List<HospitalListInfo> parseJsonToHospitalList(String json) {
        List<HospitalListInfo> list = new ArrayList<HospitalListInfo>();
        Set<String> set = new HashSet<String>();
        try {
            JSONArray jsonHospitalList = new JSONArray(json);
            for (int i = 0; i < jsonHospitalList.length(); i++) {
                String name = jsonHospitalList.getJSONObject(i).getString("hospital_name");
                if (set.contains(name)) {
                    continue;
                }
                set.add(name);
                String addr = jsonHospitalList.getJSONObject(i).getString("location_address");
                JSONObject jsonLocation = jsonHospitalList.getJSONObject(i).getJSONObject(
                        "location");
                JSONArray jsonCoordinates = jsonLocation.getJSONArray("coordinates");
                double lng = jsonCoordinates.getDouble(0);
                double lat = jsonCoordinates.getDouble(1);
                HospitalListInfo hospitalInfo = new HospitalListInfo(name, "http//:sample.link",
                        55, 5, addr, 5, 5, "phoneNumber", "openHours", "feature", "featureDetail",
                        "specialty1", "specialty2", "review1", "review2");
                hospitalInfo.setLatitude(lat);
                hospitalInfo.setLongitude(lng);
                list.add(hospitalInfo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return list;
        }
        return list;
    }
}
