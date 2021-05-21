// app.js
App({

  onLaunch() {
    // 展示本地存储能力
    const logs = wx.getStorageSync('logs') || []
    logs.unshift(Date.now())
    wx.setStorageSync('logs', logs)

    // 登录
    // wx.login({
    //   success: res => {
    //     // 发送 res.code 到后台换取 openId, sessionKey, unionId
    //     var code = res.code; //返回code
    //     console.log("code为" + code);
    //     var appId = 'wx77e608257a15f1b7';
    //     var secret = 'af0ca6af0c53211e839801efdff55d1e';
    //     wx.request({
    //       url:'http://localhost/user/login',
    //       header: {
    //         'content-type': 'json'
    //       },

    //       success: function (res) {
    //         var openid = res.data.openid //返回openid
    //         console.log('openid为' + openid);
    //         var app = getApp();
    //         app.globalData.openId = openid;
    //       }
    //     })
    //   }
    // })
  },
  globalData: {
    userInfo: null,
    openId: null
  },
})