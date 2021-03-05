package com.neno.Async;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import com.neno.utils.Helper;
import com.neno.utils.JsonParser;
import com.neno.utils.Utils;

public class TaskHandler extends AsyncTask<String, Object, Integer> {

	private String TAG = "AsyncTask";

	private Context context = null;
	private int ServiceAction;

	public static final int LOG_IN = 1;
	public static final int FORGOT_PASS = 2;

	private boolean isJArray = false;

	private int _taskStatus = 0;
	String LOGIN_STATUS;
	String FORGOT_STATUS;

	JsonParser jsonParser;
	public Bitmap myBitmap;
	private String class_id;

	public static final String SERVER = Utils.SERVER;
	public static final String log_in = SERVER + "?action=login";
	public static final String forgot_pass = SERVER + "?action=forgotPassword";

	public TaskHandler(Context context) {
		this.context = context;
	}

	@Override
	protected Integer doInBackground(String... params) {
		// TODO Auto-generated method stub

		String FeedURL = "";

		ServiceAction = Integer.parseInt(params[0]);

		if (ServiceAction == LOG_IN) {

			FeedURL = log_in;
			FeedURL = FeedURL + "&username=" + Helper.EncodeURL(params[1])
					+ "&password=" + params[2];
			isJArray = true;

		}
		if (ServiceAction == FORGOT_PASS) {

			FeedURL = forgot_pass;
			FeedURL = FeedURL + "&username=" + Helper.EncodeURL(params[1]);
			isJArray = true;

		}

		if (isJArray) {
			jsonParser = new JsonParser();
			try {
				HandleResponseArray(jsonParser.GetJasonObject(FeedURL, false));
			} catch (Exception e) {
				System.out.println("");
			}
			System.out.println("");
		} else {
			jsonParser = new JsonParser();
			try {
				// HandleResponse(jsonParser.GetJasonObject(FeedURL, false));
			} catch (Exception ex) {
				Logger.getLogger(TaskHandler.class.getName()).log(Level.SEVERE,
						null, ex);
			}
		}

		return _taskStatus;
	}

	@Override
	protected void onPostExecute(Integer result) {

		if (ServiceAction == LOG_IN) {

			Intent intent = new Intent(Utils.ACTION_LOG_IN);
			intent.putExtra("LOGIN", LOGIN_STATUS);
			if (context != null) {
				context.sendBroadcast(intent);
			}
		}

		if (ServiceAction == FORGOT_PASS) {

			Intent intent = new Intent(Utils.ACTION_FORGOT_PASS);
			intent.putExtra("FORGOT", FORGOT_STATUS);
			if (context != null) {
				context.sendBroadcast(intent);
			}
		}
		super.onPostExecute(result);

	}

	private void HandleResponseArray(JSONObject jObj) {

		if (jObj == null) {
			Log.d(TAG, "JSON object is null");
			return;
		}
		if (ServiceAction == LOG_IN) {
			LOGIN(jObj);
		} else if (ServiceAction == FORGOT_PASS) {
			FORGOT(jObj);
		}

	}

	private void FORGOT(JSONObject jObj) {
		isJArray = true;
		try {
			String posts = jObj.getString("Response");
			FORGOT_STATUS = posts;
			_taskStatus = FORGOT_PASS;

		} catch (Exception exp) {

			_taskStatus = FORGOT_PASS;
			Log.d(TAG, exp.getMessage());

		}

	}

	private void LOGIN(JSONObject jObj) {
		isJArray = true;
		try {
			String posts = jObj.getString("Response");
			LOGIN_STATUS = posts;
			_taskStatus = LOG_IN;

		} catch (Exception exp) {

			_taskStatus = LOG_IN;
			Log.d(TAG, exp.getMessage());

		}

	}

}
