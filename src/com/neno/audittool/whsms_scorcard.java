package com.neno.audittool;

import java.util.ArrayList;

import com.neno.info.Policy_Info;
import com.neno.utils.Utils;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class whsms_scorcard extends Activity {
	int num;
	TextView q1;
	ImageView im1;
	ArrayList<Policy_Info> policyinfo;
	String policies_question[];
	public static int WHSMS_res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.recordmagmentscorecard);
		init();
		policies_question = getResources().getStringArray(
				R.array.whsms_audit);
		num = getIntent().getExtras().getInt("res");
		WHSMS_res=num;
		policyinfo = (ArrayList<Policy_Info>) getIntent().getExtras()
				.getSerializable("data");
		System.out.println("usmasn");
		filldata();

	}
	public void OnNextCLick(View v)
	{
		Intent i = new Intent(whsms_scorcard.this, managmentreview.class);
		i.putExtra("name", "Management Review");
		startActivity(i);
	}

	private void filldata() {
		// TODO Auto-generated method stub
		q1.setText(policies_question[0]);

		Resources res = this.getResources();
		im1.setImageResource(res.getIdentifier(policyinfo.get(0)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));

	}

	public void OnRiskRatingClick(View v) {
		Intent i = new Intent(whsms_scorcard.this, Riskrating.class);
		i.putExtra("res", num);
		startActivity(i);
	}

	private void init() {
		// TODO Auto-generated method stub
		q1 = (TextView) findViewById(R.id.tv_ques1);

		im1 = (ImageView) findViewById(R.id.iv_1);

	}

}
