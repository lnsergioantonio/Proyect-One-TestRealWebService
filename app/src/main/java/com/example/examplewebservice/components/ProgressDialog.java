package com.example.examplewebservice.components;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class ProgressDialog {
    private Dialog dialog;
    private ProgressBar progressBar;

    public ProgressDialog(Context context) {
        dialog = new Dialog(context);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);

        RelativeLayout layout = new RelativeLayout(context);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(params);

        progressBar = new ProgressBar(context);

        RelativeLayout.LayoutParams layoutParams_progress = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams_progress.addRule(RelativeLayout.CENTER_IN_PARENT);
        LinearLayout.LayoutParams linearlayoutParams_progress = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        linearlayoutParams_progress.gravity = Gravity.CENTER;
        progressBar.setLayoutParams(layoutParams_progress);

        layout.addView(progressBar);

        dialog.getWindow().setContentView(layout, params);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    public void show() {
        if (!dialog.isShowing() && dialog != null) {
            dialog.show();
        }
    }

    public void dismiss() {
        if (dialog.isShowing() && dialog != null) {
            dialog.dismiss();
        }
    }

    public void setCancelable(boolean cancelable) {
        dialog.setCancelable(cancelable);
    }


    public void setCanceledOnTouchOutside(boolean flag) {
        dialog.setCanceledOnTouchOutside(flag);
    }

    public void setColor(int colour) {
        progressBar.getIndeterminateDrawable().setColorFilter(colour, android.graphics.PorterDuff.Mode.MULTIPLY);
    }

    public boolean isShowing() {

        return dialog.isShowing();
    }
}
