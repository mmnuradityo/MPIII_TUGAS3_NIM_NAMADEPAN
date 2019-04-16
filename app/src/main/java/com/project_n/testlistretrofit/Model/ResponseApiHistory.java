package com.project_n.testlistretrofit.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseApiHistory {

	@SerializedName("data")
	private List<History> data;

	@SerializedName("success")
	private String success;

	public List<History> getData(){
		return data;
	}

	public String getSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"ResponseApiHistory{" +
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			"}";
		}
}