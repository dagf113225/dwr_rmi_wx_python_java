package com.lixin.dao.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IDao  extends Remote {

    //�Զ���ȡ���ͨ�������ֵ���ʽ��������
    public  void    checkMusicAdd()  throws RemoteException;
    
    //��ȡ�ֲ�ͼ
    public  Object[][]   getSwiperDatas()  throws RemoteException;

    //�ֶ������ֲ�ͼ
    public  int   updateSwiperState(String[]  indexs) throws RemoteException;
}
