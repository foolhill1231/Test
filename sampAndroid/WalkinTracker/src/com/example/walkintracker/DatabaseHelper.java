package com.example.walkintracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

	public class DatabaseHelper extends SQLiteOpenHelper {
		private static final String DBNAME = "walkin.db";
		private static final int DBVERSION = 1;
		private static final String CREATE_TABLE_SQL =
		  "create table walkin"
		  + "(_id integer primary key autoincrement,"
		  + "date text not null,"
		  + "eltime text not null,"
		  + "distance real not null,"
		  + "place text null)";
		/*
		 * コンストラクタ
		 */
		public DatabaseHelper (Context context) {
			  super(context,DBNAME,null,DBVERSION);
		}
		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(CREATE_TABLE_SQL);
		}
		@Override
		public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion) {
			// データベースのバージョンアップ処理
		}
}
