package com.neno.audittool;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Companydetails extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.companydetials);
	}

}
