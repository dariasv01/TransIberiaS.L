package vistas.conductor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import vistas.comunes.PanelDatosPersonales;
import vistas.comunes.PanelMensaje;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelContratar extends JPanel{
	public PanelDatosPersonales panelDatosPersonales;
	public PanelMensaje panelMensaje;
	public PanelContratar(String nombre) {
		
		setBackground(new Color(240, 230, 140));
		
		JLabel lblNewLabel = new JLabel(nombre);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 230, 140));
		panelDatosPersonales = new PanelDatosPersonales();
		panel.setLayout(new BorderLayout(0, 0));
		panelDatosPersonales.setBackground(new Color(240, 230, 140));
		panel.add(panelDatosPersonales);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 230, 140));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Mensaje2 = new JPanel();
		panel_Mensaje2.setLayout(new BorderLayout(0, 0));
		
		panel_Mensaje2.setBackground(new Color(240, 230, 140));
		panelMensaje = new PanelMensaje();
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("imagenes\\conductor.png"));
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(56)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(495)
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(566)
									.addComponent(panel_Mensaje2, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(39)
							.addComponent(panelMensaje, GroupLayout.PREFERRED_SIZE, 560, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(68)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
							.addGap(41))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(label)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelMensaje, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(100)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addGap(70)
					.addComponent(panel_Mensaje2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(280))
		);
		setLayout(groupLayout);

		
	}
	public PanelDatosPersonales getPanelDatosPersonales() {
		return panelDatosPersonales;
	}
	public void setPanelDatosPersonales(PanelDatosPersonales panelDatosPersonales) {
		this.panelDatosPersonales = panelDatosPersonales;
	}
	
	public PanelMensaje getPanelMensaje() {
		return panelMensaje;
	}

	public void setPanelMensaje(PanelMensaje panelMensaje) {
		this.panelMensaje = panelMensaje;
	}
}
