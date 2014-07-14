package com.example.countdowntest;


import java.util.concurrent.TimeUnit;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;

public class CountDownTest extends Activity {
	
	public TextView tv; //textview to display the countdown

	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        tv = new TextView(this);
	        this.setContentView(tv);

	        //5000 is the starting number (in milliseconds)
	        //1000 is the number to count down each time (in milliseconds)
	        MyCount counter = new MyCount(300000,1000);

	        counter.start();
	    }
	    //countdowntimer is an abstract class, so extend it and fill in methods
	    public class MyCount extends CountDownTimer{

	        public MyCount(long millisInFuture, long countDownInterval) {
	            super(millisInFuture, countDownInterval);
	        }

	        @Override
	        public void onFinish() {
	            tv.setText("done!");
	        }

	        @Override
	        public void onTick(long millisUntilFinished) {
	            //tv.setText("Left: " + millisUntilFinished/60000 + ":"+millisUntilFinished/5000+":" +millisUntilFinished/1000 );
	            
	            tv.setText("left :"+String.format("%d : %d ", 
	                    TimeUnit.MILLISECONDS.toMinutes( millisUntilFinished),
	                    TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - 
	                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
	    }

	        }

	    }
  

/*	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_count_down_test);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.count_down_test, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/

	/**
	 * A placeholder fragment containing a simple view.
	 */
/*	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_count_down_test,
					container, false);
			return rootView;
		}
	}*/


