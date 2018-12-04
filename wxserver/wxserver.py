from  flask   import Flask
from   flask  import render_template
from  flask  import jsonify
from flask  import   request
from db.dboperator import *
import  os
from werkzeug.utils import secure_filename
import   time



#创建flask应用对象
wxsever=Flask(__name__)


#请求的动作
@wxsever.route("/initwx")
def  initView():
     print("初始化微信页面数据")


     datas=getSwiperInfo()

     swiperdata=[]

     for  data in datas:
          swiperdata.append("http://2qqzfm.natappfree.cc/static"+data[0])

     print(swiperdata)

     return  jsonify({"swiperdata":swiperdata});


@wxsever.route("/initmusic")
#[{},{},{}]
def  getMusicData():
     print("获取音乐数据")

     datas=getMusicInfo()
     print(datas)

     musicdatas=[]

     for  data in  datas:
          obj={}
          obj["tname"]=data[1]
          obj["turl"]=data[2]
          musicdatas.append(obj)

     return jsonify({"musicdata":musicdatas})



if  __name__=="__main__":
     #http://127.0.0.1:8100发布了这个服务
     wxsever.run(debug=True,port=8100)
