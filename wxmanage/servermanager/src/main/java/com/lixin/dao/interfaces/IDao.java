package com.lixin.dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDao  extends Remote {

    //自动获取审核通过的音乐到正式发布方法
    public  void    checkMusicAdd()  throws RemoteException;
    
    //获取轮播图
    public  Object[][]   getSwiperDatas()  throws RemoteException;

    //手动启用轮播图
    public  int   updateSwiperState(String[]  indexs) throws RemoteException;
}
