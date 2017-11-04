// Generated code from Butter Knife. Do not modify!
package com.group1c.alisoyaslan.wheresmyring.Activities;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class SignupActivity$$ViewInjector<T extends com.group1c.alisoyaslan.wheresmyring.Activities.SignupActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131165252, "field 'kullanicigiris2'");
    target.kullanicigiris2 = finder.castView(view, 2131165252, "field 'kullanicigiris2'");
    view = finder.findRequiredView(source, 2131165300, "field 'sifregiris2'");
    target.sifregiris2 = finder.castView(view, 2131165300, "field 'sifregiris2'");
    view = finder.findRequiredView(source, 2131165335, "field 'yasgiris'");
    target.yasgiris = finder.castView(view, 2131165335, "field 'yasgiris'");
    view = finder.findRequiredView(source, 2131165231, "field 'epostagiris'");
    target.epostagiris = finder.castView(view, 2131165231, "field 'epostagiris'");
    view = finder.findRequiredView(source, 2131165249, "field 'iptal' and method 'onExit'");
    target.iptal = finder.castView(view, 2131165249, "field 'iptal'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onExit(p0);
        }
      });
    view = finder.findRequiredView(source, 2131165302, "field 'sozlesmegiris'");
    target.sozlesmegiris = finder.castView(view, 2131165302, "field 'sozlesmegiris'");
    view = finder.findRequiredView(source, 2131165251, "method 'onGiris'");
    view.setOnClickListener(
      new butterknife.internal.DebouncingOnClickListener() {
        @Override public void doClick(
          android.view.View p0
        ) {
          target.onGiris(p0);
        }
      });
  }

  @Override public void reset(T target) {
    target.kullanicigiris2 = null;
    target.sifregiris2 = null;
    target.yasgiris = null;
    target.epostagiris = null;
    target.iptal = null;
    target.sozlesmegiris = null;
  }
}
