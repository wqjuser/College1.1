package mmona.hellodata.college;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Json.json;
import model.college_message;
import service.SDS_Httpclient;
import service.SDS_ZMHandler;

public class delete_college_manager extends AppCompatActivity {
    public Button gxq_input;
    public EditText gonghao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_college_manager);
        gonghao = (EditText)findViewById(R.id.gxq_delete);
    }
    public void gxq_input(View view){
        new Thread(){
            public void run(){
                String path = "http://192.168.191.1:8080/MyHsd/submitgonghao";
                SDS_Httpclient conn = new SDS_Httpclient();
                conn.Postclient(path,gonghao.getText().toString(),gxq_delete_college);
            }
        }.start();

    }
    public SDS_ZMHandler gxq_delete_college = new SDS_ZMHandler(){
        @Override
        public void onSuccess(String content) {
            super.onSuccess(content);
            Toast.makeText(delete_college_manager.this, "与服务器连接成功", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onFailture(String content) {
            super.onFailture(content);
            Toast.makeText(delete_college_manager.this, "失败", Toast.LENGTH_SHORT).show();
        }
    };
}
