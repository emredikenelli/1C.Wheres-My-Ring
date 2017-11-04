// Generated code from Butter Knife. Do not modify!
package com.group1c.alisoyaslan.wheresmyring.Activities;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class LoginActivity$$ViewInjector<T extends com.group1c.alisoyaslan.wheresmyring.Activities.LoginActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165329, "field 'usernameLogin'");
    target.usernameLogin = finder.castView(view, 2131165329, "field 'usernameLogin'");
    view = finder.findRequiredView(source, 2131165273, "field 'passwordLogin'");
    target.passwordLogin = finder.castView(view, 2131165273, "field 'passwordLogin'");
    view = finder.findRequiredView(source, 2131165272, "field 'passwordImage'");
    target.passwordImage = finder.castView(view, 2131165272, "field 'passwordImage'");
    view = finder.findRequiredView(source, 2131165328, "field 'usernameImage'");
    target.usernameImage = finder.castView(view, 2131165328, "field 'usernameImage'");
    view = finder.findRequiredView(source, 2131165258, "method 'onLogin'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onLogin(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165301, "method 'onSignUp'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onSignUp(p0);
        }
      });
  }

  @Override public void reset(T target) {
    target.usernameLogin = null;
    target.passwordLogin = null;
    target.passwordImage = null;
    target.usernameImage = null;
  }
}
