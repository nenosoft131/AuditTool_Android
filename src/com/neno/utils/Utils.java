package com.neno.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import android.util.Base64;
import android.util.Log;

public class Utils {

	public static String TAG = "Utils";

	public static final String ACTION_LOG_IN = "action_log_in";
	public static final String ACTION_FORGOT_PASS = "action_forgot_pass";
	public static final String SERVER = "http://bizexac.com.au/bizexac_webservices/index.php";
	public static final String COMPLIANT[] = { "YES", "NO" };
	public static final String Evidence[] = {"Low","Medium", "High" };
	public static final String Evidence2[] = { "Nil" };

	public enum VideoQuality {
		MOBILE, SD, HD
	}

	;// ?????????????????

	public static boolean isEmailValid(String email) {
		boolean isValid = false;

		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr = email;

		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
		}
		return isValid;
	}

	public static File createCacheDir(Context context, String dirName) {
		File preparedDir;
		if (android.os.Environment.MEDIA_MOUNTED.equals(android.os.Environment
				.getExternalStorageState())) {
			preparedDir = context.getDir(dirName /*
												 * +
												 * UUID.randomUUID().toString()
												 */, Context.MODE_PRIVATE);
			Log.i(TAG,
					"Cache dir initialized at SD card "
							+ preparedDir.getAbsolutePath());
		} else {
			preparedDir = context.getCacheDir();
			Log.i(TAG,
					"Cache dir initialized at phone storage "
							+ preparedDir.getAbsolutePath());
		}
		if (!preparedDir.exists()) {
			Log.i(TAG, "Cache dir not existed, creating");
			preparedDir.mkdirs();
		}
		return preparedDir;
	}

	public static void copyStream(InputStream is, OutputStream os) {
		final int buffer_size = 1024;
		try {
			byte[] bytes = new byte[buffer_size];
			for (;;) {
				int count = is.read(bytes, 0, buffer_size);
				if (count == -1)
					break;
				os.write(bytes, 0, count);
			}
		} catch (Exception ex) {
		}
	}

	// bitmap to Base64 String

	public String bitmapToBase64(Bitmap bitmap) {

		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 90, stream);
		byte[] image = stream.toByteArray();
		// System.out.println("byte array:"+image);
		String img_str = Base64.encodeToString(image, 0);
		return img_str;

	}

}
