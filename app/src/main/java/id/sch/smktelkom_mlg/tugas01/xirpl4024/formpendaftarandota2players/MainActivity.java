package id.sch.smktelkom_mlg.tugas01.xirpl4024.formpendaftarandota2players;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etnama;
    EditText etumur;
    RadioButton rbR, rbD;
    Button baccept, bdone;
    TextView tv11, tv22, tv55, tv66;
    Spinner sl;
    CheckBox cbT, cbC, cbS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etnama = (EditText) findViewById(R.id.editTextnama);
        etumur = (EditText) findViewById(R.id.editTextumur);
        rbR = (RadioButton) findViewById(R.id.radioButtonR);
        rbD = (RadioButton) findViewById(R.id.radioButtonD);
        baccept = (Button) findViewById(R.id.buttonaccept);
        bdone = (Button) findViewById(R.id.buttondone);
        tv11 = (TextView) findViewById(R.id.textView11);
        tv22 = (TextView) findViewById(R.id.textView22);
        tv55 = (TextView) findViewById(R.id.textView55);
        tv66 = (TextView) findViewById(R.id.textView66);
        sl = (Spinner) findViewById(R.id.spinnerlokasi);
        cbT = (CheckBox) findViewById(R.id.checkBoxT);
        cbC = (CheckBox) findViewById(R.id.checkBoxC);
        cbS = (CheckBox) findViewById(R.id.checkBoxS);
        baccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
                doClick();

            }
        });
        bdone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doClick2();
                doClick3();
            }
        });
    }

    private void doClick3() {
        tv66.setText("Lokasimu :" + sl.getSelectedItem().toString());
    }

    private void doClick2() {
        String view3 = "Kemampuanmu: \n";
        int startlen = view3.length();
        if (cbT.isChecked()) view3 += cbT.getText() + "\n";
        if (cbC.isChecked()) view3 += cbC.getText() + "\n";
        if (cbS.isChecked()) view3 += cbS.getText() + "\n";
        if (view3.length() == startlen) view3 += "Tidak Ada Kemampuan Yang Dipilih";
        tv55.setText(view3);
    }

    private void doClick() {
        String view2 = null;
        if (rbR.isChecked()) {
            view2 = rbR.getText().toString();
        } else if (rbD.isChecked()) {
            view2 = rbD.getText().toString();
        }
        if (view2 == null) {
            tv22.setText("Kamu Harus Memilih Pihak");
        } else {
            tv22.setText("Pihakmu : " + view2);
        }
    }

    private void doProcess() {
        if (isValid()) {
            String name = etnama.getText().toString();
            int age = Integer.parseInt(etumur.getText().toString());
            tv11.setText(name + ", " + age + " tahun");
        }
    }

    private boolean isValid() {
        boolean valid = true;
        String name = etnama.getText().toString();
        String age = etumur.getText().toString();

        if (name.isEmpty()) {
            etnama.setError("Kamu Harus Mengisi Namamu");
            valid = false;
        } else if (name.length() < 4) {
            etnama.setError("Minimal Harus 4 Karakter");
            valid = false;
        } else {
            etnama.setError(null);
        }
        if (age.isEmpty()) {
            etumur.setError("Kamu Harus Mengisi Umurmu");
            valid = false;
        } else if (age.length() != 2) {
            etumur.setError("Minimal Umur 10 dan Maksimal Umur 99");
            valid = false;
        } else {
            etumur.setError(null);
        }
        return valid;
    }
}
