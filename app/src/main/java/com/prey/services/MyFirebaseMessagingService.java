package com.prey.services;

import com.firebase.jobdispatcher.FirebaseJobDispatcher;
import com.firebase.jobdispatcher.GooglePlayDriver;
import com.firebase.jobdispatcher.Job;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.prey.PreyLogger;
import com.prey.beta.actions.PreyBetaController;

import org.json.JSONArray;
import org.json.JSONObject;

public class MyFirebaseMessagingService extends FirebaseMessagingService {



    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // [START_EXCLUDE]
        // There are two types of messages data messages and notification messages. Data messages are handled
        // here in onMessageReceived whether the app is in the foreground or background. Data messages are the type
        // traditionally used with GCM. Notification messages are only received here in onMessageReceived when the app
        // is in the foreground. When the app is in the background an automatically generated notification is displayed.
        // When the user taps on the notification they are returned to the app. Messages containing both notification
        // and data payloads are treated as notification messages. The Firebase console always sends notification
        // messages. For more see: https://firebase.google.com/docs/cloud-messaging/concept-options
        // [END_EXCLUDE]

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        PreyLogger.d( "From: " + remoteMessage.getFrom());
        PreyLogger.d( "From: " + remoteMessage.getFrom());
        PreyLogger.d( "From: " + remoteMessage.getFrom());

        PreyLogger.d( "From: " + remoteMessage.getFrom());
        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            PreyLogger.d("Message data payload: " + remoteMessage.getData());

            String cmd=null;

            PreyBetaController.startPrey(this,cmd);
        }

        //OSOSO
        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            //Message Notification Data: {key=dd109f, body=run_once, type=text, version=v3}
            PreyLogger.d( "Message Notification Body: " + remoteMessage.getNotification().getBody());
            PreyLogger.d( "Message Notification Body: " + remoteMessage.getNotification().getBody());
            PreyLogger.d( "Message Notification Body: " + remoteMessage.getNotification().getBody());

        }

        if (remoteMessage.getData() != null) {
            PreyLogger.d( "Message Notification Data: " + remoteMessage.getData() );
            PreyLogger.d( "Message Notification Data: " + remoteMessage.getData() );
            PreyLogger.d( "Message Notification Data: " + remoteMessage.getData() );
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }
    // [END receive_message]

    /**
     * Schedule a job using FirebaseJobDispatcher.
     */
    private void scheduleJob() {
        // [START dispatch_job]
        FirebaseJobDispatcher dispatcher = new FirebaseJobDispatcher(new GooglePlayDriver(this));
        Job myJob = dispatcher.newJobBuilder()
                .setService(MyJobService.class)
                .setTag("my-job-tag")
                .build();
        dispatcher.schedule(myJob);
        // [END dispatch_job]
    }

    /**
     * Handle time allotted to BroadcastReceivers.
     */
    private void handleNow() {
        PreyLogger.d( "Short lived task is done.");
    }

    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param messageBody FCM message body received.
     */
    private void sendNotification(String messageBody) {

    }
}