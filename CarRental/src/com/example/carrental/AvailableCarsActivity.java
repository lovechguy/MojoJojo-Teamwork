package com.example.carrental;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.telerik.everlive.sdk.core.EverliveApp;

@SuppressLint("NewApi")
public class AvailableCarsActivity extends Activity implements OnItemClickListener {
	
	ListView list;
	private Context mContext;
	CarAdapter adapter;
	private ArrayList<CarModel> cars;
	ListView carsListView;
	private UserDataPreference userPrefs;
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.actionbar_logout, menu);
	    return super.onCreateOptionsMenu(menu);
	}

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EverliveApp app = new EverliveApp("ZEW8xrnCpPDDsuQD");
		setContentView(R.layout.activity_available_cars);
		initializeElements();
		
		// action bar 
		ActionBar bar = getActionBar();		
		bar.setTitle("Available Cars");
		bar.setDisplayHomeAsUpEnabled(true);
		bar.setDisplayShowHomeEnabled(false);
		bar.show();
		
		
		CarModel sampleCar = new CarModel("Lexus",2000,2000,10,"http://media.caranddriver.com/images/media/51/dissected-lotus-based-infiniti-emerg-e-sports-car-concept-top-image-photo-451994-s-original.jpg");
		CarModel sampleCar2 = new CarModel("Lexus",2000,2000,10,"http://media.caranddriver.com/images/media/51/dissected-lotus-based-infiniti-emerg-e-sports-car-concept-top-image-photo-451994-s-original.jpg");
		CarModel sampleCar3 = new CarModel("Lexus",2000,2000,10,"http://media.caranddriver.com/images/media/51/dissected-lotus-based-infiniti-emerg-e-sports-car-concept-top-image-photo-451994-s-original.jpg");
		CarModel sampleCar4 = new CarModel("Lexus",2000,2000,10,"http://media.caranddriver.com/images/media/51/dissected-lotus-based-infiniti-emerg-e-sports-car-concept-top-image-photo-451994-s-original.jpg");

		cars.add(sampleCar);
		cars.add(sampleCar2);
		cars.add(sampleCar3);
		cars.add(sampleCar4);
		
		carsListView.setAdapter(new CarAdapter(this, cars));
		carsListView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Object o = carsListView.getItemAtPosition(position);
		CarModel car = (CarModel) o;
		Toast.makeText(AvailableCarsActivity.this, "Selected :" + " " + car,
				Toast.LENGTH_LONG).show();
		
	}
	
	private void initializeElements(){
		 mContext = this;
		 cars = new ArrayList<CarModel>();
		 carsListView = (ListView) findViewById(R.id.listView1);
		 userPrefs =  new UserDataPreference(getApplicationContext());
	}

	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId() == R.id.action_logout){
			Toast.makeText(mContext, "Logging out", Toast.LENGTH_LONG).show();
			userPrefs.forget();
			Intent intent = new Intent(AvailableCarsActivity.this, HomeActivity.class);
			startActivity(intent);
			return true;
		}
		return false;
	}
}