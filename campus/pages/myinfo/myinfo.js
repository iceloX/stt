// pages/myinfo/myinfo.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userInfo: '',
    openId: null,
    userServerInfo:'' // 用户保存在服务器上的信息
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var app = getApp();
    this.setData({
      userInfo: app.globalData.userInfo,
      openId: app.globalData.openId
    });
    this.getUserServerInfo();
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
   * 获取用户的详细信息
   */
  getUserServerInfo:function(){
    var self = this;
    var app = getApp();
    wx.request({
      url: 'http://localhost/user/info/',
      method:'GET',
      data:{
        "openId":app.globalData.openId
      },
      success:function(res){
        self.setData({
          userServerInfo:res.data.result
        })
      }
    })
  }
})