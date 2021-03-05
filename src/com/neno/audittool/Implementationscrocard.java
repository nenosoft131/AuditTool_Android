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

public class Implementationscrocard extends Activity {
	int num;
	TextView q1, q2, q3, q4, q5, q6, q7, q8, q9, q10, q11, q12, q13, q14, q15,
			q16, q17, q18, q19, q20, q21, q22, q23, q24, q25, q26, q27, q28,
			q29, q30, q31, q32, q33, q34, q35;
	ImageView im1, im2, im3, im4, im5, im6, im7, im8, im9, im10, im11, im12,
			im13, im14, im15, im16, im17, im18, im19, im20, im21, im22, im23,
			im24, im25, im26, im27, im28, im29, im30, im31, im32, im33, im35,
			im34;
	ArrayList<Policy_Info> policyinfo;
	String policies_question[];
	public static int Implem_res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.implementationscorecard);
		init();
		policies_question = getResources().getStringArray(
				R.array.implementation_questions);
		num = getIntent().getExtras().getInt("res");
		Implem_res = num;
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
		q16.setText(policies_question[15]);
		q17.setText(policies_question[16]);
		q18.setText(policies_question[17]);
		q19.setText(policies_question[18]);
		q20.setText(policies_question[19]);
		q21.setText(policies_question[20]);
		q22.setText(policies_question[21]);
		q23.setText(policies_question[22]);
		q24.setText(policies_question[23]);
		q25.setText(policies_question[24]);
		q26.setText(policies_question[25]);
		q27.setText(policies_question[26]);
		q28.setText(policies_question[27]);
		q29.setText(policies_question[28]);
		q30.setText(policies_question[29]);
		q31.setText(policies_question[30]);
		q32.setText(policies_question[31]);
		q33.setText(policies_question[32]);
		q34.setText(policies_question[33]);
		q35.setText(policies_question[34]);

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
		im16.setImageResource(res.getIdentifier(policyinfo.get(15)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im17.setImageResource(res.getIdentifier(policyinfo.get(16)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im18.setImageResource(res.getIdentifier(policyinfo.get(17)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im19.setImageResource(res.getIdentifier(policyinfo.get(18)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im20.setImageResource(res.getIdentifier(policyinfo.get(19)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im21.setImageResource(res.getIdentifier(policyinfo.get(20)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im22.setImageResource(res.getIdentifier(policyinfo.get(21)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im23.setImageResource(res.getIdentifier(policyinfo.get(22)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im24.setImageResource(res.getIdentifier(policyinfo.get(23)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im25.setImageResource(res.getIdentifier(policyinfo.get(24)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im26.setImageResource(res.getIdentifier(policyinfo.get(25)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im27.setImageResource(res.getIdentifier(policyinfo.get(26)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im28.setImageResource(res.getIdentifier(policyinfo.get(27)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im29.setImageResource(res.getIdentifier(policyinfo.get(28)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im30.setImageResource(res.getIdentifier(policyinfo.get(29)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im31.setImageResource(res.getIdentifier(policyinfo.get(30)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im32.setImageResource(res.getIdentifier(policyinfo.get(31)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im33.setImageResource(res.getIdentifier(policyinfo.get(32)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im34.setImageResource(res.getIdentifier(policyinfo.get(33)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));
		im35.setImageResource(res.getIdentifier(policyinfo.get(34)
				.getRiskRating().toLowerCase()
				+ "1", "drawable", this.getPackageName()));

	}
	public void OnNextCLick(View v)
	{
		Intent i = new Intent(Implementationscrocard.this, measurment.class);
		i.putExtra("name", "Measurement & Evaluation");
		startActivity(i);
	}
	public void OnRiskRatingClick(View v) {
		Intent i = new Intent(Implementationscrocard.this, Riskrating.class);
		i.putExtra("res", num);
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
		q16 = (TextView) findViewById(R.id.tv_16);
		q17 = (TextView) findViewById(R.id.tv_17);
		q18 = (TextView) findViewById(R.id.tv_18);
		q19 = (TextView) findViewById(R.id.tv_19);
		q20 = (TextView) findViewById(R.id.tv_20);
		q21 = (TextView) findViewById(R.id.tv_21);
		q22 = (TextView) findViewById(R.id.tv_22);
		q23 = (TextView) findViewById(R.id.tv_23);
		q24 = (TextView) findViewById(R.id.tv_24);
		q25 = (TextView) findViewById(R.id.tv_25);
		q26 = (TextView) findViewById(R.id.tv_26);
		q27 = (TextView) findViewById(R.id.tv_27);
		q28 = (TextView) findViewById(R.id.tv_28);
		q29 = (TextView) findViewById(R.id.tv_29);
		q30 = (TextView) findViewById(R.id.tv_30);
		q31 = (TextView) findViewById(R.id.tv_31);
		q32 = (TextView) findViewById(R.id.tv_32);
		q33 = (TextView) findViewById(R.id.tv_33);
		q34 = (TextView) findViewById(R.id.tv_34);
		q35 = (TextView) findViewById(R.id.tv_35);

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
		im16 = (ImageView) findViewById(R.id.im_16);
		im17 = (ImageView) findViewById(R.id.im_17);
		im18 = (ImageView) findViewById(R.id.im_18);
		im19 = (ImageView) findViewById(R.id.im_19);
		im20 = (ImageView) findViewById(R.id.im_20);
		im21 = (ImageView) findViewById(R.id.im_21);
		im22 = (ImageView) findViewById(R.id.im_22);
		im23 = (ImageView) findViewById(R.id.im_23);
		im24 = (ImageView) findViewById(R.id.im_24);
		im25 = (ImageView) findViewById(R.id.im_25);
		im26 = (ImageView) findViewById(R.id.im_26);
		im27 = (ImageView) findViewById(R.id.im_27);
		im28 = (ImageView) findViewById(R.id.im_28);
		im29 = (ImageView) findViewById(R.id.im_29);
		im30 = (ImageView) findViewById(R.id.im_30);
		im31 = (ImageView) findViewById(R.id.im_31);
		im32 = (ImageView) findViewById(R.id.im_32);
		im33 = (ImageView) findViewById(R.id.im_33);
		im34 = (ImageView) findViewById(R.id.im_34);
		im35 = (ImageView) findViewById(R.id.im_35);

	}

}
