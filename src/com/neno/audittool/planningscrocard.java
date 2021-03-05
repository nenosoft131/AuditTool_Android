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

public class planningscrocard extends Activity {
	int num;
	TextView q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15;
	ImageView im1, im2, im3, im4, im5, im6, im7, im8, im9, im10, im11, im12,
			im13, im14, im15;
	ArrayList<Policy_Info> policyinfo;
	String policies_question[];
	public static int Planning_res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.planningscorecard);
		init();
		policies_question = getResources().getStringArray(
				R.array.planning_questions);
		num = getIntent().getExtras().getInt("res");
		Planning_res=num;
		policyinfo = (ArrayList<Policy_Info>) getIntent().getExtras()
				.getSerializable("data");
		System.out.println("usmasn");
		filldata();

	}

	private void filldata() {
		// TODO Auto-generated method stub
		q1.setText(policies_question[0]);
		q2.setText(policies_question[1]);
		q3.setText(policies_question[2]);
		q4.setText(policies_question[3]);
		q5.setText(policies_question[4]);
		q6.setText(policies_question[5]);
		q7.setText(policies_question[6]);
		q8.setText(policies_question[7]);
		q9.setText(policies_question[8]);
		q10.setText(policies_question[9]);
		q11.setText(policies_question[10]);
		q12.setText(policies_question[11]);
		q13.setText(policies_question[12]);
		q14.setText(policies_question[13]);
		q15.setText(policies_question[14]);

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
		im5.setImageResource(res.getIdentifier(policyinfo.get(4)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im6.setImageResource(res.getIdentifier(policyinfo.get(5)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im7.setImageResource(res.getIdentifier(policyinfo.get(6)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im8.setImageResource(res.getIdentifier(policyinfo.get(7)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im9.setImageResource(res.getIdentifier(policyinfo.get(8)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im10.setImageResource(res.getIdentifier(policyinfo.get(9)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im11.setImageResource(res.getIdentifier(policyinfo.get(10)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im12.setImageResource(res.getIdentifier(policyinfo.get(11)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im13.setImageResource(res.getIdentifier(policyinfo.get(12)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im14.setImageResource(res.getIdentifier(policyinfo.get(13)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im15.setImageResource(res.getIdentifier(policyinfo.get(14)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));

	}

	public void OnRiskRatingClick(View v) {
		Intent i = new Intent(planningscrocard.this, Riskrating.class);
		i.putExtra("res", num);
		startActivity(i);
	}
	public void OnNextCLick(View v)
	{
		Intent i = new Intent(planningscrocard.this, implementation.class);
		i.putExtra("name", "Implementation");
		startActivity(i);
	}

	private void init() {
		// TODO Auto-generated method stub
		q1 = (TextView) findViewById(R.id.tv_1);
		q2 = (TextView) findViewById(R.id.tv_2);
		q3 = (TextView) findViewById(R.id.tv_3);
		q4 = (TextView) findViewById(R.id.tv_4);
		q5 = (TextView) findViewById(R.id.tv_5);
		q6 = (TextView) findViewById(R.id.tv_6);
		q7 = (TextView) findViewById(R.id.tv_7);
		q8 = (TextView) findViewById(R.id.tv_8);
		q9 = (TextView) findViewById(R.id.tv_9);
		q10 = (TextView) findViewById(R.id.tv_10);
		q11 = (TextView) findViewById(R.id.tv_11);
		q12 = (TextView) findViewById(R.id.tv_12);
		q13 = (TextView) findViewById(R.id.tv_13);
		q14 = (TextView) findViewById(R.id.tv_14);
		q15 = (TextView) findViewById(R.id.tv_15);

		im1 = (ImageView) findViewById(R.id.im_1);
		im2 = (ImageView) findViewById(R.id.im_2);
		im3 = (ImageView) findViewById(R.id.im_3);
		im4 = (ImageView) findViewById(R.id.im_4);
		im5 = (ImageView) findViewById(R.id.im_5);
		im6 = (ImageView) findViewById(R.id.im_6);
		im7 = (ImageView) findViewById(R.id.im_7);
		im8 = (ImageView) findViewById(R.id.im_8);
		im9 = (ImageView) findViewById(R.id.im_9);
		im10 = (ImageView) findViewById(R.id.im_10);
		im11 = (ImageView) findViewById(R.id.im_11);
		im12 = (ImageView) findViewById(R.id.im_12);
		im13 = (ImageView) findViewById(R.id.im_13);
		im14 = (ImageView) findViewById(R.id.im_14);
		im15 = (ImageView) findViewById(R.id.im_15);
	}

}
