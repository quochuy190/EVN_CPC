package com.evn.evncpcmobile.presenter;

import com.evn.evncpcmobile.models.request_api.GetAccessToken_Request;
import com.evn.evncpcmobile.models.request_api.Init_Request;
import com.evn.evncpcmobile.models.response_api.Init_Response;

/**
 * Created by: Neo Company.
 * Developer: HuyNQ2
 * Date: 02-May-2019
 * Time: 10:37
 * Version: 1.0
 */
public interface InterfaceLogin {
    interface Presenter {
        void api_init(Init_Request sBody);

        void api_get_access_token(GetAccessToken_Request sBody);

        void api_register(String sBody);

        void api_update_device(String sBody);
    }

    interface View {
        void show_error_api();

        void api_show_init(Init_Response mResponse);

    }
}
