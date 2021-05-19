// pages/community/community.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    community:'', // 社团数据
    activity:'' // 活动数据
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.getCommunityAll();
    this.getActivityAll();

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

  getCommunityAll() {
    var self = this;
    wx.request({
      url: 'http://localhost/community/all',
      method: 'GET',
      success: function (e) {
        console.log(e.data);
        self.setData({
          community:e.data.result
        });
      },
      fail: function (e) {
        console.log("获取swiper失败");
      }
    })
  },

  getActivityAll() {
    var self = this;
    wx.request({
      url: 'http://localhost/activity/all',
      method: 'GET',
      success: function (e) {
        console.log(e.data);
        self.setData({
          activity:e.data.result
        });
      },
      fail: function (e) {
        console.log("获取swiper失败");
      }
    })
  },
  GotoSearch: function(e) {
    wx.navigateTo({
      url: '../search/search',
    })
  }
})