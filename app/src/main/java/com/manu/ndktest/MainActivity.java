package com.manu.ndktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 使用NDK
 */
public class MainActivity extends AppCompatActivity {
    private EditText et_num1, et_num2;
    private TextView tv_result;
    /**
     * 静态代码块加载so文件
     * @param savedInstanceState
     */
    static{
        System.loadLibrary("hello");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_num1  = (EditText) findViewById(R.id.et_num1);
        et_num2  = (EditText) findViewById(R.id.et_num2);
        tv_result= (TextView) findViewById(R.id.tv_result);
    }
    /**
     * 单击事件
     * @param view
     */
    public void calculate(View view){
        String num1 = et_num1.getText().toString();
        String num2 = et_num2.getText().toString();
        int sum = js(Integer.parseInt(num1),Integer.parseInt(num2));
        tv_result.setText(String.valueOf(sum));
    }
    /**
     * 本地方法
     * @param num1
     * @param num2
     * @return
     */
    public native int js(int num1,int num2);
}
