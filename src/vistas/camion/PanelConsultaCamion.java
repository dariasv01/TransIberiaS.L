package vistas.camion;

import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import facade.Facade;
import modelo.vista.CamionMV;
import vistas.comunes.PanelMensaje;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class PanelConsultaCamion extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelConsultaCamion(String nombre) {
		setBackground(new Color(240, 230, 140));

		JScrollPane scrollPane = new JScrollPane();

		JLabel label = new JLabel(nombre);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 1115, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(45, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(29)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(165, Short.MAX_VALUE))
		);

//		String nombresColumnas[] = { "Matricula", "Marca", "Potncia", "Estado" };
//		String data[][] = { { "3930HDF", "MAN", "350.6 CV",  "En ruta" },
//				{ "1400DLG", "DAF", "500 CV",  "Parado" },
//				{ "2354DDX", "VOLVO", "250 CV",  "En garaje" },
//				{ "5984BMW", "IVECO", "300.8 CV", "Vendido" } };
		
		
		table = new JTable();
		Font font = new Font("Tahoma", Font.PLAIN, 16);
		table.setFont(font);
		table.getTableHeader().setFont(font);
//		DefaultTableModel defaultTableModel = new DefaultTableModel(data, nombresColumnas);
//		table.setModel(defaultTableModel);
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
}