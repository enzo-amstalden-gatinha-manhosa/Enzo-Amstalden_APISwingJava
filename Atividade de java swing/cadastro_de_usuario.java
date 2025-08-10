import javax.swing.*; // Componentes swing
import java.awt.*; // Importa o GridLayout
import java.awt.event.*; // Importa o ActionListener

public class cadastro_de_usuario {
    public static void main(String[] args) {
        // Criação do frame (janela)
        JFrame frame = new JFrame("Cadastro de Usuário"); // Janela principal
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Botão de fechar
        frame.setLocationRelativeTo(null); // Centraliza a janela
        frame.setLayout(new GridLayout(6, 2, 10, 10)); // Layout em Grid

        // Rótulos
        JLabel labelNome = new JLabel("Nome:");
        JLabel labelEmail = new JLabel("Email:");
        JLabel labelIdade = new JLabel("Idade:");

        // Campos de texto
        JTextField campoNome = new JTextField();
        JTextField campoEmail = new JTextField();
        JTextField campoIdade = new JTextField();

        // Botões de opção
        JRadioButton masculino = new JRadioButton("Masculino");
        JRadioButton feminino = new JRadioButton("Feminino");

        // Agrupamento dos botões
        ButtonGroup Genero = new ButtonGroup();
        Genero.add(masculino);
        Genero.add(feminino);

        // Botão
        JButton botaoCadastrar = new JButton("Cadastrar");

        // Ação do botão quando for clicado
        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText().trim();
                String email = campoEmail.getText().trim();
                String idade = campoIdade.getText().trim();

                // Lista de e-mails permitidos
                String[] dominiosPermitidos = {"gmail.com","outlook.com","hotmail.com","yahoo.com",
                "icloud.com","protonmail.com","terra.com","uol.com","bol.com","live.com","msn.com","aol.com","mail.com",
                "gmx.com","zoho.com","yandex.com","fastmail.com","tutanota.com","pm.com","me.com","mac.com","r7.com","globo.com","ig.com","oi.com",
                "superig.com","pop.com","zipmail.com","edu.com","gov.com","org.com"};

                // Validação do e-mail
                boolean dominioValido = false;
                for (String dominio : dominiosPermitidos) {
                    if (email.endsWith(dominio)) {
                        dominioValido = true;
                        break;
                    }
                }

                // Verifica se o campo está vazio, sem @ ou e_mail inválido
                if (nome.isEmpty() || email.isEmpty() || idade.isEmpty()) {
                    JOptionPane.showMessageDialog(frame,
                            "Preencha todos os campos!",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                } else if (!email.contains("@") || !dominioValido) {
                    JOptionPane.showMessageDialog(frame,
                    "Digite um email válido!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Cadastro realizado com sucesso!\n" +
                            "Nome: " + nome + "\nEmail: " + email + "\nIdade: " + idade,
                            "Sucesso",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Adicionando componentes ao frame
        frame.add(labelNome);
        frame.add(campoNome);
        frame.add(labelEmail);
        frame.add(campoEmail);
        frame.add(labelIdade);
        frame.add(campoIdade);
        frame.add(masculino);
        frame.add(feminino);
        frame.add(botaoCadastrar);

        // Exibir a janela
        frame.setVisible(true);
    }
}