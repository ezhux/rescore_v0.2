package org.rescore.gui.views;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.rescore.beans.YachtClass;
import org.rescore.beans.YachtClasses;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.ObjectProperty;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;

public class AddYachtClassDialog extends JDialog {
	
	private YachtClass m_yachtClass;
	private YachtClasses m_yachtClasses;
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JButton okButton;
	private JTextField textField_2;
	
	public AddYachtClassDialog(YachtClass yachtClass, YachtClasses yachtClasses){
		m_yachtClass = yachtClass;
		m_yachtClasses = yachtClasses;
		
		setBounds(150, 150, 500, 400);
		setTitle("Add New Yacht Class");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblName = new JLabel("Name:");
			GridBagConstraints gbc_lblName = new GridBagConstraints();
			gbc_lblName.anchor = GridBagConstraints.WEST;
			gbc_lblName.insets = new Insets(0, 0, 5, 5);
			gbc_lblName.gridx = 1;
			gbc_lblName.gridy = 1;
			contentPanel.add(lblName, gbc_lblName);
		}
		{
			textField = new JTextField();
			GridBagConstraints gbc_textField = new GridBagConstraints();
			gbc_textField.insets = new Insets(0, 0, 5, 0);
			gbc_textField.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField.gridx = 3;
			gbc_textField.gridy = 1;
			contentPanel.add(textField, gbc_textField);
			textField.setColumns(10);
		}
		{
			JLabel lblCoefficient = new JLabel("Coefficient:");
			GridBagConstraints gbc_lblCoefficient = new GridBagConstraints();
			gbc_lblCoefficient.anchor = GridBagConstraints.WEST;
			gbc_lblCoefficient.insets = new Insets(0, 0, 5, 5);
			gbc_lblCoefficient.gridx = 1;
			gbc_lblCoefficient.gridy = 2;
			contentPanel.add(lblCoefficient, gbc_lblCoefficient);
		}
		{
			textField_1 = new JTextField();
			GridBagConstraints gbc_textField_1 = new GridBagConstraints();
			gbc_textField_1.insets = new Insets(0, 0, 5, 0);
			gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_1.gridx = 3;
			gbc_textField_1.gridy = 2;
			contentPanel.add(textField_1, gbc_textField_1);
			textField_1.setColumns(10);
		}
		{
			JLabel lblDisplacement = new JLabel("Displacement:");
			GridBagConstraints gbc_lblDisplacement = new GridBagConstraints();
			gbc_lblDisplacement.insets = new Insets(0, 0, 5, 5);
			gbc_lblDisplacement.gridx = 1;
			gbc_lblDisplacement.gridy = 3;
			contentPanel.add(lblDisplacement, gbc_lblDisplacement);
		}
		{
			textField_2 = new JTextField();
			GridBagConstraints gbc_textField_2 = new GridBagConstraints();
			gbc_textField_2.insets = new Insets(0, 0, 5, 0);
			gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
			gbc_textField_2.gridx = 3;
			gbc_textField_2.gridy = 3;
			contentPanel.add(textField_2, gbc_textField_2);
			textField_2.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent ae) {
			            	setVisible(false);
			            }
			        });
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent ae) {
		            	cancelActionPerformed();
		            	setVisible(false);
		            }
		        });
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		initDataBindings();
	}
	
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}
	
	private void cancelActionPerformed(){
		m_yachtClasses.removeYachtClass(m_yachtClass);
	}

	protected void initDataBindings() {
		BeanProperty<YachtClass, String> yachtClassBeanProperty = BeanProperty.create("name");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<YachtClass, String, JTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, m_yachtClass, yachtClassBeanProperty, textField, jTextFieldBeanProperty);
		autoBinding.bind();
		//
		BeanProperty<YachtClass, Float> yachtClassBeanProperty_1 = BeanProperty.create("coefficient");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<YachtClass, Float, JTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, m_yachtClass, yachtClassBeanProperty_1, textField_1, jTextFieldBeanProperty_1);
		autoBinding_1.bind();
		//
		BeanProperty<YachtClass, Integer> yachtClassBeanProperty_2 = BeanProperty.create("displacement");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty.create("text");
		AutoBinding<YachtClass, Integer, JTextField, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, m_yachtClass, yachtClassBeanProperty_2, textField_2, jTextFieldBeanProperty_2);
		autoBinding_2.bind();
	}

}
