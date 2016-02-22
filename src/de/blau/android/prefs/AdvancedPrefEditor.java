package de.blau.android.prefs;

import android.os.Bundle;
import android.util.Log;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.MenuItem;

import de.blau.android.R;

public class AdvancedPrefEditor extends SherlockFragmentActivity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.d("AdvancedPrefEditor", "onCreate");
		Preferences prefs = new Preferences(this);
		if (prefs.lightThemeEnabled()) {
			setTheme(R.style.Theme_Sherlock_Light);
		}
		
		super.onCreate(savedInstanceState);
		getSupportFragmentManager().beginTransaction().replace(android.R.id.content,
                new AdvancedPrefEditorFragment()).commit();
		
		ActionBar actionbar = getSupportActionBar();
		actionbar.setDisplayHomeAsUpEnabled(true);
	}
	
	
	@Override
	public boolean onOptionsItemSelected(final MenuItem item) {
		Log.d("AdvancedPrefEditor", "onOptionsItemSelected");
		switch (item.getItemId()) {
		case android.R.id.home:
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
