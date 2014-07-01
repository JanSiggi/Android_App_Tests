package de.androidnewcomer.saghallo;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends Activity implements OnInitListener, OnClickListener {

	private TextToSpeech tts;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tts = new TextToSpeech(this, this);
	}

	@Override
	public void onInit(int arg0) {
		tts.setLanguage(Locale.GERMAN);
		Button button = (Button) findViewById(R.id.button1);
		button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		EditText editText = (EditText)findViewById(R.id.editText1);
		tts.speak(editText.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
	}
	
	

}
