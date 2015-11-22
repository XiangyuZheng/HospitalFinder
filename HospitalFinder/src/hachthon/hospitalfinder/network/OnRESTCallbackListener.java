
package hachthon.hospitalfinder.network;

import java.util.List;

import hachthon.hospitalfinder.HospitalListInfo;

public interface OnRESTCallbackListener {
    public void onSuccess(List<HospitalListInfo> hospitalList);
}
