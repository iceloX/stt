// pages/activity/activity.js
var util = require('../../utils/util.js');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    activityInfo:'',
    begin:'', // 活动开始时间
    end:'', // 活动结束时间
    active:0,
    maxactive:'4',
    isJoin:false,
    steps: [
      {text: '活动发布',desc: '发布时间',
      },
      {text: '活动报名',desc: '报名期限',
      },
      {text: '参加活动',desc: '活动时间',
      },
      {text: '录入学分',desc: '截止日期',
      },
      {text: '活动结束',desc: '圆满完成',
      },
    ],
    

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    console.log(options.flag)
    this.getActivityById(options.flag)

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

  next() {
    if(this.data.active != this.data.maxactive){
      this.setData({
        active: this.data.active+1
      })
    }else{
      this.setData({
        active: 0
      })
    }
    console.log("active为"+this.data.active)
    
  },

  /* 活动报名 */
  signUpActivity(e){

    this.setData({
      active: 1,
      isJoin: "true"
    })
    /* 发送请求到服务器 */
  },

  getActivityById(id){
    var self = this
    wx.request({
      url: 'http://localhost/activity/id/'+id,
      method:'GET',
      success:function(res){
        if(res.data.result!=null){
          var begin = new Date(res.data.result.begin)
          var end = new Date(res.data.result.end)
          begin = util.formatTime(begin)
          end = util.formatTime(end)
          self.setData({
            begin:begin,
            end:end
          })
        }
        // console.log(res.data.result)
        self.setData({
         activityInfo: res.data.result
         });
      }
    })

  }
})