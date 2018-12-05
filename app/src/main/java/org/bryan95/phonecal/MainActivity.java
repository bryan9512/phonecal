package org.bryan95.phonecal;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefs";

    EditText  etSharedName;
    String sharedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etSharedName = (EditText)findViewById(R.id.SharedName);
        // 공유 프레퍼런스를 복원한다
        SharedPreferences sharedPref = getSharedPreferences(PREFS_NAME, 0);
        sharedName = sharedPref.getString("SharedName", "");
        etSharedName.setText(sharedName);

    }
    @Override
    protected void onStop(){
        SharedPreferences myPref = getPreferences(0);
        SharedPreferences.Editor editor = myPref.edit();
        super.onStop();
// 공유 프레퍼런스를 기록한다.
        SharedPreferences sharedPref = getSharedPreferences(PREFS_NAME, 0);
        editor = sharedPref.edit(); // Editor 객체로 변경사항 기록
        sharedName = etSharedName.getText().toString();
        editor.putString("SharedName", sharedName);
        editor.commit(); // 변경사항 반영
    }
}
