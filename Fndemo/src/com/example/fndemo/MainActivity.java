package com.example.fndemo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


import com.fn.paysdk.FNPayListener;
import com.fn.paysdk.FNPayManager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Base64;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private FNPayManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		manager=FNPayManager.getInstance();
		Button init=(Button) findViewById(R.id.button1);
		Button order=(Button) findViewById(R.id.button2);
		init.setOnClickListener(this);
		order.setOnClickListener(this);
		System.out.println(getKeyHash(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.button1:
			manager.init(this, "G510001", "014e7718ca59d4e4fea246ffb4f868b3");
			break;
	
		case R.id.button2:
			manager.CreateOrder( this,"G510001", "014e7718ca59d4e4fea246ffb4f868b3", "1", 
					"蜂鸟","蜂鸟","ok", new FNPayListener() {
						
						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 1).show();
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 1).show();
						}
					});
			break;
		}
	}
	
	/**
	 * 获取应用签名信息
	 * @param context
	 * @return
	 */
	public  String getKeyHash(Context context) {
		String keyhash = null;
		try {
			PackageInfo info = context.getPackageManager().getPackageInfo(
					context.getPackageName(), PackageManager.GET_SIGNATURES);
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(info.signatures[0].toByteArray());
			keyhash = Base64.encodeToString(md.digest(), Base64.DEFAULT)
					.toString().trim();
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return keyhash;
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		manager.onDestroy();
	}
}
