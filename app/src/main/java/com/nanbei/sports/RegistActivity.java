package com.nanbei.sports;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;
import entity.Student;
import org.junit.Test;

public class RegistActivity extends Activity {

    private String url="http://192.168.1.101:8080/SHproject/homepage/register";//服务器接口地址
    private EditText school,id,name,password;//用户名和密码
    private Button regist;//提交按钮
    private TextView result;//服务器返回结果

    private Student student = new Student();;

    private static Gson gson = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        //初始化数据
        school = (EditText) findViewById(R.id.editTextSchool);
        id = (EditText) findViewById(R.id.editTextID);
        name = (EditText) findViewById(R.id.editTextName);
        password = (EditText) findViewById(R.id.editTextPassword);
        regist = (Button) findViewById(R.id.buttonRegistByHttp);



        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取输入的数据
                String namevalue = name.getText().toString();
                String schoolvalue = name.getText().toString();
                String idvalue = name.getText().toString();
                String passwordvalue = name.getText().toString();
                System.out.println(namevalue);

                //set学生对象的值
                student.setSchool(schoolvalue);
                student.setId(idvalue);
                student.setName(namevalue);
                student.setPassword(passwordvalue);

                String stuJson = StudentToJson(student);
                System.out.println(stuJson);

            }
        });

    }

    //数据包装成json
    public String StudentToJson(Student stu){
        gson = new Gson();
        String json = gson.toJson(stu);
        return json;
    }

    @Test
    public void test(){
        Student student = new Student();
        //set学生对象的值
        student.setSchool("台州学院");
        student.setId("1536200182");
        student.setName("范逸东");
        student.setPassword("123");
        System.out.println(student.toString());
        System.out.println(StudentToJson(student));
    }
}
