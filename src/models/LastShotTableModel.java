package models;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class LastShotTableModel extends  AbstractTableModel {

	
	/****************** attributes ***********************/
	private static final long serialVersionUID = -608746368845155549L;
	private List<String[]> rows;
	private String[] columnNames= {"Distance", "Max Height"};
	/****************** attributes ends ******************/

	/****************** constructors *********************/
	public LastShotTableModel() {
		rows = new ArrayList<String[]>();
		rows.add(columnNames);// add as header to avoid header won't display without jscrolpanel.
	}

	/****************** constructors ends ****************/

	/****************** private methods ******************/
	// To do: Code here
	/****************** private methods ends *************/

	/****************** properties ***********************/
	// To do: setters and getters code here
	/****************** properties ends ******************/

	/****************** public methods *******************/
	public void show(double distance, double maxHeight) {
		String[] row = new String[this.getColumnCount()];
		row[0]=String.format("%1$,.2f", distance);
		row[1]=String.format("%1$,.2f", maxHeight);
		rows.clear();
		rows.add(columnNames); // remove data row, keeps header row.
		rows.add(row);
		fireTableDataChanged();
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
	    return false; // does not allowed to edit cells 
	}
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		String[] row = rows.get(rowIndex);
        return row[columnIndex];
	}

	/****************** public methods ends **************/

}
