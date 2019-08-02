package vistas.comunes;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import utiles.Marca;

import java.awt.Color;

public class PanelMatricula extends JPanel {

	public JTextField txtMatricula;
	private JComboBox cboxMatricula;
	public JTextField txtEspecialidad;
	public JTextField txtPotencia;
	protected JLabel lblEj;
	public JTextField txtMarca;
	public JTextField txtID;

	public PanelMatricula() {
		setBackground(new Color(240, 230, 140));

		txtMatricula = new JTextField();
		txtMatricula.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMatricula.setHorizontalAlignment(SwingConstants.CENTER);

		txtMatricula.setColumns(10);
		JLabel lblNombre = new JLabel("Matricula");
		lblNombre.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		lblEj = new JLabel("Ej: 5154HGI");
		lblEj.setFont(new Font("Tahoma", Font.PLAIN, 10));

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblMarca.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		cboxMatricula = new JComboBox();
		cboxMatricula.setFont(new Font("Tahoma", Font.BOLD, 11));

		for (Marca d : Marca.values()) {
			cboxMatricula.addItem(d);
		}
		getEspecialidad().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean retorno = false;
				for (Marca d : Marca.values()) {
					if (getEspecialidad().getSelectedItem().toString() == d.toString()) {
						getTxtPotencia().setText(d.getPotencia());
					}
				}
			}
		});

		JLabel lblPotencia = new JLabel("Potencia");
		lblPotencia.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		txtPotencia = new JTextField();
		txtPotencia.setEditable(false);
		txtPotencia.setHorizontalAlignment(SwingConstants.CENTER);
		txtPotencia.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPotencia.setColumns(10);

		JLabel lblCv = new JLabel("CV");
		lblCv.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		txtMarca = new JTextField();
		txtMarca.setEditable(false);
		txtMarca.setVisible(false);
		txtMarca.setHorizontalAlignment(SwingConstants.CENTER);
		txtMarca.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtMarca.setColumns(10);

		txtID = new JTextField();
		txtID.setVisible(false);
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		txtID.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtID.setEditable(false);
		txtID.setColumns(10);

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(37)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPotencia, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMarca))
						.addGap(53)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEj)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(txtPotencia, GroupLayout.PREFERRED_SIZE, 225,
												GroupLayout.PREFERRED_SIZE)
										.addGap(8).addComponent(lblCv, GroupLayout.PREFERRED_SIZE, 58,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(
										groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(cboxMatricula, GroupLayout.PREFERRED_SIZE, 265,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtMarca,
														GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
								.addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, 272,
										GroupLayout.PREFERRED_SIZE))
						.addGap(393)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(54)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNombre, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMatricula, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGap(2).addComponent(lblEj, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(cboxMatricula, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMarca, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addGap(11)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtPotencia, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPotencia, GroupLayout.PREFERRED_SIZE, 31,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(lblCv, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(108, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	public JTextField getTxtMatricula() {
		return txtMatricula;
	}

	public void setTxtMatricula(JTextField txtMatricula) {
		this.txtMatricula = txtMatricula;
	}

	public JTextField getTxtPotencia() {
		return txtPotencia;
	}

	public void setTxtPotencia(JTextField txtPotencia) {
		this.txtPotencia = txtPotencia;
	}

	public JTextField getTextField() {
		return txtPotencia;
	}

	public void setTextField(JTextField textField) {
		this.txtPotencia = textField;
	}

	public JTextField getTxtNombre() {
		return txtMatricula;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtMatricula = txtNombre;
	}

	public JComboBox getEspecialidad() {
		return cboxMatricula;
	}

	public void setEspecialidad(JComboBox cboxMatricula) {
		this.cboxMatricula = cboxMatricula;
	}

	public void setEspecialidadValor(Marca marca) {
		this.cboxMatricula.setSelectedItem(marca);
	}

	public JTextField getTxtEspecialidad() {
		return txtEspecialidad;
	}

	public void setTxtEspecialidad(JTextField txtEspecialidad) {
		this.txtEspecialidad = txtEspecialidad;
	}

	public JComboBox getCboxMatricula() {
		return cboxMatricula;
	}

	public void setCboxMatricula(JComboBox cboxMatricula) {
		this.cboxMatricula = cboxMatricula;
	}

	public JLabel getLblEj() {
		return lblEj;
	}

	public void setLblEj(JLabel lblEj) {
		this.lblEj = lblEj;
	}

	public JTextField getTxtMarca() {
		return txtMarca;
	}

	public void setTxtMarca(JTextField txtMarca) {
		this.txtMarca = txtMarca;
	}

	public JTextField getTxtID() {
		return txtID;
	}

	public void setTxtID(JTextField txtID) {
		this.txtID = txtID;
	}

}
