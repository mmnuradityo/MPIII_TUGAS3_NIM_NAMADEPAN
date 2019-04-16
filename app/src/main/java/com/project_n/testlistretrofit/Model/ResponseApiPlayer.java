package com.project_n.testlistretrofit.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseApiPlayer {

	@SerializedName("data")
	private List<Player> data;

	@SerializedName("success")
	private String success;

	public List<Player> getData(){
		return data;
	}

	public String getSuccess(){
		return success;
	}

	@Override
 	public String toString(){
		return 
			"ResponseApiPlayer{" +
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			"}";
		}
}