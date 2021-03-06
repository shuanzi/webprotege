package edu.stanford.bmir.protege.web.client.actionbar.application;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.RunAsyncCallback;
import edu.stanford.bmir.protege.web.client.Application;

import edu.stanford.bmir.protege.web.client.auth.SignInPresenter;
import edu.stanford.bmir.protege.web.shared.user.UserId;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 23/08/2013
 */
public class SignInRequestHandlerImpl implements SignInRequestHandler {

    @Override
    public void handleSignInRequest() {
        GWT.runAsync(new RunAsyncCallback() {
            @Override
            public void onFailure(Throwable reason) {
            }

            @Override
            public void onSuccess() {
                UserId userId = Application.get().getUserId();
                if (userId.isGuest()) {
                    SignInPresenter.get().showLoginDialog();
                }
                else {
                    GWT.log("User is already signed in");
                }
            }
        });
    }
}
