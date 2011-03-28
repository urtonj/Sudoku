package org.example.sudoku;

import android.app.Activity; 
import android.os.Bundle;
import android.content.Intent; 
import android.view.View; 
import android.view.View.OnClickListener;

public class About extends Activity { 
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.about);
	}
}