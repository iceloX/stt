// pages/personage/personage.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: '',
    isLogin: false,
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    this.setData({
      userInfo : {avatarUrl:'https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F201912%2F25%2F20191225224833_zloky.thumb.400_0.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622940437&t=1e718d10f387bdbfa1627b7124f249e7'}
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  },

  /**
   * 获取用户授权信息
   */
  onGetUserInfo: function () {
    var self = this;
    var app = getApp(); 
    if (!this.data.isLogin) {
      wx.getUserProfile({
        lang: 'zh_CN',
        desc: '用于完善用户资料',
        success: function (res) {
          app.globalData.userInfo = res.userInfo;
          self.setData({
            userInfo: app.globalData.userInfo,
            isLogin: true
          });
          console.log(app.globalData.userInfo)
        },
        fail: function () {
          console.log("用户信息授权失败！")
        }
      })
    }
  },

  /**
   * 重定向个人详细信息页面
   */
  onClickMyInfo: function(){
    if(this.data.userInfo != ''){
      wx.navigateTo({
        url: '../../pages/myinfo/myinfo',
        fail: function(){
          console.log("页面通信失败！");
        }
      })
    }else{
      console.log("未登录！");
    }
    
  },

  onClickMyClub() {
    wx.navigateTo({
      url: '../../pages/myclub/myclub',
    })
  }
})