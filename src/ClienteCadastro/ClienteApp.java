package ClienteCadastro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ClienteApp extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nomeField, cpfField, telefoneField, enderecoField, numeroField, cidadeField, estadoField;
    private Map<String, Cliente> clientesMap;

    public ClienteApp() {
        setTitle("Cadastro de Cliente");
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializar o mapa de clientes
        clientesMap = new HashMap<>();

        // Configurar os campos de entrada
        JPanel panel = new JPanel(new GridLayout(8, 2));
        panel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        panel.add(nomeField);

        panel.add(new JLabel("CPF:"));
        cpfField = new JTextField();
        panel.add(cpfField);

        panel.add(new JLabel("Telefone:"));
        telefoneField = new JTextField();
        panel.add(telefoneField);

        panel.add(new JLabel("Endereço:"));
        enderecoField = new JTextField();
        panel.add(enderecoField);

        panel.add(new JLabel("Número:"));
        numeroField = new JTextField();
        panel.add(numeroField);

        panel.add(new JLabel("Cidade:"));
        cidadeField = new JTextField();
        panel.add(cidadeField);

        panel.add(new JLabel("Estado:"));
        estadoField = new JTextField();
        panel.add(estadoField);

        // Botão de cadastro
        JButton cadastrarButton = new JButton("Cadastrar Cliente");
        cadastrarButton.addActionListener(new CadastrarClienteAction());
        panel.add(cadastrarButton);

        // Botão de busca
        JButton buscarButton = new JButton("Buscar Cliente");
        buscarButton.addActionListener(new BuscarClienteAction());
        panel.add(buscarButton);

        add(panel);
    }

    // Ação para cadastrar cliente
    private class CadastrarClienteAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = nomeField.getText();
            String cpf = cpfField.getText();
            String telefone = telefoneField.getText();
            String endereco = enderecoField.getText();
            int numero = Integer.parseInt(numeroField.getText());
            String cidade = cidadeField.getText();
            String estado = estadoField.getText();

            Cliente cliente = new Cliente(nome, cpf, telefone, endereco, numero, cidade, estado);
            clientesMap.put(cpf, cliente);

            JOptionPane.showMessageDialog(ClienteApp.this, "Cliente cadastrado com sucesso!");

            // Limpar campos
            nomeField.setText("");
            cpfField.setText("");
            telefoneField.setText("");
            enderecoField.setText("");
            numeroField.setText("");
            cidadeField.setText("");
            estadoField.setText("");
        }
    }

    // Ação para buscar cliente
    private class BuscarClienteAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cpf = cpfField.getText();
            Cliente cliente = clientesMap.get(cpf);

            if (cliente != null) {
                JOptionPane.showMessageDialog(ClienteApp.this, cliente.toString(), "Cliente Encontrado", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(ClienteApp.this, "Cliente com CPF " + cpf + " não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClienteApp app = new ClienteApp();
            app.setVisible(true);
        });
    }
}
