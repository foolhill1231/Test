package com.example.walkintracker;


import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;

public class WalkinView extends ListActivity {
	private DatabaseHelper dbhelper;

	private static final String[] COLUMNS ={"_id","date","eltime","distance","place"};
	private static int[] TO = { R.id._id, R.id.date, R.id.eltime, R.id.distance, R.id.place, };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);

        Button btnView = (Button) this.findViewById(R.id.btnRet);
        btnView.setOnClickListener(new OnClickListener(){
        	public void onClick(View v) {
        		finish();
        	}
        });

        dbhelper = new DatabaseHelper(this);
        Cursor cursor = getAll();
        showAll(cursor);
    }
    private Cursor getAll(){
    	SQLiteDatabase db = dbhelper.getReadableDatabase();
    	Cursor cursor = db.query("walkin", COLUMNS, null, null, null, null, "_id DESC");
    	startManagingCursor(cursor);
    	return cursor;
    }
    private void showAll(Cursor cursor) {
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this,
              R.layout.row, cursor, COLUMNS, TO);
        setListAdapter(adapter);
     }

}
