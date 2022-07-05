package Controller;

import java.rmi.Naming;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Model.AdminModel;
import Model.benhnhan;
import Server.IServer;

public class Dao {
	public Connection conn = null;
	public PreparedStatement sttm = null;
	public ResultSet rst = null;
	public Statement attm = null;
	private ArrayList list;
	private IServer iServer;

	public String add(benhnhan benhnhan) {
		try {
			String sSQL = "insert into danhsach (ID,Name,Phone,Birthday,Dayin,Type,Room,Department,Bed,Address) values (?,?,?,?,?,?,?,?,?,?)";
			conn = ConnectDB.openConnection();
			sttm = conn.prepareStatement(sSQL);
			sttm.setString(1, benhnhan.getId());
			sttm.setString(2, benhnhan.getName());
			sttm.setString(3, benhnhan.getPhone());
			sttm.setDate(4, new java.sql.Date(benhnhan.getBirthday().getTime()));
			sttm.setDate(5, new java.sql.Date(benhnhan.getDayin().getTime()));
			sttm.setString(6, benhnhan.getType());
			sttm.setString(7, benhnhan.getRoom());
			sttm.setString(8, benhnhan.getDepartment());
			sttm.setString(9, benhnhan.getBed());
			sttm.setString(10, benhnhan.getAddress());
			try {
				iServer = (IServer) Naming.lookup("rmi://localhost:1099/db");
			} catch (Exception e) {
				return "Vui lòng kết nối với server";
			}
			if (sttm.executeUpdate() > 0) {
				return "Thêm thành công";
			} else {
				return "Thêm Chưa thành công";
			}
		} catch (Exception e) {
			return "Đã tồn tại bệnh nhân trong danh sách";
		}
	}

	public String edit(benhnhan benhnhan) {

		try {
			String sSQL = "update danhsach set Name=?,Phone=?,Birthday=?,Dayin=?,Type=?,Room=?,Department=?,Bed=?,Address=? where ID = ? ";
			conn = ConnectDB.openConnection();
			sttm = conn.prepareStatement(sSQL);
			sttm.setString(1, benhnhan.getName());
			sttm.setString(2, benhnhan.getPhone());
			sttm.setDate(4, new java.sql.Date(benhnhan.getBirthday().getTime()));
			sttm.setDate(5, new java.sql.Date(benhnhan.getDayin().getTime()));
			sttm.setString(5, benhnhan.getType());
			sttm.setString(6, benhnhan.getRoom());
			sttm.setString(7, benhnhan.getDepartment());
			sttm.setString(8, benhnhan.getBed());
			sttm.setString(9, benhnhan.getAddress());
			sttm.setString(10, benhnhan.getId());
			try {
				iServer = (IServer) Naming.lookup("rmi://localhost:1099/db");
			} catch (Exception e) {
				return "Vui lòng kết nối với server";
			}
			if (sttm.executeUpdate() > 0) {
				return "Đã sửa thành công";
			} else {
				return "Đã sửa không thành công";
			}
		} catch (Exception e) {
			return "";
		}
	}

	public String del(String id) {
		try {
			String sSQL = "DELETE danhsach where ID = ?";
			conn = ConnectDB.openConnection();
			sttm = conn.prepareStatement(sSQL);
			sttm.setString(1, id);
			try {
				iServer = (IServer) Naming.lookup("rmi://localhost:1099/db");
			} catch (Exception e) {
				return "Vui lòng kết nối với server";
			}
			sttm.executeUpdate();
			conn.close();
			sttm.close();
		} catch (Exception e) {
			System.out.println("Error :" + e.toString());
		}
		return "Đã xóa";
	}

	public List<benhnhan> getAllAccount() {
		list = new ArrayList<>();
		try {
			String sSQL = "select ID,Name,Phone,Birthday,Dayin,Type,Room,Department,Bed,Address from danhsach";
			conn = ConnectDB.openConnection();
			attm = conn.createStatement();
			rst = attm.executeQuery(sSQL);
			while (rst.next()) {
				benhnhan benhnhan = new benhnhan();
				benhnhan.setId(rst.getString(1));
				benhnhan.setName(rst.getString(2));
				benhnhan.setPhone(rst.getString(3));
				benhnhan.setBirthday(rst.getDate(4));
				benhnhan.setDayin(rst.getDate(5));
				benhnhan.setType(rst.getString(6));
				benhnhan.setRoom(rst.getString(7));
				benhnhan.setDepartment(rst.getString(8));
				benhnhan.setBed(rst.getString(9));
				benhnhan.setAddress(rst.getString(10));
				list.add(benhnhan);
			}
			conn.close();
			attm.close();
		} catch (Exception e) {
			System.out.println("Error :" + e.toString());
		}
		return list;
	}

	public benhnhan getAccountUsername(String id) {
		benhnhan benhnhan = new benhnhan();
		try {
			String sSQL = "select ID,Name,Phone,Birthday,Dayin,Type,Room,Department,Bed,Address from danhsach where ID = ?";
			conn = ConnectDB.openConnection();
			sttm = conn.prepareStatement(sSQL);
			sttm.setString(1, id);
			rst = sttm.executeQuery();
			while (rst.next()) {
				benhnhan.setId(rst.getString(1));
				benhnhan.setName(rst.getString(2));
				benhnhan.setPhone(rst.getString(3));
				benhnhan.setBirthday(rst.getDate(4));
				benhnhan.setDayin(rst.getDate(5));
				benhnhan.setType(rst.getString(6));
				benhnhan.setRoom(rst.getString(7));
				benhnhan.setDepartment(rst.getString(8));
				benhnhan.setBed(rst.getString(9));
				benhnhan.setAddress(rst.getString(10));
				return benhnhan;
			}
			conn.close();
			sttm.close();
			rst.close();
		} catch (Exception e) {
			System.out.println("Error :" + e.toString());
		}
		return benhnhan;
	}
	
	public String add(AdminModel rg){

		try {
			String sSQL = "insert into admin (account,password) values (?,?)";
			conn = ConnectDB.openConnection();
			sttm = conn.prepareStatement(sSQL);
			sttm.setString(1, rg.getAccount());
			sttm.setString(2, rg.getPassword());
			try {
				iServer = (IServer) Naming.lookup("rmi://localhost:1099/db");
			} catch (Exception e) {
				return "Vui lòng kết nối với server";
			}
			if (sttm.executeUpdate() > 0) {
				return "Tạo tài khoản thành công";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}


