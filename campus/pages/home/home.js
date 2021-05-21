// pages/home/home.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    swiperHeight: 200, // swiper高度
    swipers: '', // swiper数据
    swiperIndex: 0,
    communityTop:'', // 十佳社团数据
    activityTop:'', // 十佳活动数据
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    this.getSwiper();
    this.getCommunityTop();
    this.getActivityTop();
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
    //在当前页面显示导航条加载动画
    wx.showNavigationBarLoading(); 
    //显示 loading 提示框。需主动调用 wx.hideLoading 才能关闭提示框
    wx.showLoading({
      title: '刷新中...',
    })

    wx.stopPullDownRefresh()
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
   * 轮播图变化时-修改当前的swiperIndex
   */
  bindchange(e) {
    this.setData({
      swiperIndex: e.detail.current
    })
  },

  /**
   * 获取swiper数据 <前3条数据>
   */
  getSwiper() {
    var self = this;
    wx.request({
      url: 'http://localhost/activity/top/3',
      method: 'GET',
      success: function (e) {
      
        self.setData({
          // 
          swipers:e.data.result
        });
      },
      fail: function (e) {
        console.log("获取swiper失败");
      }
    })
  },

  /**
   * 获取十佳社团数据
   */
  getCommunityTop(){
    var self = this;
    wx.request({
      url: 'http://localhost/community/top/10',
      method: 'GET',
      success: function (e) {
        self.setData({
         //swipers: e.data.result,
        communityTop: e.data.result
        });
      },
      fail: function (e) {
        console.log("获取swiper失败");
      }
    })
  },

  // 十佳活动数据
  getActivityTop(){
    var self = this;
    wx.request({
      url: 'http://localhost/activity/top/10',
      method: 'GET',
      success: function (e) {
        self.setData({
         //swipers: e.data.result,
        activityTop: e.data.result
        });
      },
      fail: function (e) {
        console.log("获取swiper失败");
      }
    })
  },

  /**
   * 底部导航栏点击改变事件
   */
  handleChange({detail}) {
    this.setData({
      current: detail.key
    });
  },

  /* 点击搜索框跳转搜索页面事件 */
  GotoSearch: function(e) {
    wx.navigateTo({
      url: '../search/search',
    })
  },
  
  /* 点击swiper跳转指定页面 */
  clickSwiper(e){
    console.log("当前swiper的url是"+e.currentTarget.dataset.url)
    wx.navigateTo({
      url: '../../pages/activity/activity?url='+e.currentTarget.dataset.url,
    })
    
  },

  /**
   * 点击card进入社团
   */
  clickAssCard(e) {
    wx.navigateTo({
      url: '../../pages/association/association?id='+e.currentTarget.dataset.id,
    })
  },

  /**
   * 点击card进入活动详情
   */
  clickActCard(e) {
    wx.navigateTo({
      url: '../../pages/activity/activity?flag='+e.currentTarget.dataset.flag,
    })
  }
})