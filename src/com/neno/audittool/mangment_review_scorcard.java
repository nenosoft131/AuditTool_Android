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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class mangment_review_scorcard extends Activity {
	int num;
	TextView q1, q2;
	ImageView im1, im2;
	ArrayList<Policy_Info> policyinfo;
	String policies_question[];
	public static int MR_res;
	Button b;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.policyscorecard);
		init();
		b = (Button) findViewById(R.id.button1);
		b.setVisibility(View.INVISIBLE);
		policies_question = getResources().getStringArray(
				R.array.management_review);
		num = getIntent().getExtras().getInt("res");
		MR_res = num;
		policyinfo = (ArrayList<Policy_Info>) getIntent().getExtras()
				.getSerializable("data");
		System.out.println("usmasn");
		filldata();

	}

	private void filldata() {
		// TODO Auto-generated method stub
		q1.setText(policies_question[0]);
		q2.setText(policies_question[1]);

		Resources res = this.getResources();
		im1.setImageResource(res.getIdentifier(policyinfo.get(0)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im2.setImageResource(res.getIdentifier(policyinfo.get(1)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));

	}

	public void OnRiskRatingClick(View v) {
		Intent i = new Intent(mangment_review_scorcard.this, Riskrating.class);
		i.putExtra("res", num);
		startActivity(i);
	}

	private void init() {
		// TODO Auto-generated method stub
		q1 = (TextView) findViewById(R.id.tv_ques1);
		q2 = (TextView) findViewById(R.id.tv_ques2);
		im1 = (ImageView) findViewById(R.id.iv_1);
		im2 = (ImageView) findViewById(R.id.iv_2);
	}

}
