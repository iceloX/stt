// pages/sign/sign.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    latitude: '',
    longitude: '',
    markers: '',
    result:'',
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    // var amapFile = require('../../libs/amap-wx');
    // var that = this;
    // var myAmapFun = new amapFile.AMapWX({key:'0c8b966b4dbea07f16c0db38d4126d18'});
    // myAmapFun.getRegeo({
    //   iconPath: "../../assets/location.png",
    //   iconWidth: 22,
    //   iconHeight: 32,
    //   success: function(data){
    //     console.log(data)
    //     var marker = [{
    //       id: data[0].id,
    //       latitude: data[0].latitude,
    //       longitude: data[0].longitude,
    //       iconPath: data[0].iconPath,
    //       width: data[0].width,
    //       height: data[0].height
    //     }]
    //     that.setData({
    //       markers: marker
    //     });
    //     that.setData({
    //       latitude: data[0].latitude
    //     });
    //     that.setData({
    //       longitude: data[0].longitude
    //     });
    //     that.setData({
    //       textData: {
    //         name: data[0].name,
    //         desc: data[0].desc
    //       }
    //     })
    //   },
    //   fail: function(info){
    //     // wx.showModal({title:info.errMsg})
    //   }
    // })
    this.getData();
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
   * 加载本页数据
   */
  getData: function () {
    var self = this;
    wx.getLocation({
      type: "gcj02",
      success(res) {
        console.log(res)
        self.setData({
          latitude: res.latitude,
          longitude: res.longitude,
          markers: [
            {
              id: 1,
              latitude: res.latitude,
              longitude: res.longitude,
              width: 30,
              heigth: 20,
              callout: {
                content: "当前位置",
                color: '#0AAAF6',
                fontSize: 13,
                borderRadius: 3,
                borderWidth: 1,
                borderColor: '#0AAAF6',
                padding: 2,
                display: 'BYCLICK'
              }
            }
          ]
        })
      }
    })

  },

  getSignAll(){
  },

  /**
   * 打开扫一扫
   */
  scan:function() {
    var that = this;
    wx.scanCode({
      success: function(res){
        var result = res.result ;
        that.setData({
          result: result
        })
        console.log(res.result)
      }
    })
  }
})