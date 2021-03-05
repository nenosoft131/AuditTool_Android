package com.neno.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.neno.audittool.R;
import com.neno.audittool.implementation;
import com.neno.audittool.managmentreview;
import com.neno.audittool.measurment;
import com.neno.audittool.planning;
import com.neno.audittool.policy;
import com.neno.audittool.recordmangment;
import com.neno.audittool.whsmaudit;

public class createpdf {
	String question[], rationale[];
	Context current_context;
	FontFactory f;

	File myFile = new File("/sdcard/safetyriskrating.pdf");
	static Font textFont;
	private static Font catFont = new Font(Font.FontFamily.HELVETICA, 18,
			Font.BOLD);
	private static Font typeFont = new Font(Font.FontFamily.HELVETICA, 30,
			Font.NORMAL, BaseColor.BLACK);
	private static Font whiteFont = new Font(Font.FontFamily.HELVETICA, 12,
			Font.BOLD, BaseColor.WHITE);
	private static Font mainFont = new Font(Font.FontFamily.HELVETICA, 35,
			Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.HELVETICA, 12,
			Font.NORMAL, BaseColor.RED);

	public void CreatePDF(Context con) {
		try {
			myFile.createNewFile();
			this.current_context = con;
			question = current_context.getResources().getStringArray(
					R.array.policy_questions);
			rationale = current_context.getResources().getStringArray(
					R.array.policy_rationale);
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(myFile));
			document.open();

			setBackground(document);
			addMetaData(document);
			addTitlePage(document);

			addmainpage(document, "Safety Risk Rating \n     Audit Report");
			document.newPage();

			setBackgroundquestions(document);
			addpolicyquestionsanswers(document, question, rationale);

			question = current_context.getResources().getStringArray(
					R.array.planning_questions);
			rationale = current_context.getResources().getStringArray(
					R.array.planning_rationale);
			addplanningquestionsanswers(document, question, rationale);

			 question = current_context.getResources().getStringArray(
			 R.array.implementation_questions);
			 addimplmentationquestionsanswers(document, question);
			
			 question = current_context.getResources().getStringArray(
			 R.array.measurment_questions);
			 addmeasuemntquestionsanswers(document, question);
			
			 question = current_context.getResources().getStringArray(
			 R.array.records_management);
			 addrecordquestionsanswers(document, question);
			
			 question = current_context.getResources().getStringArray(
			 R.array.whsms_audit);
			 addwhsmsquestionsanswers(document, question);
			
			 question = current_context.getResources().getStringArray(
			 R.array.management_review);
			 addmangrevquestionsanswers(document, question);

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	private void addback(Document document) throws MalformedURLException,
//			IOException, DocumentException {
//
//		ByteArrayOutputStream stream = new ByteArrayOutputStream();
//		Bitmap bitmap = null;
//		bitmap = BitmapFactory.decodeResource(current_context.getResources(),
//				R.drawable.repback);
//		bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
//		Image img;
//
//		img = Image.getInstance(stream.toByteArray());
//		img.setAbsolutePosition(20, 620);
//
//		document.add(img);
//
//	}

	private void addriskrates(Document document, String rr)
			throws DocumentException, MalformedURLException, IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Bitmap bitmap = null;
		if (rr.equals("Nil")) {
			bitmap = BitmapFactory.decodeResource(
					current_context.getResources(), R.drawable.nilr);
		} else if (rr.equals("Medium")) {
			bitmap = BitmapFactory.decodeResource(
					current_context.getResources(), R.drawable.mediumr);
		} else if (rr.equals("Low")) {
			bitmap = BitmapFactory.decodeResource(
					current_context.getResources(), R.drawable.lowr);
		} else if (rr.equals("High")) {
			bitmap = BitmapFactory.decodeResource(
					current_context.getResources(), R.drawable.highr);
		}

		bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
		Image img;

		img = Image.getInstance(stream.toByteArray());
		img.setAbsolutePosition(300, 130);

		document.add(img);

	}

	private void addquestion(Document document, String string)
			throws DocumentException {
		// TODO Auto-generated method stub

		String k = getThirtyCharPerLineString(string);

		Font f = new Font(FontFamily.TIMES_ROMAN, 15.0f, Font.BOLD,
				BaseColor.WHITE);
		Chunk c = new Chunk(k, f);
		// c.setBackground(BaseColor.WHITE);
		Paragraph p = new Paragraph(c);
		document.add(p);
	}

	public String getThirtyCharPerLineString(String text) {

		String tenCharPerLineString = "";
		while (text.length() > 30) {

			String buffer = text.substring(0, 30);
			tenCharPerLineString = tenCharPerLineString + buffer + "\n";
			text = text.substring(30);
		}

		tenCharPerLineString = tenCharPerLineString + text.substring(0);
		return tenCharPerLineString;
	}

	private void addtype(Document document, String name)
			throws DocumentException {
		// TODO Auto-generated method stub
		Paragraph preface = new Paragraph();
		preface.add(new Paragraph(name, typeFont));
		addEmptyLine(preface, 1);
		document.add(preface);

	}

	private void setBackground(Document document) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Bitmap bitmap = BitmapFactory.decodeResource(
				current_context.getResources(), R.drawable.aa2);
		bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
		Image img;
		try {
			img = Image.getInstance(stream.toByteArray());
			img.setAbsolutePosition(0, 0);

			document.add(img);
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void setBackgroundquestions(Document document) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		Bitmap bitmap = BitmapFactory.decodeResource(
				current_context.getResources(), R.drawable.aa4);
		bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
		Image img;
		try {
			img = Image.getInstance(stream.toByteArray());
			img.setAbsolutePosition(0, 0);

			document.add(img);
		} catch (BadElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void addplanningquestionsanswers(Document document,
			String[] policies_question2, String[] rationale2)
			throws DocumentException, MalformedURLException, IOException {

		for (int i = 0; i < policies_question2.length; i++) {

			addtype(document, "Planning");
			addquestion(document, policies_question2[i]);
			if (rationale[i].length() > 0) {
				addtype(document, "Rationale");
				addquestion(document, rationale[i]);
			}
			addtype(document, "Findings");
			if (planning.planning_info.size() > 0) {
				if (planning.planning_info.get(i).getFindings().length() > 0) {
					addquestion(document, planning.planning_info.get(i)
							.getFindings());
				}
			}
			if (planning.planning_info.size() > 0) {
				if (planning.planning_info.get(i).getFindings().length() > 0) {
					addriskrates(document, planning.planning_info.get(i)
							.getRiskRating());
				} else {
					addriskrates(document, "High");
					//addback(document);
				}
			} else {
				addriskrates(document, "High");
				//addback(document);
			}
			document.newPage();
			setBackgroundquestions(document);
		}

	}

	private void addimplmentationquestionsanswers(Document document,
			String[] policies_question2) throws DocumentException,
			MalformedURLException, IOException {

		for (int i = 0; i < policies_question2.length; i++) {

			addtype(document, "Implmentation");
			addquestion(document, policies_question2[i]);
			addtype(document, "Findings");
			if (implementation.implementation_info.size() > 0) {
				if (implementation.implementation_info.get(i).getFindings()
						.length() > 0) {
					addquestion(document, implementation.implementation_info
							.get(i).getFindings());
				}
			}
			if (implementation.implementation_info.size() > 0) {
				if (implementation.implementation_info.get(i).getFindings()
						.length() > 0) {
					addriskrates(document, implementation.implementation_info
							.get(i).getRiskRating());
				} else {
					addriskrates(document, "High");
				}
			} else {
				addriskrates(document, "High");
			}
			document.newPage();
			setBackgroundquestions(document);
		}

	}

	private void addmeasuemntquestionsanswers(Document document,
			String[] policies_question2) throws DocumentException,
			MalformedURLException, IOException {

		for (int i = 0; i < policies_question2.length; i++) {

			addtype(document, "Measurement and \n     Evaluation ");
			addquestion(document, policies_question2[i]);
			addtype(document, "Findings");
			if (measurment.measurment_info.size() > 0) {
				if (measurment.measurment_info.get(i).getFindings().length() > 0) {
					addquestion(document, measurment.measurment_info.get(i)
							.getFindings());
				}
			}
			if (measurment.measurment_info.size() > 0) {
				if (measurment.measurment_info.get(i).getFindings().length() > 0) {
					addriskrates(document, measurment.measurment_info.get(i)
							.getRiskRating());
				} else {
					addriskrates(document, "High");
				}
			} else {
				addriskrates(document, "High");
			}
			document.newPage();
			setBackgroundquestions(document);
		}

	}

	private void addrecordquestionsanswers(Document document,
			String[] policies_question2) throws DocumentException,
			MalformedURLException, IOException {

		for (int i = 0; i < policies_question2.length; i++) {

			addtype(document, "Records Managment");
			addquestion(document, policies_question2[i]);
			addtype(document, "Findings");
			if (recordmangment.record_info.size() > 0) {
				if (recordmangment.record_info.get(i).getFindings().length() > 0) {
					addquestion(document, recordmangment.record_info.get(i)
							.getFindings());
				}
			}
			if (recordmangment.record_info.size() > 0) {
				if (recordmangment.record_info.get(i).getFindings().length() > 0) {
					addriskrates(document, recordmangment.record_info.get(i)
							.getRiskRating());
				} else {
					addriskrates(document, "High");
				}
			} else {
				addriskrates(document, "High");
			}
			document.newPage();
			setBackgroundquestions(document);
		}

	}

	private void addwhsmsquestionsanswers(Document document,
			String[] policies_question2) throws DocumentException,
			MalformedURLException, IOException {

		for (int i = 0; i < policies_question2.length; i++) {

			addtype(document, "WHSMS Audit");
			addquestion(document, policies_question2[i]);
			addtype(document, "Findings");
			if (whsmaudit.whsm_info.size() > 0) {
				if (whsmaudit.whsm_info.get(i).getFindings().length() > 0) {
					addquestion(document, whsmaudit.whsm_info.get(i)
							.getFindings());
				}
			}
			if (whsmaudit.whsm_info.size() > 0) {
				if (whsmaudit.whsm_info.get(i).getFindings().length() > 0) {
					addriskrates(document, whsmaudit.whsm_info.get(i)
							.getRiskRating());
				} else {
					addriskrates(document, "High");
				}
			} else {
				addriskrates(document, "High");
			}
			document.newPage();
			setBackgroundquestions(document);
		}

	}

	private void addmangrevquestionsanswers(Document document,
			String[] policies_question2) throws DocumentException,
			MalformedURLException, IOException {

		for (int i = 0; i < policies_question2.length; i++) {

			addtype(document, "Managment Review");
			addquestion(document, policies_question2[i]);
			addtype(document, "Findings");
			if (managmentreview.managmengrev_info.size() > 0) {
				if (managmentreview.managmengrev_info.get(i).getFindings()
						.length() > 0) {
					addquestion(document, managmentreview.managmengrev_info
							.get(i).getFindings());
				}
			}
			if (managmentreview.managmengrev_info.size() > 0) {
				if (managmentreview.managmengrev_info.get(i).getFindings()
						.length() > 0) {
					addriskrates(document, managmentreview.managmengrev_info
							.get(i).getRiskRating());
				} else {
					addriskrates(document, "High");
				}
			} else {
				addriskrates(document, "High");
			}
			document.newPage();
			setBackgroundquestions(document);
		}

	}

	// iText allows to add metadata to the PDF which can be viewed in your Adobe
	// Reader
	// under File -> Properties
	private static void addMetaData(Document document) {
		document.addTitle("AuditTool");
		document.addAuthor("Micheal");
		document.addCreator("Neno");
	}

	private static void addTitlePage(Document document)
			throws DocumentException {
		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);
		preface.add(new Paragraph("", textFont));

		document.add(preface);
	}

	private static void addmainpage(Document document, String name)
			throws DocumentException {

		Paragraph preface = new Paragraph();
		addEmptyLine(preface, 1);
		preface.add(new Paragraph(name, mainFont));
		addEmptyLine(preface, 1);

		Calendar c = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		String formattedDate = df.format(c.getTime());

		preface.add(new Paragraph("      " + formattedDate, mainFont));
		addEmptyLine(preface, 22);
		preface.add(new Paragraph("Safety Audits made \n         Simple",
				catFont));
		addEmptyLine(preface, 2);
		preface.add(new Paragraph("www.safetyriskrating.com.au", whiteFont));
		document.add(preface);
	}

	private void addpolicyquestionsanswers(Document document,
			String[] policies_question2, String[] rationale)
			throws DocumentException, MalformedURLException, IOException {

		for (int i = 0; i < policies_question2.length; i++) {

			addtype(document, "Policy");
			addquestion(document, policies_question2[i]);
			if (rationale[i].length() > 0) {
				addtype(document, "Rationale");
				addquestion(document, rationale[i]);
			}
			addtype(document, "Findings");
			if (policy.poicy_info.size() > 0) {
				if (policy.poicy_info.get(i).getFindings().length() > 0) {
					addquestion(document, policy.poicy_info.get(i)
							.getFindings());
				}
			}
			if (policy.poicy_info.size() > 0) {
				if (policy.poicy_info.get(i).getFindings().length() > 0) {
					addriskrates(document, policy.poicy_info.get(i)
							.getRiskRating());
					//addback(document);
				} else {
					addriskrates(document, "High");
					//addback(document);
				}
			} else {
				addriskrates(document, "High");
				//addback(document);
			}
			document.newPage();
			setBackgroundquestions(document);
		}
	}

	public String answer(String number, String comp) {

		if (comp.equals("YES")) {

			return "Nil";
		} else {
			if (number.equals("1")) {
				return "Low";
			} else if (number.equals("2")) {
				return "Medium";
			} else if (number.equals("3")) {
				return "Heigh";
			} else {
				return "";
			}

		}
	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}
}