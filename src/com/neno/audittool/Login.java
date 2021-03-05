package com.neno.audittool;

import com.neno.Async.TaskHandler;
import com.neno.utils.ConnectionDetector;
import com.neno.utils.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

	TaskHandler task;
	ConnectionDetector cd;

	EditText user_name, password;
	private ProgressDialog loginDialog;
	private static final int INTERNET_DIALOG = 0;
	private static final int LOGIN_DIALOG = 1;
	private static final int ERROR_DIALOG = 2;
	String USERNAME, PASSWORD;
	TextView forgot;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lo);
		user_name = (EditText) findViewById(R.id.ed_username);
		password = (EditText) findViewById(R.id.ed_pass);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub

		super.onStart();
		IntentFilter filter = new IntentFilter(Utils.ACTION_LOG_IN);
		registerReceiver(LOGIN_RECIVER, filter);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		unregisterReceiver(LOGIN_RECIVER);
	}

	public void ForgotPass(View v) {
		Intent i = new Intent(Login.this, forgotpass.class);
		startActivity(i);
	}

	public void ONclick(View v) {
		//
		// Intent i = new Intent(Login.this, AuditMain.class);
		// startActivity(i);
		cd = new ConnectionDetector(getApplicationContext());
		if (!cd.isConnectingToInternet()) {
			showDialog(INTERNET_DIALOG);
			return;
		}
		USERNAME = user_name.getText().toString();
		PASSWORD = password.getText().toString();

		if (USERNAME.length() == 0) {
			user_name.setError("Error");

		} else if (password.length() == 0) {

			Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT)
					.show();

		} else {
			showDialog(LOGIN_DIALOG);
		}

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {

		case LOGIN_DIALOG:
			loginDialog = new ProgressDialog(this);
			loginDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			loginDialog.setMessage("Signing in ..");
			loginDialog.setIndeterminate(true);
			loginDialog.setCancelable(true);
			return loginDialog;

		case ERROR_DIALOG:
			AlertDialog.Builder b2 = new Builder(this);
			b2.setTitle("Sorry!");
			b2.setMessage("Wrong User ID or Password!");
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

		case LOGIN_DIALOG:
			new TaskHandler(this).execute(String.valueOf(TaskHandler.LOG_IN),
					USERNAME, PASSWORD);
			break;

		}

	}

	BroadcastReceiver LOGIN_RECIVER = new BroadcastReceiver()

	{
		public void onReceive(android.content.Context context, Intent intent) {

			final Bundle extra = intent.getExtras();
			String STATUS = extra.getString("LOGIN");
			if (STATUS.equals("valid_user")) {
				Intent i = new Intent(Login.this, AuditMain.class);
				startActivity(i);
				Toast.makeText(Login.this, "Login Successful",
						Toast.LENGTH_SHORT).show();
				finish();

			} else {
				Toast.makeText(Login.this, "Error Login", Toast.LENGTH_LONG)
						.show();
				showDialog(ERROR_DIALOG);
			}
			removeDialog(LOGIN_DIALOG);
		}

	};
}
