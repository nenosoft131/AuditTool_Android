package com.neno.audittool;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import com.neno.info.Policy_Info;
import com.neno.utils.Utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class measurment extends Activity {
	Spinner sp_complaints, sp_evidence;
	ImageView im;
	TextView question, top;
	EditText findings;
	Typeface myfont;
	private int myYear, myMonth, myDay;
	static final int ID_DATEPICKER = 3;
	String[] policies_question;
	int count = 0;

	boolean check = true;
	int Average;
	String Date = "";
	TextView setdate, dateclick;
	public static ArrayList<Policy_Info> measurment_info = new ArrayList<Policy_Info>();
	Policy_Info policyinfo;
	int Increament = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.questions);
		policies_question = getResources().getStringArray(
				R.array.measurment_questions);
		myfont = Typeface.createFromAsset(getAssets(), "gothic.ttf");
		addvalues();
		init();
	}

	private void addvalues() {
		// TODO Auto-generated method stub
		measurment_info.clear();
		for (int i = 0; i < policies_question.length; i++) {
			policyinfo = new Policy_Info();

			policyinfo.setComplaint("");
			policyinfo.setEvidence("");
			policyinfo.setFindings("");
			policyinfo.setDate("");

			measurment_info.add(Increament, policyinfo);
		}

	}

	public void OnBackClick(View v) {

		Increament--;
		if (Increament < 0) {
			Increament = 0;
		}
		diplay();

	}

	public void OnFarwordClick(View v) {

		if (checkfields()) {
			savedata();
			Increament++;
			if (Increament > policies_question.length - 1) {
				Increament = policies_question.length - 1;
				checkresult();
				Intent i = new Intent(measurment.this,
						measurment_scrocard.class);
				i.putExtra("res", Average);
				i.putExtra("data", measurment_info);
				startActivity(i);
			}
			diplay();
		}

	}

	private void diplay() {

		// TODO Auto-generated method stub

		if (measurment_info.get(Increament).getDate().equals("")) {

			setdate.setText("");
			Date="";

		} else {
			Date = measurment_info.get(Increament).getDate();
			setdate.setText(measurment_info.get(Increament).getDate());
		}

		if (measurment_info.get(Increament).getComplaint().equals("")) {

			sp_complaints.setSelection(0);
			sp_evidence.setAdapter(new ArrayAdapter<String>(measurment.this,
					R.layout.spinner_item, Utils.Evidence2));
		} else {
			if (measurment_info.get(Increament).getComplaint().equals("NO")) {
				sp_complaints.setSelection(1);
				sp_evidence
						.setAdapter(new ArrayAdapter<String>(measurment.this,
								R.layout.spinner_item, Utils.Evidence));
			} else {
				sp_complaints.setSelection(0);
				sp_evidence
						.setAdapter(new ArrayAdapter<String>(measurment.this,
								R.layout.spinner_item, Utils.Evidence2));
			}
		}
		question.setText(policies_question[Increament]);
		if (measurment_info.get(Increament).getFindings().equals("")) {
			findings.setText("");
		} else {
			findings.setText(measurment_info.get(Increament).getFindings());
		}
		if (measurment_info.get(Increament).getEvidence().equals("")) {

			updateimage(0);
		} else {

			updateimage(Integer.parseInt(measurment_info.get(Increament)
					.getEvidence()) - 1);

		}
		if (measurment_info.get(Increament).getEvidence().equals("")) {

			sp_evidence.setSelection(0);

		} else {

			if (measurment_info.get(Increament).getComplaint().equals("NO")) {
				sp_evidence.setSelection(Integer.parseInt(measurment_info.get(
						Increament).getEvidence()) - 1);
				check = false;
			} else {
				sp_evidence.setSelection(0);
			}

		}

	}

	private void init() {
		// TODO Auto-generated method stub

		question = (TextView) findViewById(R.id.tv_question);
		top = (TextView) findViewById(R.id.tv_top);

		question.setTypeface(myfont);
		findings = (EditText) findViewById(R.id.ed_findings);
		sp_complaints = (Spinner) findViewById(R.id.spinner1);

		sp_evidence = (Spinner) findViewById(R.id.spinner3);
		im = (ImageView) findViewById(R.id.imageView1);
		dateclick = (TextView) findViewById(R.id.textView6);
		setdate = (TextView) findViewById(R.id.tv_date);

		dateclick.setOnTouchListener(new OnTouchListener() {

			@Override
			public boolean onTouch(View arg0, MotionEvent event) {
				// TODO Auto-generated method stub
				switch (event.getAction()) {
				case MotionEvent.ACTION_UP:
					showDatePicker();
					break;
				}
				return false;

			}
		});

		initvalue();

		sp_complaints.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if (check) {

					if (Utils.COMPLIANT[sp_complaints.getSelectedItemPosition()]
							.equals("YES")) {
						sp_evidence.setAdapter(new ArrayAdapter<String>(
								measurment.this, R.layout.spinner_item,
								Utils.Evidence2));
					} else {
						sp_evidence.setAdapter(new ArrayAdapter<String>(
								measurment.this, R.layout.spinner_item,
								Utils.Evidence));
					}

					updateimage(sp_evidence.getSelectedItemPosition());
				}

				else {
					check = true;
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

		sp_evidence.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				if (check) {
					updateimage(sp_evidence.getSelectedItemPosition());
				} else

				{
					check = true;
				}
				updateimage(sp_evidence.getSelectedItemPosition());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void updateimage(int selectedItemPosition) {
		// TODO Auto-generated method stub
		if (sp_evidence.getSelectedItem().toString().equals("Nil")) {
			im.setImageResource(R.drawable.nil);
		} else if (sp_evidence.getSelectedItem().toString().equals("Low")) {
			im.setImageResource(R.drawable.low);
		} else if (sp_evidence.getSelectedItem().toString().equals("Medium")) {
			im.setImageResource(R.drawable.medium);
		} else if (sp_evidence.getSelectedItem().toString().equals("High")) {
			im.setImageResource(R.drawable.high);
		}

	}

	



	private void initvalue() {
		// TODO Auto-generated method stub
		top.setText(getIntent().getExtras().getString("name"));
		sp_complaints.setAdapter(new ArrayAdapter<String>(this,
				R.layout.spinner_item, Utils.COMPLIANT));

		sp_evidence.setAdapter(new ArrayAdapter<String>(this,
				R.layout.spinner_item, Utils.Evidence));
		question.setText(policies_question[count]);
		findings.setText("");

	}

	private void checkresult() {
		// TODO Auto-generated method stub
		int total = 0;
		for (int k = 0; k < measurment_info.size(); k++) {
			total += Integer.parseInt(measurment_info.get(k).getEvidence());
			if (measurment_info.get(k).getComplaint().equalsIgnoreCase("YES")) {

			} else {
				total++;
			}

		}
		Average = total / measurment_info.size();

	}

	private boolean checkfields() {
		// TODO Auto-generated method stub
		Date=setdate.getText().toString();
		if (findings.getText().length() == 0) {
			findings.setError("Please Enter Findings..");
			findings.requestFocus();
			return false;
		} else if (Date.length() == 0) {
			dateclick.setError("Please Select Date..");
			dateclick.requestFocus();
			return false;
		}

		else {

			return true;
		}
	}

	private void savedata() {
		// TODO Auto-generated method stub
		policyinfo = new Policy_Info();

		policyinfo.setComplaint(Utils.COMPLIANT[sp_complaints
				.getSelectedItemPosition()]);
		if(sp_complaints.getSelectedItem().toString().equals("NO"))
		{
			policyinfo.setEvidence(Integer.toString(sp_evidence
					.getSelectedItemPosition() + 1));
		}
		else
		{
		policyinfo.setEvidence(Integer.toString(sp_evidence
				.getSelectedItemPosition() + 1));
		}
		policyinfo.setFindings(findings.getText().toString());
		policyinfo.setDate(Date);
		policyinfo.setRiskRating(sp_evidence.getSelectedItem().toString());
		measurment_info.remove(Increament);
		measurment_info.add(Increament, policyinfo);

	}

	private void updatefields() {
		// TODO Auto-generated method stub
		initvalue();

	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		finish();
		super.onStop();
	}
	public void showDatePicker() {
		// Initializiation
		LayoutInflater inflater = (LayoutInflater) getLayoutInflater();
		final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
		View customView = inflater.inflate(R.layout.main, null);
		dialogBuilder.setView(customView);
		final Calendar now = Calendar.getInstance();
		final DatePicker datePicker = (DatePicker) customView
				.findViewById(R.id.dialog_datepicker);
		final TextView dateTextView = (TextView) customView
				.findViewById(R.id.dialog_dateview);
		final SimpleDateFormat dateViewFormatter = new SimpleDateFormat(
				"EEEE, dd.MM.yyyy", Locale.getDefault());
		final SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy",
				Locale.getDefault());
		// Minimum date
		Calendar minDate = Calendar.getInstance();
		try {
			minDate.setTime(formatter.parse("12.12.2010"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// datePicker.setMinDate(minDate.getTimeInMillis());
		// View settings
		dialogBuilder.setTitle("Choose a date");
		Calendar choosenDate = Calendar.getInstance();
		int year = choosenDate.get(Calendar.YEAR);
		int month = choosenDate.get(Calendar.MONTH);
		int day = choosenDate.get(Calendar.DAY_OF_MONTH);
		try {
			// String choosenDateFromUI = formatter.parse(
			// setdate.getText().toString()
			// );
			// choosenDate.setTime(choosenDateFromUI);
			year = choosenDate.get(Calendar.YEAR);
			month = choosenDate.get(Calendar.MONTH);
			day = choosenDate.get(Calendar.DAY_OF_MONTH);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Calendar dateToDisplay = Calendar.getInstance();
		dateToDisplay.set(year, month, day);
		dateTextView.setText(dateViewFormatter.format(dateToDisplay.getTime()));
		// Buttons
		dialogBuilder.setNegativeButton("Go to today",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						setdate.setText(formatter.format(now.getTime()));
						dialog.dismiss();
					}
				});
		dialogBuilder.setPositiveButton("Choose",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Calendar choosen = Calendar.getInstance();
						choosen.set(datePicker.getYear(),
								datePicker.getMonth(),
								datePicker.getDayOfMonth());
						setdate.setText(dateViewFormatter.format(choosen
								.getTime()));
						dialog.dismiss();
					}
				});
		final AlertDialog dialog = dialogBuilder.create();
		// Initialize datepicker in dialog atepicker
		datePicker.init(year, month, day,
				new DatePicker.OnDateChangedListener() {
					public void onDateChanged(DatePicker view, int year,
							int monthOfYear, int dayOfMonth) {
						Calendar choosenDate = Calendar.getInstance();
						choosenDate.set(year, monthOfYear, dayOfMonth);
						dateTextView.setText(dateViewFormatter
								.format(choosenDate.getTime()));
						if (choosenDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
								|| now.compareTo(choosenDate) < 0) {
							dateTextView.setTextColor(Color
									.parseColor("#000000"));
							((Button) dialog
									.getButton(AlertDialog.BUTTON_POSITIVE))
									.setEnabled(true);
						} else {
							dateTextView.setTextColor(Color
									.parseColor("#000000"));
							((Button) dialog
									.getButton(AlertDialog.BUTTON_POSITIVE))
									.setEnabled(true);
						}
					}
				});
		// Finish
		dialog.show();
	}

}
