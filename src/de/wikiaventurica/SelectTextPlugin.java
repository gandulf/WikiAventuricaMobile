package de.wikiaventurica;

import org.json.JSONArray;

import android.util.Log;
import android.view.KeyEvent;

import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;

public class SelectTextPlugin extends Plugin {

	@Override
	public PluginResult execute(String action, JSONArray params, String callbackId) {
		Log.d("SelectTextPlugin", action);
		PluginResult result = null;
		if (action.compareTo("selectText") == 0) {
			selectText();
			result = new PluginResult(Status.NO_RESULT);
			return result;
		}
		return result;
	}

	@Override
	public boolean isSynch(String action) {
		return true;
	}

	public void selectText() {
		try {
			KeyEvent shiftPressEvent = new KeyEvent(0, 0, KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_SHIFT_LEFT, 0, 0);
			shiftPressEvent.dispatch(webView);
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

}
