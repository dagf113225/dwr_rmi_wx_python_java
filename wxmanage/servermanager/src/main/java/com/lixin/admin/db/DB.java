package com.lixin.admin.db;

/**
 * �޸�����:2018-12-04
 *�޸��ˣ�����
 *�ֻ�����:13913321086
 *�޸�ԭ��:db��Ϊrmi�ֲ�ʽ����ṹ
 * 
 */

/**import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class DB {
	private Connection conn;

	// �������ݿ�
	public DB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wxnkj", "root", "123456");

			System.out.println("�������ݿ�:" + conn);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public Object[][]  getSwiperDatas()
	{
		String sql = "SELECT  *  FROM  t_swiperimg";

		Object[][] datas = null;

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			int column = rsmd.getColumnCount();

			int count = 0;

			while (rs.next()) {
				count++;
			}

			// ��ɶ�ά���鴴����ʵ����
			datas = new Object[count][column];

			// ������ص���һ��
			rs.beforeFirst();

			int row = 0;

			while (rs.next())// ���Ƶ�����
			{
				for (int i = 1; i <= column; i++)// ���Ƶ�����
				{
					datas[row][i - 1] = rs.getObject(i);
				}
				row++;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(null!=conn)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return datas;

	}
	
	public  int   updateSwiperState(String[]  indexs)
	{
		
		String sql="UPDATE t_swiperimg SET  state=1  WHERE sid=?";
		
		int count=0;
		
		try {
			PreparedStatement  pstmt=conn.prepareStatement(sql);
			
			for(String index:indexs)
			{
				pstmt.setString(1, index);
				count=pstmt.executeUpdate();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(null!=conn)
			{
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return count;
		
	}

}**/
