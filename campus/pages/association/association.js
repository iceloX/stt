// pages/association/association.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    active: 4,
    community: '', // 当前的社团
    activities:'', // 社团中的活动
    swipers: '',
    users:'', // 社团中的用户
    steps: [{
        text: '荣誉1',
        desc: '获得时间',
      },
      {
        text: '荣誉2',
        desc: '获得时间',
      },
      {
        text: '荣誉3',
        desc: '获得时间',
      },
      {
        text: '荣誉4',
        desc: '获得时间',
      },
      {
        text: '荣誉5',
        desc: '获得时间',
      },
    ]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    let id = decodeURIComponent(options.id);
    console.log(id)
    this.getCommunityById(id);
    this.getActivityByComId(id);
    this.getUserByComId(id);
    this.getSwiper()
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

  bindchange(e) {
    this.setData({
      swiperIndex: e.detail.current
    })
  },

  /**
   * 获取swiper数据
   */
  getSwiper() {
    var self = this;
    wx.request({
      url: 'http://localhost/activity/top/3',
      method: 'GET',
      success: function (e) {
        console.log(e.data);
        self.setData({
          swipers: e.data.result
        });
      },
      fail: function (e) {
        console.log("获取swiper失败");
      }
    })
  },
  /**
   * 根据社团id查询社团
   */
  getCommunityById(id) {
    var self = this
    wx.request({
      url: 'http://localhost/community/id/' + id,
      method: 'GET',
      success: function (e) {
        console.log(e.data.result)
        self.setData({
          //swipers: e.data.result,
          community: e.data.result
        });
      },
      fail: function (e) {
        console.log("获取社团失败");
      }
    })
  },
  getActivityByComId(id){
    var self = this
    wx.request({
      url: 'http://localhost/activity/community/' + id,
      method: 'GET',
      success: function (e) {
        console.log(e.data.result)
        self.setData({
         activities:e.data.result
        });
      },
      fail: function (e) {
        console.log("获取社团失败");
      }
    })
  },
  getUserByComId(id){
    var self = this
    wx.request({
      url: 'http://localhost/user/community/' + id,
      method: 'GET',
      success: function (e) {
        console.log(e.data.result)
        self.setData({
         users:e.data.result
        });
      },
      fail: function (e) {
        console.log("获取社团失败");
      }
    })
  }
})