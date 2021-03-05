package com.neno.audittool;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

public class Riskrating extends Activity {

	int num;
	ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.riskratting);
		num = getIntent().getExtras().getInt("res");
		iv = (ImageView) findViewById(R.id.ris_img);
		Resources res = this.getResources();
		int resID = res.getIdentifier("risk" + num, "drawable",
				this.getPackageName());
		iv.setImageResource(resID);
	}
}
