//index.js
//获取应用实例
const app = getApp()

Page({
  data: {
  
  images:[]

  },

  onLoad: function () {


   var  that =this;

   //定时刷新
   setInterval(function(){

     wx.request({
       url: 'http://qyrpff.natappfree.cc/initwx',
       header: { "content-type": "application/json" },
       success: function (resp) {

         console.log(resp.data);

         that.setData({ images: resp.data.swiperdata });

       }

     })

   },3*1000);
   

  }
})
