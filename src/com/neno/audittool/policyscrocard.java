package com.neno.audittool;

import java.util.ArrayList;

import com.neno.info.Policy_Info;
import com.neno.utils.Utils;
import com.neno.utils.createpdf;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class policyscrocard extends Activity {
	int num;
	TextView q1, q2, q3, q4;
	ImageView im1, im2, im3, im4;
	ArrayList<Policy_Info> policyinfo;
	String policies_question[];
	public static int Policy_res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.policyscorecard);
		init();
		policies_question = getResources().getStringArray(
				R.array.policy_questions);
		num = getIntent().getExtras().getInt("res");
		Policy_res=num;
		policyinfo = (ArrayList<Policy_Info>) getIntent().getExtras()
				.getSerializable("data");
		System.out.println("usmasn");
		filldata();

	}
	public void OnNextCLick(View v)
	{
		Intent i = new Intent(policyscrocard.this, planning.class);
		i.putExtra("name", "Planning");
		startActivity(i);
	}

	private void filldata() {
		// TODO Auto-generated method stub
		q1.setText(policies_question[0]);
		q2.setText(policies_question[1]);
		q3.setText(policies_question[2]);
		q4.setText(policies_question[3]);
		Resources res = this.getResources();
		im1.setImageResource(res.getIdentifier(policyinfo.get(0)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im2.setImageResource(res.getIdentifier(policyinfo.get(1)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im3.setImageResource(res.getIdentifier(policyinfo.get(2)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im4.setImageResource(res.getIdentifier(policyinfo.get(3)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));

	}

	public void OnRiskRatingClick(View v) {

		Intent i = new Intent(policyscrocard.this, Riskrating.class);
		i.putExtra("res", num);
		startActivity(i);
	}

	private void init() {
		// TODO Auto-generated method stub
		q1 = (TextView) findViewById(R.id.tv_ques1);
		q2 = (TextView) findViewById(R.id.tv_ques2);
		q3 = (TextView) findViewById(R.id.tv_ques3);
		q4 = (TextView) findViewById(R.id.tv_ques4);
		im1 = (ImageView) findViewById(R.id.iv_1);
		im2 = (ImageView) findViewById(R.id.iv_2);
		im3 = (ImageView) findViewById(R.id.iv_3);
		im4 = (ImageView) findViewById(R.id.iv4);

	}

}
