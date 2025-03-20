
package principal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.SwingUtilities;
import javax.swing.JTextField;

public class AplicacaoPrincipal 
{
    private static JLabel lblNome;
    private static JLabel lblSenha;
    private static JTextField txtNome;
    private static JPasswordField txtSenha;
    private static JLabel label;
    private static JButton btnLogin;

    private static String nomeUsuario = "João";
    private static String senhaUsuario = "123";
    
    public static void main(String[] args) 
    {
        // Cria e exibe a janela
        SwingUtilities.invokeLater(new Runnable() 
        {
            public void run() 
            {
                criarTela();
            }
        });
    }

    private static void criarTela() 
    {
        JFrame frame = new JFrame("Hello World");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(null); 

        label = new JLabel();
        label.setBounds(50, 80, 180, 30); 
        frame.getContentPane().add(label);

        btnLogin = new JButton("Logar");
        btnLogin.setBounds(100, 120, 100, 30); 
        frame.getContentPane().add(btnLogin);
        btnLogin.addActionListener(e -> {
            String nome = txtNome.getText();
            String senha = new String(txtSenha.getPassword());

            if (nome.equals(nomeUsuario) && senha.equals(senhaUsuario)) 
            {
                label.setText("Bem-vindo, " + nome);
            } 
            else 
            {
                label.setText("Usuário ou senha inválidos");
            }
        });

        lblNome = new JLabel("Nome:");
        lblNome.setBounds(40, 10, 100, 30);
        frame.getContentPane().add(lblNome);

        txtNome = new JTextField();
        txtNome.setBounds(100, 10, 100, 30); 
        frame.getContentPane().add(txtNome);

        lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(40, 40, 100, 30);
        frame.getContentPane().add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 40, 100, 30); 
        frame.getContentPane().add(txtSenha);
        
        frame.setVisible(true);
    }
}
