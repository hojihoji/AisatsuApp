package jp.techacademy.mito.yuuya.aisatsuapp;

        import android.app.TimePickerDialog;
        import android.util.Log;
        import android.os.Bundle;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        showTimePickerDialog();
    }

    public void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                        TextView textView = (TextView) findViewById(R.id.textView);
                        if ((hourOfDay >= 2) && (hourOfDay < 10)) {
                            textView.setText("おはよう");
                        } else if ((hourOfDay >= 10) && (hourOfDay < 18)) {
                            textView.setText("こんにちは");
                        } else if ((hourOfDay >= 18) && (hourOfDay < 24)) {
                            textView.setText("こんばんは");
                        } else if ((hourOfDay >= 0) && (hourOfDay < 2)) {
                            textView.setText("こんばんは");
                        }
                    }
                },
                13, // 初期値（時間）
                0,  // 初期値（分）
                true);
        timePickerDialog.show();

    }
}