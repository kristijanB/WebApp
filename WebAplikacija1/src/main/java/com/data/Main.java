package com.data;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
        GetHnbData pojo=new GetHnbData();

        GetDBConnection connection=new GetDBConnection();
        connection.getCurrency();
        for (String string : connection.getCurrency()) {
			System.out.println(string);
		}
	}

}
