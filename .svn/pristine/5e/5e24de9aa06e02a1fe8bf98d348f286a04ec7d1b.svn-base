package service;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

//Custom Renderer - does the default rendering except if told the row should be a different color
/***
 * http://stackoverflow.com/questions/11859329/java-jtable-how-to-render-left-column-cells-for-simple-row-header-purposes
 * 
 * @author tonghua
 * 
 */
public class JTableColumnRender extends DefaultTableCellRenderer {

	private static final long serialVersionUID = -8358636330478673329L;

	public JTableColumnRender() {
		super();
		// Customize the rendering however you want
		setBackground(UIManager.getColor("TableHeader.background"));
	}
}
