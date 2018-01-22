using System.Collections;
using System.Collections.Generic;
using System.Net;
using UnityEngine;
using UnityEngine.Networking;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class Login : UnityEngine.MonoBehaviour
{
    //定义文本提交对象
    public UnityEngine.GameObject UserName;
    public UnityEngine.GameObject PassWord;
    //定义用户名与密码
    private string username;
    private string password;

    // 游戏方法初始化
    void Start () {
        this.GetComponent<Button>().onClick.AddListener(() => ClickButton(UserName,PassWord));  //当回调方法传递参数时,并且这个方法的参数是一个对象
	}
	
	// 游戏场景更新
	void Update () {
		
	}

    //为登录按钮绑定事件
    public void ClickButton(UnityEngine.GameObject UserName, UnityEngine.GameObject PassWord)
    {

        //获取玩家的用户名和密码
        username = UserName.GetComponent<InputField>().text;
        password = PassWord.GetComponent<InputField>().text;

        //输出用户信息，用于调试
        print("username====" + username);
        print("password====" + password);

        //调用方法进行加载
        StartCoroutine(Upload());

    }

    //upload()方法用于处理表单登录
    IEnumerator Upload()
    {

        //新建一个表单
        WWWForm formData = new WWWForm();
        
        //向表单中添加用户名与密码字段
        formData.AddField("username",username);
        formData.AddField("password", password);
        
        //创建一个web请求对象
        UnityWebRequest www = UnityWebRequest.Post("http://localhost:8080/Hello/Login",formData);

        //向tomcat服务器发送数据请求
        yield return www.SendWebRequest();

        if(www.isNetworkError || www.isHttpError)
        {
            Debug.Log(www.error);
           
        }
        else
        {
            Debug.Log("Form complete");

            //当请求处理成功后
            if (www.responseCode == 200)
            {
                //用于调试
                print("处理请求成功");
                print("result" + www.downloadHandler.text);

                //获取服务器返回结果
                string result = www.downloadHandler.text;
                
                //如果返回1,代表用户存在
                if (result.Equals("1"))
                {
                    SceneManager.LoadScene("002");
                }
                //如果返回0用户不存在
                else if (result.Equals("0"))
                {
                    print("用户不存在");
                }   
            }
            //请求处理失败
            else if (www.responseCode == 404)
            {
                print("处理失败");
            }
        }   
    }
}
