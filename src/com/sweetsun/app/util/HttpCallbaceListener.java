package com.sweetsun.app.util;

public interface HttpCallbaceListener {

	void onFinish(String response);
	void onError(Exception e);
}
