package com.example.androidbluetooch;

import android.app.Dialog;  
import android.content.Context;  
import android.os.Bundle;  
import android.view.View;  
import android.widget.Button;  
import android.widget.TextView;  
  
/** 
 * �����Զ����dialog����Ҫѧϰ��ʵ��ԭ�� 
 * Created by chengguo on 2016/3/22. 
 */  
public class SelfDialog extends Dialog {  
  
    private Button yes;//ȷ����ť  
    private Button no;//ȡ����ť  
    private TextView titleTv;//��Ϣ�����ı�  
    private TextView messageTv;//��Ϣ��ʾ�ı�  
    private String titleStr;//��������õ�title�ı�  
    private String messageStr;//��������õ���Ϣ�ı�  
    //ȷ���ı���ȡ���ı�����ʾ����  
    private String yesStr, noStr;  
  
    private onNoOnclickListener noOnclickListener;//ȡ����ť������˵ļ�����  
    private onYesOnclickListener yesOnclickListener;//ȷ����ť������˵ļ�����  
  
    /** 
     * ����ȡ����ť����ʾ���ݺͼ��� 
     * 
     * @param str 
     * @param onNoOnclickListener 
     */  
    public void setNoOnclickListener(String str, onNoOnclickListener onNoOnclickListener) {  
        if (str != null) {  
            noStr = str;  
        }  
        this.noOnclickListener = onNoOnclickListener;  
    }  
  
    /** 
     * ����ȷ����ť����ʾ���ݺͼ��� 
     * 
     * @param str 
     * @param onYesOnclickListener 
     */  
    public void setYesOnclickListener(String str, onYesOnclickListener onYesOnclickListener) {  
        if (str != null) {  
            yesStr = str;  
        }  
        this.yesOnclickListener = onYesOnclickListener;  
    }  
  
    public SelfDialog(Context context) {  
        super(context, R.style.MyDialog);  
    }  
  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.free_exercise_sure_dialog_layout);  
        //���հ״�����ȡ������  
        setCanceledOnTouchOutside(false);  
  
        //��ʼ������ؼ�  
        initView();  
        //��ʼ����������  
        initData();  
        //��ʼ������ؼ����¼�  
        initEvent();  
          
    }  
  
    /** 
     * ��ʼ�������ȷ����ȡ�������� 
     */  
    private void initEvent() {  
        //����ȷ����ť�������������ṩ����  
        yes.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                if (yesOnclickListener != null) {  
                    yesOnclickListener.onYesClick();  
                }  
            }  
        });  
        //����ȡ����ť�������������ṩ����  
        no.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View v) {  
                if (noOnclickListener != null) {  
                    noOnclickListener.onNoClick();  
                }  
            }  
        });  
    }  
  
    /** 
     * ��ʼ������ؼ�����ʾ���� 
     */  
    private void initData() {  
        //����û��Զ���title��message  
        if (titleStr != null) {  
            titleTv.setText(titleStr);  
        }  
        if (messageStr != null) {  
            messageTv.setText(messageStr);  
        }  
        //������ð�ť������  
        if (yesStr != null) {  
            yes.setText(yesStr);  
        }  
        if (noStr != null) {  
            no.setText(noStr);  
        }  
    }  
  
    /** 
     * ��ʼ������ؼ� 
     */  
    private void initView() {  
        yes = (Button) findViewById(R.id.yes);  
        no = (Button) findViewById(R.id.no);  
        titleTv = (TextView) findViewById(R.id.title);  
        messageTv = (TextView) findViewById(R.id.message);  
    }  
  
    /** 
     * �����ActivityΪDialog���ñ��� 
     * 
     * @param title 
     */  
    public void setTitle(String title) {  
        titleStr = title;  
    }  
  
    /** 
     * �����ActivityΪDialog����dialog��message 
     * 
     * @param message 
     */  
    public void setMessage(String message) {  
        messageStr = message;  
    }  
  
    /** 
     * ����ȷ����ť��ȡ��������Ľӿ� 
     */  
    public interface onYesOnclickListener {  
        public void onYesClick();  
    }  
  
    public interface onNoOnclickListener {  
        public void onNoClick();  
    }  
}  
