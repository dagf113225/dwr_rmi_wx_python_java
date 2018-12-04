package com.lixin.admin.db;

/**
 * 修改日期:2018-12-04
 *修改人：李欣
 *手机号码:13913321086
 *修改原因:db改为rmi分布式服务结构
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

	// 连接数据库
	public DB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/wxnkj", "root", "123456");

			System.out.println("连接数据库:" + conn);

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

			// 完成二维数组创建，实例化
			datas = new Object[count][column];

			// 结果集回到第一行
			rs.beforeFirst();

			int row = 0;

			while (rs.next())// 控制的是行
			{
				for (int i = 1; i <= column; i++)// 控制的是列
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
