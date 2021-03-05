package com.neno.audittool;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class fullScorecord extends Activity {

	ImageView iv1, iv2, iv3, iv4, iv5, iv6, iv7;
	TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7;
	String imagename[] = { "nil", "nil", "low", "medium", "high" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.fullscorecard);
		init();

	}

	private void init() {
		// TODO Auto-generated method stub
		iv1 = (ImageView) findViewById(R.id.iv_1);
		iv2 = (ImageView) findViewById(R.id.iv_2);
		iv3 = (ImageView) findViewById(R.id.iv_3);
		iv4 = (ImageView) findViewById(R.id.iv_4);
		iv5 = (ImageView) findViewById(R.id.iv_5);
		iv6 = (ImageView) findViewById(R.id.iv_6);
		iv7 = (ImageView) findViewById(R.id.iv_7);

		tv1 = (TextView) findViewById(R.id.tv_1);
		tv2 = (TextView) findViewById(R.id.tv_2);
		tv3 = (TextView) findViewById(R.id.tv_3);
		tv4 = (TextView) findViewById(R.id.tv_4);
		tv5 = (TextView) findViewById(R.id.tv_5);
		tv6 = (TextView) findViewById(R.id.tv_6);
		tv7 = (TextView) findViewById(R.id.tv_7);

		update();

	}

	private void update() {
		// TODO Auto-generated method stub

		Resources res = this.getResources();
		tv1.setText("Policy");
		iv1.setImageResource(res.getIdentifier(
				imagename[policyscrocard.Policy_res], "drawable",
				this.getPackageName()));
		tv2.setText("Planning");
		iv2.setImageResource(res.getIdentifier(
				imagename[planningscrocard.Planning_res], "drawable",
				this.getPackageName()));
		tv3.setText("Implementation");
		iv3.setImageResource(res.getIdentifier(
				imagename[Implementationscrocard.Implem_res], "drawable",
				this.getPackageName()));
		tv4.setText("Measurement & Evaluation");
		iv4.setImageResource(res.getIdentifier(
				imagename[measurment_scrocard.Measue_res], "drawable",
				this.getPackageName()));
		tv5.setText("Records Management");
		iv5.setImageResource(res.getIdentifier(
				imagename[record_mangment_scorcard.Rec_res], "drawable",
				this.getPackageName()));
		tv6.setText("WHSMS Audit");
		iv6.setImageResource(res.getIdentifier(
				imagename[whsms_scorcard.WHSMS_res], "drawable",
				this.getPackageName()));
		tv7.setText("Management Review");
		iv7.setImageResource(res.getIdentifier(
				imagename[mangment_review_scorcard.MR_res], "drawable",
				this.getPackageName()));

	}
}
