package vistas.comunes;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import utiles.Habilidad;

import java.awt.Color;

public class PanelDatosPersonales extends JPanel {

	public JTextField txtNombre;
	public JTextField txtaApellido;
	public JTextField txtDireccion;
	public JTextField textTelefono;
	public JLabel lblTelefono;
	private JComboBox especialidad;
	private JTextField txtEspecialidad;
	private JLabel labelHabilidad;
	public JTextField txtHabilidad;
	public JTextField txtID;
	public JLabel lblApellido;

	public PanelDatosPersonales() {
		setBackground(new Color(240, 230, 140));

		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtNombre.setHorizontalAlignment(SwingConstants.CENTER);

		txtNombre.setColumns(10);
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		txtaApellido = new JTextField();
		txtaApellido.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtaApellido.setHorizontalAlignment(SwingConstants.CENTER);
		txtaApellido.setColumns(10);

		lblApellido = new JLabel("Apellidos");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		txtDireccion = new JTextField();
		txtDireccion.setCaretColor(Color.LIGHT_GRAY);
		txtDireccion.setSelectedTextColor(Color.LIGHT_GRAY);
		txtDireccion.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtDireccion.setHorizontalAlignment(SwingConstants.CENTER);
		txtDireccion.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		textTelefono = new JTextField();
		textTelefono.setFont(new Font("Tahoma", Font.BOLD, 14));
		textTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		textTelefono.setColumns(10);

		lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		JLabel lblEjCalleO = new JLabel("Ej: Calle o Plaza o Avenida Libertad 12");
		lblEjCalleO.setFont(new Font("Tahoma", Font.PLAIN, 8));

		labelHabilidad = new JLabel("Habilidad");
		labelHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		labelHabilidad.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		especialidad = new JComboBox();
		especialidad.setFont(new Font("Tahoma", Font.BOLD, 11));

		for (Habilidad d : Habilidad.values()) {
			especialidad.addItem(d);
		}

		txtHabilidad = new JTextField();
		txtHabilidad.setEditable(false);
		txtHabilidad.setVisible(false);
		txtHabilidad.setHorizontalAlignment(SwingConstants.CENTER);
		txtHabilidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtHabilidad.setColumns(10);

		txtID = new JTextField();
		txtID.setVisible(false);
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		txtID.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtID.setEditable(false);
		txtID.setColumns(10);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addContainerGap()
								.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
														.addComponent(labelHabilidad, GroupLayout.PREFERRED_SIZE, 93,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 69,
																GroupLayout.PREFERRED_SIZE))
												.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(groupLayout.createSequentialGroup()
												.addComponent(lblApellido, GroupLayout.DEFAULT_SIZE, 89,
														Short.MAX_VALUE)
												.addGap(11))))
						.addGroup(groupLayout.createSequentialGroup().addGap(27).addComponent(lblDireccion)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(
								groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 58,
												GroupLayout.PREFERRED_SIZE)
										.addGap(25)))
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtaApellido, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
						.addComponent(textTelefono, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEjCalleO)
						.addGroup(groupLayout.createSequentialGroup()
								.addComponent(especialidad, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtHabilidad,
										GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(50, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout
										.createSequentialGroup()
										.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addGap(1)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtaApellido,
												GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
								.addGroup(
										groupLayout.createSequentialGroup().addGap(8).addComponent(lblApellido,
												GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(
										groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtDireccion, GroupLayout.PREFERRED_SIZE, 31,
														GroupLayout.PREFERRED_SIZE)
												.addGap(9).addComponent(lblEjCalleO))
								.addGroup(groupLayout.createSequentialGroup().addGap(7).addComponent(lblDireccion,
										GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textTelefono, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
								.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(labelHabilidad, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(especialidad, GroupLayout.PREFERRED_SIZE, 32,
												GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup().addGap(7).addComponent(txtHabilidad,
										GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE).addGap(178)));
		setLayout(groupLayout);
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtaApellido() {
		return txtaApellido;
	}

	public void setTxtaApellido(JTextField txtaApellido) {
		this.txtaApellido = txtaApellido;
	}

	public JTextField getTxtDireccion() {
		return txtDireccion;
	}

	public void setTxtDireccion(JTextField txtDireccion) {
		this.txtDireccion = txtDireccion;
	}

	public JTextField getTextTelefono() {
		return textTelefono;
	}

	public void setTextTelefono(JTextField textTelefono) {
		this.textTelefono = textTelefono;
	}

	public JLabel getLblTelefono() {
		return lblTelefono;
	}

	public void setLblTelefono(JLabel lblTelefono) {

		this.lblTelefono = lblTelefono;
	}

	public JComboBox getEspecialidad() {
		return especialidad;
	}

	public JLabel getLabelHabilidad() {
		return labelHabilidad;
	}

	public void setLabelHabilidad(JLabel labelHabilidad) {
		this.labelHabilidad = labelHabilidad;
	}

	public JTextField getTxtHabilidad() {
		return txtHabilidad;
	}

	public void setTxtHabilidad(JTextField txtHabilidad) {
		this.txtHabilidad = txtHabilidad;
	}

	public void setEspecialidad(JComboBox especialidad) {
		this.especialidad = especialidad;
	}

	public void setEspecialidadValor(Habilidad habilidad) {
		this.especialidad.setSelectedItem(habilidad);
		;
	}

	public JTextField getTxtEspecialidad() {
		return txtEspecialidad;
	}

	public void setTxtEspecialidad(JTextField txtEspecialidad) {
		this.txtEspecialidad = txtEspecialidad;
	}

	public JTextField getTxtID() {
		return txtID;
	}

	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}

	public JLabel getLblApellido() {
		return lblApellido;
	}

	public void setLblApellido(JLabel lblApellido) {
		this.lblApellido = lblApellido;
	}

}
