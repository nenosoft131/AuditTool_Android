package com.neno.audittool;

import com.neno.Async.TaskHandler;
import com.neno.utils.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

public class forgotpass extends Activity {

	private ProgressDialog loginDialog;
	private static final int INTERNET_DIALOG = 0;
	private static final int PASS_DIALOG = 1;
	private static final int ERROR_DIALOG = 2;
	EditText email;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.forgotpass);
		email = (EditText) findViewById(R.id.email);
	}

	public void ONclick(View v) {

		showDialog(PASS_DIALOG);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {

		case PASS_DIALOG:
			loginDialog = new ProgressDialog(this);
			loginDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			loginDialog.setMessage("Plz Wait....");
			loginDialog.setIndeterminate(true);
			loginDialog.setCancelable(true);
			return loginDialog;

		case ERROR_DIALOG:
			AlertDialog.Builder b2 = new Builder(this);
			b2.setTitle("Sorry!");
			b2.setMessage("Wrong User Email!");
			b2.setNeutralButton("OK", new OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					removeDialog(ERROR_DIALOG);
				}
			});
			b2.setCancelable(true);

			return b2.create();
		case INTERNET_DIALOG:
			AlertDialog.Builder b3 = new Builder(this);
			b3.setTitle("Problem!");
			b3.setMessage("Internet Connection Problem!");
			b3.setNeutralButton("OK", new OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					removeDialog(INTERNET_DIALOG);
				}
			});
			b3.setCancelable(true);

			return b3.create();

		}
		return null;
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {

		switch (id) {

		case PASS_DIALOG:
			new TaskHandler(this).execute(String
					.valueOf(TaskHandler.FORGOT_PASS), email.getText()
					.toString());
			break;

		}

	}
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub

		super.onStart();
		IntentFilter filter = new IntentFilter(Utils.ACTION_FORGOT_PASS);
		registerReceiver(PASS_RECIVER, filter);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		unregisterReceiver(PASS_RECIVER);
	}


	BroadcastReceiver PASS_RECIVER = new BroadcastReceiver()

	{
		public void onReceive(android.content.Context context, Intent intent) {

			final Bundle extra = intent.getExtras();
			String STATUS = extra.getString("FORGOT");
			if (STATUS.contains("An email has been sent to your account")) {
				Toast.makeText(forgotpass.this, "An email has been sent to your account", Toast.LENGTH_LONG)
				.show();
				finish();

			} else {
//				Toast.makeText(forgotpass.this, "Error Login", Toast.LENGTH_LONG)
//						.show();
				showDialog(ERROR_DIALOG);
			}
			removeDialog(PASS_DIALOG);
		}

	};

}
