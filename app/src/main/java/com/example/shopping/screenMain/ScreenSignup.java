package com.example.shopping.screenMain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.shopping.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ScreenSignup extends AppCompatActivity {

    TextInputLayout phone, address;

    Button next, back;

    CheckBox termPolicy;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_signup);

        phone = findViewById(R.id.tf_signupPhone);
        address = findViewById(R.id.tf_signupAddress);
        termPolicy = findViewById(R.id.cb_terminePolicy);
        next = findViewById(R.id.btn_nextSingup);
        back = findViewById(R.id.btn_backSingup);

        String Contrant = "You accept our Terms, Data Policy and Cookies Policy more...";
        SpannableString css = new SpannableString(Contrant);

        ClickableSpan clickableSpanMore = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                ///Dialog.
                final MaterialAlertDialogBuilder build = new MaterialAlertDialogBuilder(ScreenSignup.this)
                        .setTitle("TERMS AND CONDITIONS")
                        .setIcon(R.drawable.ic_policy)
                        .setBackground(getResources().getDrawable(R.drawable.background_alert_term_policy))
                        .setMessage(getResources().getString(R.string.terminosPoliticy));
                        build.setPositiveButton("Great!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        build.show();

            }
        };

        css.setSpan(clickableSpanMore,53, 60, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        termPolicy.setText(css);
        termPolicy.setMovementMethod(LinkMovementMethod.getInstance());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        address.getEditText().setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                     BottomDialog();
                     return true;
                }
                return false;
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),phone.getEditText().getText().toString(),Toast.LENGTH_SHORT).show();
                Bundle var = new Bundle();
                Intent start = new Intent(ScreenSignup.this, screenSignup1.class);
                var.putString("username","");
                var.putString("firstname","");
                var.putString("lastname","");
                var.putString("address","");
                var.putBoolean("statususer",true);
                var.putString("postal","");
                start.putExtras(var);
                startActivity(start);
                overridePendingTransition(R.anim.to_right,R.anim.out_left);
            }
        });

    }

    private void BottomDialog(){

        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ScreenSignup.this,R.style.BottomSheetDialogTheme);
        View bottomsheetView = LayoutInflater.from(ScreenSignup.this)
                .inflate(R.layout.activity_bottom_sheet_signup,(LinearLayout)findViewById(R.id.bottomsheetContainer));

        Button saveAdress = bottomsheetView.findViewById(R.id.btn_signupaAddress_saved);
        Button closeAdress = bottomsheetView.findViewById(R.id.btn_closeBottomsheet);


    saveAdress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Ok funciona",Toast.LENGTH_SHORT).show();
            }
        });

    closeAdress.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            bottomSheetDialog.dismiss();
        }
    });

        bottomSheetDialog.setCanceledOnTouchOutside(false);
        bottomSheetDialog.setContentView(bottomsheetView);
        bottomSheetDialog.show();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //overridePendingTransition(R.anim.to_left,R.anim.out_right);
        overridePendingTransition(R.anim.in_top,R.anim.out_top);
    }
}