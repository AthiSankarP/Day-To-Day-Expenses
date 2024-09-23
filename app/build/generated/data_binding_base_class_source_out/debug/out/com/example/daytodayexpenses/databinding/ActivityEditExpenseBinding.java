// Generated by view binder compiler. Do not edit!
package com.example.daytodayexpenses.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.daytodayexpenses.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityEditExpenseBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final EditText amount;

  @NonNull
  public final EditText category;

  @NonNull
  public final EditText date;

  @NonNull
  public final Button deleteButton;

  @NonNull
  public final EditText description;

  @NonNull
  public final Button saveButton;

  private ActivityEditExpenseBinding(@NonNull RelativeLayout rootView, @NonNull EditText amount,
      @NonNull EditText category, @NonNull EditText date, @NonNull Button deleteButton,
      @NonNull EditText description, @NonNull Button saveButton) {
    this.rootView = rootView;
    this.amount = amount;
    this.category = category;
    this.date = date;
    this.deleteButton = deleteButton;
    this.description = description;
    this.saveButton = saveButton;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityEditExpenseBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityEditExpenseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_edit_expense, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityEditExpenseBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.amount;
      EditText amount = ViewBindings.findChildViewById(rootView, id);
      if (amount == null) {
        break missingId;
      }

      id = R.id.category;
      EditText category = ViewBindings.findChildViewById(rootView, id);
      if (category == null) {
        break missingId;
      }

      id = R.id.date;
      EditText date = ViewBindings.findChildViewById(rootView, id);
      if (date == null) {
        break missingId;
      }

      id = R.id.deleteButton;
      Button deleteButton = ViewBindings.findChildViewById(rootView, id);
      if (deleteButton == null) {
        break missingId;
      }

      id = R.id.description;
      EditText description = ViewBindings.findChildViewById(rootView, id);
      if (description == null) {
        break missingId;
      }

      id = R.id.saveButton;
      Button saveButton = ViewBindings.findChildViewById(rootView, id);
      if (saveButton == null) {
        break missingId;
      }

      return new ActivityEditExpenseBinding((RelativeLayout) rootView, amount, category, date,
          deleteButton, description, saveButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}