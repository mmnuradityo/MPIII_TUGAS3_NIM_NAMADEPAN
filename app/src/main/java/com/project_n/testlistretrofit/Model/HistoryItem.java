package com.project_n.testlistretrofit.Model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class HistoryItem implements Parcelable {

	@SerializedName("id")
	private int id;

	@SerializedName("klub")
	private String klub;

	protected HistoryItem(Parcel in) {
		id = in.readInt();
		klub = in.readString();
	}
	public HistoryItem() {
	}
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(klub);
	}

	@Override
	public int describeContents() {
		return 0;
	}

	public static final Creator<HistoryItem> CREATOR = new Creator<HistoryItem>() {
		@Override
		public HistoryItem createFromParcel(Parcel in) {
			return new HistoryItem(in);
		}

		@Override
		public HistoryItem[] newArray(int size) {
			return new HistoryItem[size];
		}
	};

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setKlub(String klub){
		this.klub = klub;
	}

	public String getKlub(){
		return klub;
	}

	@Override
 	public String toString(){
		return klub ;
		}
}