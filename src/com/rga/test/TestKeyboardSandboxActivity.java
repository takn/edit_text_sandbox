package com.rga.test;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

public class TestKeyboardSandboxActivity extends Activity {
	private View relative;
	private static String TAG = TestKeyboardSandboxActivity.class
			.getCanonicalName();
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		relative = findViewById(R.id.topRelativeLayout);
		
		final View activityRootView = findViewById(R.id.root_view);
		activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
		    @Override
		    public void onGlobalLayout() {
		        int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();
		        
		        Log.d(TAG,
						"TestKeyboardSandboxActivity.onCreate(...).new OnGlobalLayoutListener() {...}.onGlobalLayout() measured height::"+activityRootView.getMeasuredHeight());
		        Log.d(TAG,
		        		"TestKeyboardSandboxActivity.onCreate(...).new OnGlobalLayoutListener() {...}.onGlobalLayout() Height::"+activityRootView.getHeight());
		        if (heightDiff > 100) { // if more than 100 pixels, its probably a keyboard...
		        	relative.setVisibility(View.GONE);
		        }else{
		        	relative.setVisibility(View.VISIBLE);
		        }
		     }
		});
	}
}