package vistas.conductor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import vistas.comunes.PanelComboBox;
import vistas.comunes.PanelDatosPersonales;

import javax.swing.JButton;
import javax.swing.JTextField;
import vistas.comunes.PanelMensaje;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class PanelDespedir extends JPanel {
	private PanelComboBox panelCombo;
	public PanelMensaje panelMensaje;
	public PanelDatosPersonales panelDatosPersonales;
	private JLabel label;

	public PanelDespedir(String name) {
		setBackground(new Color(240, 230, 140));

		JLabel lblConsultaMedico = new JLabel(name);
		lblConsultaMedico.setFont(new Font("Tahoma", Font.BOLD, 22));
		panelCombo = new PanelComboBox("Conductor", "ID");
		panelCombo.setBackground(new Color(240, 230, 140));

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout(0, 0));
		panelDatosPersonales = new PanelDatosPersonales();
		panelDatosPersonales.getTxtaApellido().setVisible(false);
		panelDatosPersonales.getLblApellido().setVisible(false);
		panelDatosPersonales.getTxtNombre().setEditable(false);
		panelDatosPersonales.getTxtDireccion().setEditable(false);
		panelDatosPersonales.getTextTelefono().setEditable(false);
		panelDatosPersonales.getEspecialidad().setVisible(false);
		panelDatosPersonales.getTxtHabilidad().setVisible(true);
		panel.add(panelDatosPersonales);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 230, 140));
		panel_1.setLayout(new BorderLayout(0, 0));
		panelMensaje = new PanelMensaje();

		label = new JLabel("");
		label.setIcon(new ImageIcon("imagenes\\conductor.png"));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblConsultaMedico)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(panelMensaje, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 565, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
								.addComponent(panelCombo, GroupLayout.PREFERRED_SIZE, 633, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label)))
					.addContainerGap(452, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblConsultaMedico)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panelCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 372, GroupLayout.PREFERRED_SIZE)
							.addGap(34)
							.addComponent(panelMensaje, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(54)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 474, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}

	public JComboBox getComboId() {
		return panelCombo.getComboBoxID();
	}

	public JComboBox getComboNombre() {
		return panelCombo.getComboBoxNombre();
	}

	public PanelComboBox getPanelCombo() {
		return panelCombo;
	}

	public void setPanelCombo(PanelComboBox panelCombo) {
		this.panelCombo = panelCombo;
	}

	public PanelMensaje getPanelMensaje() {
		return panelMensaje;
	}

	public void setPanelMensaje(PanelMensaje panelMensaje) {
		this.panelMensaje = panelMensaje;
	}

	public PanelDatosPersonales getPanelDatosPersonales() {
		return panelDatosPersonales;
	}

	public void setPanelDatosPersonales(PanelDatosPersonales panelDatosPersonales) {
		this.panelDatosPersonales = panelDatosPersonales;
	}

}
