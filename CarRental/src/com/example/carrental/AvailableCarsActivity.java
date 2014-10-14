package com.example.carrental;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.telerik.everlive.sdk.core.EverliveApp;
import com.telerik.everlive.sdk.core.result.RequestResult;
import com.telerik.everlive.sdk.core.result.RequestResultCallbackAction;

@SuppressLint("NewApi")
public class AvailableCarsActivity extends Activity implements OnItemClickListener {

	ListView list;
	private Context mContext;
	CarAdapter adapter;
	private ArrayList<CarModel> cars;
	ListView carsListView;
	private UserDataPreference userPrefs;
	EverliveApp app;

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu items for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.actionbar_logout, menu);
		return super.onCreateOptionsMenu(menu);
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		app = new EverliveApp("ZEW8xrnCpPDDsuQD");
		setContentView(R.layout.activity_available_cars);
		initializeElements();
		setActionBar();

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Object o = carsListView.getItemAtPosition(position);
		CarModel car = (CarModel) o;
		Toast.makeText(AvailableCarsActivity.this, "Selected :" + " " + car, Toast.LENGTH_LONG).show();

	}

	private void initializeElements() {
		mContext = this;
		cars = new ArrayList<CarModel>();
		carsListView = (ListView) findViewById(R.id.listView1);
		userPrefs = new UserDataPreference(getApplicationContext());
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.action_logout) {
			Toast.makeText(mContext, "Logging out", Toast.LENGTH_LONG).show();
			userPrefs.forget();
			Intent intent = new Intent(AvailableCarsActivity.this, HomeActivity.class);
			startActivity(intent);
			return true;
		}
		if (item.getItemId() == R.id.action_refresh) {
			// showData(); // todo
			return true;
		}
		return false;
	}

	private void setActionBar() {
		// action bar
		ActionBar bar = getActionBar();
		bar.setTitle("Available Cars");
		bar.setDisplayHomeAsUpEnabled(true);
		bar.setDisplayShowHomeEnabled(false);
		bar.show();
	}

	public void getAllData(RequestResultCallbackAction<ArrayList<CarModel>> callbackAction) {
		this.app.workWith().data(CarModel.class).getAll().executeAsync(callbackAction);
	}

	// public void showData(){
	// getAllData(new RequestResultCallbackAction<ArrayList<CarModel>>(){
	//
	//
	// @Override
	// public void invoke(RequestResult<ArrayList<CarModel>> result) {
	// if(result.getSuccess()){
	//
	// for(CarModel car: result.getValue()){
	// CarModel tempCar = new
	// CarModel(car.getModel(),car.getYear(),car.getPrice(),car.getConsumption(),car.getImageUrl(),car.isAvailable());
	// cars.add(tempCar);
	// }
	//
	// adapter = new CarAdapter(mContext, cars);//
	// //carsListView.setAdapter(adapter);
	// }
	// else{
	// Log.d("SSDSDAS", "fail");
	// }
	//
	// }
	// });
	// }

}
