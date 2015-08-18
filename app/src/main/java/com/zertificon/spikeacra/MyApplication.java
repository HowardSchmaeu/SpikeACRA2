package com.zertificon.spikeacra;

import android.app.Application;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

/**
 * Created by MSC on 17.08.2015.
 */

@ReportsCrashes(

        formUri = "",
        reportType = org.acra.sender.HttpSender.Type.JSON,
        httpMethod = org.acra.sender.HttpSender.Method.PUT,
        formUriBasicAuthLogin="",
        formUriBasicAuthPassword="",
        // Your usual ACRA configuration
        mode = ReportingInteractionMode.DIALOG,
        //resToastText  = R.string.crash_toast_text,
        resDialogText = R.string.crash_toast_text


)
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ACRA.init(this);
    }
}
