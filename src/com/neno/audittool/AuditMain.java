package com.neno.audittool;

import java.io.File;
import java.net.URL;

import com.neno.utils.IabHelper;
import com.neno.utils.IabResult;
import com.neno.utils.Purchase;
import com.neno.utils.createpdf;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;

public class AuditMain extends Activity {

	Button policy, details, WHS, planning, imple, measur, record, whsms,
			mangment;
	static final String SKU_COINS_300 = "pdf_id";
	IabHelper mHelper;
	public static final String TAG = "TAG";
	static final int RC_REQUEST = 10001;

	boolean inappbuillingsetup = false;
	private ProgressDialog updateDialog;
	private static final int PROGRESS_DIALOG = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainpage);

		// progressBar=(ProgressBar)findViewById(R.id.progressBar);
		mHelper = new IabHelper(this, getString(R.string.app_key));
		mHelper.startSetup(new IabHelper.OnIabSetupFinishedListener() {
			public void onIabSetupFinished(IabResult result) {
				// Log.d(TAG, "Setup finished.");

				if (!result.isSuccess()) {
					// Oh noes, there was a problem.

					// Log.e(TAG, "Problem setting up in-app billing: " +
					// result);
					// complain("Problem setting up in-app billing: " + result);
					return;
				}
				inappbuillingsetup = true;

				// Hooray, IAB is fully set up. Now, let's get an inventory of
				// stuff we own.
				// Log.d(TAG, "Setup successful. Querying inventory.");

			}
		});

		// init();
		// details.setOnTouchListener(new OnTouchListener() {
		//
		// @Override
		// public boolean onTouch(View arg0, MotionEvent event) {
		// // TODO Auto-generated method stub
		// int action = event.getAction();
		// if (action == MotionEvent.ACTION_DOWN)
		// details.setTextColor(Color.WHITE);
		// else if (action == MotionEvent.ACTION_UP)
		// details.setTextColor(Color.BLACK);
		// return false;
		// }
		// });
		// planning.setOnTouchListener(new OnTouchListener() {
		//
		// @Override
		// public boolean onTouch(View arg0, MotionEvent event) {
		// // TODO Auto-generated method stub
		// int action = event.getAction();
		// if (action == MotionEvent.ACTION_DOWN)
		// planning.setTextColor(Color.WHITE);
		// else if (action == MotionEvent.ACTION_UP)
		// planning.setTextColor(Color.BLACK);
		// return false;
		// }
		// });
		// policy.setOnTouchListener(new OnTouchListener() {
		//
		// @Override
		// public boolean onTouch(View arg0, MotionEvent event) {
		// // TODO Auto-generated method stub
		// int action = event.getAction();
		// if (action == MotionEvent.ACTION_DOWN)
		// policy.setTextColor(Color.WHITE);
		// else if (action == MotionEvent.ACTION_UP)
		// policy.setTextColor(Color.BLACK);
		// return false;
		// }
		// });
		// WHS.setOnTouchListener(new OnTouchListener() {
		//
		// @Override
		// public boolean onTouch(View arg0, MotionEvent event) {
		// // TODO Auto-generated method stub
		// int action = event.getAction();
		// if (action == MotionEvent.ACTION_DOWN)
		// WHS.setTextColor(Color.WHITE);
		// else if (action == MotionEvent.ACTION_UP)
		// WHS.setTextColor(Color.BLACK);
		// return false;
		// }
		// });
		// imple.setOnTouchListener(new OnTouchListener() {
		//
		// @Override
		// public boolean onTouch(View arg0, MotionEvent event) {
		// // TODO Auto-generated method stub
		// int action = event.getAction();
		// if (action == MotionEvent.ACTION_DOWN)
		// imple.setTextColor(Color.WHITE);
		// else if (action == MotionEvent.ACTION_UP)
		// imple.setTextColor(Color.BLACK);
		// return false;
		// }
		// });
		// measur.setOnTouchListener(new OnTouchListener() {
		//
		// @Override
		// public boolean onTouch(View arg0, MotionEvent event) {
		// // TODO Auto-generated method stub
		// int action = event.getAction();
		// if (action == MotionEvent.ACTION_DOWN)
		// measur.setTextColor(Color.WHITE);
		// else if (action == MotionEvent.ACTION_UP)
		// measur.setTextColor(Color.BLACK);
		// return false;
		// }
		// });
		// record.setOnTouchListener(new OnTouchListener() {
		//
		// @Override
		// public boolean onTouch(View arg0, MotionEvent event) {
		// // TODO Auto-generated method stub
		// int action = event.getAction();
		// if (action == MotionEvent.ACTION_DOWN)
		// record.setTextColor(Color.WHITE);
		// else if (action == MotionEvent.ACTION_UP)
		// record.setTextColor(Color.BLACK);
		// return false;
		// }
		// });
		// whsms.setOnTouchListener(new OnTouchListener() {
		//
		// @Override
		// public boolean onTouch(View arg0, MotionEvent event) {
		// // TODO Auto-generated method stub
		// int action = event.getAction();
		// if (action == MotionEvent.ACTION_DOWN)
		// whsms.setTextColor(Color.WHITE);
		// else if (action == MotionEvent.ACTION_UP)
		// whsms.setTextColor(Color.BLACK);
		// return false;
		// }
		// });
		// mangment.setOnTouchListener(new OnTouchListener() {
		//
		// @Override
		// public boolean onTouch(View arg0, MotionEvent event) {
		// // TODO Auto-generated method stub
		// int action = event.getAction();
		// if (action == MotionEvent.ACTION_DOWN)
		// mangment.setTextColor(Color.WHITE);
		// else if (action == MotionEvent.ACTION_UP)
		// mangment.setTextColor(Color.BLACK);
		// return false;
		// }
		// });
	}

	private void init() {
		// TODO Auto-generated method stub
		// details = (Button) findViewById(R.id.button1);
		// WHS = (Button) findViewById(R.id.button2);
		// policy = (Button) findViewById(R.id.button3);
		// planning = (Button) findViewById(R.id.button4);
		// imple = (Button) findViewById(R.id.button5);
		// measur = (Button) findViewById(R.id.button6);
		// record = (Button) findViewById(R.id.button7);
		// whsms = (Button) findViewById(R.id.button8);
		// mangment = (Button) findViewById(R.id.button9);
	}

	protected void showItem() {
		// TODO Auto-generated method stub

	}

	public void OnDetailsCLick(View v) {
		Intent i = new Intent(AuditMain.this, Companydetails.class);
		startActivity(i);
	}

	public void ONCurrentWHSCLick(View v) {
		Intent i = new Intent(AuditMain.this, Current_main.class);
		startActivity(i);
	}

	public void OnImplementationClick(View v) {
		Intent i = new Intent(AuditMain.this, implementation.class);
		i.putExtra("name", "Implementation");
		startActivity(i);
	}

	public void OnPolicyClick(View v) {

		Intent i = new Intent(AuditMain.this, policy.class);
		i.putExtra("name", "Policy");
		startActivity(i);
	}

	public void OnpolicyscrocardClick(View v) {

		Intent i = new Intent(AuditMain.this, policyscrocard.class);
		startActivity(i);
	}

	public void ONFUllSCORECARDCLICK(View v) {
		Intent i = new Intent(AuditMain.this, fullScorecord.class);
		startActivity(i);
	}

	public void OverallRisk(View v) {
		Intent i = new Intent(AuditMain.this, OvAriskrating.class);
		startActivity(i);
	}

	public void OnPlanningClick(View v) {

		Intent i = new Intent(AuditMain.this, planning.class);
		i.putExtra("name", "Planning");
		startActivity(i);
	}

	public void OnMeasurmentClick(View v) {

		Intent i = new Intent(AuditMain.this, measurment.class);
		i.putExtra("name", "Measurement and Evaluation");
		startActivity(i);
	}

	public void ONRecordsManagementCLick(View v) {

		Intent i = new Intent(AuditMain.this, recordmangment.class);
		i.putExtra("name", "Records Management");
		startActivity(i);
	}

	public void ONwhsmauditCLick(View v) {
		// showDialog(PROGRESS_DIALOG);

		Intent i = new Intent(AuditMain.this, whsmaudit.class);
		i.putExtra("name", "WHSMS Audit");
		startActivity(i);
	}

	public void OnReportClick(View v) {

		showDialog(PROGRESS_DIALOG);
		// if (inappbuillingsetup) {
		// String payload = "Neno";
		//
		// mHelper.launchPurchaseFlow(AuditMain.this, SKU_COINS_300,
		// RC_REQUEST, mPurchaseFinishedListener, payload);
		// } else {
		// // showMessage("Inapp builling not setup");
		// }
	}

	public void ONManagementReviewCLick(View v) {

		// genpdf();

		Intent i = new Intent(AuditMain.this, managmentreview.class);
		i.putExtra("name", "Management Review");
		startActivity(i);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.d(TAG, "onActivityResult(" + requestCode + "," + resultCode + ","
				+ data);

		// Pass on the activity result to the helper for handling
		if (!mHelper.handleActivityResult(requestCode, resultCode, data)) {
			// not handled, so handle it ourselves (here's where you'd
			// perform any handling of activity results not related to in-app
			// billing...
			super.onActivityResult(requestCode, resultCode, data);
		} else {
			Log.d(TAG, "onActivityResult handled by IABUtil.");
		}
	}

	IabHelper.OnIabPurchaseFinishedListener mPurchaseFinishedListener = new IabHelper.OnIabPurchaseFinishedListener() {
		public void onIabPurchaseFinished(IabResult result, Purchase purchase) {
			Log.d(TAG, "Purchase finished: " + result + ", purchase: "
					+ purchase);

			if (result.isFailure()) {
				// progressBar.setVisibility(View.GONE);
				if (result.getResponse() == IabHelper.BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED) {
					showDialog(PROGRESS_DIALOG);
					Log.d(TAG, "already purchased item.");

					return;
				}
				Log.d("Tag", "Error purchasing: " + result);
				// setWaitScreen(false);
				return;
			}
			if (!verifyDeveloperPayload(purchase)) {
				Log.d(TAG,
						"Error purchasing. Authenticity verification failed.");
				// progressBar.setVisibility(View.GONE);
				return;
			}

			Log.d(TAG, "Purchase successful.");

			if (purchase.getSku().equals(SKU_COINS_300)) {
				// //
				showDialog(PROGRESS_DIALOG);
			}

		}
	};

	private class DownloadFilesTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... arg0) {
			// TODO Auto-generated method stub
			genpdf();
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			removeDialog(PROGRESS_DIALOG);
			super.onPostExecute(result);
		}

	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {

		switch (id) {

		case PROGRESS_DIALOG:
			new DownloadFilesTask().execute();
			break;

		}

	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {

		case PROGRESS_DIALOG:
			updateDialog = new ProgressDialog(this);
			updateDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			updateDialog.setMessage("Generating Report");
			updateDialog.setCanceledOnTouchOutside(false);
			updateDialog.setIndeterminate(true);
			updateDialog.setCancelable(false);
			return updateDialog;
		}
		return null;
	}

	public void genpdf() {

		createpdf c = new createpdf();
		c.CreatePDF(AuditMain.this);
		File file = new File(Environment.getExternalStorageDirectory()
				.getAbsolutePath() + "/safetyriskrating.pdf");
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(file), "application/pdf");
		intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		startActivity(intent);
	}

	boolean verifyDeveloperPayload(Purchase p) {
		String payload = p.getDeveloperPayload();

		if (payload.equals("Neno")) {
			return true;
		} else {
			return false;
		}
		/*
		 * TODO: verify that the developer payload of the purchase is correct.
		 * It will be the same one that you sent when initiating the purchase.
		 * 
		 * WARNING: Locally generating a random string when starting a purchase
		 * and verifying it here might seem like a good approach, but this will
		 * fail in the case where the user purchases an item on one device and
		 * then uses your app on a different device, because on the other device
		 * you will not have access to the random string you originally
		 * generated.
		 * 
		 * So a good developer payload has these characteristics:
		 * 
		 * 1. If two different users purchase an item, the payload is different
		 * between them, so that one user's purchase can't be replayed to
		 * another user.
		 * 
		 * 2. The payload must be such that you can verify it even when the app
		 * wasn't the one who initiated the purchase flow (so that items
		 * purchased by the user on one device work on other devices owned by
		 * the user).
		 * 
		 * Using your own server to store and verify developer payloads across
		 * app installations is recommended.
		 */

	}

}
