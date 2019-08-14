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

import utiles.Mercancia;

import java.awt.Color;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelRuta extends JPanel {
	public JLabel lblNumero;
	private JComboBox ComboMercancia;
	protected JTextField txtEspecialidad;
	protected JLabel lblConductorUno;
	protected JLabel lblConductorDos;
	protected JComboBox ComboConductorUno;
	protected JLabel lblMercancia;
	protected JComboBox ComboConductorCinco;
	protected JLabel lblCamion;
	protected JComboBox ComboCamion;
	protected JLabel lblDistancia;
	public JTextField txtDistancia;
	protected JLabel lblKm;
	protected JCheckBox ChBoxUno;
	protected JCheckBox ChBoxDos;

	public PanelRuta() {
		setBackground(new Color(240, 230, 140));

		lblNumero = new JLabel("Numero de Conductores");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		lblConductorUno = new JLabel("Conductor Uno");
		lblConductorUno.setHorizontalAlignment(SwingConstants.CENTER);
		lblConductorUno.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		ComboMercancia = new JComboBox();
		ComboMercancia.setFont(new Font("Tahoma", Font.BOLD, 11));


		ChBoxUno = new JCheckBox("1");

		ChBoxUno.setBackground(new Color(240, 230, 140));

		ChBoxDos = new JCheckBox("2");
		
		ChBoxDos.setBackground(new Color(240, 230, 140));

		lblConductorDos = new JLabel("Conductor Dos");
		lblConductorDos.setHorizontalAlignment(SwingConstants.CENTER);
		lblConductorDos.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		ComboConductorUno = new JComboBox();
		ComboConductorUno.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblMercancia = new JLabel("Mercancia");
		lblMercancia.setHorizontalAlignment(SwingConstants.CENTER);
		lblMercancia.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		ComboConductorCinco = new JComboBox();
		ComboConductorCinco.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblCamion = new JLabel("Cami\u00F3n");
		lblCamion.setHorizontalAlignment(SwingConstants.CENTER);
		lblCamion.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		ComboCamion = new JComboBox();
		ComboCamion.setFont(new Font("Tahoma", Font.BOLD, 11));

		lblDistancia = new JLabel("Distancia");
		lblDistancia.setHorizontalAlignment(SwingConstants.CENTER);
		lblDistancia.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		txtDistancia = new JTextField();
		txtDistancia.setColumns(10);

		lblKm = new JLabel("km");
		lblKm.setHorizontalAlignment(SwingConstants.CENTER);
		lblKm.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMercancia, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDistancia, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConductorUno, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConductorDos, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCamion, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(ComboConductorUno, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
						.addComponent(ComboConductorCinco, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
						.addComponent(ComboCamion, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(txtDistancia, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblKm, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(ChBoxUno)
							.addGap(98)
							.addComponent(ChBoxDos))
						.addComponent(ComboMercancia, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(640, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMercancia, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(ComboMercancia, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ChBoxUno)
						.addComponent(ChBoxDos)
						.addComponent(lblNumero, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ComboConductorUno, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConductorUno, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(ComboConductorCinco, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblConductorDos, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCamion, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(ComboCamion, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDistancia, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDistancia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKm, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)))
		);
		setLayout(groupLayout);
	}

	public JLabel getLblNumero() {
		return lblNumero;
	}

	public void setLblNumero(JLabel lblNumero) {
		this.lblNumero = lblNumero;
	}

	public JComboBox getComboMercancia() {
		return ComboMercancia;
	}

	public void setComboMercancia(JComboBox comboMercancia) {
		ComboMercancia = comboMercancia;
	}

	public JTextField getTxtEspecialidad() {
		return txtEspecialidad;
	}

	public void setTxtEspecialidad(JTextField txtEspecialidad) {
		this.txtEspecialidad = txtEspecialidad;
	}

	public JLabel getLblConductorUno() {
		return lblConductorUno;
	}

	public void setLblConductorUno(JLabel lblConductorUno) {
		this.lblConductorUno = lblConductorUno;
	}

	public JLabel getLblConductorDos() {
		return lblConductorDos;
	}

	public void setLblConductorDos(JLabel lblConductorDos) {
		this.lblConductorDos = lblConductorDos;
	}

	public JComboBox getComboConductorUno() {
		return ComboConductorUno;
	}

	public void setComboConductorUno(JComboBox comboConductorUno) {
		ComboConductorUno = comboConductorUno;
	}

	public JLabel getLblMercancia() {
		return lblMercancia;
	}

	public void setLblMercancia(JLabel lblMercancia) {
		this.lblMercancia = lblMercancia;
	}

	public JLabel getLblCamion() {
		return lblCamion;
	}

	public void setLblCamion(JLabel lblCamion) {
		this.lblCamion = lblCamion;
	}

	public JComboBox getComboCamion() {
		return ComboCamion;
	}

	public void setComboCamion(JComboBox comboCamion) {
		ComboCamion = comboCamion;
	}

	public JLabel getLblDistancia() {
		return lblDistancia;
	}

	public void setLblDistancia(JLabel lblDistancia) {
		this.lblDistancia = lblDistancia;
	}

	public JTextField getTxtDistancia() {
		return txtDistancia;
	}

	public void setTxtDistancia(JTextField txtDistancia) {
		this.txtDistancia = txtDistancia;
	}

	public JLabel getLblKm() {
		return lblKm;
	}

	public void setLblKm(JLabel lblKm) {
		this.lblKm = lblKm;
	}

	public JCheckBox getChBoxUno() {
		return ChBoxUno;
	}

	public void setChBoxUno(JCheckBox chBoxUno) {
		ChBoxUno = chBoxUno;
	}

	public JCheckBox getChBoxDos() {
		return ChBoxDos;
	}

	public void setChBoxDos(JCheckBox chBoxDos) {
		ChBoxDos = chBoxDos;
	}

	public JComboBox getComboConductorCinco() {
		return ComboConductorCinco;
	}

	public void setComboConductorCinco(JComboBox comboConductorCinco) {
		ComboConductorCinco = comboConductorCinco;
	}

}
