package com.fro.sms_sendcase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btn;
	private EditText phoneEt, contextEt;
	private TextView sendMsgTv;
	private StringBuilder sendMsgSb = new StringBuilder();
	
	private OnClickListener listener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			// �绰����
			String phone = phoneEt.getText().toString();
			// ��������
			String context = contextEt.getText().toString();
			// ���Ĭ�ϵ���Ϣ������
			SmsManager manager = SmsManager.getDefault();
			// ��Ϊһ���������������ƣ����Ҫ�������Ų��
			ArrayList<String> list = manager.divideMessage(context); 
			for (String text : list) {
				// ������Ϣ
				manager.sendTextMessage(phone, null, text, null, null);
			}
			sendMsgTv.setText(sendMsgSb.append(context + '\n'));
			Toast.makeText(getApplicationContext(), "�������", Toast.LENGTH_SHORT).show();
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btn = (Button) this.findViewById(R.id.send_bt);
		phoneEt = (EditText) this.findViewById(R.id.phone_et);
		contextEt = (EditText) this.findViewById(R.id.msg_et);
		sendMsgTv = (TextView) this.findViewById(R.id.SendMsg_tv);
		btn.setOnClickListener(listener);
	}

}
