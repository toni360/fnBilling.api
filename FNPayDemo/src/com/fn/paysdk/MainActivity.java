package com.fn.paysdk;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import com.fn.paysdk.FNPayListener;
import com.fn.paysdk.FNPayManager;

public class MainActivity extends Activity implements OnClickListener {

	private FNPayManager manager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		manager=FNPayManager.getInstance();
		Button init=(Button) findViewById(R.id.button1);
		Button order=(Button) findViewById(R.id.button2);
		Button bt3=(Button) findViewById(R.id.button3);
		Button bt4=(Button) findViewById(R.id.button4);
		Button bt5=(Button) findViewById(R.id.button5);
		Button bt6=(Button) findViewById(R.id.button6);
		Button bt7=(Button) findViewById(R.id.button7);
		Button bt8=(Button) findViewById(R.id.button8);
		Button bt9=(Button) findViewById(R.id.button9);
		Button bt10=(Button) findViewById(R.id.button10);
		Button bt11=(Button) findViewById(R.id.button11);
		Button bt12=(Button) findViewById(R.id.button12);
		Button bt13=(Button) findViewById(R.id.button13);
		Button bt14=(Button) findViewById(R.id.button14);
		Button bt15=(Button) findViewById(R.id.button15);
		
		init.setOnClickListener(this);
		order.setOnClickListener(this);
		bt3.setOnClickListener(this);
		bt4.setOnClickListener(this);
		bt5.setOnClickListener(this);
		bt6.setOnClickListener(this);
		bt7.setOnClickListener(this);
		bt8.setOnClickListener(this);
		bt9.setOnClickListener(this);
		bt10.setOnClickListener(this);
		bt11.setOnClickListener(this);
		bt12.setOnClickListener(this);
		bt13.setOnClickListener(this);
		bt14.setOnClickListener(this);
		bt15.setOnClickListener(this);

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
			manager.init(this, "G510001", "8795d5a792771fb2eee48401eee655b0");
			break;
	
		case R.id.button2:
			
			manager.CreateOrder( this,"G510001", "8795d5a792771fb2eee48401eee655b0", "1", 
					"·äÄñ","·äÄñ","ok", new FNPayListener(){
						
						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "³É¹¦");
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "Ê§°Ü");
						}
					});
	 
			break;
		case R.id.button3:
			manager.CreateOrder( this,"G510001", "8795d5a792771fb2eee48401eee655b0", "2", 
					"·äÄñ","·äÄñ","ok", new FNPayListener(){
				
						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "³É¹¦");
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "Ê§°Ü");
						}
					});
			break;
		case R.id.button4:
			manager.CreateOrder( this,"G510001", "8795d5a792771fb2eee48401eee655b0", "3", 
					"·äÄñ","·äÄñ","ok", new FNPayListener(){

						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "³É¹¦");
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "Ê§°Ü");
						}
					});

			break;
		case R.id.button5:
			manager.CreateOrder( this,"G510001", "8795d5a792771fb2eee48401eee655b0", "4", 
					"·äÄñ","·äÄñ","ok", new FNPayListener(){
//			manager.CreateOrder( this,"GM01001", "3dcad221a7a81c688efb6ec3b4eb626b", "1000", 
//					"·äÄñ","·äÄñ","ok", new FNPayListener(){
						
						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "³É¹¦");
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "Ê§°Ü");
						}
					});
//			  if(GameInterface.getActivateFlag("001")){
//		            Toast.makeText(MainActivity.this, "001 ÒÑ¹ºÂò¹ý", Toast.LENGTH_SHORT).show();
//		            return;
//		          }
//		          GameInterface.doBilling(MainActivity.this, true, false, "001", null, payCallback);
	 
			break;
		case R.id.button6:
			manager.CreateOrder( this,"G510001", "8795d5a792771fb2eee48401eee655b0", "5", 
					"·äÄñ","·äÄñ","ok", new FNPayListener(){
//			manager.CreateOrder( this,"GM01001", "3dcad221a7a81c688efb6ec3b4eb626b", "1000", 
//					"·äÄñ","·äÄñ","ok", new FNPayListener(){
						
						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "³É¹¦");
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "Ê§°Ü");
						}
					});
//			  if(GameInterface.getActivateFlag("001")){
//		            Toast.makeText(MainActivity.this, "001 ÒÑ¹ºÂò¹ý", Toast.LENGTH_SHORT).show();
//		            return;
//		          }
//		          GameInterface.doBilling(MainActivity.this, true, false, "001", null, payCallback);
	 
			break;
		case R.id.button7:
			manager.CreateOrder( this,"G510001", "8795d5a792771fb2eee48401eee655b0", "6", 
					"·äÄñ","·äÄñ","ok", new FNPayListener(){
//			manager.CreateOrder( this,"GM01001", "3dcad221a7a81c688efb6ec3b4eb626b", "1000", 
//					"·äÄñ","·äÄñ","ok", new FNPayListener(){
						
						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "³É¹¦");
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "Ê§°Ü");
						}
					});
//			  if(GameInterface.getActivateFlag("001")){
//		            Toast.makeText(MainActivity.this, "001 ÒÑ¹ºÂò¹ý", Toast.LENGTH_SHORT).show();
//		            return;
//		          }
//		          GameInterface.doBilling(MainActivity.this, true, false, "001", null, payCallback);
	 
			break;
		case R.id.button8:
			manager.CreateOrder( this,"G510001", "8795d5a792771fb2eee48401eee655b0", "7", 
					"·äÄñ","·äÄñ","ok", new FNPayListener(){
//			manager.CreateOrder( this,"GM01001", "3dcad221a7a81c688efb6ec3b4eb626b", "1000", 
//					"·äÄñ","·äÄñ","ok", new FNPayListener(){
						
						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "³É¹¦");
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "Ê§°Ü");
						}
					});
//			  if(GameInterface.getActivateFlag("001")){
//		            Toast.makeText(MainActivity.this, "001 ÒÑ¹ºÂò¹ý", Toast.LENGTH_SHORT).show();
//		            return;
//		          }
//		          GameInterface.doBilling(MainActivity.this, true, false, "001", null, payCallback);
	 
			break;
		case R.id.button9:
			manager.CreateOrder( this,"G510001", "8795d5a792771fb2eee48401eee655b0", "100", 
					"·äÄñ","·äÄñ","ok", new FNPayListener(){
//			manager.CreateOrder( this,"GM01001", "3dcad221a7a81c688efb6ec3b4eb626b", "1000", 
//					"·äÄñ","·äÄñ","ok", new FNPayListener(){
						
						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "³É¹¦");
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "Ê§°Ü");
						}
					});
//			  if(GameInterface.getActivateFlag("001")){
//		            Toast.makeText(MainActivity.this, "001 ÒÑ¹ºÂò¹ý", Toast.LENGTH_SHORT).show();
//		            return;
//		          }
//		          GameInterface.doBilling(MainActivity.this, true, false, "001", null, payCallback);
	 
			break;
		case R.id.button10:
			manager.CreateOrder( this,"G510001", "8795d5a792771fb2eee48401eee655b0", "200", 
					"·äÄñ","·äÄñ","ok", new FNPayListener(){
//			manager.CreateOrder( this,"GM01001", "3dcad221a7a81c688efb6ec3b4eb626b", "1000", 
//					"·äÄñ","·äÄñ","ok", new FNPayListener(){
						
						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "³É¹¦");
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "Ê§°Ü");
						}
					});
//			  if(GameInterface.getActivateFlag("001")){
//		            Toast.makeText(MainActivity.this, "001 ÒÑ¹ºÂò¹ý", Toast.LENGTH_SHORT).show();
//		            return;
//		          }
//		          GameInterface.doBilling(MainActivity.this, true, false, "001", null, payCallback);
	 
			break;
		case R.id.button11:
			manager.CreateOrder( this,"G510001", "8795d5a792771fb2eee48401eee655b0", "300", 
					"·äÄñ","·äÄñ","ok", new FNPayListener(){
//			manager.CreateOrder( this,"GM01001", "3dcad221a7a81c688efb6ec3b4eb626b", "1000", 
//					"·äÄñ","·äÄñ","ok", new FNPayListener(){
						
						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "³É¹¦");
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "Ê§°Ü");
						}
					});
//			  if(GameInterface.getActivateFlag("001")){
//		            Toast.makeText(MainActivity.this, "001 ÒÑ¹ºÂò¹ý", Toast.LENGTH_SHORT).show();
//		            return;
//		          }
//		          GameInterface.doBilling(MainActivity.this, true, false, "001", null, payCallback);
	 
			break;
		case R.id.button12:
			manager.CreateOrder( this,"G510001", "8795d5a792771fb2eee48401eee655b0", "400", 
					"·äÄñ","·äÄñ","ok", new FNPayListener(){
//			manager.CreateOrder( this,"GM01001", "3dcad221a7a81c688efb6ec3b4eb626b", "1000", 
//					"·äÄñ","·äÄñ","ok", new FNPayListener(){
						
						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "³É¹¦");
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "Ê§°Ü");
						}
					});
//			  if(GameInterface.getActivateFlag("001")){
//		            Toast.makeText(MainActivity.this, "001 ÒÑ¹ºÂò¹ý", Toast.LENGTH_SHORT).show();
//		            return;
//		          }
//		          GameInterface.doBilling(MainActivity.this, true, false, "001", null, payCallback);
	 
			break;
		case R.id.button13:
			manager.CreateOrder( this,"G510001", "8795d5a792771fb2eee48401eee655b0", "500", 
					"·äÄñ","·äÄñ","ok", new FNPayListener(){
//			manager.CreateOrder( this,"GM01001", "3dcad221a7a81c688efb6ec3b4eb626b", "1000", 
//					"·äÄñ","·äÄñ","ok", new FNPayListener(){
						
						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "³É¹¦");
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "Ê§°Ü");
						}
					});
//			  if(GameInterface.getActivateFlag("001")){
//		            Toast.makeText(MainActivity.this, "001 ÒÑ¹ºÂò¹ý", Toast.LENGTH_SHORT).show();
//		            return;
//		          }
//		          GameInterface.doBilling(MainActivity.this, true, false, "001", null, payCallback);
	 
			break;
		case R.id.button14:
			manager.CreateOrder( this,"G510001", "8795d5a792771fb2eee48401eee655b0", "1000", 
					"·äÄñ","·äÄñ","ok", new FNPayListener(){
//			manager.CreateOrder( this,"GM01001", "3dcad221a7a81c688efb6ec3b4eb626b", "1000", 
//					"·äÄñ","·äÄñ","ok", new FNPayListener(){
						
						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "³É¹¦");
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "Ê§°Ü");
						}
					});
//			  if(GameInterface.getActivateFlag("001")){
//		            Toast.makeText(MainActivity.this, "001 ÒÑ¹ºÂò¹ý", Toast.LENGTH_SHORT).show();
//		            return;
//		          }
//		          GameInterface.doBilling(MainActivity.this, true, false, "001", null, payCallback);
	 
			break;
		case R.id.button15:
			manager.CreateOrder( this,"G510001", "8795d5a792771fb2eee48401eee655b0", "30000", 
					"·äÄñ","·äÄñ","ok", new FNPayListener(){
//			manager.CreateOrder( this,"GM01001", "3dcad221a7a81c688efb6ec3b4eb626b", "1000", 
//					"·äÄñ","·äÄñ","ok", new FNPayListener(){
						
						@Override
						public void OnSuccess(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "³É¹¦");
						}
						
						@Override
						public void OnFailed(String errcode, String errmsg) {
							// TODO Auto-generated method stub
							Toast.makeText(MainActivity.this,errmsg, 0).show();
							Log.d(errcode, "Ê§°Ü");
						}
					});
//			  if(GameInterface.getActivateFlag("001")){
//		            Toast.makeText(MainActivity.this, "001 ÒÑ¹ºÂò¹ý", Toast.LENGTH_SHORT).show();
//		            return;
//		          }
//		          GameInterface.doBilling(MainActivity.this, true, false, "001", null, payCallback);
	 
			break;
		}
	}
	
	/**
	 * 
	 * »ñÈ¡Ó¦ÓÃÇ©ÃûÐÅÏ¢
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
