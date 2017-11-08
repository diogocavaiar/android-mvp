package dmc.com.br.examplemvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by diogo on 16/10/2017.
 */

public class User implements Parcelable {
    private String mUserId;
    private String mFirstName;
    private String mLastName;
    private String mEmail;

    public User(final String userId, final String firstName, final String lastName, final String email) {
        mUserId = userId;
        mFirstName = firstName;
        mLastName = lastName;
        mEmail = email;
    }

    public User(final String firstName, final String lastName, final String email) {
        mFirstName = firstName;
        mLastName = lastName;
        mEmail = email;
    }

    protected User(Parcel in) {
        mUserId = in.readString();
        mFirstName = in.readString();
        mLastName = in.readString();
        mEmail = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(final String userId) {
        mUserId = userId;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(final String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(final String lastName) {
        mLastName = lastName;
    }

    public String getEmail(){
        return mEmail;
    }

    public void setEmail(final String email) {
        mEmail = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(mUserId);
        parcel.writeString(mFirstName);
        parcel.writeString(mLastName);
        parcel.writeString(mEmail);
    }

    @Override
    public String toString() {
        return String.format("ID: %s\nFirst Name: %s\nLast Name: %s\nEmail: %s", mUserId,mFirstName,mLastName,mEmail);
    }
}
