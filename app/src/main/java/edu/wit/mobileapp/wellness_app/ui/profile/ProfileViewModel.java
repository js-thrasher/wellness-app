package edu.wit.mobileapp.wellness_app.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Take one day at a time! - unknown");
    }

    public LiveData<String> getText() {
        return mText;
    }

}
