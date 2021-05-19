// pages/activity/activity.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
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
    url:"https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F30442067bbd3f478e8eab9c5927faa7faac4da204dcfd-VYVBxs_fw658&refer=http%3A%2F%2Fhbimg.b0.upaiyun.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1622208813&t=ec2dcba7be73d1edf7c817600ab03aa4",

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

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
  }
})