package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.sql.PreparedStatement;

import com.entity.Items;
import com.util.DBHelper;

/**
 * 实体类 
 * @author Administrator
 * @date 22017-09-10
 */
public class ItemsDAO {

	public ArrayList<Items> getAllItems() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		ArrayList<Items> list = new ArrayList<>();

		conn = DBHelper.getConnection();
		String sql = "SELECT * FROM items;";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setPrice(rs.getInt("price"));
				item.setNumber(rs.getInt("number"));
				item.setPicture(rs.getString("picture"));
				list.add(item);
			}

			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}

	// 根据商品编号ID获得商品详细资料
	public Items getItemsById(int id) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		conn = DBHelper.getConnection();
		String sql = "SELECT * FROM items WHERE id = ?";
		try {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setPrice(rs.getInt("price"));
				item.setNumber(rs.getInt("number"));
				item.setPicture(rs.getString("picture"));
				return item;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return null;
	}
	
	//获取最近浏览的5条记录
	public LinkedHashSet<Items> getViewList(String list){
		System.out.println("list:" + list);
		LinkedHashSet<Items> itemList = new LinkedHashSet<>();
		int iCount = 5;
		if (list != null && list.length() > 0) {
			String[] arr = list.split(",");
			System.out.println("arr.length=" + arr.length);
			
			//若商品记录大于等于5条就浏览最近浏览的5条记录
			if (arr.length >= 5) {
				for(int i = arr.length - 1; i >= arr.length - iCount; i--) {
					itemList.add(getItemsById(Integer.parseInt(arr[i])));
				}
			} else {
				for(int i = arr.length -1; i >= 0; i--) {
					itemList.add(getItemsById(Integer.parseInt(arr[i])));
				}
			}
			
			return itemList;
		}
		return null;
	}
}
