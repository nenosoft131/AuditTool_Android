package com.neno.audittool;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;

public class OvAriskrating extends Activity {

	int count = 1, num = 0;
	ImageView iv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.completeriskratting);
		addingall();

	}

	private void addingall() {
		// TODO Auto-generated method stub
		count += policyscrocard.Policy_res;
		count += planningscrocard.Planning_res;
		count += Implementationscrocard.Implem_res;
		count += measurment_scrocard.Measue_res;
		count += record_mangment_scorcard.Rec_res;
		count += whsms_scorcard.WHSMS_res;
		count += mangment_review_scorcard.MR_res;
		num = count / 7;
		iv = (ImageView) findViewById(R.id.ris_img);
		Resources res = this.getResources();
		int resID = res.getIdentifier("risk" + num, "drawable",
				this.getPackageName());
		iv.setImageResource(resID);

	}

}
