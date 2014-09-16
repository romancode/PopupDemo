package com.example.popupdemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.*;


public class PopupActivity extends Activity {

	Button btnShow, btnCancel;
	PopupWindow popUpWindow; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popup);

		Button btnShow=(Button)findViewById(R.id.btnShow);

		btnShow.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				showPopup();
			}
		});

	}
	private void showPopup(){
		try{
			LayoutInflater inflater = (LayoutInflater) PopupActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View layout = inflater.inflate(R.layout.window_popup,(ViewGroup) findViewById(R.id.layout_popup));
			popUpWindow = new PopupWindow(layout, 700, 600, true);
			popUpWindow.showAtLocation(layout, Gravity.CENTER, 0, 0);

			btnCancel = (Button) layout.findViewById(R.id.btnCancel);
			btnCancel.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {					
					popUpWindow.dismiss();
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


}
