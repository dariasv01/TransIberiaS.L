package vistas.comunes;
import java.awt.Color;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Dimension;

public class PanelInicio extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelInicio() {
		setBackground(new Color(240, 230, 140));
		
		JLabel lblNombreUno = new JLabel("TRANSPORTES");
		lblNombreUno.setFont(new Font("Arial Black", Font.BOLD, 40));
		
		JLabel lblNombreDos = new JLabel("IBERIA");
		lblNombreDos.setFont(new Font("Arial Black", Font.BOLD, 40));
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setIcon(new ImageIcon("imagenes\\LogoEmpresa.png"));
		
		JLabel lblComoSiLo = new JLabel("COMO SI LO LLEVASE USTED");
		lblComoSiLo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblComoSiLo.setFont(new Font("Arial Narrow", Font.BOLD, 30));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblImagen)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(133)
							.addComponent(lblNombreDos, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblComoSiLo, GroupLayout.PREFERRED_SIZE, 368, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNombreUno, GroupLayout.PREFERRED_SIZE, 364, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(473, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblImagen)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(58)
							.addComponent(lblNombreUno, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNombreDos, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblComoSiLo, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(314, Short.MAX_VALUE))
		);
		setLayout(groupLayout);


	}
}
