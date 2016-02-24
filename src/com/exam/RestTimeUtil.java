package com.exam;

import android.os.CountDownTimer;
import android.widget.TextView;

public class RestTimeUtil {

	protected static CountDownTimer mCountDownTimer;
	private static long mHours;
	private static long mMinutes;
	private static long mSeconds;
	private static long ml_Time= 1 * 60 * 60 * 1000 + 6*1000;
//	private static long ml_Time= 15 * 1000;
	

	public static void startTime(TextView bt_restTime) {
//		bt_restTime.setBackgroundResource(R.drawable.button_mlstartwork);
		getTime(bt_restTime);
		getCountDownTimer(bt_restTime).start();
//		bt_restTime.setText("");
	}

	public static void pauseTime(TextView bt_restTime) {
//		bt_restTime.setBackgroundResource(R.drawable.button_mlstopwork);
		getCountDownTimer(bt_restTime).cancel();
		mCountDownTimer = null;
		bt_restTime.setText(bt_restTime.getText().toString());
	}

	/** 倒计时的显示 */
	private static void getTime(TextView tv_restTime) {
		mHours = ml_Time / (1000 * 60 * 60);
		mMinutes = (ml_Time - mHours * (1000 * 60 * 60))
				/ (1000 * 60);
		mSeconds = (ml_Time - mHours * (1000 * 60 * 60) - mMinutes
				* (1000 * 60)) / (1000);
		if (mHours == 0) {
			if (mMinutes == 0) {
				if (mSeconds == 0) {
					tv_restTime.setText("0" + mHours + ":" + "0"
							+ mMinutes + ":" + "0" + mSeconds);
				} else if (mSeconds >10) {
					mSeconds--;
					tv_restTime.setText("0" + mHours + ":" + "0"
							+ mMinutes + ":" + mSeconds);
					
				} else {
					mSeconds--;
					tv_restTime.setText("0" + mHours + ":" + "0"
							+ mMinutes + ":" + "0" + mSeconds);
				}
			} 
			else if (mMinutes > 10) {
				if (mSeconds == 0) {
					mSeconds = 59;
					tv_restTime.setText("0" + mHours + ":"
							+ mMinutes + ":" + mSeconds);
				} else if (mSeconds > 10) {
					tv_restTime.setText("0" + mHours + ":"
							+ mMinutes + ":" + mSeconds);
					mSeconds--;
				} else {
					mSeconds--;
					tv_restTime.setText("0" + mHours + ":"
							+ mMinutes + ":" + "0" + mSeconds);
				}
				mMinutes--;
			} else {
				if (mSeconds == 0) {
					mSeconds = 59;
					tv_restTime.setText("0" + mHours + ":" + "0"
							+ mMinutes + ":" + mSeconds);
				} else if (mSeconds > 10) {
					tv_restTime.setText("0" + mHours + ":" + "0"
							+ mMinutes + ":" + mSeconds);
					mSeconds--;
				} else {
					mSeconds--;
					tv_restTime.setText("0" + mHours + ":" + "0"
							+ mMinutes + ":" + "0" + mSeconds);
				}
			}
			mMinutes--;
		} else if (mHours >= 10) {

			if (mMinutes == 0) {
				mMinutes = 59;
				tv_restTime.setText(mHours + ":" + mMinutes + ":"
						+ mSeconds);
				if (mSeconds == 0) {
					mSeconds = 59;
					tv_restTime.setText(mHours + ":" + mMinutes
							+ ":" + mSeconds);
				} else if (mSeconds > 10) {
					mSeconds--;
					tv_restTime.setText(mHours + ":" + mMinutes
							+ ":" + mSeconds);
				} else {
					mSeconds--;
					tv_restTime.setText(mHours + ":" + "0"
							+ mMinutes + ":" + "0" + mSeconds);
				}
			} else if (mMinutes > 10) {
				tv_restTime.setText(mHours + ":" + mMinutes + ":"
						+ mSeconds);
				if (mSeconds == 0) {
					mSeconds = 59;
					tv_restTime.setText(mHours + ":" + mMinutes
							+ ":" + mSeconds);
				} else if (mSeconds > 10) {
					tv_restTime.setText(mHours + ":" + mMinutes
							+ ":" + mSeconds);
					mSeconds--;
				} else {
					mSeconds--;
					tv_restTime.setText(mHours + ":" + mMinutes
							+ ":" + "0" + mSeconds);
				}
				mMinutes--;
			} else {
				if (mSeconds == 0) {
					mSeconds = 59;
					tv_restTime.setText(mHours + ":" + "0"
							+ mMinutes + ":" + "0" + mSeconds);
				} else if (mSeconds > 10) {
					tv_restTime.setText(mHours + ":" + "0"
							+ mMinutes + ":" + mSeconds);
					mSeconds--;
				} else {
					mSeconds--;
					tv_restTime.setText(mHours + ":" + "0"
							+ mMinutes + ":" + "0" + mSeconds);
				}
				mMinutes--;
			}
			mHours--;
		} else {//小时数在1~9
			if (mMinutes == 0) {
//				mMinutes = 59;
				if (mSeconds == 0) {
					mSeconds = 59;
					tv_restTime.setText("0" + mHours + ":" +"0"
							+ mMinutes + ":" + mSeconds);
				} else if (mSeconds > 10) {
					tv_restTime.setText("0" + mHours + ":" +"0"
							+ mMinutes + ":" + mSeconds);
					mSeconds--;
				} else {
					mSeconds--;
					tv_restTime.setText("0" + mHours + ":" +"0"
							+ mMinutes + ":" + "0" + mSeconds);
				}
			} else if (mMinutes > 10) {
				tv_restTime.setText("0" + mHours + ":" + mMinutes
						+ ":" + mSeconds);
				if (mSeconds == 0) {
					mSeconds = 59;
					tv_restTime.setText("0" + mHours + ":"
							+ mMinutes + ":" + mSeconds);
				} else if (mSeconds > 10) {
					tv_restTime.setText("0" + mHours + ":"
							+ mMinutes + ":" + mSeconds);
					mSeconds--;
				} else {
					mSeconds--;
					tv_restTime.setText("0" + mHours + ":"
							+ mMinutes + ":" + "0" + mSeconds);
				}
				mMinutes--;
			} else {
				mMinutes--;
				if (mSeconds == 0) {
					mSeconds = 59;
					tv_restTime.setText("0" + mHours + ":" + "0"
							+ mMinutes + ":" + mSeconds);
				} else if (mSeconds > 10) {
					tv_restTime.setText("0" + mHours + ":" + "0"
							+ mMinutes + ":" + mSeconds);
					mSeconds--;
				} else {
					mSeconds--;
					tv_restTime.setText("0" + mHours + ":" + "0"
							+ mMinutes + ":" + "0" + mSeconds);
				}
			}
			mHours--;
		}
	}

	public static CountDownTimer getCountDownTimer(final TextView tv_restTime) {
		if (mCountDownTimer == null) {
			mCountDownTimer = new CountDownTimer(ml_Time, 1000) {
				@Override
				public void onTick(long millisUntilFinished) {
					ml_Time = millisUntilFinished;
					getTime(tv_restTime);
				}

				@Override
				public void onFinish() {
//					bt_restTime.setEnabled(true);
//					bt_restTime.setBackgroundResource(R.drawable.button_mlstopwork);
					tv_restTime.setText("时间到！");
				}
			};
		}
		return mCountDownTimer;
	}
}
