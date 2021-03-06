package org.example.sudoku;

import android.app.Activity;
import android.content.Intent;
import android.media.audiofx.BassBoost.Settings;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog; import android.content.DialogInterface; import android.util.Log;

public class Sudoku extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	private static final String TAG = "Sudoku";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState); 
    	setContentView(R.layout.main);
    	// Set up click listeners for all the buttons
    	View continueButton = this.findViewById(R.id.continue_button); 
    	continueButton.setOnClickListener(this); 
    	View newButton = this.findViewById(R.id.new_button); 
    	newButton.setOnClickListener(this);
    	View aboutButton = this.findViewById(R.id.about_button); 
    	aboutButton.setOnClickListener(this); 
    	View moreButton = this.findViewById(R.id.more_about_button);
    	moreButton.setOnClickListener(this);
    	View exitButton = this.findViewById(R.id.exit_button); 
    	exitButton.setOnClickListener(this);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.menu, menu);
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	
    	switch(item.getItemId()) {
    	case R.id.settings:
    		startActivity(new Intent(this, Settings.class));
    		return true;
    	}
    	
    	return false;
    	
    }
    
	@Override
	public void onClick(View v) { 
		switch (v.getId()) { 
		case R.id.about_button:
			Intent i = new Intent(this, About.class); 
			startActivity(i); break;
		
		case R.id.more_about_button:
			Intent j = new Intent(this, MoreAbout.class);
			startActivity(j); break;
			
		case R.id.new_button:
			openNewGameDialog();
			break;
			
		case R.id.exit_button:
			finish();
			break;
		}
	}
	
	private void openNewGameDialog() {
		
		new AlertDialog.Builder(this)
			.setTitle(R.string.new_game_label)
			.setItems(R.array.difficulty,
			new DialogInterface.OnClickListener() {
				
				public void onClick(DialogInterface dialoginterface, int i) {
					
					startGame(i);
				}
				
			})
			.show();
							
	}
	
	private void startGame(int i) {
		
		Log.d(TAG, "click on " + i);
	}

	
}