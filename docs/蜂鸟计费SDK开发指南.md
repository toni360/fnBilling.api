
#蜂鸟计费开发指南


###1.接口说明
**FNPayManager**
FNPayManager对象是SDK提供开发者初始化配置参数、发起订购的接口。
开发者在实例化该对象后，调用其中的函数可以处理相应的业务。
构造FNPayManager实例：
FNPayManager对象的创建使用了单例模式，不需要重复创建：
FNPay=FNPayManager.getInstance();

**INIT初始化接口**
Init()：SDK初始化接口，此接口实现申请配置参数，开发者需要在APP初始化调用（接口内部使用
异步加载处理），这样可以避免用户在订购中的等待时间。

FNPay.Init(context,appId,appKey);

参数|必须|说明
---|-------|----  
appId|是|蜂鸟计费平台分配给游戏应用的应用标识
appKey|是|蜂鸟计费平台分配给游戏应用的接入秘钥，不能对外公开  

**CreateOrder接口**
CreateOrder（）：SDK订购接口

FNPay.CreateOrder（context,appid,appKey,sum,subject,body,alias,listener）
    
参数|必须|说明
---|-------|----
appId|是|蜂鸟计费平台分配给游戏应用的应用标识
appKey|是|蜂鸟计费平台分配给游戏应用的接入秘钥，不能对外公开    
sum |是|交易金额，分为单位，最大到千元，即长度为6位(1-100000分)
subject |是|商品标题
body |是|商品详情
alias|是|开发者自定义串 ,可以是渠道标识，长度不能超过为100个字符(只能是字符或数字)
listener|是|回调接口,通过此接口通知开发者支付状态

**FNPayListener接口**
FNPayListener（returnCode, returnObject）：SDK订购结果监听器，开发者可以通过该接口监听业务操作的状态：
returnCode: 
// 计费成功: 0;
// 计费失败: 10001|订单处理中，请稍后购买;10002|计费未初始化错误;10003|请检查网络状态;

**onDestroy接口**
onDestroy()：在退出游戏时调用的接口，用于清除SDK的计费配置

###2.导入蜂鸟计费SDK到开发工程|还有所需JAR包

导入蜂鸟计费SDK开发包（以下简称SDK）到你开发的应用程序项目

请把demo工程里的libs目录下的文件复制到你开发的工程目录里的libs目录


###3.配置AndroidManifest.xml

####权限配置：

    <uses-permission android:name="android.permission.INTERNET" />
	<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
	<uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
	<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
	<uses-permission android:name="android.permission.SEND_SMS" />
	<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
	<uses-permission android:name="android.permission.READ_CONTACTS" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    <uses-permission android:name="android.permission.BLUETOOTH" />
    <uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
    <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" />
	<uses-permission android:name="android.permission.GET_TASKS" />
    <uses-permission android:name="android.permission.RECEIVE_SMS" />
	<uses-permissionandroid:name="android.permission.MOUNT_UNMOUNT_FILESYSTEMS">
    <uses-permission android:name="android.permission.READ_SMS" />
    <uses-permission android:name="android.permission.WRITE_SMS" />

如下面所示:

    <?xml version="1.0" encoding="utf-8"?>
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.fn.paysdk"
    android:versionCode="1"
    android:versionName="1.0" >

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.SEND_SMS" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
    <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
    
    <uses-sdk
        android:minSdkVersion="8"
        android:targetSdkVersion="17" />


		<service
            android:name="mm.purchasesdk.iapservice.PurchaseService"
            android:exported="true" >

            <!-- android:process="mm.iapServices" > -->
            <intent-filter android:priority="312" >
                <action android:name="com.aspire.purchaseservice.BIND" />
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
            <intent-filter android:priority="312" >
                <action android:name="你的包名.purchaseservice.BIND" />
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>

            <intent-filter android:priority="312" >
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.SAFIAP.COMPONENT" >
                </category>
            </intent-filter>
        </service>
        <!-- android:excludeFromRecents="true" -->
        <!-- android:launchMode="singleInstance" -->
        <activity
            android:name="mm.purchasesdk.iapservice.BillingLayoutActivity"
            android:configChanges="orientation|keyboardHidden"
            android:theme="@android:style/Theme.Translucent">
            <intent-filter android:priority="312" >
                <action android:name="你的包名.com.mmiap.activity" />

                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>

        <!-- android:process="safiap.framework.safframeworkmanager" begin -->
        <service
            android:name="safiap.framework.SafFrameworkManager"
            android:exported="true"
            android:process="safiap.framework" >
            <intent-filter android:priority="632" >

            <!-- ID for services declared in AIDL -->
        		<action android:name="safiap.framework.sdk.ISAFFramework" />
            </intent-filter>
            <intent-filter android:priority="632" >
                <!-- ID for services declared in AIDL -->
                <action android:name="safiap.framework.ACTION_START_DOWNLOAD" />
        	</intent-filter>
        	<intent-filter android:priority="632" >
                <!-- ID for services declared in AIDL -->
                <action android:name="safiap.framework.ACTION_CHECK_UPDATE" />
            </intent-filter>
        </service>
        <!-- receivers -->
        <receiver android:name="safiap.framework.CheckUpdateReceiver" >
            <intent-filter>
                <action android:name="safiap.framework.ACTION_CANCEL_NOTIFICATION" />
            </intent-filter>
            <intent-filter>
                <action android:name="safiap.GET_SHARED_DATA" />
            </intent-filter>
            <intent-filter>
                <action android:name="safiap.framework.ACTION_SET_TIMER" />
            </intent-filter>
        </receiver>
        <activity
            android:name="safiap.framework.ui.UpdateHintActivity" 
            android:launchMode="singleInstance"
            android:excludeFromRecents="true"
            android:configChanges="orientation"
            android:theme="@android:style/Theme.Translucent.NoTitleBar">
            <intent-filter>
                <action android:name="safiap.framework.ACTION_TO_INSTALL" />
            </intent-filter>
            <intent-filter>
                <action android:name="safiap.framework.ACTION_TO_INSTALL_IAP" />
            </intent-filter>
            <intent-filter>
                <action android:name="safiap.framework.ACTION_NETWORK_ERROR_IAP" />
            </intent-filter>
            <intent-filter>
                <action android:name="safiap.framework.ACTION_NETWORK_ERROR_FRAMEWORK" />
            </intent-filter>
        </activity>
        <service android:name="safiap.framework.logreport.monitor.handler.LogreportHandler" android:process=":remote"/>
       	<!-- android:process="safiap.framework.safframeworkmanager" end -->
		<!-- alipay sdk begin -->
        <activity
            android:name="com.alipay.sdk.app.H5PayActivity"
            android:configChanges="orientation|keyboardHidden|navigation"
            android:exported="false"
            android:screenOrientation="behind"
            android:windowSoftInputMode="adjustResize|stateHidden" >
        </activity>
        <!-- alipay sdk end -->
        
        <activity android:name="com.fn.paysdk.FNPaySMSActivity"
             android:screenOrientation="portrait"
             
             android:theme="@android:style/Theme.Dialog"></activity>
        <activity android:name="com.fn.paysdk.ChooseActivity"
             android:screenOrientation="portrait"
             
             android:theme="@android:style/Theme.Dialog"></activity>
        <activity android:name="com.fn.paysdk.PaySuccessActivity"
            android:screenOrientation="portrait"
            android:theme="@android:style/Theme.Dialog"></activity>
        <activity android:name="com.fn.paysdk.PayFailedActivity"
            android:screenOrientation="portrait"
            android:theme="@android:style/Theme.Dialog"></activity>
        <activity android:name="com.fn.paysdk.FNNotifActivity"></activity>
        <activity android:name="com.fn.paysdk.FNWoActivity"></activity>
        <service android:name="com.fn.paysdk.service.FNService"></service>
        
         <activity
	android:name="com.unicom.woopensmspayment.UnicomWoOpenPaymentMainActivity"
            android:configChanges="keyboardHidden|orientation|screenSize"
            android:screenOrientation="portrait"
            android:windowSoftInputMode="stateAlwaysHidden|adjustPan" >
        </activity>
        <activity
            android:name="com.unicom.woopensmspayment.UnicomSMSSuccessActivity"
            android:configChanges="keyboardHidden|orientation|screenSize"
            android:launchMode="singleTop"
            android:screenOrientation="portrait" />
        <activity
            android:name="com.unicom.woopensmspayment.UnicomSMSFaildActivity"
            android:configChanges="keyboardHidden|orientation|screenSize"
            android:launchMode="singleTop"
            android:screenOrientation="portrait" />
        <activity
            android:name="com.unicom.woopensmspayment.UnicomSMSTimeOutActivity"
            android:configChanges="keyboardHidden|orientation|screenSize"
            android:launchMode="singleTop"
            android:screenOrientation="portrait" />
        <activity
            android:name="com.unicom.woopensmspayment.RecordsConsumptionActivity"
            android:configChanges="keyboardHidden|orientation|screenSize"
            android:launchMode="singleTop"
            android:screenOrientation="portrait" />

        <meta-data
            android:name="CHINA_UNICOM_MOBILE_CHANNEL"
            android:value="23" />
	</application>
    </manifest>
1）AndroidManifest 设置（开发者必须要注意的地方）
	在上述声明中，需要注意声明BillingLayoutActivity中的Action
	<activity            android:name="mm.purchasesdk.iapservice.BillingLayoutActivity"
            android:configChanges="orientation|keyboardHidden"
            android:theme="@android:style/Theme.Translucent">
	<intent-filter android:priority="313" >
	<action android:name="你程序的包名.com.mmiap.activity" />
	<category android:name="android.intent.category.DEFAULT" />
	</intent-filter>
	</activity>
	请将action声明为您程序的包名.com.mmiap.activity
	在上述声明中，需要注意声明PurchaseService中的Action
	<intent-filter android:priority="313" >
       <action android:name="你程序的包名.purchaseservice.BIND" />
       <category android:name="android.intent.category.DEFAULT" />
	</intent-filter>


##第二步：服务端计费成功通知接口


当计费成功后，蜂鸟计费平台将通知业务平台平台订单计费成功。便于应用平台进行下一步逻辑的处理。

1）接口调用请求说明

http请求方式：POST

    http://NOTIFY_URL/notify

POST数据格式：JSON

POST数据例子：

    {
        "orderId":"1234567890123456789",
        "sum":300,
        "payTime":"2014-04-05 12:22:30",
        "status":"支付成功",
        "buyerId":"13912345678",
        "appId":"12345678",
        "alias":"商户自定义字段"
    }

参数|是否必须|说明
---|-------|----
orderId|是|成功计费的订单流水号
sum|是|交易金额
payTime|是|成功计费时间
status|是|支付状态
alias|是|开发者自定义串，可以是渠道标识，长度不能超过为100个字符
NOTIFY_URL|是|业务平台定义的通知URL地址

2）返回说明

正常时的返回JSON数据包示例：

    {"errcode":0,"errmsg":"接收到订单计费通知信息"}

参数|是否必须|说明
---|-------|----
errcode|是|错误代码
errmsg|是|错误代码信息描述



