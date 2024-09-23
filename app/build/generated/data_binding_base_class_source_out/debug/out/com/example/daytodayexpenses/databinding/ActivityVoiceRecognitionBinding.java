// Generated by view binder compiler. Do not edit!
package com.example.daytodayexpenses.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.daytodayexpenses.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityVoiceRecognitionBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button startVoiceButton;

  @NonNull
  public final Button stopVoiceButton;

  private ActivityVoiceRecognitionBinding(@NonNull RelativeLayout rootView,
      @NonNull Button startVoiceButton, @NonNull Button stopVoiceButton) {
    this.rootView = rootView;
    this.startVoiceButton = startVoiceButton;
    this.stopVoiceButton = stopVoiceButton;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityVoiceRecognitionBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityVoiceRecognitionBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_voice_recognition, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityVoiceRecognitionBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.startVoiceButton;
      Button startVoiceButton = ViewBindings.findChildViewById(rootView, id);
      if (startVoiceButton == null) {
        break missingId;
      }

      id = R.id.stopVoiceButton;
      Button stopVoiceButton = ViewBindings.findChildViewById(rootView, id);
      if (stopVoiceButton == null) {
        break missingId;
      }

      return new ActivityVoiceRecognitionBinding((RelativeLayout) rootView, startVoiceButton,
          stopVoiceButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
